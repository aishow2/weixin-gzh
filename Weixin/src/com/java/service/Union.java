package com.java.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Union {
	public static String getUserInfo() throws Exception{
		String ACCESS_TOKEN;
		String OPENID;
		JSONArray json;
		ACCESS_TOKEN=Token.getAccessToken();
		json=Openid.getOpenid();
		OPENID=json.getString(0);
//	  for(int i=0;i<json.size();i++){
//		  OPENID=json.getString(i);
//		  String userUrl="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ACCESS_TOKEN+"&openid="+OPENID;
//			URL url = new URL(userUrl);
//		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//		     connection.setRequestMethod("GET");
//		     connection.setDoOutput(true);
//		     connection.setDoInput(true);
//		     connection.connect();
//
//		     //获取返回的字符
//		     InputStream inputStream = connection.getInputStream();
//		     int size =inputStream.available();
//		     byte[] bs =new byte[size];
//		     inputStream.read(bs);
//		     String message=new String(bs,"UTF-8");
//		     
//		     JSONObject jsonObject=JSONObject.fromObject(message);
//		     String unionid=jsonObject.getString("unionid");
//		     System.out.println(unionid);
//		    
//	  }
	  return ACCESS_TOKEN;
	      
	}
//	public static void main(String[] args) {
//		try{
//			Union.getUserInfo();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
