package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {
	WebDriver driver;
	
	public static void ScrollByVisibleElement(WebElement Element,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,450)", "");
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
}
