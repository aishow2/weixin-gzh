package com.java.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class Token {
	private static final String APPID = "*******";
	 private static final String APPSECRET = "*********";
	 
	public static String getAccessToken() throws Exception{
	     String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
	    		 +APPID+ "&secret="+APPSECRET;
	     //System.out.println("URL for getting accessToken accessTokenUrl="+accessTokenUrl);
	     
	     URL url = new URL(accessTokenUrl);
	     HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	     connection.setRequestMethod("GET");
	     connection.setDoOutput(true);
	     connection.setDoInput(true);
	     connection.connect();

	     //获取返回的字符
	     InputStream inputStream = connection.getInputStream();
	     int size =inputStream.available();
	     byte[] bs =new byte[size];
	     inputStream.read(bs);
	     String message=new String(bs,"UTF-8");

	     //获取access_token
	     JSONObject jsonObject = JSONObject.fromObject(message);
	     String accessToken = jsonObject.getString("access_token");
	     String expires_in = jsonObject.getString("expires_in");
	     //System.out.println("accessToken="+accessToken);
	     
	     return accessToken;
	 }
	
//	public static void main(String[] args){
//		   try {
//			Token.getAccessToken();
//		} catch (Exception e) {
//		 e.printStackTrace();
//		}
//			
//		}


}
