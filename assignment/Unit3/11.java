import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> Stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals('+')) {
                Stack.push(Stack.pop() + Stack.pop());
            } else if (c.equals('-')) {
                Stack.push(-Stack.pop() + Stack.pop());
            } else if (c.equals('*')) {
                Stack.push(Stack.pop() * Stack.pop());
            } else if (c.equals('/')) {
                int b = Stack.pop();
                int a = Stack.pop();
                if (b == 0) {
                    throw new IllegalArgumentException("division by zero");
                }
                Stack.push(a / b);
            } else {
                Stack.push(Integer.parseInt(c));
            }
        }
        return Stack.pop();
    }
}