package by.epam.StringAsObject.task10;

/*Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 знаком. Определить количество предложений в строке X.
 */

public class Main {
    public static void main(String[] args) {

        String x = "Amy normally hated Monday mornings, but this year was different. " +
                "Kamal was in her art class and she liked Kamal!" +
                " She was waiting outside the classroom when her friend Tara arrived?";

        int indexPoint = x.indexOf(".");
        int indexQuestion = x.indexOf("?");
        int indexExclamation = x.indexOf("!");

        int count = 0;

        if (indexPoint != -1){
            count++;
        }
        if (indexExclamation != -1){
            count++;
        }
        if (indexQuestion != -1){
            count++;
        }


        System.out.println("Количество предложений " + count);

    }
}
