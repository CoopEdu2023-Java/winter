import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MultiThreading {

    private static final int DATA = 10000000;
    private static final int MAX_THREADS = 500;

    public static void main(String[] args) throws InterruptedException, IOException {

        Random random = new Random();
        List<String> data = new ArrayList<>(DATA);
        for (int i = 0; i < DATA; i++) {
            data.add(String.valueOf(random.nextInt(DATA))); // 随机数
        }

        try (BufferedWriter resultWriter = new BufferedWriter(new FileWriter("result.txt"))) {

            for (int threadCount = 1; threadCount <= MAX_THREADS; threadCount++) {

                long start = System.currentTimeMillis();
                writeDataToFile(data, threadCount); // 写入
                long end = System.currentTimeMillis();
                long time = end - start;

                resultWriter.write(threadCount + ", " + time + " ms");
                resultWriter.newLine();
                System.out.println(threadCount + ", " + time + " ms");
            }
        }
    }

    private static void writeDataToFile(List<String> data, int threadCount) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        int chunkSize = data.size() / threadCount;
        AtomicInteger fileIndex = new AtomicInteger(0);

        for (int i = 0; i < threadCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadCount - 1) ? data.size() : (i + 1) * chunkSize;
            List<String> chunk = data.subList(start, end);

            executor.submit(() -> {
                try (BufferedWriter writer = new BufferedWriter(
                        new FileWriter("output_" + fileIndex.getAndIncrement() + ".txt"))) {
                    for (String line : chunk) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
