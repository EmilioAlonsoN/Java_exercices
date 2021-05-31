package workingwithenums;

public class CrewMember {
    private flightCrewJob job;
    private String name;

    public CrewMember() { }

    public CrewMember(flightCrewJob job, String name) {
        this.job = job;
        this.name = name;
    }

    public flightCrewJob getJob() {
        return job;
    }

    public void setJob(flightCrewJob job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
