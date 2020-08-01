package mv.workspace.snipplets.sorting.util;

import java.util.Arrays;

public class SortUtil {

    public static int[] inputArr() {
        return new int[]{12, 11, 0, -1, 0, -2, 1231243214, 13, 5, 6};
    }

    public static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
