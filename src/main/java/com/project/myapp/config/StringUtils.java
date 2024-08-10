package com.project.myapp.config;

public class StringUtils {

    public static String escapeDollorSign(String input){

        if(input == null){
            return null;
        }
        return input.replace("$" , "\\$");
    }
}
