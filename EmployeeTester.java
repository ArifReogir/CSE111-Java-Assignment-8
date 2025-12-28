/*Design the Manager and Developer class derived from the Employee class with appropriate attributes and properties so that the driver code can generate the output given below.
[Hint:
Manager:
1. Adds a bonus to the base salary if the manager works more than 40 hours.
2. If the manager works more than 100 hours, the full amount is approved; if they work more than 80 hours, half the amount is approved.
Otherwise, the increment is denied.
Developer:
1. Adds $700 to the base salary if the developer works with Java programming language.]
*/

public class EmployeeTester { // Driver code
    public static void main(String[] args) {
        Manager neymar = new Manager("Neymar", 1000, 45, 10);
        Developer messi = new Developer("Messi", 1000, 50, "Java");
        Developer chiesa = new Developer("Chiesa", 1000, 50, "Javascript");
        neymar.calculateSalary();
        System.out.println("1.==========");
        neymar.displayInfo();
        System.out.println("2.==========");
        neymar.requestIncrement(100);
        System.out.println("3.==========");
        neymar.setHoursWorked(85);
        neymar.requestIncrement(100);
        System.out.println("4.==========");
        neymar.calculateSalary();
        System.out.println("5.==========");
        neymar.displayInfo();
        System.out.println("6.==========");
        messi.calculateSalary();
        System.out.println("7.==========");
        messi.displayInfo();
        System.out.println("8.==========");
        chiesa.calculateSalary();
        System.out.println("9.==========");
        chiesa.displayInfo();
    }
}

// Class starts here

class Employee { // Parent class
    public String name;
    private double baseSalary;
    private int hoursWorked;

    public Employee(String name, double baseSalary, int hoursWorked) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Work Hours: " + hoursWorked);
    }
}

class Manager extends Employee { // Child class
    public double bonus;
    public double final_salary;

    public Manager(String name, double salary, int work, double bonus) {
        super(name, salary, work);
        this.bonus = bonus;
    }

    public void calculateSalary() {
        if (getHoursWorked() > 40) {
            final_salary = getBaseSalary() + (getBaseSalary() * 0.1);
        } else {
            return;
        }
    }

    public void requestIncrement(int x) {
        if (getHoursWorked() > 100) {
            final_salary = x + final_salary;
            System.out.println("$" + x + " Increment approved.");
            setBaseSalary(getBaseSalary() + x);
        } else if (getHoursWorked() > 80) {
            final_salary = (x / 2) + final_salary;
            System.out.println("$" + (x / 2) + " Increment approved.");
            setBaseSalary(getBaseSalary() + (x / 2));
        } else {
            System.out.println("Increment denied.");
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: " + bonus + " %");
        System.out.println("Final Salary: $" + final_salary);
    }

}

class Developer extends Employee {
    public String language;
    public double final_salary;

    public Developer(String name, double salary, int work, String language) {
        super(name, salary, work);
        this.language = language;
    }

    public void calculateSalary() {
        if (language.equals("Java")) {
            final_salary = getBaseSalary() + 700;
        } else {
            final_salary = getBaseSalary();
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Language: " + language);
        System.out.println("Final Salary: $" + final_salary);
    }
}