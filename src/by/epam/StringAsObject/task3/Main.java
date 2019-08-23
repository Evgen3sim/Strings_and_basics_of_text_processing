package by.epam.StringAsObject.task3;

import java.util.Scanner;

/*Проверить, является ли заданное слово палиндромом.*/

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        StringBuilder std = new StringBuilder(s);

        String reversWord = new String(std.reverse());
        System.out.println("Original " + s);
        System.out.println("Revers " + reversWord);

        if (s.toLowerCase().equals(reversWord.toLowerCase()) ){
            System.out.println("Palindrome");
        } else
        {
            System.out.println("The word is not Palindrome");
        }
    }
}
