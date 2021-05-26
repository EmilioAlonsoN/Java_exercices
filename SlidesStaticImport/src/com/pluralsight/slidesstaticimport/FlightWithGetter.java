package com.pluralsight.slidesstaticimport;

public class FlightWithGetter {
    int passengers;
    int getSeats() {
        return 150;
    }

    private int totalCheckedBags;

    private int flightNumber;
    private char flightClass;

    public FlightWithGetter() {  }

    public FlightWithGetter(int flightNumber) {
        this.flightNumber = flightNumber;

    }

    public FlightWithGetter(char flightClass) {
        this.flightClass = flightClass;
    }

    public void add1Passenger() {
        System.out.println("executing add1Passenger()");

        if (hasSeating())
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
        System.out.println("executing hasSeating() - seats: " + getSeats());
        return passengers < getSeats();
    }

    private boolean hasSeating(int count) {
        return passengers + count <= getSeats();
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
}
