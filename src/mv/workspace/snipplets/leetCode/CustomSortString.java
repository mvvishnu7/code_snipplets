package mv.workspace.snipplets.leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(
                new CustomSortString()
                        .customSortString("exv",
                                "xwvee"));
    }

    public String customSortString(String s, String t) {

        Map<Character, Integer> inputFreqMap = new LinkedHashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            inputFreqMap.put(current, (inputFreqMap.getOrDefault(current, 0) + 1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int freq = inputFreqMap.getOrDefault(current, 0);

            while (freq > 0) {
                sb.append(current);
                freq--;
            }

            inputFreqMap.remove(current);
        }

        for (char c : inputFreqMap.keySet()) {
            int freq = inputFreqMap.getOrDefault(c, 0);

            while (freq > 0) {
                sb.append(c);
                freq--;
            }
        }

        return sb.toString();
    }
}
