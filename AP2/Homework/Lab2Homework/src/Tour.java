import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Clasa Tour care contine un vehicul, clientii la care acesta poate fi asignat si o problema
 */
public class Tour {
    private Vehicle vehicle;
    private Client[] clients;
    private Problem pb;
    private int[][] distances;

    /**
     * Constructorul pentru Tour care ii asigneaza o problema si creeaza o matrice cu elemente generate aleatoriu care reprezinta timpul in minute necesar pentru
     * un vehicul sa ajunga de la orice depou la orice client
     * @param pb Problema care ii este asignata turului
     */
    public Tour(Problem pb)
    {
        this.pb = pb;

        int numberOfLocations = pb.getNumberOfClients() + pb.getNumberOfDepots();
        distances = new int[numberOfLocations][numberOfLocations];
        for(int i = 0; i<numberOfLocations-1; i++)
            for(int j = i+1; j<numberOfLocations; j++)
            {
                distances[i][j] = (int) (Math.random() * 60);
                distances[j][i] = distances[i][j];
            }
    }

    /**
     * Metoda care aloca vehicule la clienti in functie de intervalul de timp in care circula vehiculul si timpul necesar fiecarui vehicul sa ajunga la fiecare client
     */
    public void allocateVehicles() {
        for (Depot depot : pb.getDepots())
            Arrays.sort(depot.getVehicles(), Comparator.comparing(Vehicle::getStartTime));

        for (Client client : pb.getClients()) {
            Vehicle bestVehicle = null;
            LocalTime bestTime = LocalTime.MAX;

            for (Depot depot : pb.getDepots()) {
                for (Vehicle vehicle : depot.getVehicles()) {
                    int depotIndex = getDepotIndex(depot);
                    int clientIndex = getClientIndex(client);

                    if (isValidAllocation(vehicle, depotIndex, clientIndex)) {
                        LocalTime arrivalTime = calculateArrivalTime(vehicle, depotIndex, clientIndex);
                        if (arrivalTime.isBefore(bestTime)) {
                            bestTime = arrivalTime;
                            bestVehicle = vehicle;
                        }
                    }
                }
            }

            if (bestVehicle != null) {
                bestVehicle.setStartTime(bestTime);
                bestVehicle.setEndTime(bestTime.plusMinutes(distances[getDepotIndex(bestVehicle.getDepot())][getClientIndex(client)]));
                bestVehicle.setCurrentLocation(client.getName());
                System.out.println("Vehicle " + bestVehicle.getName() + " allocated to client " + client.getName());
            }
        }
    }

    /**
     * Metoda care verifica daca un vehicul poate fi alocat unui client
     * @param vehicle Vehiculul pentru care se face verificarea
     * @param depotIndex Indexul depoului in matricea distances
     * @param clientIndex Indexul clientului in matricea distances
     * @return True daca vehiculul poate fi alocat clientului, false in caz contrar
     */
    private boolean isValidAllocation(Vehicle vehicle, int depotIndex, int clientIndex) {
        return vehicle.getStartTime().isBefore(vehicle.getEndTime()) &&
                vehicle.getStartTime().plusMinutes(distances[depotIndex][clientIndex]).isBefore(vehicle.getEndTime());
    }

    /**
     * Metoda pentru calcularea timpului in care un vehicul va ajunge la un client
     * @param vehicle Vehiculul pentru care se calculeaza
     * @param depotIndex Indexul depoului in matricea distances
     * @param clientIndex  Indexul clientului in matricea distances
     * @return Timpul in care un vehicul va ajunge la un client
     */
    private LocalTime calculateArrivalTime(Vehicle vehicle, int depotIndex, int clientIndex) {
        return vehicle.getStartTime().plusMinutes(distances[depotIndex][clientIndex]);
    }

    /**
     * Metoda care obtine indexul unui depou in matricea distances
     * @param depot Depoul pentru care se obtine indexul
     * @return Indexul depoului
     */
    private int getDepotIndex(Depot depot) {
        for (int i = 0; i < pb.getNumberOfDepots(); i++) {
            if (depot.equals(pb.getDepots()[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metoda care obtine indexul unui client in matricea distances
     * @param client Clientul pentru care se obtine indexul
     * @return Indexul clientului
     */
    private int getClientIndex(Client client) {
        for (int i = 0; i < pb.getNumberOfClients(); i++) {
            if (client.equals(pb.getClients()[i])) {
                return i + pb.getNumberOfDepots();
            }
        }
        return -1;
    }
}
