package test;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login_Test extends Base_Simple_Test {

	LoginPage lgpage;

	@BeforeMethod
	public void initpages() {
		lgpage = new LoginPage(driver);
	}

	@Test()
	public void loginTest1() throws IOException {

		ConfigReader cr = new ConfigReader();

		String username = cr.getUserName();
		String password = cr.getPassWord();
		String Expected_Title = "Swag Labs";

		lgpage.userName(username);
		lgpage.PassWord(password);
		lgpage.loginButton();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String title = lgpage.titleText();

		Assert.assertEquals(title, Expected_Title);

	}

	@Test()
	public void loginTest2() throws IOException {

		ConfigReader cr = new ConfigReader();

		String Wrngusername = cr.getWrongUserName();
		String wrngpassword = cr.getPassWord();
		String ExpectedTxt = "Username and password do not match";

		lgpage.wrongUserName(Wrngusername);
		lgpage.wrongPassWord(wrngpassword);
		lgpage.loginButton();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String actualErrorMsg = lgpage.loginErrorMsg();

		Assert.assertTrue(actualErrorMsg.contains(ExpectedTxt));

	}

}
