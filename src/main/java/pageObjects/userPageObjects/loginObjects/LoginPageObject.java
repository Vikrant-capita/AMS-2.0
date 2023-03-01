package pageObjects.userPageObjects.loginObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	
	public WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By user=By.name("loginfmt");
	By userNextButton=By.xpath("//input[@id='idSIButton9']");
	By pass=By.xpath("//input[@name='passwd']");
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement getPassNextBtn;
	
	By signInButton=By.xpath("//*[@id='idBtn_Back']");
	
	
	By logoutMenuButton=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeLarge css-1l1167e']");
	By clickOnLogout=By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[2]/div[2]");
	
	//after logout click on "Website" to relogin
	By clickOnWebsite=By.xpath("//span[@class='emphasis']");
	By clickOnUseAnotherAccount=By.xpath("//div[contains(text(),'Use another account')]");
	
	
	//Forgot Pass
	By clickOnForgotPassLink=By.id("idA_PWD_ForgotPassword");
	By enterEmail=By.id("ContentPlaceholderMainContent_TextBoxUserIdentifier");
    By captchaImage=By.xpath("//img[@id='RepMapVisualChallenge']");
    By captchTextBox=By.id("RepMapChallengeSolution");
	By clickOnNextBtn=By.cssSelector("#ContentPlaceholderMainContent_ButtonNext");
    
	public void getUser(String username) {
		driver.findElement(user).sendKeys(username);
	}
	
	public void getClickBtn() {
		driver.findElement(userNextButton).click();;
	}
	
	public void getPass(String password) {
		driver.findElement(pass).sendKeys(password);
	}
	
	public WebElement getPassNextBtn() {
		return getPassNextBtn;
	}
	
	public void getsignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public void getLogoutMenuButton() {
		driver.findElement(logoutMenuButton).click();
	}
	
	public String getClickOnLogout() {
		String signOutText=driver.findElement(clickOnLogout).getText();
		return signOutText;
	}
	
	public void getClickOnWebsite() {
		driver.findElement(clickOnWebsite).click();
	}
	public void getClickOnUseAnotherAccount() {
		driver.findElement(clickOnUseAnotherAccount).click();
	}
	
	//=============forgot password=============================
	public void getClickOnForgotPassLink() {
		driver.findElement(clickOnForgotPassLink).click();
		}
	
	public void getEnterEmail(String userName) {
		driver.findElement(enterEmail).sendKeys(userName);
	}
	
	public WebElement getCaptchImage() {
		return driver.findElement(captchaImage);
	}
	
	public void getCaptchTextBox(String captchText) {
		driver.findElement(captchTextBox).sendKeys(captchText);
	}
	
	public void getClickOnNextBtn() {
		driver.findElement(clickOnNextBtn).click();
	}
}


