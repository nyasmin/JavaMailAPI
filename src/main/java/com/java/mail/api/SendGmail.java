package com.java.mail.api;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGmail {
	
	final String senderEmailId = "nilofaryasmin.ny@gmail.com";
	final String senderPassword = "Abbakibeti@2";
	final String emailSMPTServer = "smtp.gmail.com";
	final String emailServerPort = "587";
	String receiverEmailId = "nilofaryasmin.ny@gmail.com";
	String emailSubject = "MIME TESTING";
	String emailBody = "WOW";
	
	public SendGmail(String receiverEmailId,String emailSubject, String emailBody){
		
		Properties prop = new Properties();
		prop.put("mail.smtp.user",senderEmailId);
		prop.put("mail.smtp.host",emailSMPTServer);
		prop.put("mail.smtp.port",emailServerPort);
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.auth","true");
		//prop.put("mail.smtp.socketFactory.port",emailServerPort);
		//prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		//prop.put("mail.smtp.socketFactory.fallback","true");
		//SecurityManager security = System.getSecurityManager();
		
		try{
		
			Session session = Session.getInstance(prop, new Authenticator() {
				// Set the account information session，transport will send mail
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmailId,senderPassword);
				}
			});
	
			
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailId));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailId));
			Transport.send(msg);
			System.out.println("Message send");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
