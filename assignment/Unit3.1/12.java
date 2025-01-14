import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(') || (c == '{') || (c == '[')) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char p = stack.peek();
                    if ((p == '(') && (c == ')')) {
                        stack.pop();
                    } else if ((p == '[') && (c == ']')) {
                        stack.pop();
                    } else if ((p == '{') && (c == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}