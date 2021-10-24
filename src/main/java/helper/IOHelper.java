package helper;

import java.io.*;
import java.util.Set;

public class IOHelper {

	private static final BufferedReader reader;

	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Method to read line from the user input using BufferedReader
	 * 
	 * @param message
	 *            string to display to the user before the input
	 * @return String that user has entered
	 */
	public static String readLine(String message) {
		System.out.print(message);
		try {
			return reader.readLine().trim();
		} catch (IOException ex) {
			System.out.println("Can't read the text");
		}
		return null;
	}

	/**
	 * 
	 * Method to get FileInputStream by the string path
	 * 
	 * @param path
	 *            string path of a file
	 * @return FileInputStream
	 */
	public static FileInputStream getExcelInputStreamByPath(String path) {
		try {
			return new FileInputStream(path);
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
		}
		return null;
	}

	/**
	 * Generic method to print set
	 * 
	 * @param set
	 *            Set that will be printed
	 */
	public static void printSet(Set<?> set) {
		set.forEach(System.out::println);
	}
}
