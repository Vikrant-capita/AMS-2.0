package testComponents.emailSent;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.io.*;

import org.testng.annotations.Test;

public class ReadEmail {

	@Test
	public void mailData() throws InterruptedException {
		receiveMail("vikrant.bingi@capita.com","password");
	}
	
	
	public void receiveMail(String username, String password) throws InterruptedException {
		try {
			Properties properties =new Properties();
			properties.setProperty("mail.store.protocol", "imaps");
			Session emailSession=Session.getDefaultInstance(properties);     		//
			Store emailStore=emailSession.getStore("imaps");
			Thread.sleep(2000);
			emailStore.connect("cias-server-smtp-uk", username, password);
			Folder emailFolder=emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message messages[]=emailFolder.getMessages();
			for(int i=messages.length-3;i<messages.length;i++) {
				Message message=messages[i];
				System.out.println("Email Number "+i+1);
				System.out.println("email subject :"+message.getSubject());
				System.out.println("sent data  :"+message.getSentDate());
				System.out.println("from :"+message.getFrom()[0]);
			}
			emailFolder.close(false);
			emailStore.close();
			
		}catch(NoSuchProviderException e){
			e.printStackTrace();
		}catch (MessagingException m) {
			m.printStackTrace();
		}
	}
	
	
	
}
