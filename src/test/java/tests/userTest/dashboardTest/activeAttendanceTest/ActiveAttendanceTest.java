package tests.userTest.dashboardTest.activeAttendanceTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.userPageObjects.dashboardObjects.activeAttendanceObjects.ActiveAttendanceObject;
import pageObjects.userPageObjects.dashboardObjects.supervisorActionPendingObjects.SVPendingActionObject;
import tests.userTest.loginTest.LoginTest;

public class ActiveAttendanceTest {
	public WebDriver driver;
	public ActiveAttendanceObject actAtteObj;
		
	@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//validateUserLogin(driver);
		LoginTest lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	
	@Test(priority=1)
	public void verifyActiveAttendanceText() throws InterruptedException {
		actAtteObj=new ActiveAttendanceObject(driver);
		Thread.sleep(3000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='actAtteObj.getActiveAttendanceText()']"))));
		Assert.assertTrue(actAtteObj.getActiveAttendanceText().isDisplayed());
		
		List<String> headerList=actAtteObj.getTableHeaders();
		Assert.assertEquals(headerList.get(0), "Scheduled");
		Assert.assertEquals(headerList.get(1), "InTime");
		Assert.assertEquals(headerList.get(2), "OutTime");
		Assert.assertEquals(headerList.get(3), "Status");
		Assert.assertEquals(headerList.get(4), "Action");
		
		//WebElement ele=driver.findElement(By.xpath("(//div[@class='MuiAvatar-root MuiAvatar-rounded MuiAvatar-colorDefault css-lndzjk'])[1]"));
		//WebElement ele=driver.findElement(By.xpath("(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[2]/div/div[4]/div"));

		
//		System.out.println("Attribute :"+ele.getAttribute("style"));
//		System.out.println("bgd color :"+ele.getCssValue("background-color"));
//		System.out.println("color :"+ele.getCssValue("color"));
//		String c=ele.getAttribute("background-color");
//		//Color.fromString(c).asHex();
//		System.out.println("bckgnd Hex :"+Color.fromString(ele.getCssValue("background-color")).asHex());
//		System.out.println("Hex :"+Color.fromString(ele.getCssValue("color")).asHex());
//		System.out.println("font size :"+ele.getCssValue("font-size"));
//		System.out.println("font family :"+ele.getCssValue("font-family"));
//		System.out.println("font align :"+ele.getCssValue("font-align"));
		
	}
	
	@Test(priority=2)
	public void validateStatusColor() throws InterruptedException {
		actAtteObj=new ActiveAttendanceObject(driver);
		List<WebElement> statusColorList=actAtteObj.getStatusColor();
		List<WebElement> statusTextList= actAtteObj.getStatusText();
		//String attributeText=actAtteObj.getClickOnNextArrow().getAttribute("class");
		while(!actAtteObj.getClickOnNextArrow().getAttribute("class").contains("disabled")){
			for(int i=0;i<statusTextList.size(); i++) {
				System.out.println("status color :"+statusColorList.get(i).getCssValue("background-color"));
				System.out.println("bckgnd Hex :"+Color.fromString(statusColorList.get(i).getCssValue("background-color")).asHex());
				String backgndHex=Color.fromString(statusColorList.get(i).getCssValue("background-color")).asHex();
				if(statusTextList.get(i).getText().equalsIgnoreCase("UA")|| statusTextList.get(i).getText().equalsIgnoreCase("ABD") || statusTextList.get(i).getText().equalsIgnoreCase("LWP") || statusTextList.get(i).getText().equalsIgnoreCase("SLWP") || statusTextList.get(i).getText().equalsIgnoreCase("SA") || statusTextList.get(i).getText().equalsIgnoreCase("SBL")) {
					System.out.println("Status text :"+statusTextList.get(i).getText());
					Assert.assertEquals(backgndHex, "#ff1a1a","color not matching");
				}
				else {
					//System.out.println("");
					System.out.println("Status text :"+statusTextList.get(i).getText());
					Assert.assertEquals(backgndHex, "#4caf50","color not matching");
					//#4caf50 green
				}
			}//Thread.sleep(1000);
			actAtteObj.getClickOnNextArrow().click();
		}
			
	}

	@Test(priority=3)
	public void validatePayrollList() throws InterruptedException {
		actAtteObj=new ActiveAttendanceObject(driver);
		List<WebElement> schedulesList=actAtteObj.getScheduledList();
		
	//	WebElement isNextArrowEnabled=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj']"));
		//Boolean flag=isNextArrowEnabled.isEnabled();
		//System.out.println("flag status outside while :"+flag);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		//Thread.sleep(2000);
		String attributeText=actAtteObj.getClickOnNextArrow().getAttribute("class");
		while(!actAtteObj.getClickOnNextArrow().getAttribute("class").contains("disabled")){
			for(WebElement ls:schedulesList){
				System.out.println("scheduled list :"+ls.getText());
			}

			System.out.println("Attribute :"+attributeText);
			Thread.sleep(2000);
			actAtteObj.getClickOnNextArrow().click();
		}
	}
	
		
	 @AfterTest
	public void tearDown() throws InterruptedException {
		driver.close();
	}
	
}
