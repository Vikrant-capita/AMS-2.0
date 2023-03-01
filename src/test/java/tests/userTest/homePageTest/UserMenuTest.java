package tests.userTest.homePageTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.userPageObjects.homepageObjects.UserMenuObjects;
//import pageObjects.homepageObjects.UserMenuObjects;
import resources.BaseTest;
import tests.userTest.loginTest.LoginTest;
import utils.excelDriven.ExcelDataValidation;
import utils.excelDriven.excelDriven;

public class UserMenuTest extends BaseTest {
	public WebDriver driver;
	public Properties prop;
	UserMenuObjects userMenuObj;
	public String userNameText;
	
		@BeforeTest
		public void initializer() throws IOException, InterruptedException {
			LoginTest lp=new LoginTest();
			driver=lp.validateUserLogin();
		}
		
		@Test(priority=1)
		public void validateUserNameText() throws IOException, InterruptedException {
			userMenuObj=new UserMenuObjects(driver);
			Thread.sleep(1500);
			userNameText=userMenuObj.getUserNameText();
			System.out.println("user name text :"+userNameText);
			prop=getProperties();
		    String userEmpID=prop.getProperty("prodUserName").substring(1,9);
		    System.out.println("Emp Id :"+userEmpID);
		   // Integer.parseInt(prodUserName);
		    ExcelDataValidation ex=new ExcelDataValidation();
		    List<String> excelDataList= ex.excelDataValidation("Pradnya Patil1", "Name", "ProfileData_Old");
//		    excelDriven ex1=new excelDriven();
//		    List<String> empProfileData=ex1.getData("Senior Software Consultant", "Role");
//		    System.out.println(excelDataList.get(2));
//		    Assert.assertEquals(excelDataList.get(2), userEmpID,"User empID/Name not matching");
		    System.out.println("excel list size :"+excelDataList.size());
		    for(String s:excelDataList) {
				System.out.println("Excel data :"+s);
			}
		}
		
		@Test(priority=2)
		public void validateMenuOption(){
			userMenuObj=new UserMenuObjects(driver);
			userMenuObj.getClickOnUserMenu();
			List<WebElement> menuOptionList=userMenuObj.getMenuOptionList();
			Assert.assertEquals(menuOptionList.get(0).getText(), "My Profile");  
			Assert.assertEquals(menuOptionList.get(1).getText(), "Logout");  
		}
		
		//@Test(priority=3)
		public void validateMyProfile() throws InterruptedException, IOException {
			userMenuObj=new UserMenuObjects(driver);
			userMenuObj.getClickOnMyProfile();
			//Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
	    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root css-1cjh36w']"))));
			
	    	ExcelDataValidation excelProfile=new ExcelDataValidation();
			List<String> empProfileData=excelProfile.excelDataValidation("Pradnya Patil","Name","ProfileData");
			for(String s:empProfileData) {
				System.out.println("Excel data :"+s);
			}
			
		}
		
		
		@AfterTest
		public void tearDown() {
			driver.close();
		}
}


