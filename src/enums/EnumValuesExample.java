package enums;

/**
 * Enums can also hold secret information!
 * 
 * Imagine the days of the week are like secret agents, and each one has a secret code number.
 * Sunday's code is 0, Monday's is 1, and so on.
 */
public enum EnumValuesExample {

    // Here are the agents and their secret codes in parentheses ()
    SUNDAY(0), 
    MONDAY(1), 
    TUESDAY(2), 
    WEDNESDAY(3), 
    THURSDAY(4), 
    FRIDAY(5), 
    SATURDAY(6);

    // This is where the agent stores their secret code. 
    // 'final' means the code can NEVER be changed once it is set.
    final int secretCode;

    // This is the instructions on how to give an agent their code when they are created.
    EnumValuesExample(int code) {
        this.secretCode = code;
    }

}

class MainClass {
    public static void main(String[] args) {
        
        System.out.println("Let's look at all the agents and their secret codes:");
        
        // .values() is a magic trick that gives us a list of EVERY item in the Enum!
        for (EnumValuesExample day : EnumValuesExample.values()) {
            // We print the agent's name (day) and their secret code (day.secretCode)
            System.out.println("Agent " + day + " has secret code: " + day.secretCode);
        }
        
        /*
         * Expected Output:
         * Let's look at all the agents and their secret codes:
         * Agent SUNDAY has secret code: 0
         * Agent MONDAY has secret code: 1
         * Agent TUESDAY has secret code: 2
         * Agent WEDNESDAY has secret code: 3
         * Agent THURSDAY has secret code: 4
         * Agent FRIDAY has secret code: 5
         * Agent SATURDAY has secret code: 6
         */
    }
}