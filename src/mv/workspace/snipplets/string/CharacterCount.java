package mv.workspace.snipplets.string;

import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class CharacterCount {

    public static void main(String[] args) {
        String str = "aaddfcd";
        char ch = 'c';
        long count = new CharacterCount().getCount(str, ch);
        System.out.println(count);
    }

    public long getCount(String str, char ch) {
        return ofNullable(str)
                .map(getCharCount(ch))
                .orElse(0L);
    }

    private Function<String, Long> getCharCount(char ch) {
        return msg -> msg.chars()
                .filter(c -> c == ch)
                .count();
    }
}
