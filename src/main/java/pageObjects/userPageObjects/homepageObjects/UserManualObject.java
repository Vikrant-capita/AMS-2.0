package pageObjects.userPageObjects.homepageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManualObject {

public WebDriver driver;
	
	public UserManualObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-i6s8oy']/button[2]")
	WebElement clickOnUserManual;
	
	@FindBy(xpath="//li[@role='menuitem'][1]")
	WebElement clickOnDownloadUserGuide;
	
	@FindBy(xpath="//li[@role='menuitem'][2]")
	WebElement clickOnDownloadFAQ;
	
	
	public WebElement getClickOnUserManual() {
		return clickOnUserManual;
	}
	public WebElement getClickOnDownloadUserGuide() {
		return clickOnDownloadUserGuide;
	}
	public WebElement getClickOnDownloadFAQ() {
		return clickOnDownloadFAQ;
	}
	
	
}
