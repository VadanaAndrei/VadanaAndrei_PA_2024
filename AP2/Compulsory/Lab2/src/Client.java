import java.time.LocalTime;

public class Client
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
