package br.com.sevp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UtilComum {

	public String encode(String url) throws UnsupportedEncodingException {
		return URLEncoder.encode(url, "UTF-8");
	}

	public String decode(String encode) throws UnsupportedEncodingException {
		return URLDecoder.decode(encode, "UTF-8");
	}

}
