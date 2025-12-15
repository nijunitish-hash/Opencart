package testcase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testbase {
	public  WebDriver driver;
	public Properties P;
	@Parameters({"os", "browser"})
	@BeforeClass (groups= {"Sanity"})
	void openurl(String os, String br) throws IOException
	{
		
		
		
		
//		// loading config.properties
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		P=new Properties();
	P.load(file);
//		// selenium grid 
		if(P.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("print it in other browser");
			}
		
		
		// set for browser
		
		switch(br.toLowerCase())
		{
		case "chrome":cap.setBrowserName("chrome");  break;
		case "microsoft edge":cap.setBrowserName("edge");break;
		default:System.out.println("print other browser name"); return;
		
		}
		
		
		driver=new RemoteWebDriver(new URL("http://10.201.139.119:4444/wd/hub"), cap);
		
		
		}
		// selenium grid complets 
		if(P.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		
		switch(br) 
		{
		case "firefox":driver=new FirefoxDriver(); break;
		
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver();break;
		
		default: System.out.println("invalid driver");    return;
		
		}
		
		
		
		
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(P.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterClass (groups= {"Sanity"})
	void logout()
	{
		driver.close();
	}
	
	
	
	
	public String RandomString()
	{
		String generatestring =RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	public String Randomnumber()
	{
		String generatestring =RandomStringUtils.randomNumeric(10);
		return generatestring;
	}
	
	public String Randomnumber1()
	{
		String generatenumber =RandomStringUtils.randomNumeric(4);
		String generatestring =RandomStringUtils.randomAlphabetic(4);
		return (generatenumber+ generatestring);
	}
	
	// capturing screeenshot 
	public String captureScreen(String tname )
	{
		
	
	
	String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	
	String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\" + tname + "_ "+ timeStamp + ".png";
File targetFile= new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
	return targetFilePath;
}}







//docker network create gring
//
//docker run -d -p 4442-4444:4442-4444 --net gring --name selenium-hub selenium/hub
//
//docker run -d --net gring -e SE_EVENT_BUS_HOST=selenium-hub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e
//SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome
//
//docker run -d --net gring -e SE_EVENT_BUS_HOST=selenium-hub -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e
//SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox


