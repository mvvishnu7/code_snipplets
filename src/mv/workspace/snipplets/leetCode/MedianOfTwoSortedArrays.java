package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length;
        int totalLength = nums1.length + nums2.length;
        boolean mergedArrayLengthEven = isMergedArrayLengthEven(nums1, nums2);
        if (mergedArrayLengthEven) {
            length = totalLength / 2 + 1;
        } else {
            length = ((Double) Math.ceil((double) (nums1.length + nums2.length) / 2)).intValue();
        }

        int i = 0, j = 0, k = 0;
        Integer lastNo = null;
        Integer secondLastNo = null;
        while (k < length) {
            secondLastNo = lastNo;
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] > nums2[j]) {
                    lastNo = nums2[j];
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    lastNo = nums1[i];
                    i++;
                } else {
                    k++;
                    if (k == length) {
                        lastNo = nums1[i];
                    } else {
                        lastNo = secondLastNo = nums1[i];
                        i++;
                        j++;
                    }
                }
            } else if (i < nums1.length) {
                lastNo = nums1[i];
                i++;
            } else if (j < nums2.length) {
                lastNo = nums2[j];
                j++;
            }
            k++;
        }

        if (mergedArrayLengthEven) {
            return ((double) (getAnInt(lastNo) + (getAnInt(secondLastNo)))) / 2;
        } else {
            return getAnInt(lastNo);
        }
    }

    private boolean isMergedArrayLengthEven(int[] nums1, int[] nums2) {
        return (nums1.length + nums2.length) % 2 == 0;
    }

    private int getAnInt(Integer lastNo) {
        return Objects.isNull(lastNo) ? 0 : lastNo;
    }
}
