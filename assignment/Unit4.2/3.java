import java.io.File;
import java.io.FileFilter;

class FileDemo {
    public static void main(String[] args) {
        File dir = new File("./");
        if (dir.isDirectory()) {
            listJavaFiles(dir);
        }
    }

    private static void listJavaFiles(File dir) {
        FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".java");
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listJavaFiles(file);
                } else if (filter.accept(file)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
