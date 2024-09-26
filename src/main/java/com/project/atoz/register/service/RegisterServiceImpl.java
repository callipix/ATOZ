package com.project.atoz.register.service;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import com.project.atoz.dto.RegisterDTO;
import com.project.atoz.dto.UserAuth;
import com.project.atoz.dto.UserDTO;
import com.project.atoz.properties.ApiProperties;
import com.project.atoz.register.mapper.RegisterMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

	private final ApiProperties apiProperties;
	private final RegisterMapper registerMapper;

	@Override
	public int idCheck(String id) {
		int result = this.registerMapper.idCheck(id);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertUser(RegisterDTO registerDTO) {
		int result = this.registerMapper.insertUser(registerDTO.getUserDTO());
		result += this.registerMapper.insertMember(registerDTO.getMemberDTO());
		UserAuth userAuth = new UserAuth(registerDTO.getUserDTO().getId());
		result += this.registerMapper.insertAuth(userAuth);
		return result;
	}

	@Override
	public UserDTO findByEmail(String email) {
		UserDTO result = this.registerMapper.findByEmail(email);
		return result;
	}

	@Override
	public String sendSMS(String phoneNo) {
		Random ranNo = new Random();
		String noStr = "";
		for (int i = 0; i < 6; i++) {
			noStr += ranNo.nextInt(10);
		}
		certifiedPhoneNumber(phoneNo, noStr);
		log.info("noStr = {}", noStr);
		return noStr;
	}

	private void certifiedPhoneNumber(String phoneNo, String noStr) {

		String apiKey = apiProperties.getApiKey();
		String apiSecret = apiProperties.getApiSecret();
		String fromNo = apiProperties.getApiAdminNo();

		Message coolsms = new Message(apiKey, apiSecret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNo);    // 수신전화번호
		params.put("from", fromNo);    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
		params.put("type", "SMS");
		params.put("text", "문자메세지 테스트 : 인증번호는" + "[" + noStr + "]" + "입니다.");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = coolsms.send(params);
			log.info(" {} ", obj.toString());
		} catch (CoolsmsException e) {
			log.info(" {} ", e.getMessage());
			log.info(" {} ", e.getCode());
		}
	}
}