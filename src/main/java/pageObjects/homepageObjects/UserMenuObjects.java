package pageObjects.homepageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuObjects {

	public WebDriver driver;
	
	public UserMenuObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='MuiTypography-root MuiTypography-body1 css-y64j17']")
	WebElement userNameText;
	
	@FindBy(xpath="//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeLarge css-1l1167e']")
	WebElement clickOnUserMenu;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li/div[2]/span")
	List<WebElement> menuOptionList;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]//span")
	WebElement clickOnMyProfile;
	
	
	public String getUserNameText() {
		String userName=userNameText.getText();
		return userName.substring(3, userName.length());
	}
	
	public void getClickOnUserMenu() {
		clickOnUserMenu.click();
	}
	public List<WebElement> getMenuOptionList() {
		return menuOptionList;
	}
	public void getClickOnMyProfile() {
		clickOnMyProfile.click();		
	}
	
	
}
