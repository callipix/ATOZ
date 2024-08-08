package com.project.myapp.dto;

public class TestMember {

    private String MEM_ID;
    private String MEM_PASS;
    private String MEM_NAME;
    private String MEM_TEL;
    private String MEM_ADDR;
    private String MEM_PHOTO;

    public TestMember() {
    }

    public TestMember(String MEM_ID, String MEM_PASS, String MEM_NAME, String MEM_TEL, String MEM_ADDR) {
        this.MEM_ID = MEM_ID;
        this.MEM_PASS = MEM_PASS;
        this.MEM_NAME = MEM_NAME;
        this.MEM_TEL = MEM_TEL;
        this.MEM_ADDR = MEM_ADDR;
    }

    public TestMember(String MEM_ID, String MEM_PASS, String MEM_NAME, String MEM_TEL, String MEM_ADDR, String MEM_PHOTO) {
        this.MEM_ID = MEM_ID;
        this.MEM_PASS = MEM_PASS;
        this.MEM_NAME = MEM_NAME;
        this.MEM_TEL = MEM_TEL;
        this.MEM_ADDR = MEM_ADDR;
        this.MEM_PHOTO = MEM_PHOTO;
    }

    public String getMEM_ID() {
        return MEM_ID;
    }

    public void setMEM_ID(String MEM_ID) {
        this.MEM_ID = MEM_ID;
    }

    public String getMEM_PASS() {
        return MEM_PASS;
    }

    public void setMEM_PASS(String MEM_PASS) {
        this.MEM_PASS = MEM_PASS;
    }

    public String getMEM_NAME() {
        return MEM_NAME;
    }

    public void setMEM_NAME(String MEM_NAME) {
        this.MEM_NAME = MEM_NAME;
    }

    public String getMEM_TEL() {
        return MEM_TEL;
    }

    public void setMEM_TEL(String MEM_TEL) {
        this.MEM_TEL = MEM_TEL;
    }

    public String getMEM_ADDR() {
        return MEM_ADDR;
    }

    public void setMEM_ADDR(String MEM_ADDR) {
        this.MEM_ADDR = MEM_ADDR;
    }

    public String getMEM_PHOTO() {
        return MEM_PHOTO;
    }

    public void setMEM_PHOTO(String MEM_PHOTO) {
        this.MEM_PHOTO = MEM_PHOTO;
    }

    @Override
    public String toString() {
        return "TestMember{" +
                "MEM_ID='" + MEM_ID + '\'' +
                ", MEM_PASS='" + MEM_PASS + '\'' +
                ", MEM_NAME='" + MEM_NAME + '\'' +
                ", MEM_TEL='" + MEM_TEL + '\'' +
                ", MEM_ADDR='" + MEM_ADDR + '\'' +
                ", MEM_PHOTO='" + MEM_PHOTO + '\'' +
                '}';
    }
}
