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
                Integer.parseInt(parsed_input[0]);
                Integer.parseInt(parsed_input[2]);
            } catch (NumberFormatException e) {
                arabian = false;
            }

            if (arabian) {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
                if (!Exceptions.MoreThen10(value1, value2)) {
                    System.out.print("Ответ: " + Operation.Operation(value1, value2, operation));
                    System.out.println();
                    System.out.print("Введите следующее выражение: ");
                    input = value.nextLine();
                } else if (Exceptions.MoreThen10(value1, value2)) {
                    System.out.print("Можно вводить числа до 10 включительно!");
                    System.exit(0);
                }


            } else {
                int value1Rome = rome_to_arab(parsed_input[0]);
                int value2Rome = rome_to_arab(parsed_input[2]);
                if (!Exceptions.MoreThen10(value1Rome, value2Rome)) {
                    if (!arabian && (value1Rome - value2Rome) < 0) {
                        System.out.print("Ответ: -" + Converter.arab_to_rome(Operation.Operation(value1Rome, value2Rome, operation)));
                    }else if (!arabian && Operation.Operation(value1Rome, value2Rome, operation) == 0) {
                        System.out.print("Null");
                    } else {
                    System.out.print("Ответ: " + Converter.arab_to_rome(Operation.Operation(value1Rome, value2Rome, operation)));
                    }
                arabian = true;
                System.out.println();
                System.out.print("Введите следующее выражение: ");
                input = value.nextLine();
            } else if (Exceptions.MoreThen10(value1Rome, value2Rome)) {
                    System.out.print("Можно вводить числа до 10 включительно!");
                    System.exit(0);
                }
            }
        }
        System.out.println("Работа завершена");
    }
}




