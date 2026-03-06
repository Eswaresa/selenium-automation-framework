package test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends Base_Simple_Test {

	// WebDriver driver;
	LoginPage lgpage;
	CartPage cp;

	@BeforeMethod
	public void initpage() {
		lgpage = new LoginPage(driver);
		cp = new CartPage(driver);
	}
	
	
	@Test()
	public void loginTest() throws IOException {

		ConfigReader config = new ConfigReader();

		String user = config.getUserName();
		String pass = config.getPassWord();

		lgpage.userName(user);
		lgpage.PassWord(pass);
		lgpage.loginButton();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> cartList = new ArrayList<WebElement>(
				driver.findElements(By.xpath("//div[@class = 'inventory_item_name ']")));
		WebElement firstCartItem = cartList.get(0);
		String firstCartItemName = firstCartItem.getText();
		System.out.println(firstCartItemName);

		WebElement addCart = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]"));
		addCart.click();

		driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_item']")));

		List<WebElement> AddTocartList = 
				driver.findElements(By.xpath("//div[@class='cart_item']"));

		WebElement listName = AddTocartList.get(0);
		String lisnm = listName.getText();
		System.out.println(lisnm);

		Assert.assertTrue(lisnm.contains(firstCartItemName));

	}

	@Test()
	public void removeCart() {

		// Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Get list of products
		List<WebElement> productList = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]"));

		// Capture first product name
		WebElement firstProduct = productList.get(0);
		String firstProductName = firstProduct.getText();
		System.out.println(firstProductName);

		// Click first Add to Cart button
		driver.findElement(By.xpath("(//button[contains(@class,'btn_inventory')])[1]")).click();

		// Open cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		// Explicit wait for cart item
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_item']")));

		// Verify item exists in cart
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));
		Assert.assertTrue(cartItems.size() > 0, "Cart is empty");

		// Verify correct product added
		String cartProductName = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(cartProductName, firstProductName);

		// Click remove button
		driver.findElement(By.xpath("//button[contains(@id,'remove')]")).click();

		// Wait until item disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cart_item']")));

		// Verify item removed
		List<WebElement> cartAfterRemove = driver.findElements(By.xpath("//div[@class='cart_item']"));
		Assert.assertEquals(cartAfterRemove.size(), 0, "Item was not removed from cart");

	}

	@Test()
	public void cartTest() throws IOException {

		  ConfigReader config = new ConfigReader();

	        String user = config.getUserName();
	        String pass = config.getPassWord();
	        String fname = config.getfname();
	        String lname = config.getlname();
	        String pstcd = config.getpcode();

	        // Login
	        lgpage.userName(user);
	        lgpage.PassWord(pass);
	        lgpage.loginButton();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

	        // Add first product to cart
	        driver.findElement(By.xpath("(//button[contains(@class,'btn_inventory')])[1]")).click();

	        // Open cart
	        driver.findElement(By.className("shopping_cart_link")).click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_item")));

	        // Checkout
	        cp.checkOutBtn();

	        cp.firstName(fname);
	        cp.lastName(lname);
	        cp.postalCode(pstcd);
	        cp.continueBtn();

	        cp.finshBtn();

	        // Validation
	        String successMsg = cp.sucsessTxt();
	        Assert.assertTrue(successMsg.contains("Thank you for your order"));

	    }

}
