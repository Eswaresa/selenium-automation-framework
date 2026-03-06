package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelBasic_Practice {

	@Test(enabled = true)
	public void testQ1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		String Title = driver.getTitle();
		if (Title.equals("Google")) {
			System.out.println("Q1 Passed");
		} else {
			System.out.println("The Q1 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String URL = driver.getCurrentUrl();
		if (URL.contains("https")) {
			System.out.println(" Q2 Passed");
		} else {
			System.out.println("The Q2 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		String t = driver.getTitle();
		if (t.equals("Wikipedia")) {
			System.out.println("Q3 Passed");
		} else {
			System.out.println("The Q3 Code Has Error");
		}
		driver.quit();

	}

	@Test(enabled = true)
	public void testQ4() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// name locator was not unique so gone with ID
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Selenium WebDriver");
		// name locator was not unique so gone with Xpath
		WebElement click = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
		click.click();

		String title = driver.getTitle();
		System.out.println(title);
		if (title != null) {

			System.out.println("Q4 Passed");

		} else {
			System.out.println("The Q4 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ5() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Java");
		WebElement click = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
		click.click();

		String title = driver.getTitle();
		System.out.println(title);
		if (title != null) {
			driver.navigate().back();
			search.clear();
			search.sendKeys("Java Selenium");
			click.click();
			System.out.println("Q5 Passed");

		} else {
			System.out.println("The Q5 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ6() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement usr = driver.findElement(By.id("username"));
		if (usr.isDisplayed()) {
			System.out.println("Q6 SC1 Passed");
		} else {
			System.out.println("The Q6 SC1 Code Has Error");
		}
		WebElement pwd = driver.findElement(By.id("password"));
		if (pwd.isEnabled()) {
			System.out.println("Q6 SC1 Passed");
		} else {
			System.out.println("The Q6 SC2 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ7() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement usr = driver.findElement(By.id("username"));
		usr.sendKeys("eswar");
		// ClassName not available used id
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("abcd");
		WebElement clickable = driver.findElement(By.xpath("//button[@type='submit']"));
		clickable.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		String err = errmsg.getText();
		if (err != null) {
			System.out.println(err);
			System.out.println("Q7 Passed");
		} else {
			System.out.println("The Q7 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ8() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		WebElement usrnm = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement curAddr = driver.findElement(By.id("currentAddress"));
		WebElement perAddr = driver.findElement(By.id("permanentAddress"));
		WebElement submit = driver.findElement(By.id("submit"));
		usrnm.sendKeys("eswar");
		email.sendKeys("abcd@123.com");
		curAddr.sendKeys("abcd, abcdaddress");
		perAddr.sendKeys("abcd, abcdaddress");
		// submit.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		js.executeScript("arguments[0].click();", submit);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='name']")));

		List<WebElement> output = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']"));
		for (WebElement outputs : output) {
			System.out.println(outputs.getText());
		}
		WebElement nm = driver.findElement(By.xpath("//p[@id='name']"));
		String nme = nm.getText();

		if (nme.contains("eswar")) {

			System.out.println("Q8 Passed");
		} else {
			System.out.println("The Q8 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ9() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		WebElement usr = driver.findElement(By.id("user-name"));
		usr.sendKeys("standard_user");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		String title = driver.getTitle();
		if (title.contains("Swag Labs")) {
			System.out.println(title);
			System.out.println("Q9 Passed");
		} else {
			System.out.println("The Q8 Code Has Error");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void testQ10() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		WebElement usr = driver.findElement(By.id("user-name"));
		usr.sendKeys("standard_user");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		WebElement logoutBtn = driver.findElement(By
				.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/a[3]"));
		logoutBtn.click();
		if (logoutBtn.isDisplayed()) {
			logoutBtn.click();
			System.out.println("Q10 Passed");
		} else {
			System.out.println("The Q10 Code Has Error - Logoutbtn isnotdisplayed");
		}
		driver.quit();

	}

	@Test(enabled = true)
	public void testQ11() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		WebElement lgnBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		if (lgnBtn.isDisplayed()) {
			String g = driver.getTitle();
			System.out.println(g);
			System.out.println("Q10 Passed");
		} else {
			System.out.println("The Q10 Code Has Error - Logoutbtn isnotdisplayed");

		}
		driver.quit();

	}

}
