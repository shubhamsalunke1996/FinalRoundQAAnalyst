package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	static String reqValue=null;
	public static String getData(String reqProp) throws IOException {
		String projectPath=System.getProperty("user.dir");	
		FileInputStream file=new FileInputStream(projectPath+"\\src\\main\\java\\cofing.properties");
		Properties prop=new Properties();	
		prop.load(file);		
		String reqValue=prop.getProperty(reqProp);	
		return reqValue;

	}
}
