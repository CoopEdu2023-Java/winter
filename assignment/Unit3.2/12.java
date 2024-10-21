class MinHeap<T extends Comparable<T>> {
    private T[] data;
    private int size;

    public MinHeap(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    public void push(T x) {
        int i = ++this.size;
        for (; i > 1 && this.data[i / 2].compareTo(x) > 0; i /= 2) {
            this.data[i] = this.data[i / 2];
        }
        this.data[i] = x;
    }

    public T pop() {
        if (size == 0)
            return null;
        T min = this.data[1];
        T tmp = this.data[this.size--];
        int parent, child;
        for (parent = 1; parent * 2 <= this.size; parent = child) {
            child = parent * 2;
            if (child < this.size && this.data[child].compareTo(this.data[child + 1]) > 0) {
                child++;
            }
            if (tmp.compareTo(this.data[child]) <= 0) {
                break;
            } else {
                this.data[parent] = this.data[child];
            }
        }
        this.data[parent] = tmp;
        return min;
    }
}
