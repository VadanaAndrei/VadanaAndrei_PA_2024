public class Vehicle
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
