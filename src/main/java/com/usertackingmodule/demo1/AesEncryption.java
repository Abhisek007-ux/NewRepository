package com.usertackingmodule.demo1;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*
Class Name - Utility
Version  -1.0
Date -14/7/2020
@Copyright 
 
*/

@SuppressWarnings("restriction")
public class AesEncryption {

	public AesEncryption() {
		super();
	}

	private final static String ALGO = "AES";
	private final static byte[] keyValue = new byte[] {'A', 'R','N','A','B','#','S','A','M','A','N','T','A','1','9','2'};

	public static String encrypt(String data) {
		Key key;
		Cipher c;
		byte[] encVal = new byte[] {};
		String encryptedValue = data;
		try {
			key = generateKey();
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			encVal = c.doFinal(data.getBytes());
			encryptedValue = new BASE64Encoder().encode(encVal);
		} catch (NoSuchAlgorithmException e  ) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedValue;
	}

	public static String decrypt(String encryptedData) {
		Key key;
		Cipher c;
		byte[] decordedValue = new byte[] {};
		byte[] decValue = new byte[] {};
		String decryptedValue = "";
		try {
			key = generateKey();
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}
