package com.ssafy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptUtil{

	private static EncryptUtil encryptUtil = new EncryptUtil();
	
	public static EncryptUtil getInstance() {
		return encryptUtil;
	}
	
	public String createSalt() {
		
		SecureRandom r = new SecureRandom();
		byte[] salt = new byte[10];
		
		r.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for(byte b : salt) {
			sb.append(String.format("%02x", b));
		}
		
		return sb.toString().substring(0,10); 
	}
	
	public String getEncrypt(String pass, String salt) {
		String encPass = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			md.update((pass+salt).getBytes());
			byte[] pwdsalt = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for(byte b : pwdsalt) {
				sb.append(String.format("%02x", b));
			}
			
			encPass = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPass;
	}
}
