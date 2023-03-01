package pageObjects.userPageObjects.homepageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmpObjects {
	WebDriver driver;
	
	public SearchEmpObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search Employee...by firstname,lastname,employeeid']")
	WebElement clickOnSearchEmp;
	
	@FindBy(css=".css-1ujsas3")
	List<WebElement> allMatchingNameListWeb;
	
	@FindBy(xpath="//div[@class='MuiCardHeader-content css-11qjisw']//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
	List<WebElement> userInfoList;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//a")
	List<WebElement> contactInfoList;
	
	@FindBy(xpath="(//div[@class='MuiDialogContent-root css-1ty026z'])[2]/div[3]/div[2]/div/div[2]")
	List<WebElement>  generalInformationList;
	
	
	
	public WebElement getClickOnSearchEmp() {
		return clickOnSearchEmp;
	}
	public List<WebElement> getAllMatchingNameList() {
		return allMatchingNameListWeb;
	}
	
	 public List<WebElement> getUserInfoList() {
	      return userInfoList;								//3 elements
	 }
	 public List<WebElement> getContactInfoList() {
	      return contactInfoList;								//3 elements
	 }
	 
	 public List<WebElement> getGeneralInformationList() {
	      return generalInformationList;						//20 elements
	 } 
	
}
