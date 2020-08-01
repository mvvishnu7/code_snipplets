package mv.workspace.snipplets.sorting;

import static mv.workspace.snipplets.sorting.util.SortUtil.inputArr;
import static mv.workspace.snipplets.sorting.util.SortUtil.printArray;

public class SelectionSort implements SortAlgo {

    public static void main(String[] args) {
        new SelectionSort().sort(inputArr());
    }

    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int pos = i;
            int small = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < small) {
                    pos = j;
                    small = arr[j];
                }
            }

            if(pos != i) {
                arr[pos] = arr[pos] + arr[i];
                arr[i] = arr[pos] - arr[i];
            }
        }

        printArray(arr);
    }
}
