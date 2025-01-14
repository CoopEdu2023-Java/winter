import java.nio.file.Files;
import java.nio.file.Paths;

class Meow {

    public static void main(String[] args) {
        String path = "D:/users/winter/Desktop/javaa";

        if (Files.exists(Paths.get(path))) {
            System.out.println("File/directory exists");
        } else {
            System.out.println("Does not exist");
        }
    }
}
