package testComponents.emailSent;

import org.apache.commons.mail.DefaultAuthenticator;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;



//import org.apache.commons.mail.*;
// import javax.naming.*;
// import java.sql.*;
// import java.io.*;
// import java.lang.*;
// import java.text.*;
// import java.util.*;

@Test
public class EmailSent {

	
	//EmailAttachment attachment1 = new EmailAttachment();
	
	//EmailAttachment attachment=new EmailAttachment();
 
	/*
	Email email1 = new SimpleEmail();
	email1.setHostName("smtp.gmail.com");
	email.setSmtpPort("465");
	email.setSSLOnConnect(true);
	email.setAuthenticator(new DefaultAuthenticator("vikrant.bingi@capita.com", "Admin$2145"));
	email.setSSLOnConnect(true);
	email.setFrom("user@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("bingivs@gmail");
	email.send();
	
*/
	/*
	
	email.setHostName("cias-server-smtp-uk");
	email.setSmtpPort(25);
	email.setAuthenticator(new DefaultAuthenticator("P50096390@capita.co.uk", "Admin$2145"));
	email.setSSLOnConnect(true);
	email.setFrom("user@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("foo@bar.com");
	email.send();
		
	*/
	 public static void sendEmailWithAttachment() {
	 // Create the attachment
    EmailAttachment attachment = new EmailAttachment();
    attachment.setPath(System.getProperty("user.dir") + "\\ExtentReports\\Report.html");
    //attachment.setPath(System.getProperty("user.dir") + "\\test-output\\emailable-report.html");
    attachment.setDisposition(EmailAttachment.ATTACHMENT);
    attachment.setDescription("AMS Test Run Report");



    // Create the email message
    MultiPartEmail email = new MultiPartEmail();
    email.setHostName("cias-server-smtp-uk");
    email.setSmtpPort(25);
    //email.setAuthenticator(new DefaultAuthenticator("pradnya.patil2@capita.com", "Email Password"));
    //email.setAuthenticator(new DefaultAuthenticator("p50096390@capita.co.uk", "Voice@2022"));
    try {
        email.addTo("vikrant.bingi@capita.com", "Vikrant Bingi");
        // email.addTo("Amit.Verma@capita.com", "Amit Verma");
        // email.addTo("sanjiv.kumar@capita.com", "Sanjiv Kumar");
    } catch (EmailException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        email.setFrom("vikrant.bingi@capita.com", "Me");
    } catch (EmailException e) {
        e.printStackTrace();
    }
    email.setSubject("AMS 2.0 Automation Test Execution Report");
    try {
        email.setMsg("Hello, Please find the attached test run report for your reference");
    } catch (EmailException e) {
        e.printStackTrace();
    }


//add the attachment
    try {
        email.attach(attachment);
    } catch (EmailException e) {
        e.printStackTrace();
    }

    try {
        email.send();
        System.out.println("Email Sent Successfully");
    } catch (EmailException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

