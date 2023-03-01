package tests.userTest.homePageTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.userPageObjects.homepageObjects.HomepageObject;
import pageObjects.userPageObjects.homepageObjects.SearchEmpObjects;
import tests.userTest.loginTest.LoginTest;
import utils.excelDriven.ExcelDataValidation;

public class validateSearchEmpTest {
	public WebDriver driver;
	public SearchEmpObjects seObj;
	String empSearchText="Pradnya Patil";
	//String empSearchText="Mayank Geete";
	//String empSearchText="Vikrant Bingi";
	List<String> allUserDetailsList;
	
	
	@BeforeTest
	public void initializer() throws IOException, InterruptedException {
		//driver=initializeDriver();
		//validateUserLogin(driver);
		LoginTest lp=new LoginTest();
		driver=lp.validateUserLogin();
	}
	
	@Test
	public void validateSearchEmpDetails() throws IOException, InterruptedException {
		HomepageObject hpObj=new HomepageObject(driver);
		Thread.sleep(1500);
		hpObj.getSearchBox();
		seObj=new SearchEmpObjects(driver);
		seObj.getClickOnSearchEmp().sendKeys(empSearchText);
		Thread.sleep(5000);
		List<WebElement> allMatchingNameListWeb=seObj.getAllMatchingNameList();
		List<String> allMatchingNameList=new ArrayList<String>();
		for(WebElement matchingName:allMatchingNameListWeb) {
			System.out.println("search text list:"+matchingName.getText());
			if(matchingName.getText().contains(empSearchText)) {
				System.out.println("text matched");
				//Thread.sleep(1000);
				matchingName.click();
			}
			//allMatchingNameList.add(matchingName.getText());
		}
		validateUserDetails();
	}
	
	public void validateUserDetails() throws IOException {
		//seObj=new SearchEmpObjects(driver);
		List<WebElement> userInfoList=seObj.getUserInfoList();
		List<WebElement> contactInfoList=seObj.getContactInfoList();
		List<WebElement> generalInfoList=seObj.getGeneralInformationList();
		
		ExcelDataValidation excelProfile=new ExcelDataValidation();
		List<String> empProfileData=excelProfile.excelDataValidation(userInfoList.get(0).getText(),"Name","ProfileData");
		//List<String> empProfileData=excelProfile.excelDataValidation("Vikrant Bingi","Name","ProfileData");
		
		System.out.println("Excel Size :"+empProfileData.size());
		allUserDetailsList=new ArrayList<String>();
		
		//-----------adding string list to another string list using stream-----------------------
		//allUserDetailsList.stream().collect(Collectors.toCollection(userInfoList));
		
		//----------------convert webelement to string list using stream------------------------
		//userInfoList.stream().map(WebElement::getText).forEach(allUserDetailsList::add);
		
		for(int i=0; i<userInfoList.size();i++) {
			//System.out.println("initial size all:"+allUserDetailsList.size());
			//Assert.assertEquals(userInfoList.get(i).getText(), empProfileData.get(i));
			allUserDetailsList.add(userInfoList.get(i).getText());
			System.out.println("user info size all:"+allUserDetailsList.size());
		}
		
		//allUserDetailsList.addAll(contactInfoList.get(0));
		for(int i=0; i<contactInfoList.size();i++) {
			allUserDetailsList.add(contactInfoList.get(i).getText());
			System.out.println("contact info size all:"+allUserDetailsList.size());
		}
		for(int i=0; i<generalInfoList.size();i++) {
			allUserDetailsList.add(generalInfoList.get(i).getText());
			//System.out.println("size all:"+allUserDetailsList.size());
		}
	
		System.out.println("UI size :"+allUserDetailsList.size()+" Excel size :"+empProfileData.size());
		for(int i=0;i<allUserDetailsList.size();i++) {
			if( !allUserDetailsList.get(i).equals("")) {
				//System.out.println("null :" +i+" mame :"+ allUserDetailsList.get(i) +" size: "+allUserDetailsList.size());
				//Assert.assertEquals(allUserDetailsList.get(i), empProfileData.get(i));
				System.out.println("UI info list inside if :"+allUserDetailsList.get(i));
				System.out.println("Excel profile data inside if:"+empProfileData.get(i));
			}
		}
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
