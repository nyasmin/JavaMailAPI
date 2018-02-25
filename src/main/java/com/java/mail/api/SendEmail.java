package com.java.mail.api;
public class SendEmail {
	
	
	
	public static void main(String args[]){
		String receiverEmailId = "nilofaryasmin.ny@gmail.com";
		 String emailSubject = "MIME TESTING";
		 String emailBody = "WOW";
		SendGmail mail = new SendGmail(receiverEmailId,emailSubject,emailBody);
		//sendSimpleEmail();
		//sendEmailWithAttach();
	}
	
	public static String sendSimpleEmail(){
		return null;
	}
	
	public static String sendEmailWithAttach(){
		return null;
	}

}
