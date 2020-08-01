package mv.workspace.snipplets.hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }


    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        HashMap<String, Integer> map = new HashMap<>();

        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSortedSubString = Stream.of(s.substring(i, j).split(""))
                        .sorted()
                        .collect(Collectors.joining());

                if (map.containsKey(currentSortedSubString)) {
                    int value = map.get(currentSortedSubString);
                    totalCount = totalCount + value;

                    map.put(currentSortedSubString, value + 1);
                } else {
                    // Never seen it before = insert and set to 1 to indiciate we've now seen it
                    map.put(currentSortedSubString, 1);
                }
            }
        }
        return totalCount;

//        Map<String, Integer> subStrCountMap = new HashMap();
//        // abba
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                for (int k = j + 1; k < s.length() + 1; k++) {
//                    String currentSubStr = Stream.of(s.substring(j, k).split(""))
//                            .sorted()
//                            .collect(Collectors.joining());
//                    System.out.println("i: " + i + " | j: " + j + " | k: " + k);
//                    int currentSubStrCount = 1;
//                    if (subStrCountMap.containsKey(currentSubStr)) {
//                        currentSubStrCount = subStrCountMap.get(currentSubStr) + 1;
//                    }
//                    subStrCountMap.put(currentSubStr, currentSubStrCount);
//                }
//            }
//        }
//
//        int sum = subStrCountMap
//                .values()
//                .stream()
//                .filter(e -> e > 1)
//                .mapToInt(Integer::intValue)
//                .sum();
//        return sum > 0 ? sum / 2 : sum;
    }
}
