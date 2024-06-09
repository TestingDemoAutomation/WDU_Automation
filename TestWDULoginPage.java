package QTEAutomation;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pompage.CartPage;
import org.pompage.ConfigProperties;
import org.pompage.SocialWebPage;
import org.pompage.WDULoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestWDULoginPage {
	
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	private ConfigProperties config;
	
	WebDriver driver;
	WDULoginPage wdu=new WDULoginPage(driver);
	
	@BeforeTest
	public void reportModule() throws IOException
	{
		//wdu.geturl(config.url1());
		wdu.reportGenerate();
		config=new ConfigProperties();
		config.loadProperties();
		
	}
	
	
	
	
	
	@Test(priority=0, enabled=true)
	
	public void userLogin() throws InterruptedException, IOException
	{
		wdu.validLogin(config.WDUserFirstName(), config.WDUserLastName(), config.WDUserEmail(), config.comments());
		Thread.sleep(3000);
		wdu.loginScreenshot();
		Thread.sleep(3000);
		wdu.closeWindow();
	}
	
	@Test(priority=1,enabled=true)
	public void ivalidLoginNameError1() throws InterruptedException, IOException
	{
		wdu.ivalidLoginNameError(config.WDUserLastName(), config.WDUserEmail(), config.comments());
		Thread.sleep(3000);
		try
		{
		wdu.loginScreenshotInvalid();
		}
		catch(Exception e)
		{
			System.out.println("This is not working.");
		}
		Thread.sleep(3000);
		wdu.closeWindow();//ivalidLoginLastError
	}
	
	@Test(priority=2,enabled=true)
	public void ivalidLoginLastError1() throws InterruptedException, IOException
	{
		wdu.ivalidLoginLastError(config.WDUserFirstName(), config.WDUserEmail(), config.comments());
		Thread.sleep(3000);
		try
		{
		wdu.loginScreenshotInvalidLast();
		}
		catch(Exception e)
		{
			System.out.println("This is not working.");
		}
		Thread.sleep(3000);
		wdu.closeWindow();
	}
	
	@Test(priority=3,enabled=true)
	public void resetButton() throws InterruptedException, IOException
	{
		wdu.ivalidLoginResetButton();
		Thread.sleep(3000);
		try
		{
		wdu.loginScreenshotResetButton();
		}
		catch(Exception e)
		{
			System.out.println("This is not working.");
		}
		Thread.sleep(3000);
		wdu.closeWindow();
	}
	
	@AfterTest
	public void flushReportModule() throws InterruptedException
	{
		wdu.endTest();
	}

}
