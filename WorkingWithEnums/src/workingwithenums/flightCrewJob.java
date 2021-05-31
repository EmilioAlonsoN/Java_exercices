package workingwithenums;

public enum flightCrewJob {
    FLIGHT_ATTENDANT("Flight Attendant","*"),
    COPILOT("First Officer", "**"),
    PILOT("Captain", "***");

    private String title;

    public String getTitle() {
        return title;
    }

    flightCrewJob(String title, String stars) {
        this.title = title;
        this.stars = stars;
    }

    private String stars;

    public String getStars() {
        return stars;
    }

    private void flightCrewStart(String title, String stars) {
        this.title = title;
        this.stars = stars;
    }

}
