package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtils;

public class BaseClass {
	public static WebDriver driver=null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	public static Logger log = Logger.getLogger("BaseClass");
	
	
	public void initalization() {
		System.out.println("browser initalization start");
		log.info("browser initalization start");
		log.info("reading property file for key browser");
		String browser= PropertiesUtils.readproperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			log.info("initalizting chrome browser");
			System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
	log.info("maximizing browser window");	
	driver.manage().window().maximize();
	log.info("appying browser level waits");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	log.info("launching JBK offline application");
	driver.get(PropertiesUtils.readproperty("url"));
	}

	public void reportInit() {
		log.info("initalizing extent report");
		report =new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtendReport.html");
		report.attachReporter(spark);
	}
	
	public String captureScreenShot(String name) {
		log.info("capturing screenshot for failed testcases");
		TakesScreenshot ts = (TakesScreenshot)driver; 
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+name+"_"+getDate()+".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date =sdf.format(new Date());
		return date;
	}
	
}
