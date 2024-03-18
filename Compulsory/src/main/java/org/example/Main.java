package org.example;

public class Main
{
    public static void main( String[] args )
    {
        Person p1 = new Driver("Alexandra", 67);
        Person p2 = new Passenger("Andreea", 19);
        Person p3 = new Driver("Gica", 20);
        Person p4 = new Passenger("Mircea", 32);
        Person p5 = new Passenger("Andrei", 48);

        Group g1 = new Group(p1,p2,p3,p4,p5);

        g1.printDrivers();
        g1.printPassengers();
    }
}

