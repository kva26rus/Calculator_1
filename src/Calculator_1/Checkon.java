package Calculator_1;public class Checkon {
    public static void More10Ex (int a, int b) throws MyException {
        if (a > 10 || b > 10) throw new MyException("Извините! Можно вводить числа до 10 включительно!");


    }
    public static void UpperCaseEx (String str1, String str2) throws MyException {
        String strUp1 = str1.toUpperCase(),
                strUp2 = str2.toUpperCase();
        if (!strUp1.equals(str1) || !strUp2.equals(str2)) throw new MyException("Ошибка! Можно использовать только буквы в верхнем регистре!");

    }
    public static void SameTipeEx (String str1, String str2) throws MyException {
        boolean first = true;
        boolean second = true;
        try {
            Integer.parseInt(str1);
        }catch (NumberFormatException e) {
            first = false;
        }
        try {
            Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            second = false;
        }
        if ((!first && second) || (first && !second))
            throw new MyException("Нельзя использовать арабские и римские цифры одновременно!");



    }

}
