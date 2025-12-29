/*Given the following classes, 
write the code for the CarDriver and the BikeDriver class so that the following output is printed. */

import java.util.Arrays;

public class PathaoRideManager { // Driver code
    public static void main(String[] args) {
        System.out.println("1.==============");
        GenericDriver d = new GenericDriver();
        System.out.println("2.==============");
        d.hasSafetyTraining();
        System.out.println("3.==============");
        BikeDriver d1 = new BikeDriver("John", "Not Premium");
        System.out.println("4.==============");
        System.out.println(d1);
        System.out.println("5.==============");
        System.out.println(d1.acceptRide(false));
        System.out.println("6.==============");
        d1.hasSafetyTraining();
        System.out.println("7.==============");
        CarDriver d2 = new CarDriver("Max");
        System.out.println("8.==============");
        System.out.println(d2);
        System.out.println("9.==============");
        d2.hasSafetyTraining();
        System.out.println("10.==============");
        System.out.println(d2.acceptRide(true));
        System.out.println("11.==============");
        System.out.println(d2);
        System.out.println("12.==============");
        BikeDriver.restrictedAreas("Airport Road");
        BikeDriver.restrictedAreas("Defense Area");
        BikeDriver.restrictedAreas("Navy Base");
        System.out.println(Arrays.toString(BikeDriver.restrictedAreas));
        System.out.println("13.==============");
        d1.fightRestriction(new String[] { "Defense Area", "Banani", "Uttara" });
        System.out.println("14.==============");
        CarDriver.restrictedAreas("Cantonment");
        CarDriver.restrictedAreas("Road 27");
        System.out.println(Arrays.toString(CarDriver.restrictedAreas));
        System.out.println("15.==============");
        d2.fightRestriction(new String[] { "Defense Area", "Road 27" });
    }
}

// Class starts here

class GenericDriver { // Parent class
    private String name;

    public GenericDriver() {
        System.out.println("Welcome to Pathao!");
    }

    public GenericDriver(String name) {
        this.name = name;
        System.out.println("Welcome to Pathao Driver Panel!");
        System.out.println(this.name + " has been registered as a Pathao driver!");
    }

    public String getName() {
        return name;
    }

    public void hasSafetyTraining() {
        System.out.println("All drivers must have safety training.");
    }

    public String acceptRide(boolean hasVehicle) {
        String s = "All Pathao drivers can accept rides. ";
        if (!hasVehicle)
            s += "Driver does not have a verified vehicle. ";
        else
            s += "Driver has a verified vehicle. ";
        return s;
    }
}

class BikeDriver extends GenericDriver {
    public String profile;

    public static String[] restrictedAreas = new String[3];
    public static int count;

    public BikeDriver(String name, String profile) {
        super(name);
        this.profile = profile;
    }

    public String toString() {
        return getName() + "'s driver profile is " + profile;
    }

    public String acceptRide(boolean ride) {
        return super.acceptRide(ride) + "\nJohn's driver profile is " + profile;
    }

    public void hasSafetyTraining() {
        super.hasSafetyTraining();
    }

    public static void restrictedAreas(String name) {
        if (count < restrictedAreas.length) {
            restrictedAreas[count] = name;
            count++;
        } else {
            return;
        }
    }

    public void fightRestriction(String[] newarea) {
        for (int i = 0; i < newarea.length; i++) {
            int located = 0;

            for (int j = 0; j < restrictedAreas.length; j++) {
                if (newarea[i].equals(restrictedAreas[j])) {
                    located = 1;
                }
            }

            if (located == 1) {
                System.out.println(getName() + " cannot enter " + newarea[i]);
            } else {
                System.out.println(getName() + " can enter " + newarea[i]);
            }
        }
    }

}

class CarDriver extends GenericDriver {
    public String profile = "Premium";

    public static String[] restrictedAreas = new String[2];
    public static int count;

    public CarDriver(String name) {
        super(name);
    }

    public String toString() {
        return getName() + "'s driver profile is a " + profile;
    }

    public String acceptRide(boolean ride) {
        return super.acceptRide(true) + "\nMax's driver profile is " + profile;
    }

    public void hasSafetyTraining() {
        super.hasSafetyTraining();
        System.out.println("Premium drivers recieve extra safety briefings.");
    }

    public static void restrictedAreas(String name) {
        if (count < restrictedAreas.length) {
            restrictedAreas[count] = name;
            count++;
        } else {
            return;
        }
    }

    public void fightRestriction(String[] newarea) {
        for (int i = 0; i < newarea.length; i++) {
            int located = 0;

            for (int j = 0; j < restrictedAreas.length; j++) {
                if (newarea[i].equals(restrictedAreas[j])) {
                    located = 1;
                }
            }

            if (located == 1) {
                System.out.println(getName() + " cannot enter " + newarea[i]);
            } else {
                System.out.println(getName() + " can enter " + newarea[i]);
            }
        }
    }

}
