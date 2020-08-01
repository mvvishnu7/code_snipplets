package mv.workspace.snipplets.hackerrank;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.max;

public class Solution5 {

    private static Integer[][] lookUp;
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        lookUp = new Integer[s1.length()+1][s2.length()+1];
        return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int n , int m) {
        if(n == 0 || m == 0) {
            return 0;
        } else if(lookUp[n][m] != null) {
            return lookUp[n][m];
        } else if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + lcs(s1, s2, n-1, m-1);
        } else {
            int lcs1 = lcs(s1, s2, n-1, m);
            int lcs2 = lcs(s1, s2, n, m-1);
            int lcs = max(lcs1, lcs2);
            lookUp[n][m] = lcs;
            return lcs;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
