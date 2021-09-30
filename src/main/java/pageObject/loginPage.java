package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By email =By.cssSelector("[id='user_email']");
	By passord =By.cssSelector("[id='user_password']");
	By Login =By.cssSelector("[value='Log In']");
	By forgetPassword =By.cssSelector("[href*='password/new']");
	
	public ForgetPassword forgetPassword() {
		// TODO Auto-generated constructor stub
		driver.findElement(forgetPassword).click();
		ForgetPassword fp = new ForgetPassword(driver);
		return fp;
	}
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassord() {
		return driver.findElement(passord);
	}
	
	public WebElement getLogin() {
		return driver.findElement(Login);
	}

}
