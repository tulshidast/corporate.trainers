/**
 * 
 */
package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;
import utility.GetPropertyFromPropertyFile;
import utility.GetScreenShot;
import utility.ReadExcel;

/**
 * @author Administrator
 *
 */
@Listeners(utility.ListnerImp.class)
public class LoginFunctionality {
	LoginPage loginPage;
	WebDriver driver;

	ExtentReports extentReports;
	ExtentSparkReporter extentSparkReporter;
	ExtentTest extentTest;

	static Logger log;

	@BeforeMethod
	public void setupBrowser() throws IOException {

		log = Logger.getLogger(LoginFunctionality.class);
		// file path of properties file
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.get(GetPropertyFromPropertyFile.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter("report.html");
		extentReports.attachReporter(extentSparkReporter);
	}

	@Test
	public void verifyValidLogin() throws IOException {

		extentTest = extentReports.createTest("Verify valid login");

		log.info("before click on login button");
		loginPage.getCustomerLoginButton().click();
		log.info("Clicked on login button");

		log.info("select dropdown option");
		loginPage.selectValueFromDropdown("//select[@id='userSelect']", ReadExcel.readExcel());
		log.info("dropdown option selected");

		log.info("click on login button");
		loginPage.clickOnLoginButton();

		log.info("verify successfull login");
		Assert.assertEquals(loginPage.getAccountNumber().trim(), "1004");

		//extentTest.log(Status.PASS, "Test passed");
		extentTest.log(Status.FAIL, "Test failed");

	}

	@AfterMethod
	public void tearDown(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			GetScreenShot.getScreenShot(iTestResult.getName(), driver);
		}
		driver.quit();
		extentReports.flush();
	}
}
