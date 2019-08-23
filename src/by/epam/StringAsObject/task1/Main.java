package by.epam.StringAsObject.task1;

import java.util.Scanner;

/*Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.*/

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			System.out.println("enter the string:");
			String testString = scanner.nextLine();
			System.out.println(testString);
			int maxSpaceNumber = getMaxSpaceNumber(testString);
			System.out.println("The max number of spaces in the test string = " + maxSpaceNumber);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getMaxSpaceNumber(String testString) {
		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return 0;
		}
		int counter = 0;                                       
		String[] strings = testString.split("\\S");     
		for (String string : strings) {
			if (string.length() > counter) {
				counter = string.length();
			}
		}
		return counter;
	}
}
