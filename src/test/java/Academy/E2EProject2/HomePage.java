package Academy.E2EProject2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgetPassword;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	// for parallel execute we need to assign a copy of actual driver to test case
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = Initializedriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Passord) throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		//div[style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']
		landingPage l = new landingPage(driver);
		loginPage lp = l.signin();
		lp.getEmail().sendKeys(Username);
		lp.getPassord().sendKeys(Passord);
		lp.getLogin().click();
		log.info("email entered successfully");
		ForgetPassword fp = lp.forgetPassword();
		fp.getEmail().sendKeys("xxx");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		
		data[0][0]="nonrestricteduser@q.com";
		data[0][1]="123456";
		//data[0][2]="Restricted user";
		
		data[1][0]="restricteduser@q.com";
		data[1][1]="456788";
//		data[1][2]="Non restricted user";
//	
		return data;
	}
		@AfterTest
		public void tearDon() {
			driver.close();
		}

}
