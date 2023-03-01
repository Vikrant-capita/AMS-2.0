package pageObjects.loginObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarHandleObjects {
	public WebDriver driver;
	
	public CalendarHandleObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[text()='Leave Plan']/parent::div/parent::div/div[3]/div/button)[1]")
	WebElement clickonPlusButton;
	
	@FindBy(xpath="(//button[@aria-label='Choose date, selected date is Dec 3, 2022'])[1]")
	WebElement calendar;
	
	@FindBy(xpath="//button[@title='Previous month']") 
	WebElement prevClick;
	
	@FindBy(xpath="//button[@title='Next month']")
	WebElement nextclick;
	
	@FindBy(xpath="//div[@class='MuiPickersCalendarHeader-label css-1v994a0']")
	WebElement currentDate;
	
	@FindBy(xpath="//div[@class='MuiDayPicker-weekContainer css-mvmu1r']/button")
	List<WebElement> dates;
	
	
	
	public void getClickonPlusButton() {
		clickonPlusButton.click();
	}
	public void getCalendar() {
		calendar.click();
	}
	public WebElement getPrevClick() {
		return prevClick;
	}
	public WebElement getNextclick() {
		return nextclick;
	}
	public WebElement getCurrentDate() {
		return currentDate;
	}
	public List<WebElement> getDates() {
		return dates;
	}

	
}
