package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	private Workbook wb;
	private Sheet sheet;

	public ExcelHelper(FileInputStream fileInputStream) {
		try {
			this.wb = new XSSFWorkbook(fileInputStream);
			this.sheet = wb.getSheetAt(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Method to check if string contains only numbers
	 *
	 * @param str
	 *            string to be checked
	 * @return boolean
	 */
	public boolean containsOnlyDigits(String str) {
		return str.matches("[0-9]+");
	}

	/**
	 * Method parsing string to int
	 *
	 * @param s
	 *            string for parsing
	 * @return parsed int || -1
	 */
	public int stringToInt(String s) {
		if (containsOnlyDigits(s)) {
			double d = Double.parseDouble(s);
			// checks if double contains decimal point
			if (d % 1 == 0) {
				return (int) d;
			}
		}
		return -1;
	}

	/**
	 * checks whether the number is prime
	 *
	 * @param num
	 *            number to check
	 * @return whether num is prime
	 */
	public boolean isNumberPrime(double num) {
		for (int i = 2; i <= num / 2; ++i) {
			// condition for non-prime number
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to remove header element from the list
	 *
	 * @param list
	 *            values
	 * @return new list without first value
	 */
	public <T> List<T> removeFirstValueOfList(List<T> list) {
		List<T> newList = new ArrayList<>();
		list.stream().skip(1).forEach(newList::add);
		return newList;
	}

	/**
	 * Gets a string list by the column index
	 * 
	 * @param index
	 *            index of the column
	 * @return list of string values at given column without the header
	 */
	public List<String> getAllValuesWithoutHeaderFromColumnAtIndex(int index) {
		List<String> allStringValues = new ArrayList<>();
		this.sheet.forEach(row -> {
			Cell cell = row.getCell(index);
			allStringValues.add(cell.getStringCellValue());
		});
		// returns list without header
		return removeFirstValueOfList(allStringValues);
	}

	/**
	 * Gets a list of integers from a list of strings; ignores negative and
	 * non-integer values
	 * 
	 * @param stringValues
	 *            list with string values
	 * @return list of doubles at given column
	 */
	public List<Integer> stringListToListOfIntegers(List<String> stringValues) {
		List<Integer> numericValues = new ArrayList<>();
		stringValues.forEach(value -> {
			// parse number string to int
			// if value contains decimal || other characters -> parsedValue = -1 -> invalid
			int parsedValue = stringToInt(value);
			if (parsedValue > 0) {
				numericValues.add(parsedValue);
			}
		});
		return numericValues;
	}

	/**
	 * Gets prime numbers from a list of integers; Using set to ignore duplicates
	 * 
	 * @param values
	 *            list of integers
	 * @return new list of prime values
	 */
	public Set<Integer> getPrimeNumbersFromIntegers(List<Integer> values) {
		Set<Integer> primeNumbers = new HashSet<>();
		values.forEach(num -> {
			if (isNumberPrime(num)) {
				primeNumbers.add(num);
			}
		});
		return primeNumbers;
	}
}
