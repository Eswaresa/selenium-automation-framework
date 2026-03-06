package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By username = By.id("user-name");
	By password = By.id("password");
	By loginbutton = By.id("login-button");
	By usrnmpwderrormsg = By.xpath("//h3[@data-test='error']");
	//By title = By.xpath("//div[@class='app_logo']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public void userName(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void PassWord(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void loginButton() {
		driver.findElement(loginbutton).click();
	}
	public String titleText() {
		return driver.getTitle();
	}
	public void wrongUserName(String wuser) {
		driver.findElement(username).sendKeys(wuser);
	}
	public void wrongPassWord(String wpass) {
		driver.findElement(password).sendKeys(wpass);
	}
	public String loginErrorMsg() {
		return driver.findElement(usrnmpwderrormsg).getText();
	}

}
