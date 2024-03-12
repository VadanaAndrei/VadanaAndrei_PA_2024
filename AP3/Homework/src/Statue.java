import java.time.*;
import java.util.Map;

public class Statue extends Atraction implements Visitable
{
    public Statue(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> availability)
    {
        super(name,availability);
    }
}