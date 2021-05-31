package workingwithenums;

public class Main {

    public static void main(String[] args) {
        enumEquality();
        enumSwitchStatement();
        enumRelativeCompare();
	// write your code here
    }

    private static void enumRelativeCompare() {
        System.out.println("***************************");
        System.out.println("Relative Comparison of Enums");
        System.out.println();

        CrewMember geetha = new CrewMember(flightCrewJob.PILOT, "Geetha");
        CrewMember bob = new CrewMember(flightCrewJob.FLIGHT_ATTENDANT, "Bob");

        System.out.println("Comparing " + geetha.getName() + " who is a " + geetha.getJob() +
                " with " + bob.getName() + " who is a " + bob.getJob());

        whoIsInCharge(geetha, bob);

        System.out.println("***************************");
        System.out.println();
    }

    private static void whoIsInCharge(CrewMember member1, CrewMember member2) {
        CrewMember theBoss = member1.getJob().compareTo(member2.getJob()) > 0 ?
                member1 : member2;
        flightCrewJob job = theBoss.getJob();
        System.out.println(theBoss.getJob().getTitle() + " " + theBoss.getName() + " is in charge and have: " + theBoss.getJob().getStars()+ " starts.");
        System.out.println(displayJobResponsibilities(job));
    }

    private static void enumSwitchStatement() {

    }

    private static void enumEquality() {
        System.out.println("***************************");
        System.out.println("Equality Checks with Enums");
        System.out.println();

        flightCrewJob job1 = flightCrewJob.PILOT;
        flightCrewJob job2 = flightCrewJob.FLIGHT_ATTENDANT;

        if(job1 == flightCrewJob.PILOT)
            System.out.println("job1 is PILOT");

        if(job1 != job2)
            System.out.println("job1 and job2 are different");


        System.out.println("***************************");
        System.out.println();
    }

    private static boolean displayJobResponsibilities(flightCrewJob job) {
        switch (job) {
            case FLIGHT_ATTENDANT -> System.out.println("Assures passenger safety");
            case COPILOT -> System.out.println("Assists in flying the plane");
            case PILOT -> System.out.println("Flies the plane");
        }
        return false;
    }
}
