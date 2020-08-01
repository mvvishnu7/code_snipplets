package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("912.83472332"));
    }


    public int myAtoi(String str) {

        if (Objects.isNull(str)) {
            return 0;
        }

        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }
        int startPos = getStartPos(str.charAt(0));

        if (startPos < 0) {
            return 0;
        }
        int i;
        for (i = startPos; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                break;
            }
        }

        if (i == 1 && startPos == 1) {
            return 0;
        }

        try {
            return Integer.valueOf(str.substring(0, i));
        } catch (NumberFormatException e) {
            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

    }

    private int getStartPos(char c) {
        if ((c == '+') || (c == '-')) {
            return 1;
        } else if ((c >= '0' && c <= '9')) {
            return 0;
        } else {
            return -1;
        }
    }
}
