/*Design the PremiumRide derived from Ride class to generate the given output.
An extra 20% charge is applied to the total fare if surge is active(true).
 */

public class RideTester { // Driver code
    public static void main(String[] args) {
        Ride r1 = new Ride(7);
        PremiumRide r2 = new PremiumRide(15, true);
        PremiumRide r3 = new PremiumRide(12, false);
        System.out.println("1============");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println("2============");
        System.out.println("Regular Ride: " + r1.calculateFare() + " TK");
        System.out.println("Premium Ride " + r2.getId() + ": " + r2.calculateFare() + " TK");
        System.out.println("Premium Ride " + r3.getId() + ": " + r3.calculateFare(40) + " TK");
        System.out.println("3============");
        System.out.println(r3);
    }
}

// Class starts here

class Ride { // Parent class
    private int distance;

    public Ride(int distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return distance * 10;
    }

    public double getDistance() {
        return distance;
    }

    public String toString() {
        return "Distance: " + this.distance + " km";
    }
}

class PremiumRide extends Ride { // Child class
    private static int counter;
    private int id;
    public boolean surge;
    public boolean discount;

    public PremiumRide(int distance, boolean sur) {
        super(distance);
        this.surge = sur;
        counter++;
        this.id = counter;
    }

    public double getDistance() {
        return super.getDistance();
    }

    public String getId() {
        return id + "-" + (int) getDistance();
    }

    public double calculateFare() {

        double total = (getDistance() * 10) + 50;

        if (surge == true) {
            return total * 1.2;
        }

        return total;
    }

    public double calculateFare(int x) {
        discount = true;
        return calculateFare() - x;
    }

    public String toString() {
        return super.toString() + "\nID: " + getId() + "\nService Charge: 50 Tk"
                + "\nSurge: "
                + surge + "\nDiscount: " + discount;
    }

}
