package com.project.myapp.errorboard.service;

import com.amazonaws.services.s3.AmazonS3;
import com.project.myapp.dto.ErrNFilesDTO;
import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.FilesDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.errorboard.dao.ErrorBoardDAO;
import com.project.myapp.utiles.AwsConfig;
import com.project.myapp.utiles.AwsS3FileUploadService;
import com.project.myapp.utiles.FileUpload;
import com.project.myapp.vo.ErrLogFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorBoardServiceImpl implements ErrorBoardService {

    AwsS3FileUploadService awsS3FileUploadService;
    AwsConfig awsConfig;
    ErrorBoardDAO errorBoardDAO;
    FileUpload fileUpload;
    AmazonS3 amazonS3;

    @Autowired
    ErrorBoardServiceImpl(ErrorBoardDAO errorBoardDAO , AwsS3FileUploadService awsS3FileUploadService, FileUpload fileUpload , AmazonS3 amazonS3,AwsConfig awsConfig ){
        this.errorBoardDAO = errorBoardDAO;
        this.awsS3FileUploadService = awsS3FileUploadService;
        this.fileUpload = fileUpload;
        this.amazonS3 = amazonS3;
        this.awsConfig = awsConfig;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception {
        // 게시글 등록
        List<Integer> fileNoList = new ArrayList<>();
        for(String fileKeyList : afterList){
            fileNoList.add(this.fileUpload.getFileNoKeyList(fileKeyList));
        }
        int result = errorBoardDAO.insertErrorBoardMapper(errorBoardDTO);

        // 최근에 작업했던(auto_increment값 가져오기)
        int selectKey = this.fileUpload.selectKey();

        for(Integer fileNo : fileNoList){
            FilesDTO filesDTO = new FilesDTO();
            filesDTO.setFile_no(fileNo);
            filesDTO.setPost_no(selectKey);
            filesDTO.setCategory_no(errorBoardDTO.getCategoryNo());
            result += this.fileUpload.updateImages(filesDTO);
        }
        return result;
    }

    @Override
    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception {
        // 게시글 페이징 + 검색
        return this.errorBoardDAO.getSearchSelectPage(sc);
    }

    @Override
    public int getSearchResultCount(SearchCondition sc) throws Exception {
        // 전체 게시글 수
        return this.errorBoardDAO.getSearchResultCount(sc);
    }

    @Override
    public ErrorBoardDTO getErrorBoardByErrBno(int errBno){
        // 특정 게시글 조회
        ErrorBoardDTO errorBoardDTO = this.errorBoardDAO.getErrorBoardByErrBno(errBno);
        // 게시글을 조회하면 조회수가 증가
        errorBoardDAO.increaseViewCount(errBno);
        return errorBoardDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Integer errBno, String writer) throws Exception {
        System.out.println("errBno = " + errBno);
        String awsURL = "https://test-bucket-myappaws.s3.ap-northeast-2.amazonaws.com/";
        String bucketName = awsConfig.getBucketName();
        // 게시글 삭제
        int result = errorBoardDAO.delete(errBno, writer);
        System.out.println("게시글 삭제결과 1 나와야함 = " + result);

        // 해당 게시물에 등록됐던 파일 정보(storedName)를 가져온다(파일테이블)
        List<ErrNFilesDTO> deleteList = this.errorBoardDAO.getDeleteList(errBno);
        System.out.println("deleteList = " + deleteList);
        for(ErrNFilesDTO deleteKey : deleteList){
            System.out.println("deleteKey = " + deleteKey);
        }
        System.out.println("최종삭제 결과 게시글 1 + 이미지 삭제 개수만큼 여기서는 4 나와야함 = " + result);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ErrorBoardDTO errorBoardDTO) throws Exception {
        // 게시글 업데이트
        int result = errorBoardDAO.update(errorBoardDTO);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int isCheckWriter(String writer, int errBno) {
        System.out.println("service writer = " + writer);
        System.out.println("service errBno = " + errBno);
        int result = this.errorBoardDAO.isCheckWriter(writer, errBno);
        System.out.println("service result = " + result);
        return result;
    }

}
