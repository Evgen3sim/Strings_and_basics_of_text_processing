package by.epam.WorkingWithAStringAsAnArrayOfCharacters.task5;

import java.util.Scanner;

/*Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 Крайние пробелы в строке удалить.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Input some string:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();

        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                beginIndex = i;
                break;
            }
        }

        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] != ' ') {
                endIndex = i;
                break;
            }
        }

        int spaceCount = redundantSpaceCounter(charArray, beginIndex, endIndex);

        char[] newArray = new char[((endIndex - beginIndex) + 1) - spaceCount];

        for (int strIndex = beginIndex, newStrIndex = 0; strIndex <= endIndex;) {
            if (charArray[strIndex] == ' ') {
                newArray[newStrIndex] = charArray[strIndex];
                strIndex++;
                while (charArray[strIndex] == ' ') {
                    strIndex++;
                }
                newStrIndex++;
            } else {
                newArray[newStrIndex] = charArray[strIndex];
                strIndex++;
                newStrIndex++;
            }
        }

        System.out.println("Modified string:\n");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }
    }

    private static int redundantSpaceCounter(char[] charArray, int beginIndex, int endIndex) {
        int count = 0;

        for (int i = beginIndex; i <= endIndex; i++) {
            if (charArray[i] == ' ') {
                i++;
                while (charArray[i] == ' ') {
                    count++;
                    i++;
                }
            }
        }

        return count;
    }
    }

