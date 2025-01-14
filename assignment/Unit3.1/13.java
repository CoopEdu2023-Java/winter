class LinearQueue {
    private final int[] data;
    private int front;
    private int rear;

    public LinearQueue(int capacity) {
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(int value) {
        this.data[this.rear] = value;
        this.rear = (this.rear + 1) % this.data.length;
    }

    public void dequeue() {
        this.front = (this.front + 1) % this.data.length;
    }

    public int peek() {
        return this.data[this.front];
    }

}
