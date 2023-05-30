package Base;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.reflect.Method;
import java.time.Duration;
public class BaseTest  {
	
	public static WebDriver driver ;
	public ExtentHtmlReporter sparkReporter ;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeTest
	public void beforetestmethod() {
		sparkReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "Acc_ManagerExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Account_Manager_Reports");
		sparkReporter.config().setReportName("OCPI_AccountManager_Report");
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser,Method testMethod) {
		
		logger = extent.createTest(testMethod.getName());	
	    setupDriver(browser);
	    driver.get(Constants.url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	
	public void setupDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	 

}

