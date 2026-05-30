package oop;

/**
 * Encapsulation is like a Secret Diary with a lock!
 * 
 * You don't want anyone to read or change your secrets directly.
 * So, you make the secrets 'private'. The only way to get them is to ask 
 * nicely through a 'public' method (like using a key).
 */
public class EncapsulationExample {
    
    // PRIVATE: No one outside this class can touch this!
    private int moneyInPiggyBank = 0;

    // PUBLIC GETTER: A safe way to LOOK at the money.
    public int getMoney() {
        return moneyInPiggyBank;
    }

    // PUBLIC SETTER: A safe way to ADD money. 
    // We can add rules here! Like: "No stealing allowed!"
    public void addMoney(int amount) {
        if (amount > 0) {
            moneyInPiggyBank += amount;
            System.out.println("Added " + amount + " coins!");
        } else {
            System.out.println("Hey! You can't take money out or add negative coins!");
        }
    }

    public static void main(String[] args) {
        EncapsulationExample myBank = new EncapsulationExample();
        
        // myBank.moneyInPiggyBank = 100; // ERROR! It is private!
        
        myBank.addMoney(10);
        myBank.addMoney(-5); // The setter protects us from this bad math!
        
        System.out.println("Total money: " + myBank.getMoney());
    }
}