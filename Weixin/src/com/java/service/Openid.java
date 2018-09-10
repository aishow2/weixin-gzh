package com.java.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import com.java.util.CommonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Openid {
	Token token=new Token();
	@SuppressWarnings("static-access")
	public static JSONArray getOpenid() throws Exception{
        String ACCESS_TOKEN;
        Token token=new Token();
        ACCESS_TOKEN=token.getAccessToken();
		String openidUrl="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+ACCESS_TOKEN+"&next_openid=";
		//openidUrl=openidUrl.replace("ACCESS_TOKEN",access_token);
		
		URL url = new URL(openidUrl);
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
	     
         JSONObject jsonObject = JSONObject.fromObject(message);
	     String open=jsonObject.getString("data");
	     
	    
	     JSONObject jsonObject1=JSONObject.fromObject(open);
	     String openid=jsonObject1.getString("openid");
	    
	     
	     //System.out.println(s);
	     JSONArray json=JSONArray.fromObject(openid);
	   
//	     for(int i=0;i<json.size();i++){
//	    	 String s1=json.getString(i);
//	    	 System.out.println(s1);
//	     } 
//	     System.out.println(json.size());
         
	     return json;
	}
//	public static void main(String args[]){
//		try{
//			Openid.getOpenid();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
