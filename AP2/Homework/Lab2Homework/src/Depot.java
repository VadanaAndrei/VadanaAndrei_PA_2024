import java.util.Objects;

/**
 * Clasa Depot care contine numele unui depou si un numar variabil de obiecte de tip Vehicle
 */
public class Depot {
    public String name;
    private Vehicle[] vehicles;

    /**
     * Constructorul pentru Depot care ii atribuie numele si problema din care va face parte
     * @param name Numele depoului
     * @param pb Problema din care va face parte depoul
     */
    public Depot(String name, Problem pb)
    {
        this.name = name;
        pb.addDepot(this);
    }

    /**
     * Getter-ul pentru name
     * @return Numele depoului
     */
    public String getName() {
        return name;
    }

    /**
     * Setter-ul pentru name
     * @param name Numele depoului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda care asigneaza un numar variabil de vehicule unui depou
     * @param vehicles Un numar variabil de obiecte de tip Vehicle
     */
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    /**
     * Metoda care returneaza vehiculele din acest depou
     * @return Vehiculele din acest depou
     */
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * Metoda pentru afisarea tuturor informatiilor despre un depou
     * @return Numele si vehiculele depoului respectiv
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Depot's name: ").append(name).append('\n');
        res.append("Vehicles in this depot: ");

        if (vehicles != null) {
            for (Vehicle v : vehicles) {
                res.append(v.getName()).append(' ');
            }
            res.append('\n');
        } else {
            res.append("No vehicles");
            res.append('\n');
        }
        return res.toString();
    }

    /**
     * Metoda care verifica daca doua depouri au acelasi nume
     * @param obj Un alt depou
     * @return True daca au acelasi nume, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obj;
        return name.equals(other.name);
    }

    /**
     * Metoda pentru adaugarea unui vehicul intr-un depou
     * @param newVehicle Vehiculul care urmeaza sa fie adaugat
     */
    public void addVehicle(Vehicle newVehicle)
    {
        if (vehicles == null)
            vehicles = new Vehicle[]{newVehicle};
        else
        {
            boolean verifyVehicle = true;
            for(Vehicle v : vehicles)
                if(newVehicle.getName().equals(v.getName())){
                    verifyVehicle = false;
                    break;
                }
            if(verifyVehicle)
            {
                Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
                System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
                newVehicles[vehicles.length] = newVehicle;
                vehicles = newVehicles;
            }
        }
        newVehicle.setDepot(this);
    }

    /**
     * Metoda care afiseaza toate vehiculele dintr-un depou
     */
    public void printVehicles()
    {
        if(vehicles == null);
        else
            for(Vehicle v : vehicles)
        {
            System.out.print(v.getName());
            System.out.print(' ');
        }
        System.out.println();
    }
}
