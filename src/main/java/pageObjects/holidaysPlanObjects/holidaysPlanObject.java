package pageObjects.holidaysPlanObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class holidaysPlanObject {

WebDriver driver;
	
	public holidaysPlanObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Holiday Plan')]/parent::div/parent::div//div[3]//button[1]")
	WebElement clickOnHolidayPlus;
	
	@FindBy(xpath="//div[contains(text(),'Holiday Date')]")
	WebElement holidayNameText;
	
	@FindBy(xpath="//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	WebElement checkBox;
	
	public WebElement getClickOnHolidayPlus() {
		//clickOnHolidayPlus.click();
		return clickOnHolidayPlus;
	}
	public WebElement getHolidayNameText() {
		return holidayNameText;
	}
	public void getCheckBox() {
		checkBox.click();
	}
}
