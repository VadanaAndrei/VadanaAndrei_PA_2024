import java.time.LocalTime;
import java.util.Objects;


/**
 * Clasa Client care contine numele, tipul, si intervalul de timp in care clientul este disponibil.
 */
public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;

    /**
     * Constructorul pentru Client care ii atribuie numele, intervalul orar, tipul si problema din care va face parte
     * @param name Numele clientului
     * @param minTime Ora cand clientul devine activ.
     * @param maxTime Ora cand clientul isi inceteaza activitatea.
     * @param type Tipul clientului.
     * @param pb Problema din care va face parte clientul.
     */
    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type, Problem pb) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
        pb.addClient(this);
    }

    /**
     * Getter-ul pentru nume.
     * @return Numele clientului.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter-ul pentru nume.
     * @param name Numele clientului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter-ul pentru minTime
     * @return Ora cand clientul devine activ
     */
    public LocalTime getMinTime() {
        return minTime;
    }

    /**
     * Setter-ul pentru minTime
     * @param minTime Ora cand clientul devine activ
     */
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    /**
     *  Getter-ul pentru maxTime
     * @return Ora cand clientul isi inceteaza activitatea
     */
    public LocalTime getMaxTime() {
        return maxTime;
    }

    /**
     * Setter-ul pentru maxTime
     * @param maxTime Ora cand clientul isi incheie activitatea
     */
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    /**
     * Getter-ul pentru type
     * @return Tipul clientului
     */
    public ClientType getType() {
        return type;
    }

    /**
     * Setter-ul pentru type
     * @param type Tipul clientului
     */
    public void setType(ClientType type) {
        this.type = type;
    }

    /**
     * Metoda pentru afisarea tuturor informatiilor despre un client
     * @return Numele, tipul si intervalul orar specific clientului
     */
    public String toString() {
        return "Client's name: " + name + '\n' + "Client's type: " + type + '\n' + "Client's minTime: " + minTime + '\n' +
                "Client's maxTime: " + maxTime + '\n';
    }

    /**
     * Metoda care verifica daca doi clienti au acelasi nume
     * @param obj Un alt client
     * @return True daca au acelasi nume, false in caz contrar
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        return name.equals(other.name);
    }
}
