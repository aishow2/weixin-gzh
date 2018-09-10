package com.java.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//根据unionID查询openid
public class ConnectSql {

	public static String getResult() throws Exception{
	 Connection con;
	 String driver="com.mysql.jdbc.Driver";
	 String url="jdbc:mysql://localhost:3306/wxinfo";
	 String user="root";
	 String password="123456";
//	 try{
//		 String UNIONID="oPQNTxCbld8HV77O0r5TVIp8fYBQ";
//		 //加载驱动
//		 Class.forName(driver);
//		 //getConnect()连接数据库
//		 con=DriverManager.getConnection(url, user, password);
//		 //创建statement类对象来执行sql语句
//		 Statement stat=con.createStatement();
//		 String sql="select openid from user where unionid="+UNIONID+"";
//		 ResultSet rs=stat.executeQuery(sql);
//		 String openid=null;
//		 while(rs.next()){
//			 openid=rs.getString(openid);	 	 
//		 }
//		 rs.close();
//		 con.close();
//	 }catch(ClassNotFoundException e){
//		 System.out.println("excepetion");
//		 e.printStackTrace();
//	 }catch(SQLException e){
//		 e.printStackTrace();
//	 }
	 String UNIONID="*******";
	 Class.forName(driver);
	 //getConnect()连接数据库
	 con=DriverManager.getConnection(url, user, password);
	 //创建statement类对象来执行sql语句
	 Statement stat=con.createStatement();
	 String sql="select openid from user where unionid='"+UNIONID+"'";
	 ResultSet rs=stat.executeQuery(sql);
	 String openid=null;
	 while(rs.next()){
		 openid=rs.getString("openid");	 	 
	 }
	 rs.close();
	 con.close();
	 System.out.println(openid);
	 return openid;
	}
	public static void main(String[] args){
		try{
			ConnectSql.getResult();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


