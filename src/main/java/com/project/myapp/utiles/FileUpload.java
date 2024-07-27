package com.project.myapp.utiles;

import com.project.myapp.dto.FilesDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileUpload {

    @Autowired
    SqlSession sqlSession;

    private static final String namespace = "com.project.myapp.utiles.FileMapper.";

    public int uploadFile(FilesDTO filesDTO) {
        int result = this.sqlSession.insert(namespace + "insertFileInfo" , filesDTO);
        return result;
    }

}
