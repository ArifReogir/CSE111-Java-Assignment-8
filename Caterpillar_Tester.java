/*Implement the design of the  Butterfly class and the Moth class so that these classes extend from the Caterpillar class and generate the output as follows.
1. Butterfly loses 5 units of energy due to flying and gains 5 energy units per food amount
2. Moth loses 2.5 units of energy due to nocturnal activity and gains 2.5 energy units per food amount
 */

public class Caterpillar_Tester { // Driver code
  public static void main(String[] args) {
    Caterpillar c = new Caterpillar("Leaf", 5);
    c.showDetails();
    System.out.println("--------------1-------------");
    c.eat();
    c.eat(3);
    c.showDetails();
    System.out.println("--------------2-------------");
    Butterfly b = new Butterfly("Flower", 2);
    Moth m = new Moth("Cotton", 4);
    System.out.println("--------------3-------------");
    b.transform();
    m.transform();
    System.out.println("--------------4-------------");
    b.eat(2);
    m.eat(5);
    System.out.println("--------------5-------------");
    b.showDetails();
    m.showDetails();
  }
}

// Class starts here

class Caterpillar { // Parent class
  public String food;
  public int age;
  public double energy;

  public Caterpillar(String food, int age) {
    this.food = food;
    this.age = age;
    this.energy = 0;
  }

  public void eat() {
    energy += 1;
    System.out.println("Caterpillar ate 1 unit of food");
  }

  public void eat(int amount) {
    energy += amount;
    System.out.println("Caterpillar ate " + amount + " units of food");
  }

  public void transform() {
    System.out.println("Caterpillar transforms");
  }

  public void showDetails() {
    System.out.println("Food: " + food);
    System.out.println("Age: " + age);
    System.out.println("Energy: " + energy);
  }
}

class Butterfly extends Caterpillar { // Child class

  public Butterfly(String food, int age) {
    super(food, age);
  }

  public void transform() {
    System.out.print("Caterpillar tranforms into Butterfly");
    System.out.println();
  }

  public void eat(int x) {
    energy = (energy - 5) + (x * 5);
    System.out.println("Butterfly lost energy while flying and absorbed necter");
  }

  public void showDetails() {
    System.out.println("Food: " + food);
    System.out.println("Age: " + age);
    System.out.println("Energy: " + energy + " joules");
  }
}

class Moth extends Caterpillar {
  public Moth(String food, int age) {
    super(food, age);
  }

  public void transform() {
    System.out.print("Caterpillar transforms into Moth");
    System.out.println();
  }

  public void eat(int x) {
    energy = (energy - 2.5) + (2.5 * x);
    System.out.println("Moth lost energy due to nocturnal activity");
  }

  public void showDetails() {
    System.out.println("Food: " + food);
    System.out.println("Age: " + age);
    System.out.println("Energy: " + energy + " joules");
  }
}