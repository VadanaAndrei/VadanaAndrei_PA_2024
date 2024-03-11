import java.time.*;

public interface Visitable
{
   String getName();
   void setName(String name);
   LocalTime getOpeningHour();
   void setOpeningHour(LocalTime openingHour);
   LocalTime getClosingHour();
   void setClosingHour(LocalTime closingHour);
}
