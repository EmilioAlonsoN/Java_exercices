package com.pluralsight.slidesstaticimport;

import java.util.Random;

public class AdminService {
    Random random;
    public void connect() {
        random = new Random();
    }
    public void close() {

    }

    public boolean isRestricted() {
        boolean isRestricted = random.nextBoolean();
        return isRestricted;
    }

    public int getMaxFlightPassengers() {
        int max = random.nextInt(1000);
        return max;
    }
}
