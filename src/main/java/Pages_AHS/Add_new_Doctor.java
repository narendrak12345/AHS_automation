package Pages_AHS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helper;
import MainBase.BaseTest;

public class Add_new_Doctor extends BaseTest{

	

	@FindBy(xpath="//h5[normalize-space()='Add New Physician to your list']")
	
	WebElement Addnewpysician;
	
	
	@FindBy(xpath="//input[@name='filterDoctor']")
	
	WebElement Searchdoctor;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	
	WebElement Clickonsearch;
	
	@FindAll({@FindBy(xpath="//select[@multiple='multiple']/option")})
	
	List<WebElement> Alloptions;
	
	@FindAll({@FindBy(xpath="(//div[@class='record-picker']/ul)[1]/li")})
	List<WebElement> choosephysician;
	
	
	@FindBy(xpath="//button[@name='addBtn']")
	WebElement choosepysicianbtn;
	


	public Add_new_Doctor(WebDriver driver) throws IOException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Searchdoctor(String search,int k) throws InterruptedException, IOException {
		
		Addnewpysician.click();
		Searchdoctor.sendKeys(search);
		Clickonsearch.click();
		Thread.sleep(2000);
		Helper help=new Helper();
		help.ClickOnbtn(5);
		help.ClickOnbtn(4);
		Thread.sleep(2000);
		help.Scrolldropdwon(Alloptions,k,driver);
	}	
	
	public void choosephysicians(int k) throws InterruptedException, IOException {
		
		Helper help=new Helper();
		choosepysicianbtn.isEnabled();
		help.Scrolldropdwon1(choosephysician,k,driver);
		choosepysicianbtn.click();
		Thread.sleep(4000);	
	}
}