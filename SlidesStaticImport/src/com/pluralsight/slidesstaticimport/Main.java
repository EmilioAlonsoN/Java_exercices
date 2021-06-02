package com.pluralsight.slidesstaticimport;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*
        inheritance_CargoFlightReference();
        inheritance_FlightReference();
        inheritance_ArrayOfReferences();
        inheritance_FieldHiding();
        inheritance_MethodOverriding();
        inheritance_ObjectsAndArray();
        inheritance_ObjectReferences();
        inheritance_Equals();
        useEqualsWithSuper();
        inheritanceAndConstructors()
         */
        //flightWithIterator();
        //comparable();
        nestedType();
        innerClass();
    }

    private static void flightWithIterator() {
        System.out.println("***************************");
        System.out.println("For-each through Flight Passenger list with Iterable");
        System.out.println();

        Flight f175 = new Flight(175);
        f175.add1Passenger(new Passenger("Santiago"));
        f175.add1Passenger(new Passenger("Julie"));
        f175.add1Passenger(new Passenger("John"));
        f175.add1Passenger(new Passenger("Geetha"));
        for (Passenger p : f175) {
            System.out.println("Passenger name: " + p.getName());
        }

        System.out.println("***************************");
        System.out.println();
    }

    private static void nestedType() {
        System.out.println("***************************");
        System.out.println("Nested Class - Passenger.RewardProgram");
        System.out.println();

        Passenger steve = new Passenger("Steve", 3, 180);

        Passenger.RewardProgram platinum = new Passenger.RewardProgram();
        platinum.setMemberLevel(3);

        if(steve.getRewardProgram().getMemberLevel() == platinum.getMemberLevel())
            System.out.println("Steve is platinum");

        System.out.println("***************************");
        System.out.println();
    }

    private static void innerClass() {
        System.out.println("***************************");
        System.out.println("Inner Class - Flight.FlightIterable");
        System.out.println();

        Flight f175 = new Flight(175);
        f175.add1Passenger(new Passenger("Luisa", 1, 180));
        f175.add1Passenger(new Passenger("Jack", 1, 90));
        f175.add1Passenger(new Passenger("Ashanti", 3, 730));
        f175.add1Passenger(new Passenger("Harish", 2, 150));

        System.out.println(" ** Passenger order using Flight class' Iterable implementation **");
        for(Passenger p : f175)
            System.out.println(p.getName());

        System.out.println();
        System.out.println(" ** Passenger order using FlightIterable class' Iterable implementation **");
        for(Passenger p : f175.getOrderedPassengers())
            System.out.println(p.getName());

        System.out.println("***************************");
        System.out.println();
    }
