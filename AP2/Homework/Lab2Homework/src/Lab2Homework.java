import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

enum ClientType
{
    REGULAR, PREMIUM;
}

class Client
{
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;

    public Client() {}
    public Client(String name)
    {
        this(name, null, null, ClientType.REGULAR);
    }
    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type)
    {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String toString()
    {
        return "Client's name: " + name + '\n' + "Client's type: " + type + '\n' + "Client's minTime: " + minTime + '\n' +
                "Client's maxTime: " + maxTime + '\n';
    }
}

class Vehicle
{
    private String name;
    private Depot depot;

    public Vehicle(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {

        this.depot = depot;
    }

    public String toString() {
        if(depot == null)
            return "Vehicle's name: " + name + '\n' + "Vehicle's depot: No Depot" + '\n';
        else
            return "Vehicle's name: " + name + '\n' + "Vehicle's depot: " + depot.getName() + '\n';
    }

}

class Depot
{
    public String name;
    private Vehicle[] vehicles;

    public Depot(){};

    public Depot(String name)
    {
        this.name = name;
    }

    public Depot(String name, Vehicle ... vehicles)
    {
        this.name = name;
        this.vehicles = vehicles;
        for(Vehicle v : vehicles)
            v.setDepot(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(Vehicle ... vehicles)
    {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Depot's name: ").append(name).append('\n');
        res.append("Vehicles in this depot: ");

        if(vehicles != null) {
            for (Vehicle v : vehicles) {
                res.append(v.getName()).append(' ');
            }
            res.append('\n');
        }
        else
        {
            res.append("No vehicles");
            res.append('\n');
        }
        return res.toString();
    }

}


public class Lab2Homework {
    public static void main(String args[])
    {
        Client Alin = new Client("Alin");
        System.out.println(Alin);
        Alin.setType(ClientType.PREMIUM);
        Alin.setMinTime(LocalTime.of(12,0));
        Alin.setMaxTime(LocalTime.of(12, 30));
        System.out.println(Alin);

        Client Marcel = new Client("Marcel", LocalTime.of(8,0), LocalTime.of(10, 0), ClientType.PREMIUM);
        System.out.println(Marcel);

        Vehicle Skoda = new Vehicle("Skoda");
        System.out.println(Skoda);
        Vehicle Opel = new Vehicle("Opel");
        Vehicle Fiat = new Vehicle("Fiat");

        Depot Depot1 = new Depot("Depot1");

        Vehicle Dacia = new Vehicle("Dacia");
        Dacia.setDepot(Depot1);
        System.out.println(Dacia);

        Depot Depot2 = new Depot("Depot2", Opel, Fiat);
        System.out.println(Depot2);
    }
}