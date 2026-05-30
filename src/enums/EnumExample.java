package enums;

/**
 * Enums are like a super strict menu! 
 * 
 * Imagine you go to an ice cream shop and they ONLY have Vanilla, Chocolate, and Strawberry.
 * If you ask for "Pizza Flavor", they will say "No! Pick from the menu!"
 * 
 * Enums are a way to tell Java: "These are the ONLY choices allowed."
 * Here, our menu is the Days of the Week.
 */
public enum EnumExample {
    // These are the only allowed choices! 
    // We usually write them in ALL CAPS so we know they are special constants.
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY, // Added Wednesday so the menu is complete!
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

class Main {
    public static void main(String[] args) {
        // I am picking a day from our special menu.
        EnumExample today = EnumExample.FRIDAY;
        
        // We can use a switch (vending machine) to do something based on our choice!
        switch (today) {
            case FRIDAY:
                System.out.println("Yay! The weekend is almost here!");
                // Output: Yay! The weekend is almost here!
                break;
            case MONDAY:
                System.out.println("Oh no, the week just started.");
                break;
            case THURSDAY:
                System.out.println("Almost weekend!");
                break;
            default:
                System.out.println("It's just a regular day.");
        }
    }
}