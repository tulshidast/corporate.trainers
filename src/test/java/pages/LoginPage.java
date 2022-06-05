/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Administrator
 *
 */
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getCustomerLoginButton() {
		WebElement elm = driver
				.findElement(By.xpath("//button[@class='btn btn-primary btn-lg'][text()='Customer Login']"));
		return elm;

	}

	public void selectValueFromDropdown(String locator, String option) {
		WebElement elm1 = driver.findElement(By.xpath(locator));
		Select select = new Select(elm1);
		select.selectByVisibleText(option);
	}

	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public String getAccountNumber() {
		String str = driver.findElement(By.xpath("//div[text()='Account Number : ']/strong[1]"))
				.getAttribute("innerHTML");
		return str;

	}

}
