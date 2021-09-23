package Calculator_1;

import java.util.Scanner;

import static Calculator_1.Converter.rome_to_arab;

public class Calculator_1 {
    public static boolean arabian = true;

    private static String[] value(String input) {
        String[] input_arr = input.split(" ");
        if (input_arr.length != 3) {
            Scanner rewrite_value = new Scanner(System.in);
            System.out.println("Проверьте правильность ввода.");
            System.out.println("Можно вводить числа до 10 включительно.");
            System.out.println("Римские цифры: " + "I = 1, " + "V = 5, " + "X = 10.");
            System.out.println("Символы вводятся через пробел.");
            System.out.print("Введите выражение еще раз:");
            input = rewrite_value.nextLine();
            return value(input);
        }else
            return input_arr;
    }

    public static void main(String[] args) {

        Scanner value = new Scanner(System.in);
        System.out.print("Введите выражение:");
        String input = value.nextLine();
        while (!input.isEmpty()) {
            String[] parsed_input = Calculator_1.value(input);
            String operation = parsed_input[1];
            int value1;
            int value2;
            try {
                Checkon.SameTipeEx(parsed_input[0], parsed_input[2]);
            } catch (MyException e) {
                System.out.print(e.getMessage());
                System.exit(0);
            }
            try {
                Integer.parseInt(parsed_input[0]);
                Integer.parseInt(parsed_input[2]);

                try {
                    Checkon.More10Ex(Integer.parseInt(parsed_input[0]), Integer.parseInt(parsed_input[2]));
                } catch (MyException e) {
                    System.out.print(e.getMessage());
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                arabian = false;
                try {
                    Checkon.More10Ex(rome_to_arab(parsed_input[0]), rome_to_arab(parsed_input[2]));
                }catch (MyException e1) {
                    System.out.print(e1.getMessage());
                    System.exit(0);
                }
                try {
                    Checkon.UpperCaseEx(parsed_input[0], parsed_input[2]);
                } catch (Exception ex) {
                    System.out.print(ex.getMessage());
                    System.exit(0);
                }
            }


            if (arabian) {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
                    System.out.print("Ответ: " + Operations.operation(value1, value2, operation));
            } else {
                int value1Rome = rome_to_arab(parsed_input[0]);
                int value2Rome = rome_to_arab(parsed_input[2]);
                int result = Operations.operation(value1Rome, value2Rome, operation);
                    if (result < 0) {
                        System.out.print("Ответ: -" + Converter.arab_to_rome(result * -1));
                    }else if (result == 0) {
                        System.out.print("Null");
                    } else {
                    System.out.print("Ответ: " + Converter.arab_to_rome(result));
                    }
                arabian = true;

            }
            System.out.println();
            System.out.print("Введите следующее выражение: ");
            input = value.nextLine();
        }
        System.out.println("Работа завершена");
    }
}




