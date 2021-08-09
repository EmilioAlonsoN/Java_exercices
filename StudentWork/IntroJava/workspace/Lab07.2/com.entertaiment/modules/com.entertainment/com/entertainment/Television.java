package com.entertainment;

public class Television {

    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;
    private static final String[] VALID_BRAND = { "Sony","Samsung", "LG", "AOC", "Asus", "Toshiba", "Phillips"};

    private String brand = "Samsung";
    private int volume = 1;
    private int oldVolume;
    private boolean isMuted;
    private DisplayType displayType = DisplayType.LED;

    public Television() {
        System.out.println("No arguments constructor.");
    }

    public Television(String brand, int volume, DisplayType displayType) {
        this(brand,volume);
        System.out.println("Constructor with three arguments String + int + com.entertainment.DisplayType.");
        this.displayType = displayType;
    }

    public Television(String brand, int volume) {
        this();
        System.out.println("Constructor with two arguments String + int.");
        setBrand(brand);
        setVolume(volume);
    }

    public Television(String brand) {
        System.out.println("Minimum value of Volume is : " + MIN_VOLUME);
        System.out.println("Maximum value of Volume is : " + MAX_VOLUME);
        System.out.println("Constructor with one argument String.");
        setBrand(brand);
    }

    public Television(int volume) {
        System.out.println("Constructor with one argument int.");
        setVolume(volume);
    }

    public String toString() {
        String msg = isMuted() ? "<muted>" : getVolume() + "%";
        return "Television brand is: " + getBrand() + " with volume: " + msg + " with com.entertainment.DisplayType: " + displayType;
    }

    public void turnOn() {
        System.out.println("Turning on the Television with brand: " + brand + "%");
    }

    public void turnOff() {
        System.out.println("Turning off the Television with volume: " + volume + "%");
    }

    public void muting() {
        if (isMuted()) {
            volume = oldVolume;
        }
        else {
            oldVolume = getVolume();
            volume = MIN_VOLUME;
        }
        isMuted = !isMuted;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public String getBrand()  {
        return brand;
    }

    public void setBrand(String brand) {

        if (isValidBrand(brand)) {
            this.brand = brand;
        } else {
            System.out.println("Invalid brand " + brand + ", Brand must be one of the following: ");
            for (String currentBrand : VALID_BRAND) {
                System.out.println(currentBrand + ", ");
            }
            System.out.println();
        }
        /*
        for (int i = 0; i < VALID_BRAND.length; i++) {
            if (Arrays.toString(VALID_BRAND).contains(brand)) {
                this.brand = brand;
                return;
            }
        }
        System.out.println("Invalid brand " + brand);


        switch (brand) {
            case "Sony": case "Samsung": case "LG": case "AOC": case "Asus": case "Toshiba":
                this.brand = brand;
                break;
            default: System.out.println("Invalid brand" + brand);
        }
         */
    }

    private static boolean isValidBrand(String brand) {
        boolean isValid = false;
        for (String currentBrand : VALID_BRAND) {
            if (currentBrand.equals(brand)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
            if (isMuted()) { muting();}
            this.volume = volume;
        }
        else System.out.println("Invalid Volume" + volume + "%" + " Values between: " + MIN_VOLUME + "%" + " and "
                + MAX_VOLUME + "%");
    }
}