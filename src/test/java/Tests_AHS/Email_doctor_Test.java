package Tests_AHS;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.BaseTest;
import Pages_AHS.Add_new_Doctor;
import Pages_AHS.Email_doctor_Page;
import Pages_AHS.Login_Page;
import ReadJsonData.Readdata;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class Email_doctor_Test extends BaseTest{

	
	public Login_Page login;
	public Email_doctor_Page emaildoct;
	public Readdata data;
	
	public Email_doctor_Test() throws IOException {
		super();
	}

	@Step("Application has started")
	@BeforeMethod
	public void excutebefore() throws IOException {
		init();
		emaildoct = new Email_doctor_Page();
		login = new Login_Page();
		data=new Readdata();
	}

	@Test
	@Description("Search By Elemrex Registered Physician or Provider")
	public void SearchbyElemrexRegisteredPhysician() throws InterruptedException, IOException, ParseException {

		login.checklogin(prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("otp"));
		emaildoct.SendMailByElemrexRegisteredPhysician(data.jsondata("email"),data.jsondata("reenteremail"));
	}
}