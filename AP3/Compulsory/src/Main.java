import java.time.*;
import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Church church1 = new Church("Trinity Church");
        Concert concert1 = new Concert("Yeat", 500);
        Statue statue1 = new Statue("Statue of Liberty");

        //System.out.println(concert1);
        //System.out.println(church1);
        Trip t1 = new Trip("New York", church1, concert1, statue1);
        System.out.println(t1);
    }
}

