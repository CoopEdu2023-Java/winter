import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MyClass.class.getName());
        logger.setLevel(Level.CONFIG);
        try {
            FileHandler fileHandler = new FileHandler("d:/Users/winter/Desktop/java/winter/assignment/Unit4.1/demo.log",
                    true);
            logger.addHandler(fileHandler);
            logger.info("Hello World");
        } catch (java.io.IOException e) {
            logger.log(Level.WARNING, "Error while creating file handler", e);
        }
    }
}
