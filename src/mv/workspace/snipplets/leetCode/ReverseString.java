package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] arr = "abcd".toCharArray();
        new ReverseString()
                .reverseString(arr);
        System.out.println(arr);

    }

    public void reverseString(char[] s) {
        if (Objects.isNull(s) || s.length == 0) return;

        for (int i = 0; i < s.length / 2; i++) {
            s[i] = (char) (s[i] + s[s.length - i - 1]);
            s[s.length - i - 1] = (char) (s[i] - s[s.length - i - 1]);
            s[i] = (char) (s[i] - s[s.length - i - 1]);
        }
    }
}
