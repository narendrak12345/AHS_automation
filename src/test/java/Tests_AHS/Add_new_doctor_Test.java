package Tests_AHS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Add_new_doctor_Test extends BaseTest{

	public Add_new_Doctor newdoctor;
	public Login_Page login;
	
	
	public Add_new_doctor_Test() throws IOException {
		super();
	}
	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		newdoctor=new Add_new_Doctor(driver);
		login=new Login_Page(driver);
	}
	@Test
	@Description("First login into application and Click on module New doctor and search using princeton and select some physician")
	public void SearchforDoctor() throws InterruptedException, IOException {
	
		login.checklogin(prop.getProperty("email"),prop.getProperty("password"),prop.getProperty("otp"));
		newdoctor.Searchdoctor("princeton",8);	
		newdoctor.choosephysicians(4);
	}
	
	@Step("Closing the application")
	 @AfterMethod
     public void teardown() {
	driver.quit();
 }
}
