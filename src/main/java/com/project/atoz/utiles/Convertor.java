package com.project.atoz.utiles;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Convertor {
	public static void main(String[] args) {

		String aa = "ERR_BNO ERR_CODE TITLE CONTENT WRITER VIEW_CNT COMMENT_CNT REG_DATE UP_DATE CATEGORY_NO ERR_BOARD_THUM ";
		log.info("bb = {}", toLowerConvertor(aa));
		log.info("cc = {}", toUpperConvertor(aa));
	}

	public static String toLowerConvertor(String string) {
		return string.toLowerCase();
	}

	public static String toUpperConvertor(String string) {
		return string.toUpperCase();
	}
}
