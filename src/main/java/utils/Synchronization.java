package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

public class Synchronization {
	
	public  WebDriver driver;
	public  WebDriverWait wait;
	
	public Synchronization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public void elementToBeClickable(WebElement ele) {
    	wait = new WebDriverWait (driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
    
    public  void visibilityOf(WebElement ele) {
    	wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(ele));
    }
    
    
    public  void invisibilityOfEleLocated(WebElement ele) {
    	wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ContentPlaceHolderBody_TabContainer1_TabPanel1_GridLeave_LBLWorkingDate_0")));
    }
	
    //workingDate
	
	
	
}
