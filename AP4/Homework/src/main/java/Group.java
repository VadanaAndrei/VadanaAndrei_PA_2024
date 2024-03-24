import java.util.*;
import java.util.stream.Collectors;

public class Group
{
    private List<Person> persons;

    public Group(List<Driver> drivers, List<Passenger> passengers)
    {
        persons = new ArrayList<>();
        persons.addAll(drivers);
        persons.addAll(passengers);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    //Returneaza obiectele de tip Person din persons care sunt soferi
    public List<Person> getDrivers()
    {
        return persons.stream()
                .filter(Person -> Person instanceof Driver)
                .collect(Collectors.toList());
    }

    ////Returneaza obiectele de tip Person din persons care sunt pasageri
    public List<Person> getPassengers()
    {
        return persons.stream()
                .filter(Person -> Person instanceof Passenger)
                .collect(Collectors.toList());
    }

    //Metoda care afiseaza soferii sortati crescator in functie de varsta
    public void printDrivers()
    {
        List<Person> sortedDrivers = new LinkedList<>(getDrivers());
        sortedDrivers = sortedDrivers.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());

        for(Person p : sortedDrivers)
            System.out.println(p.getName() + " is " + p.getAge() + " years old and is a driver");
        System.out.println();
    }

    //Metoda care afiseaza pasagerii sortati alfabetic in functie de nume
    public void printPassengers()
    {
        TreeSet<Person> sortedPassengers = new TreeSet<>(Comparator.comparing(Person::getName));
        sortedPassengers.addAll(getPassengers());

        for(Person p : sortedPassengers)
            System.out.println(p.getName() + " is " + p.getAge() + " years old and is a passenger");
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Person p : persons) {
            res.append(p.getName());
            if (p instanceof Driver)
                res.append(" is a driver ");
            else if(p instanceof Passenger)
                res.append(" is a passenger ");
            res.append('\n');
        }
        return res.toString();
    }
}