package com.project.myapp.utiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
//            return new ResponseEntity<>(successURL, HttpStatus.OK);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uploaded" , false);
            return map;
//            return new ResponseEntity<>("uploadResult", HttpStatus.BAD_REQUEST);
        }
    }
}
