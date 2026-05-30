package methods;

/**
 * Access Modifiers are like the locks on your house doors!
 * 
 * They tell Java who is allowed to see or touch your variables and methods.
 * This is super important to keep your code safe and organized (this is called Encapsulation!).
 */
public class AccessModifiers {

    // 1. PUBLIC: This is like the sidewalk in front of your house. 
    // ANYONE in the whole world (any part of the program) can see and use this!
    public String publicVariable = "Everyone can see me!";

    // 2. PROTECTED: This is like your backyard. 
    // Your family (subclasses) and your neighbors (classes in the same package) can come in and play. 
    // Strangers cannot!
    protected String protectedVariable = "Only family and neighbors allowed!";

    // 3. DEFAULT (No keyword written): This is like the living room of your house. 
    // Anyone who lives in your house or neighborhood (same package) can come in.
    // If you don't write public, private, or protected, Java uses this one automatically.
    String defaultVariable = "Only neighbors (same package) allowed!";

    // 4. PRIVATE: This is like your secret diary in your bedroom!
    // ONLY YOU (this specific class) can read it or change it. NO ONE ELSE is allowed!
    private String privateVariable = "Shh... this is a secret only I can see!";
    
    // Note: Since we are in the 'AccessModifiers' class, we can see ALL of these variables here.
    // But if another class tries to look, they might get blocked!
}