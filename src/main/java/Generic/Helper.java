package Generic;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainBase.BaseTest;

public class Helper extends BaseTest {

	private FluentWait<WebDriver> wait;

	public Helper() throws IOException {
		super();
	}

	// Common methods

	public void ClickAndWait(WebElement ele) {

		ele.isDisplayed();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	public void CheckVisibiltyOfText(WebElement ele) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
	}

	public String ChecklElementAndGettext(WebElement ele, WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		return ele.getText();
	}

	public void HandleDropDown(WebElement ele, int i) throws InterruptedException {

		Select sc = new Select(ele);
		Thread.sleep(2000);
		List<WebElement> eles = sc.getOptions();
		log.info(eles.size());
		sc.selectByIndex(i);
		Thread.sleep(2000);
	}
	public void HandleDropDownByText(WebElement ele,String text) throws InterruptedException {

		Select sc = new Select(ele);
		Thread.sleep(2000);
		List<WebElement> eles = sc.getOptions();
		log.info(eles.size());
		
		log.info("All states " +ele.getText());
		sc.selectByVisibleText(text);
		Thread.sleep(2000);
	}

	public WebElement GetBycommonText(String text) {

		return driver.findElement(By.xpath("//input[@name='" + text + "']"));
	}
	
	public void SendtextAndClick(String text) {

		driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
	}

	public void WaitForSomeTime(int i) throws InterruptedException {

		Thread.sleep(1000 * i);
	}

	public WebElement GettextByCommontext(String text) {

		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		return ele;
	}
	
	public void ClickandWait(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele)).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();	
	}
	
	public void SendTextAndWait(WebElement ele, String text) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(text);
	}

	public void Switchframe(WebElement ele, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(ele);
	}
	
	public void alert(WebElement ele, WebDriver driver) throws InterruptedException {
		
		Alert alert = driver.switchTo().alert();
		//alert.getText();
		alert.accept();
	}

	public void sendvalues(WebElement ele, String text) {

		ele.sendKeys(text);
	}
	public String Gettext(WebElement ele) {

		return ele.getText();
	}

	public void ClickAndWait(WebElement ele, String text) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	public void Scrolldropdwon(List<WebElement> alloptions, int j, WebDriver driver) throws InterruptedException {

		List<WebElement> m = alloptions;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			System.out.println(text.getText());
		}
		for (int i = 1; i <= j; i++) {
			Thread.sleep(2000);
			m.get(i).click();
			Thread.sleep(3000);
			m.get(i).click();
		}
	}

	public void ClickOnbtn(int index) throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("(//*[@type='button'])[" + index + "]"));
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(ele).click().build().perform();
		ele.click();
		Thread.sleep(3000);
	}

	public int GetList(List<WebElement> alloptions, WebDriver driver) {

		List<WebElement> m = alloptions;
		int size = 0;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			log.info(text.getText());
			size = m.size();
			//log.info("No. of added physicians are " + size);
		}
		return size;
	}

	public void Scrolldropdwon1(List<WebElement> alloptions, int j, WebDriver driver) throws InterruptedException {

		List<WebElement> m = alloptions;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			System.out.println(text.getText());
		}
		for (int i = 1; i <= j; i++) {
			Thread.sleep(2000);
			m.get(i).click();
		}
	}
}