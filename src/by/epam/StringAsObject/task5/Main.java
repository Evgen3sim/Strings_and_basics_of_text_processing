package by.epam.StringAsObject.task5;

/*Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.*/

public class Main {
    public static void main(String[] args) {

        String str = "Privet Evgeny and Vitaly";


        int count = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a'){
                count++;
            }
        }
        System.out.println("kol-vo " + count);

    }
}
