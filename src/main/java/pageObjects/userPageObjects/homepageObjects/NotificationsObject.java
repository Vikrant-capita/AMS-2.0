package pageObjects.userPageObjects.homepageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationsObject {
public WebDriver driver;
	
	public NotificationsObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='MuiBadge-root MuiBadge-root css-1rzb3uu']//span")
	WebElement clickOnNotificationBtn;
	
	public WebElement getClickOnNotificationBtn() {
		return clickOnNotificationBtn;
	}
	
}
//button[text()='Open']/parent::div/parent::div/div[2]/span -----Message
//button[text()='Open']/parent::div/parent::div/div[3]/span -------Posted

//div[text()='Message']/../../../../../../../../div[2]/descendant::div[@data-field='message']/span-----Message
//div[text()='Message']/../../../../../../../../div[2]/descendant::div[@data-field='posted']/span-----Posted

//div[text()='Message']/ancestor::div[@class='MuiDataGrid-main css-opb0c2']/div[2]/descendant::div[@data-field='message']/span-----Message
//div[text()='Message']/ancestor::div[@class='MuiDataGrid-main css-opb0c2']/div[2]/descendant::div[@data-field='posted']/span-----Posted