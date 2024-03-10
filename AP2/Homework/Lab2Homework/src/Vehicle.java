import java.time.LocalTime;

/**
 * Clasa Vehicle care contine numele, depozitul in care se afla, intervalul de timp in care circula si locatia curenta a unui vehicul
 */
public abstract class Vehicle
{
    private String name;
    private Depot depot;
    private LocalTime startTime;
    private LocalTime endTime;
    private String currentLocation;

    /**
     * Constructorul pentru Vehicle care ii atribuie numele, depoul, un interval orar aleatoriu si face ca locatia curenta sa fie depoul in care se afla
     * @param name Numele vehiculului
     * @param depot Depoul in care se afla vehiculul
     */
    public Vehicle(String name, Depot depot)
    {
        this.name = name;
        this.depot = depot;
        depot.addVehicle(this);
        int startHour = (int) (Math.random() * 24);
        int startMinute = (int) (Math.random() * 60);
        int endHour = startHour + (int) (Math.random() * (24 - startHour));
        int endMinute = (int) (Math.random() * 60);
        startTime = LocalTime.of(startHour, startMinute);
        endTime = LocalTime.of(endHour, endMinute);
        currentLocation = new String(depot.getName());
    }

    /**
     * Getter-ul pentru nume
     * @return Numele vehiculului
     */
    public String getName() {
        return name;
    }

    /**
     * Setter-ul pentru nume
     * @param name Numele vehiculului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter-ul pentru depou
     * @return Depoul in care se afla vehiculul
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Setter-ul pentru depou
     * @param depot Depoul in care se va afla vehiculul
     */
    public void setDepot(Depot depot) {

        this.depot = depot;
    }

    /**
     * Metoda pentru afisarea tuturor informatiilor despre un vehicul
     * @return Tipul, numele, depoul si capacitatea sau durata maxima de zbor in functie de tip
     */
    public String toString() {
            StringBuilder res = new StringBuilder();
            if(this instanceof Truck)
                res.append("Vehicle's type: Truck").append('\n');
            else if(this instanceof Drone)
                res.append("Vehicle's type: Drone").append('\n');
            res.append("Vehicle's name: ").append(name).append('\n');
            res.append("Vehicle's depot: ").append(depot.name).append('\n');
            if(this instanceof Truck)
                res.append("Vehicle's capacity: ").append(((Truck) this).getCapacity()).append('\n');
            else if(this instanceof Drone)
                res.append("Vehicle's maximum flight duration: ").append(((Drone) this).getMaxFlightDuration()).append('\n');
            return res.toString();
    }

    /**
     * Metoda care verifica daca doua vehicule au acelasi nume
     * @param obj Un alt vehicul
     * @return True daca au acelasi nume, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }

    /**
     * Getter-ul pentru startTime
     * @return Ora cand vehiculul isi incepe activitatea
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Setter-ul pentru startTime
     * @param startTime Ora cand vehiculul isi incepe activitatea
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter-ul pentru endTime
     * @return Ora cand vehiculul isi inceteaza activitatea
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Setter-ul pentru endTime
     * @param endTime Ora cand vehiculul isi inceteaza activitatea
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter-ul pentru currentLocation
     * @return Locatia curenta a vehiculului
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Setter-ul pentru currentLocation
     * @param currentLocation Locatia curenta a vehiculului
     */
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}