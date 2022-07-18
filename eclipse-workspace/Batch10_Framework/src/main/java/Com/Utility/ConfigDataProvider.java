package Com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider() throws IOException {     //Constructor
		String file="C:\\Users\\rpgsa\\eclipse-workspace\\Batch10_Framework\\Config\\Config.Properties";
		FileInputStream fis=new FileInputStream(file);
		 pro=new Properties();   //to load file make object of Properties class
		pro.load(fis);
	}
	
	public String getQAENV_1() {
		return pro.getProperty("QAENV_1");
	}

}
