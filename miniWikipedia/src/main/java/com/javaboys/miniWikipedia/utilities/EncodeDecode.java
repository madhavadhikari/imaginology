package com.javaboys.miniWikipedia.utilities;

import java.util.Base64;

public class EncodeDecode {
	public  String doEncode(String encodeString) {
		byte[] x = Base64.getEncoder().encode(encodeString.getBytes());
		
		return  new String(x); 
	}
	public String doDecode(String decodeString) {
		byte[] y= Base64.getDecoder().decode(decodeString.getBytes());
		return new String(y);
	}

}
