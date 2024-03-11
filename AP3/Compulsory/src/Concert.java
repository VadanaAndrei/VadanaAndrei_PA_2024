import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.Map;

public class Concert extends Atraction implements Visitable, Payable
{
    private double ticketPrice;

    public Concert(String name, double ticketPrice)
    {
        super(name);
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
