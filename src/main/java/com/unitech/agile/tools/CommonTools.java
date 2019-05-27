package com.unitech.agile.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.unitech.agile.entity.UserSession;

public class CommonTools {
	
	private static final int TOKEN_SIZE = 50;
	private static final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final long MILIS_IN_60_MINS = 3600000;

	public static String generateMD5(String s) {
		final String original = s;
		final MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String generateSessionToken() {
		final SecureRandom rnd = new SecureRandom();
		final StringBuilder sb = new StringBuilder(TOKEN_SIZE);
		for(int i = 0; i < TOKEN_SIZE; i++) 
			sb.append(SOURCE.charAt(rnd.nextInt(SOURCE.length())));
		return sb.toString();
	}
	
	public static String convert(InputStream inputStream) throws IOException {
		final StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {	
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}
		return stringBuilder.toString();
	}
	
	public static boolean isSessionValid(UserSession session) {
		if(session == null) {
			return false;
		}
		final long milis = session.getAddDate().getTime();
		return Math.abs(milis - System.currentTimeMillis()) <= MILIS_IN_60_MINS;
	}
	
	public static byte[] convertBase64ToBytes(String imageData) {
		if(StringUtils.isBlank(imageData)) {
			return null;
		}
		return Base64.decodeBase64(imageData);
	}
}
