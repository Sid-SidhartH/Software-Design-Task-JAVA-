package TravelAgency;

public class TravelAgencyTest{
    public static void main(String[] args){

        Activity activity1 = new Activity("City Tour", "Guided tour of the city", 50, 20);
        Activity activity2 = new Activity("Beach Day", "Relaxing day at the beach", 30, 15);

        // Create destinations
        Destination destination1 = new Destination("GOA");
        destination1.addActivity(activity1);

        Destination destination2 = new Destination("Manali");
        destination2.addActivity(activity2);

        // Create passengers
        Passenger passenger1 = new Passenger("Aathira", 1, "standard", 100);
        Passenger passenger2 = new Passenger("shubham", 2, "gold", 150);
        Passenger passenger3 = new Passenger("sid", 3, "premium", 0);

        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("City Hopping", 3);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Add passengers to the travel package
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        // Sign up passengers for activities
        passenger1.signUpForActivity(activity1);
        passenger1.signUpForActivity(activity2);
        passenger2.signUpForActivity(activity2);
        passenger3.signUpForActivity(activity1);
       // System.out.println(passenger1.toString());

        travelPackage.printItinerary();
        travelPackage.printPassengerList();

        for (Passenger passenger : travelPackage.getPassengers()) {
            travelPackage.printPassengerDetails(passenger);
        }

        travelPackage.printAvailableActivities();
    }

}
