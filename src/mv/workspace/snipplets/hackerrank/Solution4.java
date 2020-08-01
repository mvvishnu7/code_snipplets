package mv.workspace.snipplets.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution4 {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int palindromeCount = 0;
        StringBuilder expected = new StringBuilder();
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < n; i++) {
            actual.append(s.charAt(i));
            if(actual.toString().equals(expected.toString())) {
                palindromeCount++;
            }
        }
        return palindromeCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

