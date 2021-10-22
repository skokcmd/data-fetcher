import java.io.FileInputStream;
import java.util.List;

import helper.ExcelHelper;
import helper.IOHelper;

public class App {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		String stringPath = IOHelper.readLine("enter file path (D:\\vzorek_dat.xlsx): ");
		FileInputStream inputStream = IOHelper.getExcelInputStreamByPath(stringPath);

		if (inputStream != null) {
			ExcelHelper excelHelper = new ExcelHelper(inputStream);
			// parses string values to numeric
			List<Integer> numericSecondColValues = excelHelper
					.stringListToListOfIntegers(excelHelper.getAllRowsOfColumnAtIndex(1));

			List<Integer> primeNumbers = excelHelper.getPrimeNumbersFromList(numericSecondColValues);
			IOHelper.printList(primeNumbers);
		}
		// D:\vzorek_dat.xlsx
	}
}
