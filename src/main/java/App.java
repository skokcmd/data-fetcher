import java.io.FileInputStream;
import java.util.List;
import java.util.Set;

import helper.Excel;
import helper.IOHelper;

public class App {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		String stringPath = IOHelper.readLine("enter file path (D:\\vzorek_dat.xlsx): ");
		FileInputStream inputStream = IOHelper.getExcelInputStreamByPath(stringPath);

		if (inputStream != null) {
			Excel excel = new Excel(inputStream);
			// parses string values to numeric
			List<Integer> numericSecondColValues = excel
					.stringListToListOfIntegers(excel.getAllValuesWithoutHeaderFromColumnAtIndex(1));

			Set<Integer> primeNumbers = excel.getPrimeNumbersFromIntegers(numericSecondColValues);
			IOHelper.printSet(primeNumbers);
		}
		// D:\vzorek_dat.xlsx
	}
}
