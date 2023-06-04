import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //чтение в буфер введенного значения
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //регулярка на проверку, число или нет
        String reg = "^[0-9]*[.]?[0-9]+$";

        //Вопрос 1, масса или расстояние
        String unswer1;
        do {
            System.out.println("Выберите что переводить, 1 - масса, 2 - расстояние: ");
            unswer1 = buffer.readLine();
        } while (!unswer1.equals("1") && !unswer1.equals("2"));

        //Выбор единицы измерения
        String unswer2;
        if(unswer1.equals("2")){ //если выбрали расстояние
            do {
                System.out.println("Выберите единицу измерения, 1 - метр, 2 - миля, 3 - ярд, 4 - фут: ");
                unswer2 = buffer.readLine();
            } while (!unswer2.equals("1") && !unswer2.equals("2") && !unswer2.equals("3") && !unswer2.equals("4"));
        }
        else{ //если выбрали массу
            do {
                System.out.println("Выберите единицу измерения, 1 - килограмм, 2 - фунт: ");
                unswer2 = buffer.readLine();
            } while (!unswer2.equals("1") && !unswer2.equals("2") && !unswer2.equals("3") && !unswer2.equals("4"));
        }

        String unswer = unswer1 + unswer2;

        String value;
        do {
            System.out.println("Введите значение: ");
            value = buffer.readLine();
        } while (!(value.matches(reg)));
        double myValue = Double.parseDouble(value);

        double metr = 0;
        double mill = 0;
        double yard = 0;
        double fut = 0;
        double kg = 0;
        double funt = 0;
        // Если масса
        switch (unswer) {
            case "11": //килограмм
                kg = myValue;
                funt = myValue * 2.205;
                break;
            case "12": //фунт
                kg = myValue / 2.205;
                funt = myValue;
                break;
        }

        // Если расстояние
        switch (unswer) {
            case "21": //метр
                metr = myValue;
                mill = myValue / 1609;
                yard = myValue * 1.094;
                fut = myValue * 3.281;
                break;
            case "22": //миля
                metr = myValue * 1609;
                mill = myValue;
                yard = myValue * 1760;
                fut = myValue * 5280;
                break;
            case "23": //ярд
                metr = myValue / 1.094;
                mill = myValue / 1760;
                yard = myValue;
                fut = myValue * 3;
                break;
            case "24": //фут
                metr = myValue / 3.281;
                mill = myValue / 5280;
                yard = myValue / 3;
                fut = myValue;
        }

        System.out.println("РЕЗУЛЬТАТ");

        if(unswer1.equals("2")){ //если выбрали расстояние
            System.out.println("Метры: " + String.format("%.3f",metr));
            System.out.println("Милли: " + String.format("%.3f",mill));
            System.out.println("Ярды: " + String.format("%.3f",yard));
            System.out.println("Футы: " + String.format("%.3f",fut));

        }
        else{ //если выбрали массу
            System.out.println("Килограммы: " + String.format("%.3f",kg));
            System.out.println("Фунты: " + String.format("%.3f",funt));

        }
    }
}