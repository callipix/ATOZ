package com.project.myapp.vo;

public class ErrLogFileDto {

    private Integer errBno;
    private Integer writer;
    private String filePath;

    public ErrLogFileDto(){

    }

    public ErrLogFileDto(String filePath) {
        this.filePath = filePath;
    }

    public ErrLogFileDto(Integer errBno, Integer writer, String filePath) {
        this.errBno = errBno;
        this.writer = writer;
        this.filePath = filePath;
    }

    public Integer getErrBno() {
        return errBno;
    }

    public void setErrBno(Integer errBno) {
        this.errBno = errBno;
    }

    public Integer getWriter() {
        return writer;
    }

    public void setWriter(Integer writer) {
        this.writer = writer;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
