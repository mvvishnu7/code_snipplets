package mv.workspace.snipplets.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsPhoneNumber {

    private static final String[][] KEY_LOOKUP = new String[][]{
            null, null, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
            {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}
    };

    public static void main(String[] args) {
        List<String> combinations = new LetterCombinationsPhoneNumber().letterCombinations("12");
        combinations.forEach(System.out::println);
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        if (digits.length() == 1) return Arrays.asList(KEY_LOOKUP[digits.charAt(0) - '0']);

        List<String> result = new ArrayList<>();
        List<String> combinations = letterCombinations(digits.substring(1));
        for (String current : KEY_LOOKUP[digits.charAt(0) - '0']) {
            for (String com : combinations) {
                result.add(current + com);
            }
        }
        return result;
    }
}
