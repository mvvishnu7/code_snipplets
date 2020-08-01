package mv.workspace.snipplets.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords()
                .topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();

        Arrays.stream(words)
                .forEach(word -> wordCount.put(word, wordCount.getOrDefault(word, 0) + 1));

        return wordCount.entrySet().stream()
                .sorted(this::compare)
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    private int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() > e2.getValue()) {
            return -1;
        } else if (e1.getValue() < e2.getValue()) {
            return 1;
        } else {
            return e1.getKey().compareTo(e2.getKey());
        }
    }

}

