package br.com.sevp.util;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Cifrador {

	private static final byte[] SALT = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35,
			(byte) 0xE3, (byte) 0x03 };
	private static final int ITERATION_COUNT = 65536;
	private static final int KEY_LENGTH = 256;
	private Cipher ecipher;
	private Cipher dcipher;
	
	
	
	public Cifrador(String passPhrase) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

		ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		ecipher.init(Cipher.ENCRYPT_MODE, secret);

		dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] iv = ecipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
		dcipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
	}

	public String encripta(String encrypt) throws Exception {
		byte[] bytes = encrypt.getBytes("UTF8");
		byte[] encrypted = encrypt(bytes);
		return new BASE64Encoder().encode(encrypted);
	}

	public byte[] encrypt(byte[] plain) throws Exception {
		return ecipher.doFinal(plain);
	}

	public String descripta(String encrypt) throws Exception {
		byte[] bytes = new BASE64Decoder().decodeBuffer(encrypt);
		byte[] decrypted = decrypt(bytes);
		return new String(decrypted, "UTF8");
	}

	public byte[] decrypt(byte[] encrypt) throws Exception {
		return dcipher.doFinal(encrypt);
	}
	
	public static void main(String[] args) throws Exception {
		Cifrador cifrador = new Cifrador("ola");
		
		
		String algo = "3";
		String algo1 = "ARijEumRikveQUlOCnSXoA==";
		//cifrador.encripta(algo);
		System.out.println(algo1);
		
		String aff = cifrador.descripta(algo1);
		System.out.println(aff); 
	}
}
