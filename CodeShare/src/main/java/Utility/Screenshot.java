package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void getPhoto(WebDriver driver, String picname)  {
		String projectPath=System.getProperty("user.dir");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(projectPath+"\\Screenshot\\"+picname+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File path genrated successfully");
		}
	}
}



