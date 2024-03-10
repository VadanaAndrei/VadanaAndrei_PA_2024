import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Lab2Homework {
    public static void main(String args[])
    {
        Problem pb = new Problem();

        Client Alin = new Client("Alin", LocalTime.of(0, 1), LocalTime.of(23, 59), ClientType.REGULAR, pb);
        System.out.println(Alin);

        Client Marcel = new Client("Marcel", LocalTime.of(0, 1), LocalTime.of(23, 59), ClientType.PREMIUM, pb);
        System.out.println(Marcel);

        Depot Depot1 = new Depot("Depot1", pb);
        Depot Depot2 = new Depot("Depot2", pb);
        Truck Volvo = new Truck("Volvo", Depot1, 12);
        Drone Samsung = new Drone("Samsung", Depot1, LocalTime.of(0,45));
        System.out.println(Volvo);
        System.out.println(Samsung);

        System.out.println(Depot1);
        Truck MAN = new Truck("MAN", Depot2, 221);
        System.out.println(Depot2);

        System.out.println(pb);

        Tour t = new Tour(pb);
        Solution s = new Solution(t);
        s.printSolution();
    }
}