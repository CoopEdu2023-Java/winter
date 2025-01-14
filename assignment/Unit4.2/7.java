import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Meow {

    public static void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("D:/users/winter/desktop/java/meow.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}