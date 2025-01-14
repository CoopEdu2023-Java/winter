import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Meow {

    public static void testBufferSize(String filePath, int bufferSize) {

        long start = System.currentTimeMillis();
        int bytesRead;
        long totalBytesRead = 0;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath), bufferSize)) {
            byte[] buffer = new byte[bufferSize];
            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.print(totalBytesRead);
        System.err.println(" bytes");
        System.out.println("Buffer Size: " + bufferSize + " bytes, Time Taken: " + (end - start) + " ms");
    }

    public static void main(String[] args) {
        String filePath = "D:/users/winter/desktop/exams/large_file.txt"; // Replace with a valid file path over 500 MB

        testBufferSize(filePath, 8 * 1024);
        testBufferSize(filePath, 16 * 1024);
        testBufferSize(filePath, 8 * 1024 * 1024);
    }
}
