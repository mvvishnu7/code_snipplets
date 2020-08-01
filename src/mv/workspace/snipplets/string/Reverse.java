package mv.workspace.snipplets.string;

// reverse String in Java using Iteration and Recursion
public class Reverse {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        String str = "coronavirus";
        reverse.reverseWithStringIteration(str);
        reverse.reverseWithStringReverse(str);
        System.out.println(reverse.reverseWithRecursion(str));
    }

    public void reverseWithStringReverse(String str) {
        System.out.println(new StringBuffer(str).reverse().toString());
    }

    public void reverseWithStringIteration(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }

        System.out.println(stringBuilder.toString());
    }

    public String reverseWithRecursion(String str) {

        if(str.length() < 2) {
            return str;
        }
        String temp = reverseWithRecursion(str.substring(1)) + str.charAt(0);
//        System.out.println(temp);
        return temp;
    }
}
