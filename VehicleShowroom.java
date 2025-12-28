/*Design the Car and ElectricCar classes so that the following output is produced.
 The ElectricCar class and Car class should inherit from the Vehicle class.
 */

public class VehicleShowroom { // Driver code
    public static void main(String[] args) {
        Car c1 = new Car("Toyota Camry", 25000, 4);
        System.out.println("--------1---------");
        c1.vehicleDetail();
        System.out.println("--------2---------");
        Car.showAllAvailableCars();
        System.out.println("--------3---------");
        Car c2 = new Car("Honda Civic", 22000, 4);
        Car c3 = new Car("Ford Mustang", 35000, 2);
        Car.markAsSold(c1);
        Car.markAsSold(c2);
        System.out.println("--------4---------");
        c2.vehicleDetail();
        System.out.println("--------5---------");
        Car.showAllCars();
        System.out.println("--------6---------");
        ElectricCar e1 = new ElectricCar("Tesla Model 3", 45000, 75);
        ElectricCar e2 = new ElectricCar("Nissan Leaf", 32000, 60);
        ElectricCar e3 = new ElectricCar("Nissan Leaf", 32000, 60);
        System.out.println("--------7---------");
        e1.vehicleDetail();
        System.out.println("--------8---------");
        e3.vehicleDetail();
        System.out.println("--------9---------");
        ElectricCar.markAsSoldEV(e1);
        ElectricCar.markAsSoldEV(e2);
        ElectricCar.markAsSoldEV(e3);
    }
}

// Class starts here

class Vehicle { // Parent class
    public String model;
    public int price;
    public boolean sold;
    public String vehicleId;

    public Vehicle(String model, int price) {
        this.model = model;
        this.price = price;
        this.sold = false;
        this.vehicleId = "";
    }

    public void vehicleDetail() {
        System.out.println("Model: " + model + ", Price: $" + price);
        System.out.print("Status: ");
        if (sold) {
            System.out.print("Sold\n");
        } else {
            System.out.print("Available\n");
        }
    }
}

class Car extends Vehicle { // Child class
    public int seats;
    public String type;

    public static int total_cars;
    public static Car[] list = new Car[3];
    public static int count;

    public Car(String model, int price, int seat) {
        super(model, price);
        this.seats = seat;
        count++;
        vehicleId = "CAR00" + count;
        type = "Regular Car";
        list[count - 1] = this;
        System.out.println("Vehicle ID: " + vehicleId + " created");
        total_cars++;

    }

    public void vehicleDetail() {
        System.out.println("Model: " + model + ", Price: $" + price);
        System.out.print("Status: ");
        if (sold) {
            System.out.print("Sold\n");
        } else {
            System.out.print("Available\n");
        }
        System.out.println("Type: " + type);
        System.out.println("Seats: " + seats);
    }

    public static void showAllAvailableCars() {
        System.out.println("Total Car: " + total_cars);
        System.out.println("Available Cars: ");
        for (int i = 0; i < count; i++) {
            System.out.println(list[i].vehicleId + " : " + list[i].model);
        }
    }

    public static void markAsSold(Car c1) {
        c1.sold = true;
    }

    public static void showAllCars() {
        System.out.println("Total Car: " + total_cars);

        for (int i = 0; i < count; i++) {
            System.out
                    .println(list[i].vehicleId + " : " + list[i].model + " - " + (list[i].sold ? "sold" : "available"));
        }
    }
}

class ElectricCar extends Vehicle { // Child class
    public int id;
    public int battery;
    public String type;
    public static boolean Sold;

    public ElectricCar(String model, int price, int battery) {
        super(model, price);
        vehicleId = "EV000";
        type = "Electric Vehicle";
        this.battery = battery;
        System.out.println("Vehicle ID: " + vehicleId + " created");
    }

    public static void markAsSoldEV(ElectricCar e1) {
        Sold = true;
    }

    public void vehicleDetail() {
        super.vehicleDetail();
        System.out.println("Type: " + type);
        System.out.println("Battery Capacity: " + battery + " kWh");
    }
}