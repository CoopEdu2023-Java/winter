class LinearStack {
    private final int[] stack;
    private int top;
    private final int capacity;

    public LinearStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack is Empty");
        }
        return stack[top];
    }
}
