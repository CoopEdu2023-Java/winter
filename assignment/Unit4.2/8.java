import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Meow {

    public static void writeFile(String filePath, String content) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(content.getBytes());
        bos.flush();
        System.out.println("File written successfully.");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:/users/winter/desktop/java/output.txt";
        String content = "Hello World 22";
        writeFile(filePath, content);
    }
}
