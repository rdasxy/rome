package com.ravipatel.statusserver.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;;
public class PasswordUtil {

	public static String convertToSha1(String input){
		byte[] hashedString = DigestUtils.sha1(input);
		String password = new String(Hex.encodeHex(hashedString));
		return password;
	}
}
