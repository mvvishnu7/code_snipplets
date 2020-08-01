package mv.workspace.snipplets.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution3 {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        if (expenditure.length > d) {
            int count = 0;
            for (int i = d; i < expenditure.length; i++) {
                double median = getMedian(getSubArray(expenditure, i - d, i));
                if (2 * median <= expenditure[i]) {
                    count++;
                }
            }
            return count;
        } else {
            return 0;
        }
    }

    private static int[] getSubArray(int[] src, int startInclusive, int endExclusive) {
        return Arrays.stream(src, startInclusive, endExclusive)
                .toArray();
    }

    private static double getMedian(int[] numArray) {
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0) {
            median = ((double) numArray[numArray.length / 2]
                    + (double) numArray[numArray.length / 2 - 1]) / 2;
        } else {
            median = (double) numArray[numArray.length / 2];
        }
        return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
