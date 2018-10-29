package com.julian.rodo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashMD5 {

	private final static int N = 64;

	private byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom rnd = SecureRandom.getInstanceStrong();
		byte[] bytes = new byte[N];
		rnd.nextBytes(bytes);
		return bytes;
	}

	public static String getHashed(String toHash) throws NoSuchAlgorithmException {
		return getHashed(toHash, new byte[N]);
	}

	public static String getHashed(String toHash, byte[] salt) {
		byte[] bytes = new byte[N];
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			bytes = md.digest(toHash.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytesToString(bytes);
	}
	
	private static String bytesToString(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toString((b[i] & 0xff) /* + 0x100 */, N).substring(1));
		}
		return sb.toString();
	}
}