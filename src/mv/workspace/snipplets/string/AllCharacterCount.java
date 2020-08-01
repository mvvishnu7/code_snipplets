package mv.workspace.snipplets.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class AllCharacterCount {

    private static final List<Character> ESCAPE_CHARS = List.of('\n', '\t', ' ');

    public static void main(String[] args) {
        new AllCharacterCount().printCharacterCount("ようこそようこそsdsff");
    }

    private void printCharacterCount(final String str) {
        Map<Character, Integer> countMap = new HashMap<>();

        IntStream.range(0, str.length())
                .filter(i -> !ESCAPE_CHARS.contains(str.charAt(i)))
                .forEach(i -> {
                    char currentChar = str.charAt(i);
                    countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
                });

        countMap.forEach((key, value) -> System.out.println("char: " + key + " | count: " + value));
    }
}
