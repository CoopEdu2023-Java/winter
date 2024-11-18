import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Cracker {

    public static void main(String[] args) throws Exception {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> mainClass = systemClassLoader.loadClass("GuessingGame");
        Object instance = mainClass.getDeclaredConstructor().newInstance();
        Method mainMethod = mainClass.getDeclaredMethod("main", String[].class);

        new Thread(() -> {
            try {
                mainMethod.invoke(instance, (Object) new String[] {});
            } catch (Exception e) {
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            try {
                Field field = mainClass.getDeclaredField("secretNumber");
                field.setAccessible(true);
                Object value = field.get(instance);
                System.out.println("value: " + value);
            } catch (Exception e) {
            }
        }).start();

    }
}