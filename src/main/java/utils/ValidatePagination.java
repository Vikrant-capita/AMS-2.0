package utils;

import org.openqa.selenium.WebElement;

public class ValidatePagination {

	public void validatePagination(WebElement isNextArrowEnabled ) throws InterruptedException {

		Boolean flag=isNextArrowEnabled.isEnabled();
		System.out.println("flag status outside while :"+flag);
		Thread.sleep(2000);
		while(isNextArrowEnabled.isEnabled()){
		
				//driver.findElement(By.xpath("//div[@class='MuiTablePagination-actions']/button")).isEnabled();
		System.out.println("flag status :"+flag);
		isNextArrowEnabled.click();
		}
	
	}
	
	
}
