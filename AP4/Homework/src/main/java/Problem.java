import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem
{
    private List<Destination> destinations;
    private Group group;
    private Map<Person, Destination> map;
    private Map<Passenger, Driver> assignments;

    public Problem(List<Destination> destinations, Group group)
    {
        this.destinations = destinations;
        this.group = group;
    }

    //Metoda pentru asignarea unei destinatii aleatorie fiecarei persoane
    public void assignDestinations(int numberOfPersons, int numberOfDestinations)
    {
        map = new LinkedHashMap<>();
        for(int i = 0; i < numberOfPersons; i++) {
            int randIndex = (int) (Math.random() * numberOfDestinations);
            Person person = group.getPersons().get(i);
            Destination destination = destinations.get(randIndex);
            map.put(person, destination);
            person.setDestination(destination);
        }
    }

    public void printMap()
    {
        for (Map.Entry<Person, Destination> entry : map.entrySet())
            System.out.println(entry.getKey().getName() + " wants to go to " + entry.getValue().getAddress());
        System.out.println();
    }

    //Metoda care asigneaza pasageri la soferi in functie de ordinea destinatiilor prin care vor trece soferii
    public void assignPassengerToDriver()
    {
        List<Person> drivers = new ArrayList<>(group.getDrivers());
        List<Person> passengers = new ArrayList<>(group.getPassengers());
        assignments = new LinkedHashMap<>();
        for(Person d : drivers)
            for(Person p : passengers)
                for(Destination dest : destinations)
                {
                    if (p.getDestination().equals(dest) && p.assigned == false && d.assigned == false) {
                        assignments.put((Passenger) p, (Driver) d);
                        p.assigned = true;
                        d.assigned = true;
                    }
                    if(d.getDestination().equals(dest))
                        break;
                }
    }

    public void printAssignments()
    {
        for (Map.Entry<Passenger, Driver> entry : assignments.entrySet())
            System.out.println(entry.getKey().getName() + " will go with " + entry.getValue().getName());
        System.out.println();
    }
}
