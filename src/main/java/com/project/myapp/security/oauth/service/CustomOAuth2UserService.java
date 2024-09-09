package com.project.myapp.security.oauth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.register.dao.RegisterMapper;
import com.project.myapp.security.auth.CustomDetails;
import com.project.myapp.security.oauth.provider.GoogleUserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService{

	private final RegisterMapper registerMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회

		log.info("소셜 로그인시 여기 타는거 확인");
		return processOAuth2User(userRequest, oAuth2User);
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

		// Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			log.info("구글 로그인 요청");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		}
		log.info("oAuth2UserInfo.getName() {}", oAuth2UserInfo.getName());
		log.info("oAuth2UserInfo.getEmail() {}", oAuth2UserInfo.getEmail());
		log.info("oAuth2UserInfo.getProvider()   {}", oAuth2UserInfo.getProvider());
		log.info("oAuth2UserInfo.getProviderId() {}", oAuth2UserInfo.getProviderId());

		String provider = oAuth2UserInfo.getProvider();
		String providerId = oAuth2UserInfo.getProviderId();

		log.info("provider   = {}", provider);
		log.info("providerId = {}", providerId);
		Map<String, String> providerMap = new HashMap<>();

		providerMap.put("provider", provider);
		providerMap.put("providerId", providerId);

		Optional<UserDTO> userOptional = registerMapper.findByProviderAndProviderId(providerMap);

		UserDTO userDTO;
		if (userOptional.isPresent()) {
			userDTO = userOptional.get();
			// user가 존재하면 update 해주기
			userDTO.setEmail(oAuth2UserInfo.getEmail());
			registerMapper.updateUser(userDTO);
		} else {
			userDTO = null; // user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음
			userDTO = UserDTO.builder()
				.nickName(oAuth2UserInfo.getName())
				.email(oAuth2UserInfo.getEmail())
				.role("ROLE_USER")
				.provider(oAuth2UserInfo.getProvider())
				.providerId(oAuth2UserInfo.getProviderId())
				.build();

			String id = provider+"_"+providerId;
			String oAuth2Password = bCryptPasswordEncoder.encode(provider+"_"+providerId);

			userDTO.setId(id);
			userDTO.setPassword(oAuth2Password);
			userDTO.setNickName(providerId);

			log.info("userDTO for processOAuth2User = {}", userDTO);

			registerMapper.save(userDTO);
		}
		return new CustomDetails(userDTO, oAuth2User.getAttributes());
	}

}