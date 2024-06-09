package org.pompage;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	public Properties properties=new Properties();
	
	
	public String userName()
	{
		String username=properties.getProperty("username");
		return username;
	}
	
	public String password()
	{
		String password=properties.getProperty("password");
		return password;
	}
	
	public String url()
	{
		String url=properties.getProperty("url");
		return url;
	}
	
	public String WDUserFirstName()
	{
		String WDUserFirstName=properties.getProperty("WDUserFirstName");
		return WDUserFirstName;
	}
	
	public String WDUserLastName()
	{
		String WDUserLastName=properties.getProperty("WDUserLastName");
		return WDUserLastName;
	}
	
	public String WDUserEmail()
	{
		String WDUserEmail=properties.getProperty("WDUserEmail");
		return WDUserEmail;
	}
	
	public String comments()
	{
		String comments=properties.getProperty("comments");
		return comments;
	}
	
	public String url1()
	{
		String url=properties.getProperty("url1");
		return url;
	}
	public Properties loadProperties() throws IOException {
      //  Properties properties = new Properties();
		FileReader reader=new FileReader("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\src\\test\\java\\QTEAutomation\\application.properties");
		properties.load(reader);
        
        return properties;
    }

}
