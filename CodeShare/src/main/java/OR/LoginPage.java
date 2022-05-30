package OR;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.PropertiesFile;
import Utility.Screenshot;

public class LoginPage {
	WebDriver driver;



	@FindBy(linkText="Share Code Now") 
	private WebElement shareCodeNow;

	@FindBy(xpath = "//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre[1]")
	private static WebElement firstLine;

	@FindBy(xpath = "(//div[@class='CodeMirror-gutter-wrapper']/following-sibling::pre)[2]")
	private static WebElement secondLine;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void login() throws IOException  {


	}


	public void codeShare() throws IOException {
		Screenshot.getPhoto(driver, "OpenCodeShare");
		Actions obj=new Actions(driver);
		obj.moveToElement(shareCodeNow).doubleClick().build().perform();
		obj.moveToElement(firstLine).click().sendKeys(PropertiesFile.getData("line1")).sendKeys(Keys.ENTER).build().perform();
		Screenshot.getPhoto(driver, "InsertedTextLine1");

	}

	public void ignitoShare() throws IOException {
		Screenshot.getPhoto(driver, "OpenIgnito");
		Actions obj=new Actions(driver);	
		obj.moveToElement(secondLine).click().sendKeys(PropertiesFile.getData("line2")).sendKeys(Keys.ENTER).build().perform();
		Screenshot.getPhoto(driver, "InsertedTextLine2");
	}

}


