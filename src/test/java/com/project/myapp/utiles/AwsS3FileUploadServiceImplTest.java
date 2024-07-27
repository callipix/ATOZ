package com.project.myapp.utiles;

import com.amazonaws.services.s3.AmazonS3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AwsS3FileUploadServiceImplTest {

    @Autowired
    private AmazonS3 amazonS3;
    @Autowired
    private AwsConfig awsConfig;

    @Test
    public void saveFileToS3() {
        System.out.println("key = " + awsConfig.getBucketName());
        System.out.println("amazonS3 = " + amazonS3);
    }

    @Test
    public void uploadImages() {
    }
}