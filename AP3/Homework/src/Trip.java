import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Trip
{
    private String city;
    private Pair<LocalDate, LocalDate> time;
    private List<Atraction> atractions;

    public Trip(String city,Pair<LocalDate, LocalDate> time, Atraction ... newAtraction)
    {
        this.city = city;
        this.time = time;

        atractions = new ArrayList<>();
        for(Atraction a : newAtraction)
            atractions.add(a);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("The city's name is: ").append(this.getCity()).append('\n');
        res.append("The period of time is: ").append(time.getFirst()).append(" - ").append(time.getSecond()).append('\n');
        res.append("The atractions that are going to be visited are: ");
        for(Atraction a : atractions)
            res.append(a.getName()).append(", ");
        res.delete(res.length() - 2, res.length());
        res.append('\n');

        return res.toString();
    }

    public String getCity() {
        return city;
    }

    public void setName(String city) {
        this.city = city;
    }

    public List<Atraction> getAtractions() {
        return atractions;
    }

    public void setAtractions(List<Atraction> atractions) {
        this.atractions = atractions;
    }

    public Pair<LocalDate, LocalDate> getTime() {
        return time;
    }

    public void setTime(Pair<LocalDate, LocalDate> time) {
        this.time = time;
    }

    //Afiseaza atractiile care sunt Visitable, dar nu si Payable, sortate dupa ora de deschidere
    public void printVisitableNotPayable()
    {
        System.out.print("These atractions are Visitable and not Payable: ");
        StringBuilder res = new StringBuilder();
        for(Atraction a : atractions)
            if(a instanceof Visitable && !(a instanceof Payable))
            {
                res.append(a.getName()).append(", ");
            }
        res.delete(res.length() - 2, res.length());
        System.out.println(res);
        System.out.println();

        for(Atraction a : atractions)
            if(a instanceof Visitable && !(a instanceof Payable))
            {
                System.out.println(a.getName() + " is available on: ");
                List<Map.Entry<LocalDate, Pair<LocalTime, LocalTime>>> entryList = new ArrayList<>(a.availability.entrySet());
                entryList.sort(Map.Entry.comparingByValue(Comparator.comparing(Pair :: getFirst)));

                for(Map.Entry<LocalDate, Pair<LocalTime, LocalTime>> entry : entryList)
                    System.out.println(entry.getKey() + " between " + entry.getValue().getFirst() + " and " + entry.getValue().getSecond());
                System.out.println();
            }
    }
}

