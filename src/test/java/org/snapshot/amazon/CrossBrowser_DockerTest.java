package org.snapshot.amazon;

import java.net.MalformedURLException;
import java.net.URL; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class CrossBrowser_DockerTest {
    WebDriver driver;
    @Test
    @Parameters({"bname"})
    public void browserTest(@Optional("chrome") String bname) throws MalformedURLException, InterruptedException
    {
    	if(bname.equalsIgnoreCase("chrome"))
    	{
    		ChromeOptions options=new ChromeOptions();
    		driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
    		System.out.println("Connection Established with Chrome Browser");
    	}
    	if(bname.equalsIgnoreCase("firefox"))
    	{
    		FirefoxOptions options=new FirefoxOptions();
    		driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
    		System.out.println("Connection Established with Firefox Browser");
    	}
    	if(bname.equalsIgnoreCase("edge"))
    	{
    		EdgeOptions options=new EdgeOptions();
    		driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
    		System.out.println("Connection Established with Edge Browser");
    	}
    	Thread.sleep(5000);
    	driver.get("https://www.amazon.in/");
    	Thread.sleep(4000);
    	System.out.println("Application Executing Parallelly!");
    	driver.quit();
    }
    
}
