import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Meow {
    public static void listDirectoryContents(String dirPath) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dirPath))) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        listDirectoryContents("D:/users/winter/Desktop/java");
    }
}
