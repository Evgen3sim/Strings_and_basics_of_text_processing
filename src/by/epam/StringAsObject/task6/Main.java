package by.epam.StringAsObject.task6;

/*Из заданной строки получить новую, повторив каждый символ дважды.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Input ");

        String s = scn.nextLine();

        String s2 = " ";

        for (int i = 0; i < s.length(); i ++){
            s2 += s.charAt(i);
            s2 += s.charAt(i);
        }
        System.out.println(s2);
    }
}
