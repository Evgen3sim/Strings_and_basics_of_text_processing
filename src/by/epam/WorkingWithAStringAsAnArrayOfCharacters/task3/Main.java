package by.epam.WorkingWithAStringAsAnArrayOfCharacters.task3;

import java.util.Scanner;

/*В строке найти кол-во цифр*/

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Input some string ");
        String str = scn.nextLine();

        int count = 0;

        for (char ch: str.toCharArray()){
            if ((int) ch > 47 && (int) ch < 58){
                count++;
            }
        }
        System.out.println("Количество цифр " + count);

    }
}
