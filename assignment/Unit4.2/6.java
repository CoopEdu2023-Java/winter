import java.io.FileOutputStream;
import java.io.IOException;

class Meow {

    public static void writeFile(String filePath, String content) throws IOException {
        new FileOutputStream(filePath).write(content.getBytes());
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:/users/winter/desktop/java/output.txt";
        String content = "Hello World";
        writeFile(filePath, content);
    }
}
