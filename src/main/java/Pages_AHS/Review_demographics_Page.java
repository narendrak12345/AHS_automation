package Pages_AHS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath = "//input[@id='selectAll']")
	WebElement SelectAllcheckbox;
	
	
	@FindBy(xpath ="//*[@value='I Accept']")
	WebElement Iselctbtn;
	
	
	@FindBy(xpath ="//div[@class='btn-group bottom-btn']//a[@class='btn btn-primary save-form1'][normalize-space()='Done']")
	WebElement clickondone;
	
	
	@FindBy(xpath ="//*[@value='Submit']")
	WebElement clicksubmit;
	
	@FindBy(xpath ="//div[@class='signature-pad-area border']")
	WebElement esign;

	public Review_demographics_Page() throws IOException {
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
	
	public void FillData(String street,String city,String zip,String cell) throws IOException, InterruptedException {
		
		Helper help = new Helper();
		WebElement e1 = help.GetBycommonText("street");
		e1.clear();
		e1.sendKeys(street);
		WebElement e2 = help.GetBycommonText("city");
		e2.clear();
		e2.sendKeys(city);
		WebElement e3 = help.GetBycommonText("zip");
		e3.clear();
		e3.sendKeys(zip);
		WebElement e4 = help.GetBycommonText("cellPhone");
		e4.clear();
		e4.sendKeys(cell);
		//Thread.sleep(3000);
		help.ClickAndWait(Accpetbtn, driver);
		//Thread.sleep(3000);
		help.ClickAndWait(ClickonOK, driver);
	    Thread.sleep(5000);
		help.ClickAndWait(SelectAllcheckbox, driver);
		//SelectAllcheckbox.click();
		SelectAllcheckbox.isSelected();
		help.ClickAndWait(ClickonOK, driver);
		help.ClickAndWait(Iselctbtn, driver);
		//Thread.sleep(3000);
		help.ClickAndWait(ClickonOK, driver);
		//Thread.sleep(3000);
        Action action = new Actions(driver).click(esign)
                .moveToElement(esign, 3, 3).clickAndHold(esign)
                .moveByOffset(50, 50).moveByOffset(-50, 50)
                .moveByOffset(-60,-50).moveByOffset(-100,59).release(esign)
                .moveByOffset(30,-130)
                .build();
        action.perform();
        //Thread.sleep(5000);
        help.ClickAndWait(clickondone, driver);
        help.ClickAndWait(ClickonOK, driver);
        Thread.sleep(10000);
        help.ClickandWait(clicksubmit);
        //Thread.sleep(5000);
        help.ClickAndWait(ClickonOK, driver);
        Thread.sleep(5000);
	}
	public void clickOnDemo() throws IOException {
		Helper help = new Helper();
		CheckReviewdemograph.click();
		help.ClickAndWait(ClickonOK, driver);
	}
}
