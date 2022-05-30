package TestNgRetryFailedTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import OR.LoginPage;
import Utility.Base;
import Utility.Screenshot;

public class TestNgRetryFailedTest extends Base {

	private static WebDriver driver=null;
	private static WebDriver Ignitodriver=null;
	private static LoginPage l=null;
	static ExtentReports extent;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void codeShareTest() throws IOException   {
		System.out.println("*************Test Started : ");
		System.out.println("I am inside codeShareTest ");
		ExtentTest codeShareTest=extent.createTest("MyFirstTest", "this is a test to valiadate OpenShare functionality");
		codeShareTest.log(Status.INFO,"Starting Test Case");
		codeShareTest.info("This step shows usage of info(details)");
		driver=LaunchURL();
		codeShareTest.pass("Launch the Chrome Browser");
		l=new LoginPage(driver);	
		l.codeShare();
		codeShareTest.pass("Inserted #include <stdio.h> in the chrome Browser editor");
		String parentline1 = driver.findElement(By.xpath("//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre[1]")).getText();
		System.out.println("parentline1  :  "+parentline1);	
		codeShareTest.pass("Get text #include <stdio.h> from Chrome Browser editor");
		String ignitoInputUrl=driver.getCurrentUrl();
		System.out.println(ignitoInputUrl);	
		codeShareTest.pass("Get Current URL for open Ignito Browser");
		Ignitodriver = LaunchURLOnIgnito();
		codeShareTest.pass("Launch the Ignito Browser");
		Ignitodriver.get(ignitoInputUrl);
		codeShareTest.pass("Open the URL on Ingnito Browser");
		String ignitoparentline1 = driver.findElement(By.xpath("//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre[1]")).getText();
		System.out.println("ignitoparentline1  : "+ignitoparentline1);
		codeShareTest.pass("Get text #include <stdio.h> from  Ignito Browser editor");
		l.ignitoShare();
		
		codeShareTest.pass("assert that in new window there should be text #include <stdio.h> visible");
		Assert.assertEquals(parentline1, ignitoparentline1);
		codeShareTest.pass("Verified that in new window there should be text #include <stdio.h> is visible");
		
		codeShareTest.pass("Inserted #include <conio.h>in the Ignito Browser editor");	
		String ignitoparentline2 = driver.findElement(By.xpath("(//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre)[2]")).getText();
		System.out.println("ignitoparentline2  : "+ignitoparentline2);
		codeShareTest.pass("Get text #include <conio.h>in from Ignito Browser editor");
		Ignitodriver.quit();
		codeShareTest.pass("Closes the Ignitodriver");
		String parentline2 = driver.findElement(By.xpath("(//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre)[2]")).getText();
		System.out.println("parentline1  :  "+parentline2);
		
		codeShareTest.pass("Get text #include <conio.h>in from chrome Browser editor");
		Assert.assertEquals(ignitoparentline2, parentline2);
		
		codeShareTest.pass("assert that in first window W1 there are two lines visible");
		Screenshot.getPhoto(driver, "TwoLinesvisible");
		codeShareTest.pass("Verified first window W1 there are two lines are visible");
		codeShareTest.pass("close the browser");		
		driver.quit();
		codeShareTest.pass("Tests Completed ");
		System.out.println("*************Tests Completed : ");
		

	}

	@BeforeSuite
	public void setup() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("CodeShare.html");
		extent.attachReporter(spark);

	}


	@AfterTest
	public void afterTest() {
		System.out.println("Test Completed successfully");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	

}
