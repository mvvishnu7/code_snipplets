package mv.workspace.snipplets.leetCode;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("VL"));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int last = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentVal;
            switch (s.charAt(i)) {
                case 'I':
                    currentVal = 1;
                    break;
                case 'V':
                    currentVal = 5;
                    break;
                case 'X':
                    currentVal = 10;
                    break;
                case 'L':
                    currentVal = 50;
                    break;
                case 'C':
                    currentVal = 100;
                    break;
                case 'D':
                    currentVal = 500;
                    break;
                case 'M':
                    currentVal = 1000;
                    break;
                default:
                    currentVal = 0;
                    break;
            }

            if (currentVal < last) {
                sum -= currentVal;
            } else {
                sum += currentVal;
                last = currentVal;
            }
        }
        return sum;
    }
}
