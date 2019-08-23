package by.epam.StringAsObject.task7;

/*Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 def", то должно быть выведено "abcdef".*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String newStr = "";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!newStr.contains(String.valueOf(str.charAt(i)))) {
                newStr += String.valueOf(str.charAt(i));
            }
        }
        newStr = newStr.replace(" ", "");
        System.out.println(newStr);
    }
}
