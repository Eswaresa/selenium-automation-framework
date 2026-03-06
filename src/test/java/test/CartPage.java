package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;

	By checkout = By.id("checkout");
	By firstname = By.id("first-name");
	By lastname = By.id("last-name");
	By postalcode = By.id("postal-code");
	By continuebtn = By.id("continue");
	By finishbtn = By.id("finish");
	By Successtxt = By.xpath("//h2[@class='complete-header']");

	public CartPage(WebDriver driver) {

		this.driver = driver;
	}

	public void checkOutBtn() {
		driver.findElement(checkout).click();
	}

	public void firstName(String firName) {
		driver.findElement(firstname).sendKeys(firName);

	}

	public void lastName(String lName) {
		driver.findElement(lastname).sendKeys(lName);
	}

	public void postalCode(String pCode) {
		driver.findElement(postalcode).sendKeys(pCode);
	}

	public void continueBtn() {
		driver.findElement(continuebtn).click();
	}

	public void finshBtn() {
		driver.findElement(finishbtn).click();
	}
	public String sucsessTxt() {
		return driver.findElement(Successtxt).getText();
		
		
	}

}
