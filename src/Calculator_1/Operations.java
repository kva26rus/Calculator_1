package Calculator_1;

public class Operations {
    public static int operation(int value1, int value2, String symbol) {
        int result = 0;

        switch (symbol) {
            case "+":
                result = value1 + value2;
                return result;
            case "-":
                result = value1 - value2;
                /*if (result < 0 && !Calculator_1.arabian) {

                    result *= -1;
                }*/
                    return result;
            case "/":
            case ":":

                try {
                    result = value1 / value2;
                    return result;
                } catch (ArithmeticException e) {
                    System.out.print("Делить на 0 нельзя!");
                    System.exit(0);
                }
            case "*":
            case "x":
                result = value1 * value2;
                return result;
            default: System.out.print("Введен неизвестный символ");
            System.exit(0);
        }
    return result;
    }

    }
