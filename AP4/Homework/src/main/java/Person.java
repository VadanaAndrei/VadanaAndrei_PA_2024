import com.github.javafaker.Faker;

public abstract class Person
{
    private String name;
    private int age;
    private Destination destination;
    public boolean assigned = false;

    public Person()
    {
        this.name = new Faker().name().fullName();
        this.age = (int) (Math.random() * 82) + 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
