package TravelAgency;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name,int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        } else {
            return false;
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");

        for (Destination destination : itinerary) {
            System.out.println("- Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  - Activity: " + activity.getName());
                System.out.println("    - Description: " + activity.getDescription());
                System.out.println("    - Cost: " + activity.getCost() + " credits");
                System.out.println("    - Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());

        for (Passenger passenger : passengers) {
            System.out.println("- Passenger: " + passenger.getName() + " (Number: " + passenger.getPassengerNumber() + ")");
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Details for Passenger: " + passenger.getName());
        System.out.println("- Passenger Number: " + passenger.getPassengerNumber());
        System.out.println("- Balance: " + passenger.getBalance() + " credits");

        List<Activity> signedUpActivities = passenger.getSignedUpActivities();
        if (!signedUpActivities.isEmpty()) {
            System.out.println("- Signed Up Activities:");
            for (Activity activity : signedUpActivities) {
                System.out.println("  - Activity: " + activity.getName());
                System.out.println("    - Destination: " + findDestinationByActivity(activity).getName());
                System.out.println("    - Cost Paid: " + calculateCostForPassenger(passenger, activity) + " credits");
            }
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities with Spaces:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getCapacity() - activity.getCurrentParticipants();
                if (spacesAvailable > 0) {
                    System.out.println("- Activity: " + activity.getName());
                    System.out.println("  - Destination: " + destination.getName());
                    System.out.println("  - Spaces Available: " + spacesAvailable);
                }
            }
        }
    }

    private Destination findDestinationByActivity(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination;
            }
        }
        return null;
    }

    private double calculateCostForPassenger(Passenger passenger, Activity activity) {
        if (passenger.getPassengerType().equals("standard")) {
            return activity.getCost();
        } else if (passenger.getPassengerType().equals("gold")) {
            return 0.9 * activity.getCost();
        } else {
            return 0; // Premium passengers sign up for free
        }
    }


    public List<Passenger> getPassengers() {
        return passengers;
    }
}
