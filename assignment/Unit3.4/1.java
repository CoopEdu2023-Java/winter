import java.util.Arrays;
import java.util.Random;

class SortingComparison {
    public static void main(String[] args) {
        int size = 1000000;
        int[] array = generateRandomArray(size);

        int[] bubbleArray = Arrays.copyOf(array, array.length);
        long start = System.currentTimeMillis();
        bubbleSort(bubbleArray);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时: " + (end - start) + " 毫秒");

        int[] insertionArray = Arrays.copyOf(array, array.length);
        start = System.currentTimeMillis();
        insertionSort(insertionArray);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时: " + (end - start) + " 毫秒");

        int[] quickArray = Arrays.copyOf(array, array.length);
        start = System.currentTimeMillis();
        Arrays.sort(quickArray);
        end = System.currentTimeMillis();
        System.out.println("快速排序耗时: " + (end - start) + " 毫秒");

        int[] mergeArray = Arrays.copyOf(array, array.length);
        start = System.currentTimeMillis();
        mergeSort(mergeArray);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时: " + (end - start) + " 毫秒");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];
        System.arraycopy(arr, 0, l, 0, mid);
        for (int i = mid; i < arr.length; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
    }

    public static void merge(int[] arr, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && i < r.length) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < l.length) {
            arr[k++] = l[i++];
        }
        while (j < r.length) {
            arr[k++] = r[j++];
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000000);
        }
        return array;
    }
}