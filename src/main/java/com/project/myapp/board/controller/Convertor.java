package com.project.myapp.board.controller;

public class Convertor {
    public static void main(String[] args) {

        String aa = "ERR_BNO ERR_CODE TITLE CONTENT WRITER VIEW_CNT COMMENT_CNT REG_DATE UP_DATE CATEGORY_NO ERR_BOARD_THUM ";
        String result = "";
        result = aa.toLowerCase();
        System.out.println("result = " + result);
        for (int i = 0; i < aa.length(); i++) {
            aa.toLowerCase();
        }

    }
}
