package tests.loginTest;

import java.io.IOException;
import java.time.Duration;

import java.util.HashMap;

import java.util.List;

import org.openqa.selenium.By;

//import org.openqa.selenium.By <http://org.openqa.selenium.By> ;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginObjects.CalendarHandleObjects;

public class CalenderHandle {

	public WebDriver driver;
	public String monthandYear;
	public WebElement currentDate;
	public LoginTest lp;

	@BeforeTest
	public void initializer() throws InterruptedException, IOException {

		// driver=initializeDriver();
		lp = new LoginTest();
		driver = lp.validateUserLogin();
	}

	// @BeforeTest

	public void login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://ams-in-dev.azurewebsites.net/"); // AMS 2.0
		// driver.get("https://capita-cm-in-ams-int.azurewebsites.net"); //INT
		// driver.get("https://ams-in.capita.co.in/Mypage/Home.aspx"); //Prod
		driver.findElement(By.name("loginfmt")).sendKeys("P50096390@capitaindia.onmicrosoft.com");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("January@2023");
		Thread.sleep(2000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='submit']"))));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("exception name: " + e.getMessage());
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
		driver.findElement(By.xpath("//*[@id='idBtn_Back']")).click();
	}

	@Test

	public void calenderTest() throws InterruptedException {
		CalendarHandleObjects cho = new CalendarHandleObjects(driver);
		Thread.sleep(2000);
		cho.getClickonPlusButton();
		Thread.sleep(1200);
		cho.getCalendar();
		WebElement prevClick = cho.getPrevClick();
		WebElement nextclick = cho.getNextclick();
		String expDate = "20";
		String expMonth = "June";
		String expYear = "2023";
		monthandYear = expMonth.concat(" " + expYear);
		Thread.sleep(500);
		currentDate = cho.getCurrentDate();
		System.out.println("current date:" + currentDate.getText());
		String currYear = currentDate.getText().split(" ")[1];
		String currMonth = currentDate.getText().split(" ")[0];
		while (!currentDate.getText().contains(monthandYear)) {
			prevNextButtonAction(driver, expYear, currYear, expMonth, currMonth, nextclick, prevClick);
		}
		List<WebElement> dates = cho.getDates();
		for (WebElement date : dates) {
			if (date.getText().contains(expDate)) {
				date.click();
				break;
			}
		}

	}

	public static void prevNextButtonAction(WebDriver driver, String expyear, String actyr, String expmonth,
			String currMonth, WebElement next, WebElement prev) {
		{
			if(Integer.parseInt(expyear)>Integer.parseInt(actyr))
			{
				next.click();
			}
			if(Integer.parseInt(expyear)==Integer.parseInt(actyr))
			{
				int exp = monthConversion(expmonth);
				int act = monthConversion(currMonth);
				if(exp>act)
				{
					next.click();
				}
				else
				{
					prev.click();
				}
			}
			if(Integer.parseInt(expyear)<Integer.parseInt(actyr))
			{
				prev.click();
			}
		}
	}

	public static int monthConversion(String month)

	{
		String month1 = month.substring(0, 3);
		// System.out.println("month :"+month);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Jan", 1);
		hm.put("Feb", 2);
		hm.put("Mar", 3);
		hm.put("Apr", 4);
		hm.put("May", 5);
		hm.put("Jun", 6);
		hm.put("Jul", 7);
		hm.put("Aug", 8);
		hm.put("Sep", 9);
		hm.put("Oct", 10);
		hm.put("Nov", 11);
		hm.put("Dec", 12);
		int Month = hm.get(month1);
		return Month;

	}
}
