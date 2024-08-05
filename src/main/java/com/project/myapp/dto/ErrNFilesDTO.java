package com.project.myapp.dto;

public class ErrNFilesDTO {

    private int errBno;
    private int postNo;
    private int fileNo;
    private String storedName;
    private String filePath;

    public ErrNFilesDTO() {
    }

    public ErrNFilesDTO(int errBno, int postNo, int fileNo, String storedName, String filePath) {
        this.errBno = errBno;
        this.postNo = postNo;
        this.fileNo = fileNo;
        this.storedName = storedName;
        this.filePath = filePath;
    }

    public int getErrBno() {
        return errBno;
    }

    public void setErrBno(int errBno) {
        this.errBno = errBno;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getStoredName() {
        return storedName;
    }

    public void setStoredName(String storedName) {
        this.storedName = storedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "ErrNFilesDTO{" +
                "errBno=" + errBno +
                ", postNo=" + postNo +
                ", fileNo=" + fileNo +
                ", storedName='" + storedName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
