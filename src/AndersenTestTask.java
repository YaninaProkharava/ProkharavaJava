import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AndersenTestTask {
    private static final int COMPARISON_NUMBER = 7;
    private static final int MULTIPLICITY_NUMBER = 3;
    private static final String EXPECTED_NAME = "Вячеслав";
    private static final Scanner _scanner = new Scanner(System.in);

    private static void checkNumber(){
        System.out.printf("Введите число больше %s: %n", COMPARISON_NUMBER);

        if (_scanner.hasNextInt()) {
            int inputNumber = _scanner.nextInt();
            if (inputNumber > COMPARISON_NUMBER) {
                System.out.println("Привет");
            } else {
                System.out.println("Число не больше " + COMPARISON_NUMBER);
            }
        } else {
            System.out.println("Не число");
        }
    }

    private static void checkName(){
        _scanner.nextLine();
        System.out.println("Введите имя:");
        if(_scanner.hasNextLine()) {
            String name = _scanner.nextLine();

            if (name.equals(EXPECTED_NAME)) {
                System.out.println("Привет, " + name);
            } else {
                System.out.println("Нет такого имени");
            }
        }
    }

    private static void checkArray(){
        System.out.println("Введите массив целых чисел:");
        String input = _scanner.nextLine();
        String[] inputString = input.split("[, ]+");
        ArrayList<Integer> sortedArrayList = new ArrayList<>();
        boolean exeptionAppeared = false;

        for (String stringNumber : inputString) {
            try {
                var number = Integer.parseInt(stringNumber);
                if (number % MULTIPLICITY_NUMBER == 0) {
                    sortedArrayList.add(number);
                }
            } catch (NumberFormatException e) {
                exeptionAppeared = true;
                System.out.println("Неправильные данные");
                break;
            }
        }

        if(!exeptionAppeared){
            if (sortedArrayList.isEmpty()) {
                System.out.println("Нет ни одного числа кратного " + MULTIPLICITY_NUMBER);
            } else {
                System.out.printf("Числа, кратные %s: %n", MULTIPLICITY_NUMBER);
                for (int number : sortedArrayList) {
                    System.out.println(number);
                }
            }
        }
    }

    private static void pressEnterToContinue()
    {
        System.out.println("Нажмиме Enter, чтобы выйти...");
        _scanner.nextLine();
    }

    public static void main(String[] args) {
        // Part 1
        checkNumber();

        //Part 2
        checkName();

        //Part 3
        checkArray();

        pressEnterToContinue();
    }
}
