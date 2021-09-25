package Calculator_1;

public class CheckOn {

    public static boolean More10Ex(int a, int b) {
        return (a > 10 || b > 10);
    }

    public static boolean UpperCaseEx(String str1, String str2) {
        String strUp1 = str1.toUpperCase(),
                strUp2 = str2.toUpperCase();
        return (!strUp1.equals(str1) || !strUp2.equals(str2));
    }

    public static boolean SameTypeEx(String str1, String str2) {
        boolean first = true;
        boolean second = true;
        try {
            Integer.parseInt(str1);
        } catch (NumberFormatException e) {
            first = false;
        }
        try {
            Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            second = false;
        }
        return ((!first && second) || (first && !second));
    }

    public static boolean ArrLenLess3Ex(String[] arr) {

        return arr.length < 3;

    }

    public static boolean ArrLenMore3Ex(String[] arr) {

        return arr.length > 3;
    }

    public static boolean NotOperationEx(String str) {
        switch (str) {
            case "+":
            case "-":
            case "/":
            case ":":
            case "*":
            case "x":
                return false;
            default:
                return true;
        }
    }
}

