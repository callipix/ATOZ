package com.project.myapp.utiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    AwsS3FileUploadService awsS3FileUploadService;

    @ResponseBody
    @PostMapping("/upload/uploadCK")
    public Map<String , Object> uploads(MultipartHttpServletRequest request , HttpSession session) {

        System.out.println("request = " + request.toString());
        MultipartFile uploadImg = request.getFile("upload");
        System.out.println("uploadImg = " + uploadImg);
        String id = (String)session.getAttribute("id");
        try{
            String successURL = this.awsS3FileUploadService.saveFileToS3(uploadImg , id);
            if(successURL == null) {
                throw new Exception("uploadCK failed");
            }
            System.out.println("successURL = " + successURL);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uploaded" , true);
            map.put("url" , successURL);
            map.put("HttpStatus" , ResponseEntity.ok(successURL));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uploaded" , false);
            map.put("HttpStatus" , new ResponseEntity<>("uploaded_ERR" , HttpStatus.BAD_REQUEST));
            return map;
        }
    }

    @ResponseBody
    @PostMapping("/delete/ckIMG")
    public String removeImage(@RequestBody Map<String , List<?>> imageAddress) {

        for(Object beforeImgAddress : imageAddress.get("beforeImgAddress")) {
            System.out.println("beforeImgAddress = " +beforeImgAddress);
        }
        for(Object afterImgAddress : imageAddress.get("afterImgAddress")) {
            System.out.println("afterImgAddress = " +afterImgAddress);
        }

        for(int i = 0 ; i < imageAddress.get("beforeImgAddress").size(); i++) {

            if(!imageAddress.get("beforeImgAddress").get(i).equals(imageAddress.get("afterImgAddress").get(i))) {
                System.out.println("아닌값? = " + imageAddress.get("beforeImgAddress").get(i));
            }
        }

//        int result = Integer.valueOf(this.removeImage(imgAddress));
        return "String.valueOf(result)";
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
