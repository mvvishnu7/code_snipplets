package mv.workspace.snipplets.string;

// Q) first non repeated character from String? (solution)

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        new FirstNonRepeatedCharacter()
                .findFirstNonRepeatedCharacter("Monday")
                .ifPresent(System.out::println);
    }

    public Optional<Character> findFirstNonRepeatedCharacter(String str) {
        LinkedHashMap<Character, Integer> characterCount = new LinkedHashMap<>();

        str.chars()
                .forEach(c -> characterCount.put((char) c, getOrDefault(characterCount, (char) c)));

        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            if (entry.getValue() == 1) {
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    private int getOrDefault(Map<Character, Integer> characterCount, char c) {
        return characterCount.getOrDefault(c, 0) + 1;
    }
}
