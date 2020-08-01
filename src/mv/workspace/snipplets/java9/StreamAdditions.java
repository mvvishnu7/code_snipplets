package mv.workspace.snipplets.java9;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamAdditions {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(x -> x < 6)
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeWhile(x -> x < 6)
                .forEach(System.out::println);

        Stream.iterate(100, x -> x + 1)
                .limit(10)
                .forEach(System.out::println);

        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("ram", "raman");
        nickNames.put("dave", null);
        nickNames.put("mickel", "mic");

        nickNames.entrySet().stream()
                .map(v -> Objects.requireNonNullElse(v.getValue(), ""))
                .forEach(System.out::println);
    }
}
