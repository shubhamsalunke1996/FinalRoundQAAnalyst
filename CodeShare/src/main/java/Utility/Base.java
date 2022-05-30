package Utility;


import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static WebDriver driver = null;
	static WebDriver Ignitodriver = null;
		
	public static WebDriver LaunchURL() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(PropertiesFile.getData("URL1"));	
		
		return driver;

	}
	public static WebDriver LaunchURLOnIgnito() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();		
		options.addArguments("--incognito");
		options.addArguments("window-size=1980,1080");
		Ignitodriver=new ChromeDriver(options);
		Ignitodriver.manage().window().maximize();
		Ignitodriver.manage().deleteAllCookies();
		Ignitodriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return Ignitodriver;

	}


}
