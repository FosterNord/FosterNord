package Academy.E2EProject2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class validateNavigationBar extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void validateNavBar() throws IOException {
		
		//div[style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']
		landingPage l = new landingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar find");
	}

	@AfterTest
	public void tearDon() {
		driver.close();
	}

}
