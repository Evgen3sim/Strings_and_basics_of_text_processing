package by.epam.WorkingWithAStringAsAnArrayOfCharacters.task2;

import java.util.Scanner;

/*Заменить в строке все вхождения "word" na "letter"*/


public class Main {
    public static void main(String[] args) {

        System.out.println("Input some string:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();


        char[] charArray = str.toCharArray();
        char[] word = { 'w', 'o', 'r', 'd' };
        char[] letter = { 'l', 'e', 't', 't', 'e', 'r' };
        int wordCount = Count(charArray, word);

        char[] newArray = new char[charArray.length + wordCount * ((letter.length - word.length) + 1)];

        for (int strIndex = 0, newStrIndex = 0; strIndex < charArray.length;) {
            if (isWordByIndex(charArray, word, strIndex)) {
                for (int j = 0; j < letter.length && newStrIndex < newArray.length; j++, newStrIndex++) {
                    newArray[newStrIndex] = letter[j];
                }
                strIndex += word.length;
            } else {
                newArray[newStrIndex] = charArray[strIndex];
                strIndex++;
                newStrIndex++;
            }
        }

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }
    }

    private static int Count(char[] str, char[] word) {
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            boolean isEqual = true;

            for (int j = 0, strIndex = i; j < word.length && strIndex < str.length; j++, strIndex++) {
                if (str[strIndex] != word[j]) {
                    isEqual = false;
                }
            }
            if (isEqual) {
                count++;
            }
        }

        return count;
    }

    private static boolean isWordByIndex(char[] str, char[] word, int index) {
        boolean isEqual = true;

        for (int i = index, wordIndex = 0; i < str.length && wordIndex < word.length; i++, wordIndex++) {
            if (str[i] != word[wordIndex]) {
                isEqual = false;
                break;
            }

        }

        return isEqual;
    }
}

