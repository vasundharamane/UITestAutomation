package com.task.automation.util;

import java.util.Random;

public class StringUtil {

	public static String createRandomString(String prefix) {
		Random r = new Random();

		String token = Long.toString(Math.abs(r.nextLong()), 36);

		return prefix + "_" + token;
	}

	public static String createRandomString() {
		Random r = new Random();

		String token = Long.toString(Math.abs(r.nextLong()), 36);

		return token;
	}

	public static void main(String args[]) {
		System.out.println(createRandomString("TC_SignIN"));
	}
}
