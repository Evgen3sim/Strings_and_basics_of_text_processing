package by.epam.StringAsObject.task8;

import java.util.Scanner;

/*Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
 длинных слов может быть несколько, не обрабатывать.
 */

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(str);
        String[] word = str.split(" ");
        String str2 = " ";
        
        for (int i = 0; i < word.length; i++){
            if (word[i].length() > str2.length()){
                str2 = word[i];

            }
        }


        System.out.println(str2.length());
    }
}
