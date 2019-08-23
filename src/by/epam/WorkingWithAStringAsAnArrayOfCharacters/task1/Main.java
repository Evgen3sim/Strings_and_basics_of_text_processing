package by.epam.WorkingWithAStringAsAnArrayOfCharacters.task1;

import java.util.Scanner;

/*Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Input the number of values ");
        int size = scn.nextInt();
        String[] values = new String[size];
        scn.nextLine();
        for (int i = 0; i < values.length; i++) {
            System.out.println("Input name of value:");
            values[i] = scn.nextLine();
        }

        System.out.println("Result of casting:");
        for (int i = 0; i < values.length; i++) {
            System.out.println(ToCamelCase(values[i]));
        }

    }

    private static char[] ToCamelCase(String variableStr) {
        char[] str = variableStr.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (Character.isUpperCase(str[i])) {
                count++;
            }
        }
        char[] copyStr = new char[str.length + count];
        for (int i = 0, j = 0; i < str.length; i++) {
            if (Character.isUpperCase(str[i])) {
                copyStr[j] = '_';
                copyStr[j + 1] = Character.toLowerCase(str[i]);
                j += 2;
            } else {
                copyStr[j] = str[i];
                j++;
            }
        }
        return copyStr;
    }
}
