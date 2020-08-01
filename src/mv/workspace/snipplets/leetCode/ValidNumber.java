package mv.workspace.snipplets.leetCode;

import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
//        System.out.println(validNumber.isNumber("0"));
//        System.out.println(validNumber.isNumber(" 0.1 "));
//        System.out.println(validNumber.isNumber("abc"));
//        System.out.println(validNumber.isNumber("1 a"));
//        System.out.println(validNumber.isNumber("2e10"));
//        System.out.println(validNumber.isNumber(" -90e3   "));
//        System.out.println(validNumber.isNumber(" 1e"));
//        System.out.println(validNumber.isNumber("e3"));
//        System.out.println(validNumber.isNumber(" 6e-1"));
        System.out.println(validNumber.isNumber("005047e+6"));
//        System.out.println(validNumber.isNumber(".e93"));
//        System.out.println(validNumber.isNumber(".2e81"));
//        System.out.println(validNumber.isNumber("-+3"));
//        System.out.println(validNumber.isNumber("+3."));
//        System.out.println(validNumber.isNumber("-.1"));
//        System.out.println(validNumber.isNumber("-."));


    }

    public boolean isNumber(String s) {
        if (Objects.isNull(s) || s.isEmpty())
            return false;

        boolean eAvailable = false;
        boolean dotAvailable = false;

        List<Character> nonSupportedLastChar = List.of('e', '-', '+');

        String str = trim(s);

        if (str.isEmpty()
                || nonSupportedLastChar.contains(str.charAt(str.length() - 1))
                || (str.length() == 1 && (isNotDigit(str.charAt(0)))))
            return false;


        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (isNotDigit(currentChar)) {
                switch (currentChar) {
                    case 'e':
                        if (isInvalidExponent(eAvailable, str, i))
                            return false;

                        eAvailable = true;
                        break;
                    case '.':
                        if (isInvalidDot(eAvailable, dotAvailable, str, i))
                            return false;

                        dotAvailable = true;
                        break;
                    case '-':
                    case '+':
                        if ((i != 0 && !eAvailable) || (eAvailable && !(str.charAt(i - 1) == 'e')))
                            return false;

                        break;
                    default:
                        return false;
                }
            }
        }

        return true;
    }

    private boolean isNotDigit(char currentChar) {
        return currentChar < '0' || currentChar > '9';
    }

    private boolean isInvalidExponent(boolean eAvailable, String str, int i) {
        return i == 0
                || eAvailable
                || (i == 1 && str.charAt(0) == '.')
                || str.charAt(i - 1) == '-'
                || str.charAt(i - 1) == '+';
    }

    private boolean isInvalidDot(boolean eAvailable, boolean dotAvailable, String str, int i) {
        return dotAvailable
                || eAvailable
                || (i == str.length() - 1 && (str.charAt(i - 1) == '-'
                || str.charAt(i - 1) == '+'));
    }

    private String trim(String str) {
        int end = str.length();
        int start = 0;

        while (start < end && str.charAt(start) == ' ') {
            start++;
        }

        while (end > start && str.charAt(end - 1) == ' ') {
            end--;
        }
        return str.substring(start, end);
    }
}
