package Listenerpackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

	// public WebDriver driver;
	public void onTestStart(ITestResult result) {
		System.out.println("***********"+ result.getName()+ " "+ "##started## **************");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("********Test completed successfull*******" + result.getName());

	}

	public void onTestFailure(ITestResult result, WebDriver driver) {
		System.out.println("Test Failed- " + result.getName());

		// WebDriver driver;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File failureImageFile = new File("./Screenshots/" + result.getName() + ".png");
		try {
			FileUtils.copyFile(imageFile, failureImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped- " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Started- " + context.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("Finished- " + context.getName());

	}
}
