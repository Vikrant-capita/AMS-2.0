package tests.homePageTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.homepageObjects.HomepageObject;
import resources.BaseTest;
import tests.loginTest.LoginTest;

public class validateHomepageElementTest extends BaseTest {
	public LoginTest lp;
	public WebDriver driver;
	
	
	@BeforeTest
	public void initializer() throws InterruptedException, IOException	{
		
		//driver=initializeDriver();
		lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	
	
	@Test
	public void validateHomepageEleText() throws InterruptedException {
		HomepageObject hpObj=new HomepageObject(driver);
		Thread.sleep(1000);
		Assert.assertEquals(hpObj.getCapitaAMSName(), "Capita AMS");
		Assert.assertEquals(hpObj.getDashboardName(), "Dashboard");
		Assert.assertEquals(hpObj.getHROperationsName(), "HR Operation");
		Assert.assertEquals(hpObj.getReportsName(), "Reports");
	}
}
