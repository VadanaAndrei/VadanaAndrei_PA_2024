import java.lang.reflect.*;

public class ClassLoaderUtil {

    public static Class<?> loadClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    public static void analyzeClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.toString());
        }
    }

    public static void runTests(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                    try {
                        System.out.println("Running test: " + method.getName());
                        method.invoke(null);
                        System.out.println("Test " + method.getName() + " passed.");
                    } catch (Exception e) {
                        System.out.println("Test " + method.getName() + " failed: " + e.getCause());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ClassLoaderUtil <full-qualified-class-name>");
            return;
        }

        String className = args[0];

        try {
            Class<?> clazz = loadClass(className);
            analyzeClass(clazz);
            runTests(clazz);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
