class ArrayList {
    private int[] arr;
    private int size;

    public ArrayList(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = this.size; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[index] = value;
        this.size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int deletedValue = this.arr[index];
        for (int i = index; i < this.size - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.size--;
        return deletedValue;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.arr[index] = value;
    }

}
