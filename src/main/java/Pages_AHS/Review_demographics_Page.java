package Pages_AHS;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Review_demographics_Page extends BaseTest {

	@FindBy(xpath = "//h5[normalize-space()='Review Demographics']")
	WebElement CheckReviewdemograph;

	@FindBy(xpath = "//*[text()='OK']")
	WebElement ClickonOK;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement Textonscreen;

	@FindBy(xpath = "//*[text()=' Accept ']")
	WebElement Accpetbtn;

	public Review_demographics_Page(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String FillDemoGraphics() throws IOException, InterruptedException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		help.ClickAndWait(ClickonOK, driver);
		Thread.sleep(2000);
		log.info(help.ChecklElementAndGettext(Textonscreen, driver));
		help.ClickAndWait(Accpetbtn, driver);
		help.ClickAndWait(ClickonOK, driver);
		return CheckReviewdemograph.getText();
	}

	public String Verifstreet() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("street");
		Thread.sleep(2000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn, driver);
		Thread.sleep(5000);
		WebElement text = help.GettextByCommontext(" Please Enter Street Address. ");
		return text.getText();

	}

	public String Verifcity() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("city");
		Thread.sleep(3000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(4000);
		help.ClickAndWait(Accpetbtn, driver);
		WebElement text = help.GettextByCommontext(" Please Enter City. ");
		return text.getText();
	}

	public String Verifyzip() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("zip");
		Thread.sleep(2000);
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn, driver);
		WebElement text = help.GettextByCommontext(" Please Enter zip code. ");
		return text.getText();
	}

	public String Verifycellularphone() throws IOException, InterruptedException {

		Helper help = new Helper();
		WebElement ele = help.GetBycommonText("cellPhone");
		Thread.sleep(2000);
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.ARROW_LEFT + "a");
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		help.ClickAndWait(Accpetbtn, driver);
		WebElement text = help.GettextByCommontext(" Cellular Phone must be at least 10 digits long. ");
		return text.getText();
	}

	public void clickOnDemo() throws IOException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		help.ClickAndWait(ClickonOK, driver);
	}
}
