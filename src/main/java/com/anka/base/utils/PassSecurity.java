package com.anka.base.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PassSecurity {
	//加密方式
    private static String hashAlgorithmName = "md5";
    //加密次数
    private static int hashIterations = 1024;
	
	public static String getEncode(String password,String salt){
		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
		password = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations).toHex();
		return password;
	}
}
