package tests.homePageTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.homepageObjects.UserManualObject;
import tests.loginTest.LoginTest;
import utils.Synchronization;

public class UserManualTest {
public WebDriver driver;
UserManualObject userMan;
	
	@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//validateUserLogin(driver);
		LoginTest lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	
	@Test
	public void validateUserManualOption() throws InterruptedException {
		userMan =new UserManualObject(driver);
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
    	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-i6s8oy']/button[2]"))));
		//wait.until(ExpectedConditions.visibilityOf(userMan.getClickOnUserManual()));
    	Synchronization sync=new Synchronization(driver);
    	sync.elementToBeClickable(userMan.getClickOnUserManual());
    	//new Synchronization(driver ).elementToBeClickable(userMan.getClickOnUserManual());
		userMan.getClickOnUserManual().click();;
		Assert.assertTrue(userMan.getClickOnDownloadUserGuide().isDisplayed(),"Download User Guide option is not displayed");
		Assert.assertTrue(userMan.getClickOnDownloadFAQ().isDisplayed(),"Download FAQ's option is not displayed");
	
	}
	
	
	
}
