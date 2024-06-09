package org.pompage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WDULoginPage {
	
	WebDriver driver;
	Actions action;
	TakesScreenshot screenshot;
	public WDULoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By firstName=By.name("first_name");
	By lastName=By.name("last_name");
	By emailAddress=By.name("email");
	By comment=By.name("message");
	By submitbutton=By.xpath("//input[@class='contact_button']");
	By validLoginMessage=By.xpath("//h1[text()='Thank You for your Message!']");
	static ExtentReports extentreport;
	
	static ExtentSparkReporter spark;
	static ExtentTest extenttest;
	
	public void reportGenerate()
	{
		extentreport=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\LoginExtentReportWDU.html");
		extentreport.attachReporter(spark);
		extenttest=extentreport.createTest("WDULoginTest");
		
	}
	
	public void loginScreenshot() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String s1=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(s1);
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageLogin.jpeg"));
		fos.write(b1);
		
	}
	public void loginScreenshotInvalid() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String s1=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(s1);
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageInvalidLogin.jpeg"));
		fos.write(b1);
		
	}
	public void loginScreenshotInvalidLast() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String s1=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(s1);
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageInvalidLoginLastName.jpeg"));
		fos.write(b1);
		
	}
	public void loginScreenshotResetButton() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String s1=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(s1);
		FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageResetButton.jpeg"));
		fos.write(b1);
		
	}
	
	
	
	
	public void closeWindow()
	{
		driver.quit();
	}
	
	public void endTest() throws InterruptedException
	{
		extentreport.flush();	
	}
	
	public void validLogin(String firstname, String lastname, String emailaddress, String comments) throws InterruptedException
	{
		boolean LoginMessage=false;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		driver.findElement(firstName).sendKeys(firstname);
		Thread.sleep(3000);
		driver.findElement(lastName).sendKeys(lastname);
		Thread.sleep(3000);
		driver.findElement(emailAddress).sendKeys(emailaddress);
		Thread.sleep(3000);
		driver.findElement(comment).sendKeys(comments);
		Thread.sleep(3000);
		
		List<WebElement> l1=driver.findElements(By.xpath("//input[@class='contact_button']"));
		WebElement submitbutton=l1.get(1);
		submitbutton.click();
		Thread.sleep(3000);
		LoginMessage=driver.findElement(validLoginMessage).isDisplayed();
		if(LoginMessage)
		{
			System.out.println("Test case 1 is passed.");
			extenttest.log(Status.PASS, "The user is logged in successfully.");
		
		}
		
		else
		{
			System.out.println("Test case 1 is fail.");
			extenttest.log(Status.PASS, "The user is not logged in.");
		}
		
		
		
	}
	
	public void ivalidLoginNameError(String lastname, String emailaddress, String comments) throws InterruptedException
	{
		boolean LoginMessage=false;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		driver.findElement(firstName).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(lastName).sendKeys(lastname);
		Thread.sleep(3000);
		driver.findElement(emailAddress).sendKeys(emailaddress);
		Thread.sleep(3000);
		driver.findElement(comment).sendKeys(comments);
		Thread.sleep(3000);
		
		List<WebElement> l1=driver.findElements(By.xpath("//input[@class='contact_button']"));
		WebElement submitbutton=l1.get(1);
		submitbutton.click();
		Thread.sleep(3000);
		String ActualTitle=driver.getTitle();
		
		String ExpectedTitle="Contact form handler";
		
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Test case 2 is passed.");
		extenttest.log(Status.PASS, "The user is not logged.");
		
		
		
	}
	
	public void ivalidLoginLastError(String firstname, String emailaddress, String comments) throws InterruptedException
	{
		boolean LoginMessage=false;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		driver.findElement(firstName).sendKeys(firstname);
		Thread.sleep(3000);
		driver.findElement(lastName).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(emailAddress).sendKeys(emailaddress);
		Thread.sleep(3000);
		driver.findElement(comment).sendKeys(comments);
		Thread.sleep(3000);
		
		List<WebElement> l1=driver.findElements(By.xpath("//input[@class='contact_button']"));
		WebElement submitbutton=l1.get(1);
		submitbutton.click();
		Thread.sleep(3000);
		String ActualTitle=driver.getTitle();
		
		String ExpectedTitle="Contact form handler";
		
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Test case 3 is passed.");
		extenttest.log(Status.PASS, "The user is not logged.");
		
		
		
	}
	
	public void ivalidLoginResetButton() throws InterruptedException
	{
		boolean  fisrtnamesize=false;
		boolean  blankLastName=false;
		boolean  blankEmail=false;
		boolean blankComment=false;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		WebElement firstname=driver.findElement(By.name("first_name"));
		
		
		firstname.sendKeys("TestFirst");
	Thread.sleep(3000);
		WebElement lastname=driver.findElement(By.name("last_name"));
		lastname.sendKeys("TestLast");
			Thread.sleep(3000);
		WebElement emailaddress=driver.findElement(By.name("email"));
			emailaddress.sendKeys("sharma.tft92@gmail.com");
			Thread.sleep(3000);
		
		WebElement comments=driver.findElement(By.name("message"));
		comments.sendKeys("This is for testing purpose.");
			Thread.sleep(3000);
		
		List<WebElement> l1=driver.findElements(By.xpath("//input[@class='contact_button']"));
		WebElement submitbutton=l1.get(0);
		submitbutton.click();
		Thread.sleep(3000);
		 fisrtnamesize=firstname.isDisplayed();
		System.out.println(fisrtnamesize);
		blankLastName=lastname.isDisplayed();
		 blankEmail=emailaddress.isDisplayed();
		blankComment=comments.isDisplayed();
		if(fisrtnamesize)// && blankLastName && blankEmail && blankComment
		{
		System.out.println("Test case 4 is passed.");
		extenttest.log(Status.PASS, "The Reset Button is clicked.");
		}
		else 
		{
			System.out.println("Test case 4 is Fail.");
			extenttest.log(Status.PASS, "The Reset Button is not clicked.");
		}
		
		
		
	}
	
	
	
	
	
	
	
	

}
