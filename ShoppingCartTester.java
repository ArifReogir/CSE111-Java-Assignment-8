/*A retail company only sells two types of products and wants to store them in a catalog. You are given the Tester class and Product class. Design the Clothing and Electronics class by observing the given classes and their outputs.
 */

public class ShoppingCartTester { // Driver code
    public static void main(String[] args) {
        Product p1 = new Product("Notebook", 4.99);
        Clothing c1 = new Clothing("T-Shirt", 19.99, "M");
        Electronics e1 = new Electronics("Laptop", 999.99, 24);
        p1.displayInfo();
        c1.displayInfo();
        e1.displayInfo();
        System.out.println("Total products created: " + Product.totalProducts);
        Electronics e2 = new Electronics("Smartphone", 799.99, 12);
        e2.displayInfo(false);
    }
}

// Class starts here

class Product { // Parent class
    public String productName;
    public double price;
    public static int totalProducts = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayInfo() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }
}

class Clothing extends Product { // Child class
    public String size;

    public Clothing(String name, double price, String sizes) {
        super(name, price);
        this.size = sizes;
    }

    public void displayInfo() {
        System.out.println("Clothing: " + productName + ", Price: $" + price + ", Size: " + size);
    }
}

class Electronics extends Product {
    public int warranty;
    public boolean stock;

    public Electronics(String name, double price, int war) {
        super(name, price);
        this.warranty = war;
    }

    public void displayInfo() {
        System.out
                .println("Electronics: " + productName + ", Price: $" + price + ", Warranty: " + warranty + " months");
    }

    public void displayInfo(boolean info) {
        System.out.println("Electronics: " + productName + ", Warranty: " + warranty + " months");
    }
}