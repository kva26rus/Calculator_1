package Calculator_1;

import java.util.Scanner;

import static Calculator_1.Converter.rome_to_arab;

public class InputArray {
    public static String[] value(String input) {

        String[] input_arr = input.split(" ");
        if (CheckOn.ArrLenLess3Ex(input_arr)) {
            System.out.println("Вводите значения через пробел!");
            System.out.print("Введите следующее выражение: ");
            String input1 = new Scanner(System.in).nextLine();
            return value(input1);
        }else if (CheckOn.NotOperationEx(input_arr[1])) {
            System.out.println("Введен неизвестный символ!");
            System.out.print("Введите следующее выражение: ");
            String input1 = new Scanner(System.in).nextLine();
            return value(input1);
        } else {
            try {
                Integer.parseInt(input_arr[0]);
                Integer.parseInt(input_arr[2]);
                if (CheckOn.More10Ex(Integer.parseInt(input_arr[0]), Integer.parseInt(input_arr[2]))) {
                    System.out.println("Извините! Можно вводить числа до 10 включительно!");
                    System.out.print("Введите следующее выражение: ");
                    String input1 = new Scanner(System.in).nextLine();
                    return value(input1);
                } else if (CheckOn.ArrLenMore3Ex(input_arr)) {
                    System.out.println("Вычисления производятся только с двумя значениями!");
                    System.out.print("Введите следующее выражение: ");
                    String input1 = new Scanner(System.in).nextLine();
                    return value(input1);
                } else
                    return input_arr;
            } catch (NumberFormatException e) {
                Calculator_1.arabian = false;
                if (CheckOn.More10Ex(rome_to_arab(input_arr[0]), rome_to_arab(input_arr[2]))) {
                    System.out.println("Извините! Можно вводить числа до 10 включительно!");
                    System.out.print("Введите следующее выражение: ");
                    String input1 = new Scanner(System.in).nextLine();
                    return value(input1);
                }else if (CheckOn.SameTypeEx(input_arr[0], input_arr[2])) {
                    System.out.println("Нельзя использовать арабские и римские цифры одновременно!");
                    System.out.print("Введите следующее выражение: ");
                    String input1 = new Scanner(System.in).nextLine();
                    return value(input1);
                } else if (CheckOn.UpperCaseEx(input_arr[0], input_arr[2])) {
                    System.out.println("Ошибка! Можно использовать только буквы в верхнем регистре!");
                    System.out.print("Введите следующее выражение: ");
                    String input1 = new Scanner(System.in).nextLine();
                    return value(input1);
                }
            }
        }
        return input_arr;
    }
}
