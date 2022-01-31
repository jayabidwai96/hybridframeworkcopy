package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.utility.PropertiesUtils;

import javafx.scene.layout.Priority;

public class LoginTest extends BaseClass {
	
	public LoginPage lp = null;
	
	@BeforeSuite
	public void setup() {
		log.info("inside beforesuite");
		initalization();
		reportInit();
		lp = new LoginPage(driver);
		
	}
	
	@AfterSuite
	public void tearDown() {
		log.info("inside aftersuite");
		report.flush();
	}
	
	
	@Test(priority = 1)
	public void loginTest() {
		//driver.findElement(By.id("email")).sendKeys(PropertiesUtils.readproperty("username"));//
		//driver.findElement(By.id("password")).sendKeys(PropertiesUtils.readproperty("password"));//
		//driver.findElement(By.xpath("//button")).click();//
		log.info("executing login test");
		lp.loginToApplication();
		log.info("login test passed");
		
		
	}
	
	@Test(priority = 2)
	public void failTest() {
		log.info("executing fail test");
    Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
    log.info("login test failed");
	}
	

}
