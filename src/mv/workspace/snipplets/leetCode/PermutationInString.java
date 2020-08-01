package mv.workspace.snipplets.leetCode;


/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean isAvailable = new PermutationInString().checkInclusion(s1, s2);
        System.out.println(isAvailable);
    }
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if(s2.length() == 0 || s2Len < s1Len) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0; i < s1Len; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < (s2Len - s1Len); i++) {
            if(isPermutation(s1Arr, s2Arr)) return true;

            s2Arr[s2.charAt(i) - 'a']--;
            s2Arr[s2.charAt(i + s1Len) - 'a']++;
        }

        return isPermutation(s1Arr, s2Arr);
    }

    private boolean isPermutation(int[] s1Arr, int[] s2Arr) {
        for(int i = 0; i < 26; i++) {
            if(s1Arr[i] != s2Arr[i]) return false;
        }

        return true;
    }
}
