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

public class validateTitle extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initializedriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver launched successfully");
	}
	
	@Test()
	public void validateAppTitle() throws IOException {
		
		//div[style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']
		landingPage l = new landingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Title Matched");
		
	}

	@AfterTest
	public void tearDon() {
		driver.close();
	}

}
