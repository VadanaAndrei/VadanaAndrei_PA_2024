import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;


public class Lab2 {
    public static void main(String args[])
    {
        Client Alin = new Client("Alin");
        System.out.println(Alin);
        Alin.setType(ClientType.PREMIUM);
        Alin.setMinTime(LocalTime.of(12,0));
        Alin.setMaxTime(LocalTime.of(12, 30));
        System.out.println(Alin);

        Client Marcel = new Client("Marcel", LocalTime.of(8,0), LocalTime.of(10, 0), ClientType.PREMIUM);
        System.out.println(Marcel);

        Vehicle Skoda = new Vehicle("Skoda");
        System.out.println(Skoda);
        Vehicle Opel = new Vehicle("Opel");
        Vehicle Fiat = new Vehicle("Fiat");

        Depot Depot1 = new Depot("Depot1");

        Vehicle Dacia = new Vehicle("Dacia");
        Dacia.setDepot(Depot1);
        System.out.println(Dacia);

        Depot Depot2 = new Depot("Depot2", Opel, Fiat);
        System.out.println(Depot2);
    }
}