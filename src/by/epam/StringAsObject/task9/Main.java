package by.epam.StringAsObject.task9;

/*Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
 буквы.*/

public class Main {
    public static void main(String[] args) {

        String str = "Hello My name IS";

        int up = 0;
        int lower = 0;

        char ch;


        for (int i = 0; i < str.length(); i++){

            ch = str.charAt(i);
            int a = (int)ch;

            if (a >= 65 && a <= 90){
                up++;
            } else {
                if (a >=97 && a <= 122){
                    lower++;
                }
            }

        }

        System.out.println("Маленьких " + lower);
        System.out.println("Больших " + up);
    }
}
