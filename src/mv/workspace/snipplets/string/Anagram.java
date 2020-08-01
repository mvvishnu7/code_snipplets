package mv.workspace.snipplets.string;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        // TODO handle null
        System.out.println("M1: " + new Anagram().isAnagramM1("ar my", "mary"));
        System.out.println("M2: " + new Anagram().isAnagramM1("ar my", "mary"));
    }

    private boolean isAnagramM1(String s1, String s2) {
        char[] s1CharArr = s1.replaceAll("\\s+", "").toCharArray();
        char[] s2CharArr = s2.replaceAll("\\s+", "").toCharArray();

        if (s1CharArr.length != s2CharArr.length) {
            return false;
        }

        Arrays.sort(s1CharArr);
        Arrays.sort(s2CharArr);

        return Arrays.equals(s1CharArr, s2CharArr);
    }

    private boolean isAnagramM2(String s1, String s2) {
        char[] s1CharArr = s1.replaceAll("\\s+", "").toCharArray();
        s2 = s2.replaceAll("\\s+", "");

        if (s1CharArr.length != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1CharArr.length; i++) {
            int pos = s2.indexOf(s1CharArr[i]);
            if (pos < 0) {
                return false;
            }
        }

        return true;
    }
}
