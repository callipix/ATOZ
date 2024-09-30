package com.project.atoz.fileupload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.atoz.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UploadService {

	private final AwsS3FileUploadService awsS3FileUploadService;

	@ResponseBody
	@PostMapping("/upload/uploadCK")
	public Map<String, Object> uploads(MultipartHttpServletRequest request) {

		MultipartFile uploadImg = request.getFile("upload");
		log.info("uploadImg = {}", uploadImg);

		CustomDetails customDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		String id = customDetails.getName();

		try {
			String successURL = this.awsS3FileUploadService.saveFileToS3(uploadImg, id);
			if (successURL == null) {
				throw new Exception("uploadCK failed");
			}
			log.info("successURL = {}", successURL);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uploaded", true);
			map.put("url", successURL);
			map.put("HttpStatus", ResponseEntity.ok(successURL));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uploaded", false);
			map.put("HttpStatus", new ResponseEntity<>("uploaded_ERR", HttpStatus.BAD_REQUEST));
			return map;
		}
	}

	@ResponseBody
	@PostMapping("/contentImgCheck")
	public ResponseEntity removeImage(@RequestBody Map<String, List<String>> imageAddress) throws IOException {

		List<String> beforeAddress = new ArrayList<>();
		List<String> afterAddress = new ArrayList<>();

		Map<String, Object> resultMap = new HashMap<>();

		int result = 0;

		for (String beforeImgAddress : imageAddress.get("beforeImgAddress")) {
			beforeAddress.add(beforeImgAddress);
			log.info("beforeImgAddress = {}", beforeImgAddress);
		}
		for (String afterImgAddress : imageAddress.get("afterImgAddress")) {
			afterAddress.add(afterImgAddress);
			log.info("afterImgAddress = {}", afterImgAddress);
		}

		log.info("beforeAddress = {}", beforeAddress.size());
		log.info("afterAddress = {}", afterAddress.size());

		if (beforeAddress.size() != afterAddress.size()) {
			// 글 작성 전후 이미지 변화가 있을때
			List<String> endImgList = new ArrayList<>(beforeAddress);
			endImgList.removeAll(afterAddress);
			result = this.awsS3FileUploadService.deleteImageFile(endImgList, afterAddress);

			resultMap.put("result", result);
			resultMap.put("afterAddress", afterAddress);
			log.info("deletedImg = {}", endImgList);
		}
		if (result != 0) {
			return ResponseEntity.ok(resultMap);
		}
		return new ResponseEntity<>("HttpStatus", HttpStatus.BAD_REQUEST);
	}
	/** *
	 * 업로드 과정(DB까지)
	 * 1. 이미지 파일이 맞는지 체크
	 * 2. 확장자 명이 올바른지 체크
	 * 3. S3에 업로드
	 * 4. S3 업로드 성공시 DB에 파일정보 저장
	 * 4-1. DB에 파일정보 저장 성공시 최종 URL반환
	 * 4-2. DB에 파일정보 저장 실패시 S3에 업로드된 파일 삭제
	 *
	 * 1-1. 게시글 삭제시 AWS S3에 파일 삭제
	 * 1-2. 파일삭제 성공시 DB에 저장된 파일정보 삭제
	 * 2. 1-1,2는 트랜잭션으로 묶여야함
	 */
}