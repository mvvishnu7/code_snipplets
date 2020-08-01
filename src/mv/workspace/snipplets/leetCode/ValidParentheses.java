package mv.workspace.snipplets.leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid(""));
    }

    public boolean isValid(String s) {
        String closedParentheses = "}])";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (closedParentheses.indexOf(currentChar) > -1) {
                if(stack.size() < 1) {
                    return  false;
                }
                char openChar = stack.pop();
                switch (currentChar) {
                    case '}':
                        if (openChar != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (openChar != '[') {
                            return false;
                        }
                        break;
                    case ')':
                        if (openChar != '(') {
                            return false;
                        }
                        break;

                }
            } else {
                stack.push(currentChar);
            }
        }

        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
