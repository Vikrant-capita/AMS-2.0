package tests.holidayPlanTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.holidaysPlanObjects.holidaysPlanObject;
import pageObjects.homepageObjects.SearchEmpObjects;
import tests.loginTest.LoginTest;
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
	
	@Test
	public void validateHolidayList() throws InterruptedException {
		holidaysPlanObject hpObj=new holidaysPlanObject(driver);
		Thread.sleep(2000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,400)");
		//js.executeScript("arguments[0].scrollIntoView();", hpObj.getClickOnHolidayPlus());
		JavaScriptExecutor.ScrollByVisibleElement(hpObj.getClickOnHolidayPlus(),driver);
		hpObj.getClickOnHolidayPlus().click();
		
		Synchronization sync=new Synchronization(driver);
		sync.visibilityOf(hpObj.getHolidayNameText());
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
