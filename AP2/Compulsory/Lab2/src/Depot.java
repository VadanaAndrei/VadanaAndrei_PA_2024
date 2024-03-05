public class Depot
{
    public String name;
    private Vehicle[] vehicles;

    public Depot(){};

    public Depot(String name)
    {
        this.name = name;
    }

    public Depot(String name, Vehicle... vehicles)
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

    public void setVehicles(Vehicle... vehicles)
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
