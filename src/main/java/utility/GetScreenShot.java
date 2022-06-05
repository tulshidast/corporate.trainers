/**
 * 
 */
package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class GetScreenShot {

	public static void getScreenShot(String name, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File file2 = new File("screenshot/" + name + ".png");
		FileUtils.copyFile(file, file2);

	}

}
