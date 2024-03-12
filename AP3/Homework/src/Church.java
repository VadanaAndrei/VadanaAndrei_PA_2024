import java.time.*;
import java.util.Map;

public class Church extends Atraction implements Visitable
{
    public Church(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> availability)
    {
        super(name,availability);
    }
}