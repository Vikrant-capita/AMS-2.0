package tests.userTest.dashboardTest.SVPendingActionTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import pageObjects.dashboardObjects.supervisorActionPendingObjects.SVPendingActionObject;
import pageObjects.userPageObjects.dashboardObjects.supervisorActionPendingObjects.SVPendingActionObject;
import tests.userTest.loginTest.LoginTest;
import utils.Synchronization;

public class SVPendingActionTest {
	public WebDriver driver;
	public SVPendingActionObject SVPendObj;
	int pendCount;
		
	@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//validateUserLogin(driver);
		LoginTest lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	@Test(priority=1)
	public void validateSVPendingActionItems() throws InterruptedException {
		SVPendObj =new SVPendingActionObject(driver);
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
//    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiCardHeader-title css-yb0lig'])[2]"))));
//		Synchronization sync=new Synchronization(driver);
//		sync.elementToBeClickable(SVPendObj.getSVPendingActionText1());
		System.out.println(SVPendObj.getSVPendingActionText());
		Assert.assertEquals(SVPendObj.getSVPendingActionText(), "Supervisor pending action");
		List<String> itemsList=SVPendObj.getSVPendingItemsList();
		Assert.assertEquals(itemsList.get(0), "Exception");
		Assert.assertEquals(itemsList.get(1), "Holiday");
		Assert.assertEquals(itemsList.get(2), "Leave");
		
	}
	
	public int getSVPendingCount1() throws InterruptedException {
		SVPendObj =new SVPendingActionObject(driver);
		//Thread.sleep(1500);
//		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
//   	wait.until(ExpectedConditions.elementToBeClickable(SVPendObj.getSVPendingItemsList()));
		List<String> pendingItems=SVPendObj.getSVPendingItemsList();
		List<Integer> pendingCount=SVPendObj.getSVPendingCountList();
		for(int i=0;i<pendingItems.size();i++) {
			if(pendingItems.get(i).equalsIgnoreCase("Holiday")) {
				//System.out.println("Count :"+pendingCount.get(i));
				pendCount=pendingCount.get(i);
			}
		}return pendCount;
	}
	
	@Test(priority=2)
	public void getSVpendingCount() throws InterruptedException {
		//int count= getSVPendingCount1();
		 System.out.println("Count :"+getSVPendingCount1());
	}

}
