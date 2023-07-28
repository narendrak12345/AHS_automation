package Tests_AHS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Login_Page;
import Pages_AHS.Review_demographics_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Review_demographics_Test extends BaseTest {

	public Login_Page login;
	public Review_demographics_Page demo;
	public Login_test logintest;

	public Review_demographics_Test() throws IOException {
		super();
	}

	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		login = new Login_Page();
		demo = new Review_demographics_Page();
		logintest=new Login_test();
		}
	
	@Test
	@Description("Fields are not updating,simply clicking on Active button")
	public void Updateexistprofile() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics();
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW DEMOGRAPHICS");
		}
	
	@Test
	@Description("Validating with invalid test data")
	public void TestwithNegativescenario() throws InterruptedException, IOException {

		
		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo();
		String actual1 = demo.Verifstreet();
		Assert.assertEquals(actual1, "Please Enter Street Address.");
		String actual2 = demo.Verifcity();
		Assert.assertEquals(actual2, "Please Enter City.");
		String actual3 = demo.Verifyzip();
		Assert.assertEquals(actual3, "Please Enter zip code.");
		String actual4 = demo.Verifycellularphone();
		Assert.assertEquals(actual4, "Please Enter Cellular Phone.");
		}
	
	@Test
	@Description("Fields are not updating,simply clicking on Active button")
	public void Updatprofile() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		String actual = demo.FillDemoGraphics();
		log.info(actual);
		Assert.assertEquals(actual, "REVIEW DEMOGRAPHICS");
	}
	@Test
	@Description("Entering fields inputs and Click on Accpet button")
	public void TestwithValidTestData() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		demo.clickOnDemo();
		demo.FillData("all 1","cables","234323","6142315231");
	}
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}