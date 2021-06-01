package com.pluralsight.slidesstaticimport;

import java.util.ArrayList;
import java.util.Iterator;

public class Flight
        implements Comparable<Flight>, Iterable<Passenger> {
    int passengers;
    int seats = 150;
    private ArrayList<Passenger> passengerList = new ArrayList<>();

    private int flightTime ;

    private int totalCheckedBags;

    private int flightNumber;
    private char flightClass;

    public Flight() {  }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;

    }

    public Flight(char flightClass) {
        this.flightClass = flightClass;
    }

    public void add1Passenger() {
        System.out.println("executing add1Passenger()");

        if(hasSeating())
            passengers += 1;
    }

    public void add1Passenger(int bags) {
        System.out.println("executing add1Passenger(int bags)");

        if (hasSeating()) {
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    public void add1Passenger(Passenger p) {
        System.out.println("executing add1Passenger(Passenger p)");

        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(int bags, int carryOns) {
        System.out.println("executing add1Passenger(int bags, int carryOns)");

        if(carryOns <= 2)
            add1Passenger(bags);
    }

    public void add1Passenger(Passenger p, int carryOns) {
        System.out.println("executing add1Passenger(Passenger p, int carryOns)");

        add1Passenger(p.getCheckedBags(), carryOns);
    }

    public void addPassengers(Passenger... list) {
        System.out.println("executing addPassengers(Passenger... list)");
        if (hasSeating(list.length)) {
            passengers += list.length;
            for (Passenger passenger : list) {
                System.out.println("Adding " + passenger.getCheckedBags() + " checked bags");
                totalCheckedBags += passenger.getCheckedBags();
            }
        }
    }

    private boolean hasSeating() {
        System.out.println("executing hasSeating() - seats: " + seats);
        return passengers < seats;
    }

    private boolean hasSeating(int count) {
        return passengers + count <= seats;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTotalCheckedBags() {
        return totalCheckedBags;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("executing Flight.equals(Object o)");

        if(super.equals(o)) {
        System.out.println("Both references point to the same Flight instance)");
        return true;
    }
        if (!(o instanceof Flight)) {
        System.out.println("Object being compared is NOT a Flight");
        return false;
    }
    Flight flight = (Flight) o;

        return flightNumber == flight.flightNumber &&
                flightClass == flight.flightClass;
    }
    public int compareTo(Flight flight) {
        // Flights are sorted by time of day. Ordering starts with those just after midnight and
        // continuing through the rest of the day. (i.e. 15 (12:15am) comes before 90 (1:30am)
        return flightTime - flight.flightTime;
    }

    public Iterator<Passenger> iterator() {
        return passengerList.iterator();
    }
}

