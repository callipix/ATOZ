package com.project.myapp.oauth;

import java.util.Optional;

import com.project.myapp.security.provider.GoogleUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.register.dao.RegisterMapper;
import com.project.myapp.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	private final RegisterMapper registerMapper;
	private static final String GOOGLE = "google";

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회

		return processOAuth2User(userRequest, oAuth2User);
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

		// Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			log.info("구글 로그인 요청~~");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		}
		//		else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
		//			log.info("페이스북 로그인 요청~~");
		//			oAuth2UserInfo = new FaceBookUserInfo(oAuth2User.getAttributes());
		//		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
		//			log.info("네이버 로그인 요청~~");
		//			oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
		//		} else {
		//			log.info("우리는 구글과 페이스북만 지원해요 ㅎㅎ");
		//		}

		//log.info("oAuth2UserInfo.getProvider()   {}" , oAuth2UserInfo.getProvider());
		//log.info("oAuth2UserInfo.getProviderId() {}" , oAuth2UserInfo.getProviderId());
		Optional<UserDTO> userOptional =
			registerMapper.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());

		UserDTO userDTO;
		if (userOptional.isPresent()) {
			userDTO = userOptional.get();
			// user가 존재하면 update 해주기
			userDTO.setEmail(oAuth2UserInfo.getEmail());
			registerMapper.updateUser(userDTO);
		} else {
			// user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음.
			userDTO = UserDTO.builder()
				.nickName(oAuth2UserInfo.getProviderId())
				.email(oAuth2UserInfo.getEmail())
				.role("ROLE_USER")
				.provider(oAuth2UserInfo.getProvider())
				.providerId(oAuth2UserInfo.getProviderId())
				.build();
			registerMapper.updateUser(userDTO);
		}
		return new CustomDetails(userDTO, oAuth2User.getAttributes());
	}
}