package Calculator_1;

import java.util.Scanner;

import static Calculator_1.Converter.rome_to_arab;

public class Calculator_1 {
    public static boolean arabian = true;

    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        System.out.print("Введите выражение:");
        String input = value.nextLine();
        while (!input.isEmpty()) {
            String[] parsed_input = InputArray.value(input);
            String operation = parsed_input[1];
            int value1;
            int value2;
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
                    } else if (result == 0) {
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
        }
    }





