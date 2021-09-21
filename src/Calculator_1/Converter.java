package Calculator_1;

public class Converter {
    private static final String [] rome = {"X", "IX", "V", "IV", "I"};

    private static final int [] arab = {10, 9, 5, 4, 1};

    public static int rome_to_arab(String str) {
        int value = 0;

        for (int i = 0; i < rome.length; i++) {
            while (str.startsWith(rome[i])) {
                value += arab[i];
                str = str.substring(rome[i].length());
            }

        }

        return value;

    }

    public static String arab_to_rome(int num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0 || arab.length == (i-1)) {
            while ((num - arab[i]) >=0) {
                num -= arab[i];
                result.append(rome[i]);
            }
            i++;
        }

        return result.toString();
    }


}

