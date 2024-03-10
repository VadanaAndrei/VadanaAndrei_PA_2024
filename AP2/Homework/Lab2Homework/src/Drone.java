import java.time.LocalTime;

/**
 * Clasa care extinde Vehicle
 */
public class Drone extends Vehicle
{
    private LocalTime maxFlightDuration;

    /**
     * Constructorul pentru Drone care pe langa field-urile unui Vehicle mai are si durata maxima de zbor
     * @param name Numele dronei
     * @param depot Depoul in care se afla drona
     * @param maxFlightDuration Capacitatea maxima de zbor a dronei
     */
    public Drone(String name, Depot depot, LocalTime maxFlightDuration)
    {
        super(name, depot);
        this.maxFlightDuration = maxFlightDuration;
    }

    /**
     * Getter-ul pentru maxFlightDuration
     * @return Capacitatea maxima de zbor a dronei
     */
    public LocalTime getMaxFlightDuration() {
        return maxFlightDuration;
    }

    /**
     * Setter-ul pentru maxFlightDuration
     * @param maxFlightDuration Capacitatea maxima de zbor a dronei
     */
    public void setMaxFlightDuration(LocalTime maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }
}
