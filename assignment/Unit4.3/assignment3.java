import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignment3 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, 2, 4, 3));
        arr = sleepSort(arr);
        System.out.println(arr);
    }

    public static List<Integer> sleepSort(List<Integer> arr) throws InterruptedException {
        List<Integer> sortedNumbers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int num : arr) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sortedNumbers.add(num); // 添加到对应的 ArrayList
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        return sortedNumbers;
    }
}