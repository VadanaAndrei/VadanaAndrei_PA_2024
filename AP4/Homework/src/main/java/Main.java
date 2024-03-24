import com.github.javafaker.Faker;
import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        List<Driver> drivers = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Driver())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Passenger> passengers = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Passenger())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Destination> destinations = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Destination())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Group g1 = new Group(drivers, passengers);
        //g1.printPassengers();
        //g1.printDrivers();

        System.out.println(g1);

        for(Destination d : destinations)
            System.out.print(d);
        System.out.println();

        Problem p = new Problem(destinations, g1);
        p.assignDestinations(drivers.size() + passengers.size(), destinations.size());
        p.printMap();
        p.assignPassengerToDriver();
        p.printAssignments();
    }
}


