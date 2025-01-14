class LinkedStack {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack Underflow");
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is Empty");
        }
        return top.data;
    }

}
