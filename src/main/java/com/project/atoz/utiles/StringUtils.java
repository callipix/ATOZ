package com.project.atoz.utiles;

public class StringUtils {

	public static String escapeDollorSign(String input) {

		if (input == null) {
			return null;
		}
		return input.replace("$", "\\$");
	}
}
