import java.io.FileInputStream;
import java.io.IOException;

class Meow {

    public static void readFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        StringBuilder lineBuffer = new StringBuilder();
        int character;

        while ((character = fis.read()) != -1) {
            if (character == '\n') {
                System.out.println(lineBuffer.toString());
                lineBuffer.setLength(0);
            } else if (character != '\r') {
                lineBuffer.append((char) character);
            }
        }
        if (lineBuffer.length() > 0) {
            System.out.println(lineBuffer.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:/users/winter/desktop/java/output.txt";
        readFile(filePath);
    }
}
