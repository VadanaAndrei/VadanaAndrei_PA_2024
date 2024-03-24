import com.github.javafaker.Faker;

import java.util.Objects;

public class Destination
{
    private String address;

    public Destination()
    {
        this.address = new Faker().address().cityName();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Destination: " + getAddress() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(address, that.address);
    }

}
