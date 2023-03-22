package org.example.utils;

import java.util.Random;

public class StringUtils {

	
	private static final String ALFABETO = "qwertyuiopasdfghjklzxcvbnm1234567890";
	private static Random random = new Random();
	
	
	private StringUtils() {}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< length; i++) {
			sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
		}
		return sb.toString();
	}
	
}
