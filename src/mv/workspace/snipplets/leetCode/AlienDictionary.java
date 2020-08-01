package mv.workspace.snipplets.leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String order1 = "worldabcefghijkmnpqstuvxyz";
        String[] words1 = new String[]{
                "word", "world", "row"
        };
        System.out.println(alienDictionary.isAlienSorted(words1, order1));


        String order2 = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words2 = new String[]{
                "hello", "leetcode"
        };
        System.out.println(alienDictionary.isAlienSorted(words2, order2));

        String order3 = "abcdefghijklmnopqrstuvwxyz";
        String[] words3 = new String[]{
                "apple", "app"
        };
        System.out.println(alienDictionary.isAlienSorted(words3, order3));


        String order4 = "abcdefghijklmnopqrstuvwxyz";
        String[] words4 = new String[]{
                "app", "apple"
        };
        System.out.println(alienDictionary.isAlienSorted(words3, order3));
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < word1.length() || j < word2.length(); j++) {
                if(word1.length() < j && word2.length() < j) {
                    if (order.indexOf(word2.charAt(j)) < order.indexOf(word1.charAt(j))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isAlienSorted1(String[] words, String order) {
        List<String> originalArr = Arrays.stream(words).collect(Collectors.toList());
        Arrays.sort(words, (String o1, String o2) -> {
            int pos1 = 0;
            int pos2 = 0;
            for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
                pos1 = order.indexOf(o1.charAt(i));
                pos2 = order.indexOf(o2.charAt(i));
            }

            if (pos1 == pos2 && o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }

            return pos1 - pos2;
        });

        for (int i = 0; i < originalArr.size(); i++) {
            if (!originalArr.get(i).equals(words[i])) return false;
        }

        return true;
    }
}
