package com.anka.base.utils;

import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class PassSecurity {
	
    private static Key getKey(String strKey) {
        Key key = null;
        try {
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(new SecureRandom(strKey.getBytes()));
            key = kg.generateKey();
            kg = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return key;
    }
 
    public static String getEncode(String strMing, String strKey) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        Key key = getKey(strKey);
        try {
            byteMing = strMing.getBytes("utf-8");
            byteMi = getEncCode(byteMing, key);
            strMi = Base64.getEncoder().encodeToString(byteMi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteMi = null;
            byteMing = null;
        }
        return strMi;
    }
 
    public static String getDecode(String strMi, String strKey) {
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        Key key = getKey(strKey);
        try {
            byteMi = Base64.getDecoder().decode(strMi);
            byteMing = getDecCode(byteMi, key);
            strMing = new String(byteMing, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }
 
 
    private static byte[] getEncCode(byte[] byts, Key key) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }
 
    private static byte[] getDecCode(byte[] bytd, Key key) {
        byte[] byteFina = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(bytd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }
}
