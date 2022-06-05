/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Administrator
 *
 */
public class ReadExcel {

	static String str = "";

	public static String readExcel() throws IOException {
		FileInputStream fis = new FileInputStream(new File("src/test/resources/test.xlsx"));
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		int lastRowNumber = sheet.getLastRowNum();
		for (int i = 1; i <= lastRowNumber; i++) {
			for (int j = 0; j <= sheet.getRow(i).getLastCellNum(); j++)
				str = sheet.getRow(i).getCell(0).getStringCellValue();
		}

		return str;

	}

}
