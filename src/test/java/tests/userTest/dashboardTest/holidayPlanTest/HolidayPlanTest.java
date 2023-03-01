package tests.userTest.dashboardTest.holidayPlanTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.userPageObjects.dashboardObjects.holidaysPlanObjects.holidaysPlanObject;
//import pageObjects.homepageObjects.SearchEmpObjects;
import pageObjects.userPageObjects.homepageObjects.SearchEmpObjects;
import tests.userTest.loginTest.LoginTest;
import utils.JavaScriptExecutor;
import utils.Synchronization;

public class HolidayPlanTest {
	public WebDriver driver;
	public SearchEmpObjects seObj;
	
	@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		LoginTest lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	/*
	 Verify "Holiday plan" is displayed down the "active attendance"
	Verify column names of holiday list
	Verify collapsar and expander arrow
	Verify all the applied holidays(Past & future dated) are displaying in Holiday plan window
	User is able to see "Request a Holiday"  button  and it's working
	Verify all holiday List
	Verify "Show All" check box availability and it functinality
	User is able to navigate to next pages(if more that one page is available) and able to close the window.
	User is able to close the "Upcoming Holiday"window
	 */
	
	@Test(priority=1)
	public void validateHolidayList() throws InterruptedException {
		holidaysPlanObject hpObj=new holidaysPlanObject(driver);
		Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,400)");
		//js.executeScript("arguments[0].scrollIntoView();", hpObj.getClickOnHolidayPlus());
		JavaScriptExecutor.ScrollByVisibleElement(hpObj.getClickOnReqHoliday(),driver);
		
		System.out.println("holiday text :"+hpObj.getHolidayPlanText());
		
		hpObj.getClickOnReqHoliday().click();
		
		
		Synchronization sync=new Synchronization(driver);
		//sync.visibilityOf(hpObj.getHolidayNameText());
		Thread.sleep(1000);
		//hpObj.getCheckBox();
		//List<WebElement> holidayList=driver.findElements(By.xpath("//div[text()='Holiday Date']/ancestor::div[@class='MuiDataGrid-main css-opb0c2']/div[2]/descendant::div[@class='MuiDataGrid-row']/div[2]/div"));
		List<WebElement> holidayList=driver.findElements(By.xpath("//div[@data-field='holidayDate']/div"));
		System.out.println("size :"+holidayList.size());
		for(WebElement hl:holidayList) {
			System.out.println(hl.getText());
		}
		//holidayList.stream().forEach(s->System.out.println("holiday list :"+s));
		
		
	}
}
