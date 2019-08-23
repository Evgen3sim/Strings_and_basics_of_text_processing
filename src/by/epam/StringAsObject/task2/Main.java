package by.epam.StringAsObject.task2;

import java.util.Scanner;

/*В строке вставить после каждого символа 'a' символ 'b'.*/

public class Main {
    public static void main(String[] args) {

       Scanner scn = new Scanner(System.in);

        System.out.println("Input some string ");

        String s = scn.nextLine();

        String s2 = " ";

        for (int i = 0; i < s.length(); i++) {
            s2 += s.charAt(i);
            if(s.charAt(i) == 'a') {
                s2 += 'b';
            }
        }
        System.out.println(s2);


    }
}
