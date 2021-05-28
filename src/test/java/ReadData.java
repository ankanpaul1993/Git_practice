
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static List<String> readdatafromExcelusingcolumnName(String ColumnName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<String> cellValues = new ArrayList<String>();
		String SheetName = "Sheet1";
		File file = new File(
				"C:\\Users\\748639\\OneDrive - Cognizant\\Desktop\\SF\\Users with username and passwords - DefResMH.xlsx");
		FileInputStream fi = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet(SheetName);
		// it will take value from first row
		Row row = sheet.getRow(0);
		// it will give you count of columns which is used or filled
		short lastcolumnused = row.getLastCellNum();
		System.out.println(lastcolumnused);

		int lastRowNumber = sheet.getLastRowNum();
		System.out.println(lastRowNumber);

		int colnum = 0;
		for (int i = 0; i < lastcolumnused; i++) {
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
				colnum = i;

				for (int j = 1; j < lastRowNumber; j++) {

					Row row1 = sheet.getRow(j);
					String cellValue = row1.getCell(colnum).getStringCellValue();
					System.out.println(cellValue);
					cellValues.add(cellValue);

				}

			}
		}
		return cellValues;

	}

	public String getAppProperties(String Key) {

		String value = "";

		try {
			FileInputStream Locator = new FileInputStream("");
			Properties properties;
			properties = new Properties();
			properties.load(Locator);
			value = properties.getProperty(Key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;

	}
}
