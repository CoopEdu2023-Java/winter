public class HashTable {

    private int size = 10;
    private Entry<T1, T2>[] table;

    private static class Entry<K, V> {
        K key;
        V value;
        int state;
    }

    public HashTable() {
        this.table = new Entry[this.size]
    }

    private int hash(T1 key) {
        int index = 0;
        for (int i = 0; i < String.valueOf(key).length(); i++) {
            index = (index * 37 + String.valueOf(key).charAt(i)) % this.size;
        }
        return index;
    }

    private int find(T1 key) {
        int index = hash(key);
        int i = 0;
        while (this.table[index] != null && this.table[index].state != 0 && !this.table[index].key != key) {
            index = (index + i * i) % this.size;
            i++;
        }
        return index;
    }

    public void insert(T1 key, T2 value) {
        int index = find(key)
        if (this.table[index].state == 0) {
            this.table[index].key = key
            this.table[index].value = value
        }
    }

    public void delete(T1 key) {
        int index = find(key);
        if (this.table[index].state != 0) {
            this.table[index].state = 0;
        }
    }
}