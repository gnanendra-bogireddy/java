package enums;
// Enums are used to store constant values.
// Enum is a separate type of file in java.
// Enums should have final variables and constructors also
// Enum classes automatically extend Base java Enum, and it has
// one method values() it will provide all the values as Array of type Enum class name
public enum EnumExample {

    SUNDAY,
    MONDAY,
    TUESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

class Main {
    public static void main(String[] args) {
        EnumExample enumExample = EnumExample.FRIDAY;
        switch (enumExample) {
            case FRIDAY:
                System.out.println("Yay weekend !");
                break;
            case MONDAY:
                System.out.println("Week just started");
                break;
            case THURSDAY:
                System.out.println("Almost weekend !");
            default:
                System.out.println("Default handler");
        }
    }
}

