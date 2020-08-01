package mv.workspace.snipplets.sorting;

import static mv.workspace.snipplets.sorting.util.SortUtil.inputArr;
import static mv.workspace.snipplets.sorting.util.SortUtil.printArray;

public class MergeSort implements SortAlgo {

    public static void main(String[] args) {
        int[] arr = inputArr();
        new MergeSort().sort(arr);
        printArray(arr);
    }

    @Override
    public void sort(int[] arr) {

        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        sort(left);
        sort(right);

        merge(arr, left, right);

    }

    private void merge(int[] arr, int[] left, int[] right) {
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
            }
        }

        while (l < left.length) {
            arr[i++] = left[l++];
        }

        while (r < right.length) {
            arr[i++] = right[r++];
        }
    }
}

