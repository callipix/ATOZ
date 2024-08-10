package com.project.myapp.utiles;

public class Convertor {
    public static void main(String[] args) {

        String aa = "ERR_BNO ERR_CODE TITLE CONTENT WRITER VIEW_CNT COMMENT_CNT REG_DATE UP_DATE CATEGORY_NO ERR_BOARD_THUM ";
    }
    public static String toLowerConvertor(String string){
        // 소문자를 대문자로 변환해주는
        return string.toLowerCase();
    }
    public static String toUpperConvertor(String string){
        // 대문자를 소문자로 변환해주는
        return string.toUpperCase();
    }
}
