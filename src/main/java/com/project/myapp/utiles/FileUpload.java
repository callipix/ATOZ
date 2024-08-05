package com.project.myapp.utiles;

import com.project.myapp.dto.FilesDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileUpload {

    @Autowired
    SqlSession sqlSession;

    private static final String namespace = "com.project.myapp.utiles.FileMapper.";

    public int uploadFile(FilesDTO filesDTO) {
        int result = this.sqlSession.insert(namespace + "insertFileInfo" , filesDTO);

        return result;
    }
    public int deleteFile(String storedName) {
        int result = this.sqlSession.delete(namespace + "deleteFileInfoByStoredName" , storedName);
        return result;
    }
    public int updateImages(FilesDTO filesDTO) {
        System.out.println("updateImages filesDTO = " + filesDTO);
        int result = this.sqlSession.update(namespace + "updateFileInfo" , filesDTO);
        return result;
    }
    public int getFileNoKeyList(String imgAddress) {
        int fileNoKey = sqlSession.selectOne(namespace + "getFileNoKey", imgAddress);
        return fileNoKey;
    }
    public int selectKey(){
        int selectKey = this.sqlSession.selectOne(namespace + "getSelectKey");
        return selectKey;
    }
}
