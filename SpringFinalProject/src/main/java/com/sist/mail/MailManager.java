package com.sist.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.sist.vo.*;


@Component
public class MailManager {
	private String style="<style>" + 
    		"body {" + 
    		"	  padding:1.5em;" + 
    		"	  background: #f5f5f5" + 
    		"	}" + 
    		"	table {" + 
    		"	  border: 1px #a39485 solid;" + 
    		"	  font-size: .9em;" + 
    		"	  box-shadow: 0 2px 5px rgba(0,0,0,.25);" + 
    		"	  width: 100%;" + 
    		"	  border-collapse: collapse;" + 
    		"	  border-radius: 5px;" + 
    		"	  overflow: hidden;" + 
    		"	}" + 
    		"	th {" + 
    		"	  text-align: left;" + 
    		"	}" + 
    		"	thead {" + 
    		"	  font-weight: bold;" + 
    		"	  color: #fff;" + 
    		"	  background: #73685d;" + 
    		"	}" + 
    		"	 td, th {" + 
    		"	  padding: 1em .5em;" + 
    		"	  vertical-align: middle;" + 
    		"	}" + 
    		"	 td {" + 
    		"	  border-bottom: 1px solid rgba(0,0,0,.1);" + 
    		"	  background: #fff;" + 
    		"	}" + 
    		"	a {" + 
    		"	  color: #73685d;" + 
    		"	}" + 
    		"	 @media all and (max-width: 768px) {" + 
    		"	  table, thead, tbody, th, td, tr {" + 
    		"	    display: block;" + 
    		"	  }" + 
    		"	  th {" + 
    		"	    text-align: right;" + 
    		"	  }" + 
    		"	  table {" + 
    		"	    position: relative; " + 
    		"	    padding-bottom: 0;" + 
    		"	    border: none;" + 
    		"	    box-shadow: 0 0 10px rgba(0,0,0,.2);" + 
    		"	  }" + 
    		"	  thead {" + 
    		"	    float: left;" + 
    		"	    white-space: nowrap;" + 
    		"	  }" + 
    		"	  tbody {" + 
    		"	    overflow-x: auto;" + 
    		"	    overflow-y: hidden;" + 
    		"	    position: relative;" + 
    		"	    white-space: nowrap;" + 
    		"	  }" + 
    		"	  tr {" + 
    		"	    display: inline-block;" + 
    		"	    vertical-align: top;" + 
    		"	  }" + 
    		"	  th {" + 
    		"	    border-bottom: 1px solid #a39485;" + 
    		"	  }" + 
    		"	  td {" + 
    		"	    border-bottom: 1px solid #e5e5e5;" + 
    		"	  }" + 
    		"	  }" + 
    		"</style>";
	public static void main(String[] args) {
		MailManager m=new MailManager();
		MemberVO vo=new MemberVO();
		m.naverMailSend(vo, 1);
	}
	public void naverMailSend(Object obj,int type) { 
		MemberVO vo=null;
		if(type==1)
			vo=(MemberVO)obj;
		 String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정 
	     String user = "plushan98@naver.com"; // 패스워드 
	     String password = "";      // SMTP 서버 정보를 설정한다. 
	     Properties props = new Properties(); 
	     props.put("mail.smtp.host", host); 
	     props.put("mail.smtp.port", 587); 
	     props.put("mail.smtp.auth", "true"); 
	     Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){ 
	    	 protected PasswordAuthentication getPasswordAuthentication() 
	    	 { 
	    		 return new PasswordAuthentication(user, password); 
	    	 } 
	     }); 
	     try { 
	        	MimeMessage message = new MimeMessage(session); 
	              message.setFrom(new InternetAddress(user)); 
	              message.addRecipient(Message.RecipientType.TO, new InternetAddress("plushan98@naver.com")); // 메일 제목 
	              message.setSubject("등록 내역입니다!!"); // 메일 내용
	              
	              String html="<html>"
	              		+ "<head>"
	            		+style
	            		+"</head>"
	            		+ "<body>"
	            		+ "<table>"
	            		+ "<thead>"
	            		+ "<tr>"
	            		+ "<th>회원번호</th>"
	            		+ "<td>1</td>"
	            		+ "</tr>"
	            		+ "<tr>"
	            		+ "<th>이름</th>"
	            		+ "<td>홍길동</td>"
	            		+ "</tr>"
	            		+ "<tr>"
	            		+ "<th>성별</th>"
	            		+ "<td>남자</td>"
	            		+ "</tr>"
	            		+ "<tr>"
	            		+ "<th>생일</th>"
	            		+ "<td>2023-08-23</td>"
	            		+ "</tr>"
	            		+ "<tr>"
	            		+ "<th>아이디</th>"
	            		+ "<td>hong12</td>"
	            		+ "</tr>"
	            		+ "</body>"
	            		+ "</html>";
	              		     
	              message.setContent(html,"text/html;charset=UTF-8"); // send the message 
	              Transport.send(message); 
	              System.out.println("Success Message Send"); 
	         } catch (MessagingException e) 
	          {
	        	 e.printStackTrace();
	          }
	     }
}
