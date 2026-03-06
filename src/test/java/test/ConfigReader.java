package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() throws IOException {

		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");

			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getUserName() {
		return prop.getProperty("username");

	}

	public String getPassWord() {
		return prop.getProperty("password");

	}

	public String getURL() {
		return prop.getProperty("url");

	}
	public String getfname() {
		return prop.getProperty("firName");

	}
	public String getlname() {
		return prop.getProperty("LastName");

	}
	public String getpcode() {
		return prop.getProperty("PostalCode");

	}

	public String getWrongUserName() {
		return prop.getProperty("wusername");

	}

	public String getwrongPassWord() {
		return prop.getProperty("wpassword");

	}

}
