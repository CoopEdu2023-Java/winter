/*
 * @Author: winter
 * @Date: 2024-10-21 13:29:14
 * @Description: 
 * (^•ᴥ•^)/
 */
class MaxHeap<T> {
    private T[] data;
    private int size;

    public MaxHeap(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.data[0] = null;
        this.size = 0;
    }

    public void push(int x) {
        int i = ++this.size;
        for (; i > 0 && this.data[i / 2] < x; i /= 2) {
            this.data[i] = this.data[i / 2];
        }
        this.data[i] = x;
    }

    public T pop() {
        T max = this.data[1];
        T tmp = this.data[this.size--];
        int parent;
        int child;
        for (parent = 1; parent * 2 <= this.size; parent = child) {
            child = parent * 2;
            if (child != this.size && this.data[child] < this.data[child + 1]) {
                child++;
            }
            if (tmp >= this.data[child]) {
                break;
            } else {
                this.data[parent] = this.data[child];
            }
        }
        this.data[parent] = tmp;
        return max;
    }
}