/**
 * Clasa Problem care contine datele unei probleme(depouri cu vehiculele din ele si clienti)
 */
public class Problem {
    private Depot[] depots;
    private Client[] clients;
    private int numberOfClients = 0;
    private int numberOfDepots = 0;

    /**
     * Getter-ul pentru depots
     * @return Un array cu obiecte de tip Depot
     */
    public Depot[] getDepots() {
        return depots;
    }

    /**
     * Metoda pentru returnarea tuturor vehiculelor din toate depourile
     * @return Toate vehiculele din toate depourile
     */
    public String getVehicles()
    {
        if(depots == null)
            return "There are no vehicles";
        else
        {
            StringBuilder res = new StringBuilder();
            for (Depot d : depots) {
                if (d.getVehicles() == null)
                    res.append(d.getName()).append(": No vehicles");
                else {
                    res.append(d.getName() + ": ");
                    for(Vehicle v : d.getVehicles())
                        res.append(v.getName()).append(' ');
                    res.append('\n');
                }
            }
            return res.toString();
        }
    }

    /**
     * Metoda pentru adaugarea unui nou depou in array-ul depots
     * @param newDepot Depoul care urmeaza sa fie adaugat
     */
    public void addDepot(Depot newDepot)
    {
            if (depots == null)
            {
                depots = new Depot[]{newDepot};
                numberOfDepots++;
            }
            else
            {
                boolean verifyDepot = true;
                for(Depot d : depots)
                    if(newDepot.name.equals(d.name)){
                       verifyDepot = false;
                        break;
                    }
                if(verifyDepot)
                {
                    numberOfDepots++;
                    Depot[] newDepots = new Depot[depots.length + 1];
                    System.arraycopy(depots, 0, newDepots, 0, depots.length);
                    newDepots[depots.length] = newDepot;
                    depots = newDepots;
                }
            }

    }

    /**
     * Metoda pentru adaugarea unui nou client in array-ul clients
     * @param newClient Clientul care urmeaza sa fie adaugat
     */
    public void addClient(Client newClient)
    {
        if (clients == null)
        {
            clients = new Client[]{newClient};
            numberOfClients++;
        }
        else
        {
            boolean verifyClient = true;
            for(Client c : clients)
                if(newClient.getName().equals(c.getName())){
                    verifyClient = false;
                    break;
                }
            if(verifyClient)
            {
                numberOfClients++;
                Client[] newClients = new Client[clients.length + 1];
                System.arraycopy(clients, 0, newClients, 0, clients.length);
                newClients[clients.length] = newClient;
                clients = newClients;
            }
        }
    }

    /**
     * Metoda pentru afisarea tuturor informatiilor despre o problema
     * @return Toti clientii, depourile si vehiculele din problema respectiva
     */
    public String toString()
    {
        System.out.print("Clients: ");
        for(Client c : clients)
        {
            System.out.print(c.getName());
            System.out.print(' ');
        }
        System.out.println();

        return getVehicles();
    }

    /**
     * Getter-ul pentru numberOfClients
     * @return Numarul de clienti din problema respectiva
     */
    public int getNumberOfClients() {
        return numberOfClients;
    }

    /**
     * Getter-ul pentru numberOfDepots
     * @return Numarul de depouri din problema respectiva
     */
    public int getNumberOfDepots() {
        return numberOfDepots;
    }

    /**
     * Getter-ul pentru clients
     * @return Array-ul clients
     */
    public Client[] getClients() {
        return clients;
    }
}
