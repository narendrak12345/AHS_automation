package MainBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static FileInputStream fis1;

	public static Logger log = LogManager.getLogger(BaseTest.class);

	public BaseTest() throws IOException {

		prop = new Properties();
		String home = System.getProperty("user.dir");
		// System.out.println(home);
		fis = new FileInputStream(home + "\\src\\main\\resources\\Properties\\Testdata.properties");
		prop.load(fis);
		fis1 = new FileInputStream(home + "\\src\\main\\resources\\logs\\log4j2.properties");
		prop.load(fis);
		//log.info("Loading files");
	}

	public void init() {

		WebDriverManager.chromedriver().setup();
		String browser = prop.getProperty("browser");
		log.info("Current browser is " + browser);

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			log.info("Selecting chrome browser");
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			log.info("Selecting Firefox browser");
		} else if (browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			log.info("Selecting IE browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		log.info("Opening URL");
		driver.get(prop.getProperty("URL"));
	}
}
