package com.project.myapp.utiles;

import com.project.myapp.utiles.properties.AwsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AwsS3FileUploadServiceImplTest {

	@Autowired
	private AmazonS3 amazonS3;
	@Autowired
	private AwsProperties awsProperties;

	@Test
	public void saveFileToS3() {
		log.info("key = {}", awsProperties.getBucketName());
		log.info("amazonS3 = {}", amazonS3);
	}

	@Test
	public void uploadImages() {
	}
}