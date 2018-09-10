package com.java.main;

import java.util.ArrayList;
import java.util.List;

import com.java.model.Template;
import com.java.model.TemplateParam;
import com.java.service.ConnectSql;
import com.java.service.TemplateMsg;
import com.java.service.Token;

public class SendMsg {
	 public static void main(String[] args) throws Exception{		 
		 
	 ConnectSql conn=new ConnectSql();	 
	 Template tem=new Template();
	 //模板ID
	 String muban_id="*******";
	 String color="#00DD00";
	 String u_openid=conn.getResult();
	  
	 String access_token;
	 Token token=new Token();
	 access_token=token.getAccessToken();
	 tem.setTemplateId(muban_id);
	 tem.setTopColor(color);
	 tem.setToUser(u_openid);
	 tem.setUrl("http://www.baidu.com");
	 		
	 List<TemplateParam> paras=new ArrayList<TemplateParam>();
	 paras.add(new TemplateParam("first","尊敬的客户你好，您的服务有新进度","#FF3333"));
	 paras.add(new TemplateParam("keyword1","进度：名称审核成功","#0044BB"));
	 paras.add(new TemplateParam("keyword2","日期：2018年08月21日","#0044BB"));
	 paras.add(new TemplateParam("remark","感谢您对**的支持！","#AAAAAA"));
	 		
	 tem.setTemplateParamList(paras);
	 TemplateMsg msg=new TemplateMsg();		
	 boolean result=msg.sendTemplateMsg(access_token,tem);

 }
}
