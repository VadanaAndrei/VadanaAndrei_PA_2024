/**
 * Clasa care extinde Vehicle
 */
public class Truck extends Vehicle
{
    private int capacity;

    /**
     * Constructorul pentru Truck care pe langa field-urile unui Vehicle mai are si capacitate
     * @param name Numele Truck-ului
     * @param depot Depoul in care se afla Truck-ul
     * @param capacity Capacitatea Truck-ului
     */
    public Truck(String name, Depot depot, int capacity)
    {
        super(name, depot);
        this.capacity = capacity;
    }

    /**
     * Getter-ul pentru capacity
     * @return Capacitatea Truck-ului
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter-ul pentru capacity
     * @param capacity Capacitatea Truck-ului
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
