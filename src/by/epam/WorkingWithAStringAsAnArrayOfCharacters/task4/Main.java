package by.epam.WorkingWithAStringAsAnArrayOfCharacters.task4;

import java.util.Scanner;

/*B строке найти количесвто чисел*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Input some string:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int count = 0;
        int numCount = 0;
        boolean isNum = false;
        for (char c: str.toCharArray()){
            if ((int)c >= 47 && (int)c <= 58){
                count++;
                if (!isNum){
                    numCount++;
                    isNum = true;
                } else {
                    isNum= false;
                }
            }
        }

        System.out.println(numCount);

    }
}
