/*Given the following base class and driver code, write the code for the Warrior and Mage classes derived from the GameCharacter class so that the following output is printed. */

/*Damage Calculation Formulas:
Warrior: (level * strength) + (armor * 50) 
Mage: (level * intelligence) + (mana * 10) */

public class CharacterTester { // Driver code
    public static void main(String[] args) {
        Warrior warriorOne = new Warrior("Conan", 100, 150, 15, "Two-Handed Sword");
        System.out.println("--------1--------");
        warriorOne.calculateDamage();
        System.out.println(warriorOne);
        System.out.println("--------2--------");
        Mage mageOne = new Mage("Merlin", 80, 200, 18, "Arcane Staff");
        mageOne.calculateDamage();
        System.out.println(mageOne);
        System.out.println("--------3--------");
        GameCharacter.printAllCharacters();
    }
}

// Class starts here

class GameCharacter { // Parent class
    public static String[] allCharacters = new String[5];
    public static int characterCount = 0;
    private String characterName;
    private int level;
    public String weaponType;
    public double totalDamage;

    public GameCharacter(String name, int level, String weapon) {
        this.characterName = name;
        this.level = level;
    }

    public String getCharacterInfo() {
        return "Name: " + characterName + ", Level: " + level;
    }

    public int getLevel() {
        return level;
    }

    public static void printAllCharacters() {
        if (characterCount > 0) {
            System.out.println("Available Characters:");
            for (int i = 0; i < characterCount; i++) {
                System.out.println(allCharacters[i]);
            }
        } else {
            System.out.println("No available character");
        }
    }
}

class Warrior extends GameCharacter { // Child class
    public int strength;
    public int armor;

    public Warrior(String name, int lvl, int power, int armors, String weapon) {
        super(name, lvl, weapon);
        this.weaponType = weapon;
        this.strength = power;
        this.armor = armors;
        allCharacters[characterCount++] = name;
        System.out.println("A new warrior has arrived");

    }

    public void calculateDamage() {
        totalDamage = (getLevel() * strength) + (armor * 50);
    }

    public String toString() {
        return super.getCharacterInfo() + "\nCharacterType: Warrior \nWeapon: " + weaponType + "\nStrength: " + strength
                + ", Armor: " + armor + "\nTotal Damage: " + totalDamage;
    }
}

class Mage extends GameCharacter {
    public int intelligence;
    public int mana;

    public Mage(String name, int lvl, int power, int manas, String weapon) {
        super(name, lvl, weapon);
        this.weaponType = weapon;
        this.intelligence = power;
        this.mana = manas;

        allCharacters[characterCount++] = name;
        System.out.println("A new mage came to live");
    }

    public void calculateDamage() {
        totalDamage = (getLevel() * intelligence) + (mana * 10);
    }

    public String toString() {
        return super.getCharacterInfo() + "\nCharacter Type: Mage \nWeapon: " + weaponType + "\nIntelligence: "
                + intelligence + ", Mana: " + mana + "\nTotal Damage: " + totalDamage;
    }
}