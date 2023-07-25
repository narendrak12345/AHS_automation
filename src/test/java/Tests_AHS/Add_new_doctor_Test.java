package Tests_AHS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(Listenerpackage.listener.class)
public class Add_new_doctor_Test extends BaseTest {

	public Add_new_Doctor newdoctor;
	public Login_Page login;

	public Add_new_doctor_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		newdoctor = new Add_new_Doctor();
		login = new Login_Page();
	}
	@Test
	@Description("Selecting Multiple physicians")
	public void Selectmultipledoctor() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton", 10);
		newdoctor.choosephysicians(7);// here selcting no. of doctors are 7
		newdoctor.GetalllistofPysiciannames();
	}

	@Test
	@Description("Selecing single physician")
	public void Selectphysician() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.SelectDoctor("princeton", 2);
		newdoctor.choosephysicians(1);// here selcting no. of doctors are 1
		newdoctor.GetalllistofPysiciannames();
	}
	
	@Test
	@Description("Testing with Negative scenarios")
	public void CheckWithInvaliddata() throws InterruptedException, IOException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		newdoctor.ValidateNegativescenario("princeton",6);
		Thread.sleep(5000);
	}
	
	@Step("Closing the application")
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
