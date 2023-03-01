package pageObjects.userPageObjects.homepageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageObject {

public WebDriver driver;
	
	public HomepageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	By capitaAMSName=By.xpath("//div[contains(text(),'Capita AMS')]");
	By dashboardName=By.xpath("//span[contains(text(),'Dashboard')]");
	By hrOperationsName=By.xpath("//span[contains(text(),'HR Operation')]");
	By reportsName=By.xpath("//span[contains(text(),'Reports')]");
	
	By searchBox= By.cssSelector(".css-k58djc");
	By searchEmpBox=By.id(":r8h:");
	
	
	public String getCapitaAMSName() {
		return driver.findElement(capitaAMSName).getText();
	}
	public String getDashboardName() {
		return driver.findElement(dashboardName).getText();
	}
	public String getHROperationsName() {
		return driver.findElement(hrOperationsName).getText();
	}
	public String getReportsName() {
		return driver.findElement(reportsName).getText();
	}
	public void getSearchBox()
	{
		driver.findElement(searchBox).click();;
	}
	public void getSearchEmpBox(String empName) {
		driver.findElement(searchEmpBox).sendKeys("empName");;;
	}
	
			
}
