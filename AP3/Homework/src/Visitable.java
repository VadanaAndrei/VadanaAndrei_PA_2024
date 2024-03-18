import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Visitable
{
    String getName();
    void setName(String name);
    LocalTime getOpeningHour();
    void setOpeningHour(LocalTime openingHour);
    LocalTime getClosingHour();
    void setClosingHour(LocalTime closingHour);

    //Returneaza ora de deschidere a unei atractii in functie de o data si un orar date ca parametrii
    default LocalTime getOpeningHour(LocalDate date, Map<LocalDate, Pair<LocalTime, LocalTime>> map)
    {
        List<Map.Entry<LocalDate, Pair<LocalTime, LocalTime>>> entryList = new ArrayList<>(map.entrySet());
        for(Map.Entry<LocalDate, Pair<LocalTime, LocalTime>> entry : entryList)
        {
            if(entry.getKey().compareTo(date) == 0)
                return entry.getValue().getFirst();
        }

        return LocalTime.now();
    }
}

