import java.time.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Atraction
{
    protected String name;
    protected Duration openTime;
    protected LocalTime openingHour, closingHour;
    protected Map<LocalDate, Pair<LocalTime, LocalTime>> availability;

    public Atraction(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> availability)
    {
        this.name = name;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        if(this instanceof Statue)
            res.append("Statue's name: ").append(this.getName()).append('\n');
        else if(this instanceof Church)
            res.append("Church's name: ").append(this.getName()).append('\n');
        else if(this instanceof Concert)
            res.append("Concert's name: ").append(this.getName()).append('\n');

        res.append("The atraction is open on: ").append('\n');
        for(Map.Entry<LocalDate, Pair<LocalTime, LocalTime>> entry : availability.entrySet())
            res.append(entry.getKey()).append(" between the hours ").append(entry.getValue().getFirst()).append(" and ").append(entry.getValue().getSecond()).append('\n');

        if(this instanceof Payable)
            res.append("The ticket price is: ").append(((Payable) this).getTicketPrice()).append('\n');

        return res.toString();
    }

    public Map<LocalDate, Pair<LocalTime, LocalTime>> getAvailability() {
        return availability;
    }
}
