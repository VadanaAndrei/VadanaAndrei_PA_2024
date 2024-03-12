import java.time.*;
import java.util.Map;

public class Concert extends Atraction implements Visitable, Payable
{
    private double ticketPrice;

    public Concert(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> availability, double ticketPrice)
    {
        super(name,availability);
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

