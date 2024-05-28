public class MyClass {

    @Test
    public static void myTest1() {
        System.out.println("myTest1 is running");
    }

    @Test
    public static void myTest2() {
        System.out.println("myTest2 is running");
    }

    public static void notATest() {
        System.out.println("This should not run");
    }
}
