package pageObjects.userPageObjects.dashboardObjects.supervisorActionPendingObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SVPendingActionObject {
	public WebDriver driver;

	public SVPendingActionObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='MuiTypography-root MuiTypography-body1 MuiCardHeader-title css-yb0lig'])[2]")
	//span[contains(text(),'Supervisor pending action')]
	WebElement SVPendingActionText;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[1]/div/div[2]/div")
	List<WebElement> SVPendingIteamsList;
	
	@FindBy(xpath="(//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'])[1]/div/div[3]/div")
	List<WebElement> SVPendingCountList;
	
	
	public String getSVPendingActionText() {
		return SVPendingActionText.getText();
	}
	
	public List<String> getSVPendingItemsList() {
		List<String> ls=new ArrayList<String>();
		for(WebElement list:SVPendingIteamsList) {
			ls.add(list.getText());
		}
		return ls;
	}
	
	public List<Integer> getSVPendingCountList() {
		List<Integer> ls=new ArrayList<Integer>();
		for(WebElement list:SVPendingCountList) {
			ls.add(Integer.parseInt(list.getText()));
		}
		return ls;
	}
	
	
	
	
}