/*
    private static void comparable() {
        System.out.println("***************************");
        System.out.println("Sorting Passenger array with Comparable");
        System.out.println();

        Passenger[] passengers = {
                new Passenger("Luisa", 1, 180),
                new Passenger("Jack", 1, 90),
                new Passenger("Ashanti", 3, 730),
                new Passenger("Harish", 2, 150),
        };

        Arrays.sort(passengers);

        Arrays.sort(passengers);

        System.out.println();
        System.out.println("Passengers after sort");
        for (Passenger p : passengers) {
            System.out.println("Passenger name: " + p.getName() + " level: " + p.getMemberLevel() +
                    " member days: " + p.getMemberDays());
        }

        System.out.println("***************************");
        System.out.println();
    }

 */

    private static void inheritance_CargoFlightReference() {
        System.out.println("***************************");
        System.out.println("Inheritance - CargoFlight instance assigned to CargoFlight reference");
        System.out.println();

        CargoFlight cf = new CargoFlight();
        cf.add1Package(1.0f, 2.5f, 3.0f);

        Passenger jack = new Passenger(0, 2);
        cf.add1Passenger(jack);

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_FlightReference() {
        System.out.println("***************************");
        System.out.println("Inheritance - CargoFlight instance assigned to CargoFlight reference");
        System.out.println();

        Flight f = new CargoFlight();

        Passenger jack = new Passenger(0, 2);
        f.add1Passenger(jack);

        // The following line will produce an error because the reference "f" is
        //  of type Flight and therefore cannot access members that are declared
        //  within the CargoFlight class
        //f.add1Package(1.0f, 2.5f, 3.0f);

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_ArrayOfReferences() {
        System.out.println("***************************");
        System.out.println("Inheritance - Adding Flights and CargoFlights to a Flight array");
        System.out.println();

        Flight[] squadron = new Flight[5];
        squadron[0] = new Flight();
        squadron[1] = new CargoFlight();
        squadron[2] = new CargoFlight();
        squadron[3] = new Flight();
        squadron[4] = new CargoFlight();

        // Loop through and print out the class type of each member
        for(Flight member : squadron)
            System.out.println("Added a " + member.getClass().getSimpleName());

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_FieldHiding() {
        System.out.println("***************************");
        System.out.println("Inheritance - Field hiding");
        System.out.println();

        System.out.println("Flight reference with Flight instance - seats");
        Flight f1 = new Flight();
        System.out.println(f1.getSeats());

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - seats");
        CargoFlight cf = new CargoFlight();
        System.out.println(cf.seats);

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - seats");
        Flight f2 = new CargoFlight();
        System.out.println(f2.getSeats());

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - add1Passenger");
        f2.add1Passenger();

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - add1Passenger");
        cf.add1Passenger();

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_MethodOverriding() {
        System.out.println("***************************");
        System.out.println("Inheritance - Method overriding");
        System.out.println();

        System.out.println("Flight reference with Flight instance - getSeats()");
        FlightWithGetter f1 = new FlightWithGetter();
        System.out.println(f1.getSeats());

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - getSeats()");
        CargoFlightWithGetter cf = new CargoFlightWithGetter();
        System.out.println(cf.getSeats());

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - getSeats()");
        FlightWithGetter f2 = new CargoFlightWithGetter();
        System.out.println(f2.getSeats());

        System.out.println();
        System.out.println("Flight reference with CargoFlight instance - add1Passenger");
        f2.add1Passenger();

        System.out.println();
        System.out.println("CargoFlight reference with CargoFlight instance - add1Passenger");
        cf.add1Passenger();

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_ObjectsAndArray() {
        System.out.println("***************************");
        System.out.println("Inheritance - Object class");
        System.out.println();

        System.out.println("Populate Object array");
        Object[] stuff = new Object[3];
        stuff[0] = new Flight();
        stuff[1] = new Passenger(0, 2);
        stuff[2] = new CargoFlight();

        // Loop through and print out the class type of each member
        for(Object member : stuff)
            System.out.println("Added a " + member.getClass().getSimpleName());

        System.out.println();
        System.out.println("Set Object reference to new Passenger[]");
        Object o = new Passenger();

        System.out.println();
        System.out.println("Set Object reference to new Flight[5]");
        o = new Flight[5];

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_ObjectReferences() {
        System.out.println("***************************");
        System.out.println("Inheritance - Object reference with CargoFlight instance");
        System.out.println();

        Object o = new CargoFlight();
        // The following line will produce an error because the reference "o" is
        //  of type Object and therefore cannot access members that are declared
        //  within the CargoFlight class
        //  o.add1Package(1.0f, 2.5f, 3.0f);

        if(o instanceof CargoFlight) {
            CargoFlight cf = (CargoFlight) o;
            cf.add1Package(1.0f, 2.5f, 3.0f);
        }

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritance_Equals() {
        System.out.println("***************************");
        System.out.println("Inheritance - Equality");
        System.out.println();

        Flight f1 = new Flight(175);
        Flight f2 = new Flight(175);

        if(f1 == f2)
            System.out.println("Flight references are same");
        else
            System.out.println("Flight references are NOT same");

        if(f1.equals(f2))
            System.out.println("Flights are equal");
        else
            System.out.println("Flights are NOT equal");

        System.out.println("***************************");
        System.out.println();
    }

    private static void useEqualsWithSuper() {
        System.out.println("***************************");
        System.out.println("Equals with Super");
        System.out.println();

        Flight f1 = new Flight(175);
        Flight f2 = f1;

        // do some other stuff

        System.out.println("Calling f1.equals(f2)");
        if(f1.equals(f2))
            System.out.println("f1.equals(f2) returns true");

        System.out.println("***************************");
        System.out.println();
    }

    private static void inheritanceAndConstructors() {
        System.out.println("***************************");
        System.out.println("Inheritance and Constructors");
        System.out.println();

        System.out.println("Creating - Flight f175");
        Flight f175 = new Flight(175);

        System.out.println();
        System.out.println("Creating - CargoFlight cf");
        CargoFlight cf = new CargoFlight();

        System.out.println();
        System.out.println("Creating - CargoFlight cf294");
        CargoFlight cf294 = new CargoFlight(294);

        System.out.println();
        System.out.println("Creating - CargoFlight cf85");
        CargoFlight cf85 = new CargoFlight(85, 2000.0f);

        System.out.println();
        System.out.println("Creating - CargoFlight cfBig");
        CargoFlight cfBig = new CargoFlight(5000.0f);

        System.out.println("***************************");
        System.out.println();
    }
}