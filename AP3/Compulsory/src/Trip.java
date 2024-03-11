import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trip
{
    private String name;
    private Pair<LocalDate, LocalDate> time;
    private List<Atraction> atractions;

    public Trip(String name, Atraction ... newAtraction)
    {
        this.name = name;
        this.time = new Pair<>(LocalDate.of(2024, 3,12), LocalDate.of(2024, 3, 19));

        atractions = new ArrayList<>();
        for(Atraction a : newAtraction)
        {
            atractions.add(a);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("The city's name is: ").append(this.getName()).append('\n');
        res.append("The period of time is: ").append(time.getFirst()).append(" - ").append(time.getSecond()).append('\n');
        res.append("The atractions that are going to be visited are: ");
        for(Atraction a : atractions)
            res.append(a.getName()).append(", ");
        res.delete(res.length() - 2, res.length());
        res.append('\n');

        return res.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
