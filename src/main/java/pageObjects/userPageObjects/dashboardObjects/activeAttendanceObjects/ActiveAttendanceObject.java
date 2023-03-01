package pageObjects.userPageObjects.dashboardObjects.activeAttendanceObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveAttendanceObject {
	public WebDriver driver;

	public ActiveAttendanceObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Active Attendance')]")
	WebElement activeAttendanceText;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-columnHeadersInner css-vcjdx3'])[2]/div/div/div/div/div/div")
	List<WebElement> tableHeaders;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[2]/div/div[4]/div")
	List<WebElement> statusColor;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[2]/div/div[4]/p")
	List<WebElement> statusText;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[2]/div/div[1]/p")
	List<WebElement> scheduledList;
	
	//@FindBy(xpath="(//p[@class='MuiTablePagination-displayedRows css-1chpzqh'])[2]")
	//WebElement 
	
	@FindBy(xpath="(//div[@class='MuiTablePagination-actions'])[2]/button[2]")
	WebElement clickOnNextArrow;
	
	
	
	public WebElement getActiveAttendanceText() {
		return activeAttendanceText;
	}
	public List<String> getTableHeaders() {
		List<String> headersNameList=new ArrayList<String>();
		for(WebElement ls:tableHeaders) {
			headersNameList.add(ls.getText());
		}
		return headersNameList;
	}
	
	public List<WebElement> getStatusColor() {
		return statusColor;
	}
	
	public List<WebElement> getStatusText() {
		return statusText;
	}
	public List<WebElement> getScheduledList() {
		return scheduledList;
	}
	
	public WebElement getClickOnNextArrow() {
		return clickOnNextArrow;
	}
	
	
	
}
