import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import helper.ExcelHelper;

public class ExcelTest {
	FileInputStream inputStream;
	ExcelHelper excelHelper;

	@BeforeEach
	void setUp() {
		try {
			inputStream = new FileInputStream("src/test/resources/vzorek_dat.xlsx");
			excelHelper = new ExcelHelper(inputStream);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	void containsOnlyDigits() {
		assertTrue(excelHelper.containsOnlyDigits("123"));
		assertFalse(excelHelper.containsOnlyDigits("asfs12"));
	}

	@Test
	void stringToInt() {
		assertEquals(123, excelHelper.stringToInt("123"));
		assertEquals(-1, excelHelper.stringToInt("123abc"));
	}

	@Test
	void isNumberPrime() {
		assertTrue(excelHelper.isNumberPrime(7));
		assertFalse(excelHelper.isNumberPrime(9));
	}

	@Test
	void removeFirstValueOfList() {
		List<Integer> nums = Arrays.asList(1, 2, 3);
		List<Integer> expected = Arrays.asList(2, 3);

		assertEquals(expected, excelHelper.removeFirstValueOfList(nums));
	}

	@Test
	void getPrimeNumbersFromList() {
		Set<Integer> expected = new HashSet<>(Arrays.asList(0, 1, 2, 3, 5, 7));
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			values.add(i);
		}
		Set<Integer> primeValues = excelHelper.getPrimeNumbersFromIntegers(values);
		assertEquals(expected, primeValues);
	}

	@Test
	void stringListToListOfIntegers() {
		List<String> strings = Arrays.asList("123", "21344");
		List<Integer> expected = Arrays.asList(123, 21344);

		assertEquals(expected, excelHelper.stringListToListOfIntegers(strings));
	}

	@Test
	void getAllValuesWithoutHeaderFromColumnAtIndex() {
		List<String> expected = Arrays.asList("5645641", "5645657", "5799555", "15619", "5221652", "1234187", "9584",
				"211", "7.0", "9785", "65132114", "9788677", "23311", "54881", "21448", "28", "564564556", "safsfd");
		assertEquals(expected, excelHelper.getAllValuesWithoutHeaderFromColumnAtIndex(1));
	}

}
