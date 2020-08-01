package mv.workspace.snipplets.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(
                new LongestSubstringWithoutRepeatingCharacters()
                        .lengthOfLongestSubstring("ababa")
        );
    }


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lookUp = new HashMap<>();

        int i = 0;
        String maxStr = "";

        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            if(lookUp.containsKey(current)) {
                i = Math.max(lookUp.get(current) + 1, i);
            }

            if (j - i + 1 > maxStr.length()) {
                maxStr = s.substring(i, j+1);
            }

            lookUp.put(current, j);
        }

        return maxStr.length();
    }
}
