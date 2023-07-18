package Generic;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

	public void ClickAndWait(WebElement ele, WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ele)).click();
	}

	public void CheckVisibiltyOfText(WebElement ele) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
	}

	public String ChecklElementAndGettext(WebElement ele, WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		return ele.getText();
	}
	
	public void HandleDropDown(WebElement ele, String text,int i) {

		Select sc = new Select(ele);
		if(text!=null) {
		sc.selectByVisibleText(text);
		}
		else {
		sc.selectByIndex(i);
		}
	}

	public WebElement GetBycommonText(String text) {

		return driver.findElement(By.xpath("//input[@name='" + text + "']"));
	}

	public void WaitForSomeTime(int i) throws InterruptedException {

		Thread.sleep(1000 * i);
	}

	public WebElement GettextByCommontext(String text) {

		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		return ele;
	}

	public void SendTextAndWait(WebElement ele, String text) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(text);
	}

	public void Switchframe(WebElement ele, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(ele);
	}

	public void sendvalues(WebElement ele, String text) {

		ele.sendKeys(text);
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

	public void GetList(List<WebElement> alloptions, WebDriver driver) {

		List<WebElement> m = alloptions;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			log.info(text.getText());
			int size = m.size();
			log.info("No. of added physicians are " + size);
		}
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