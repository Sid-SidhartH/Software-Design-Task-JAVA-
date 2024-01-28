package TravelAgency;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private String name;
    private int passengerNumber;
    private String passengerType;
    private double balance;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, String passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean signUpForActivity(Activity activity) {
        if (signUp1(activity)) {
            signedUpActivities.add(activity);
            return true;
        }
        return false;
    }


    public boolean signUp1(Activity activity) {
        if (passengerType.equals("standard")) {
            if (balance >= activity.getCost()) {
                balance -= activity.getCost();
                return activity.signUp(this);
            } else {
                return false;
            }
        } else if (passengerType.equals("gold")) {
            double discountedCost = 0.9 * activity.getCost();
            if (balance >= discountedCost) {
                balance -= discountedCost;
                return activity.signUp(this);
            } else {
                return false;
            }
        } else if (passengerType.equals("premium")) {
            return activity.signUp(this);
        } else {
            return false;
        }
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passengerNumber=" + passengerNumber +
                ", passengerType='" + passengerType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
