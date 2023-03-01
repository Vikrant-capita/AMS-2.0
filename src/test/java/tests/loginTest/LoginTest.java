package tests.loginTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.loginObjects.LoginPageObject;
import resources.BaseTest;
import utils.Synchronization;

public class LoginTest extends BaseTest{

	public WebDriver driver;
	public LoginPageObject loginpg;
	public SoftAssert sa;
	Properties prop;
	WebDriverWait wait;
	
	//@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//validateUserLogin(driver);
	}
	
	@Test(priority=1)
	public WebDriver validateUserLogin() throws IOException, InterruptedException {
		driver=initializeDriver();
		loginpg=new LoginPageObject(driver); 
		prop=getProperties();
	    String prodUserName=prop.getProperty("prodUserName");
	    String prodPass=prop.getProperty("prodUserPass");
	    loginpg.getUser(prodUserName);
		loginpg.getClickBtn();
		loginpg.getPass(prodPass);
		
//		wait = new WebDriverWait (driver, Duration.ofSeconds(10));
//    	wait.until(ExpectedConditions.elementToBeClickable(loginpg.getPassNextBtn()));
    	//Synchronization sync=new Synchronization(driver);
    	//sync.elementToBeClickable(loginpg.getPassNextBtn());
		//new Synchronization(driver).elementToBeClickable(loginpg.getPassNextBtn());
    	Thread.sleep(2000);
		loginpg.getPassNextBtn().click();;
		loginpg.getsignInButton();
		String loginTittle=driver.getTitle();
		System.out.println(loginTittle);
		Assert.assertEquals(loginTittle, "AMS 2.0");
		System.out.println("Login Tittle Matched");	
		return driver;
	}

	//@Test(priority=2)
	public void validateUserLogout() throws InterruptedException {
		Thread.sleep(4000);
		loginpg.getLogoutMenuButton();
		loginpg.getClickOnLogout();
	}
	
	//@Test
	public void validateAllCred() throws IOException, InterruptedException {
		driver=initializeDriver();
		loginpg=new LoginPageObject(driver); 
		prop=getProperties();
	    String prodUserName=prop.getProperty("prodUserName");
	    String prodPass=prop.getProperty("prodUserPass");
	    loginpg.getUser(prodUserName);
		loginpg.getClickBtn();
		
		
		try 
		{
			//System.out.println("displayed:"+driver.findElement(By.id("usernameError")).isDisplayed());
			if(driver.findElement(By.id("usernameError")).isDisplayed()) 
			{
				System.out.println("Username Error:"+driver.findElement(By.id("usernameError")).getText());
				Assert.assertEquals(driver.findElement(By.id("usernameError")).getText(), "We couldn't find an account with that username.");
				driver.close();
			}
		}catch(NoSuchElementException e) {
			loginpg.getPass(prodPass);
			//Synchronization sync=new Synchronization(driver);
	    	//sync.elementToBeClickable(loginpg.getPassNextBtn());
	    	Thread.sleep(1500);
	    	loginpg.getPassNextBtn().click();
			try {
				if(driver.findElement(By.cssSelector("#passwordError")).isDisplayed()) 
				{
					System.out.println("Username Error:"+driver.findElement(By.cssSelector("#passwordError")).getText());
					Assert.assertEquals(driver.findElement(By.cssSelector("#passwordError")).getText(), "Your account or password is incorrect. If you don't remember your password, reset it now.");
					driver.close();
				}
			}catch(NoSuchElementException e1) {
				//wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		    	//wait.until(ExpectedConditions.elementToBeClickable(loginpg.getPassNextBtn()));
				//new Synchronization(driver).elementToBeClickable(loginpg.getPassNextBtn());
				loginpg.getsignInButton();
				String loginTittle=driver.getTitle();
				System.out.println(loginTittle);
				Assert.assertEquals(loginTittle, "AMS 2.0");
				System.out.println("Login Tittle Matched");	
				driver.close();
			}
		}
				
				//return driver;
	}
			
		
		
	
	
}
