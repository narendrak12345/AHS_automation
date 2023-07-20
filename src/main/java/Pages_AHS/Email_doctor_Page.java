package Pages_AHS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;
import junit.framework.Assert;

public class Email_doctor_Page extends BaseTest {

	@FindBy(xpath = "//h5[normalize-space()='Email Doctors']")

	WebElement Emaildoctor;

	@FindBy(xpath = "//select[@name='practiceGrp']")

	WebElement practiceGrp;

	@FindBy(xpath = "//select[@name='practice']")

	WebElement practice;

	@FindBy(xpath = "//*[@name='emailLogTxt']")

	WebElement message;

	@FindBy(xpath = "//select[@name='docSet']")

	WebElement doctype;

	@FindAll({ @FindBy(xpath = "//*[@class='form-group']//table//tbody/tr[*]/td[1]/input") })
	List<WebElement> Documents;

	@FindBy(xpath = "//select[@name='attachmentDocment']")

	WebElement UploadHIPAA;

	@FindBy(xpath = "//input[@name='altEmail']")

	WebElement Physicianemail;

	@FindBy(xpath = "//input[@name='cnfAltEmail']")

	WebElement Physicianemailalternate;

	@FindBy(xpath = "//button[@class='btn btn-primary']")

	WebElement Sendbtn;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(xpath = "//div[text()='Email sent successfully!']")
	WebElement alerttext;

	public Email_doctor_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void SendMailByElemrexRegisteredPhysician(String email, String reenteremail)
			throws IOException, InterruptedException {

		Helper help = new Helper();
		help.ClickAndWait(Emaildoctor, driver);
		help.HandleDropDown(practiceGrp,1);
		help.HandleDropDown(practice,1);
		help.SendTextAndWait(message, "Test");
		help.HandleDropDown(doctype,1);
		help.Scrolldropdwon1(Documents, 2, driver);
		help.HandleDropDown(UploadHIPAA,2);
		help.SendTextAndWait(Physicianemail, email);
		help.SendTextAndWait(Physicianemailalternate, reenteremail);
		Sendbtn.click();
		Thread.sleep(5000);
		help.ClickAndWait(ClickonOK, driver);
		validatealerttext();
		help.ClickAndWait(ClickonOK, driver);

	}

	public void validatealerttext() throws IOException {

		Helper help = new Helper();
		String actual = help.ChecklElementAndGettext(alerttext, driver);
		Assert.assertEquals(actual, "Email sent successfully!");
	}

}