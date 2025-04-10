package ComparingObjects;

import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args){

        //=========================
        // DISPLAYING OBJECT DETAILS
        //=========================
        /*
         * Let's begin by displaying object details. When we create objects in Java,
         * we often need to view their contents in a readable format.
         * This is useful for debugging and understanding program state.
         * By default, printing an object uses Object's toString() method,
         * but we can customize this behavior for better readability.
         */

        System.out.println("---------------------------");
        System.out.println("OUTPUT FOR: DISPLAYING OBJECTS DETAILS");

        // Without overriding toString()
        // The default toString() method returns className@hashCode which isn't very informative
        CreatePerson sim = new CreatePerson("John", "black", 26);
        System.out.println("\nObject details are: " + sim);
        // This will print something like "CreatePerson@15db9742" which doesn't tell us about the object's actual data

        // With overridden toString() in CreatePerson2
        // We can customize how our object is represented as a string
        sim = new CreatePerson2("John", "black", 26);
        System.out.println("Object details are: " + sim);
        // This will print "CreatePerson2[Name:John| Race:black| age:26]" - much more informative!


        //======================
        // COMPARING TWO OBJECTS
        //======================
        /*
         * Now let's explore how to check if two objects are the same.
         * This is a common need when working with collections, databases, or
         * any scenario where you need to identify duplicates.
         * Java offers different ways to compare objects, and choosing the right
         * approach depends on what we mean by "same" - same identity or same contents.
         */

        System.out.println("---------------------------");
        System.out.println("OUTPUT FOR: COMPARING TWO OBJECTS");

        // Using CreatePerson2 (which only overrides toString())
        // First approach: Comparing objects using == operator (reference equality)
        sim = new CreatePerson2("John", "black", 26);
        CreatePerson2 simDuplicate = new CreatePerson2("John", "black", 26);
        boolean sameObject = sim == simDuplicate;
        System.out.println("\nComparing objects using == operator");
        System.out.println("sim and duplicate are the same: " + sameObject);
        // Returns 'false' because the == operator checks if both variables point to exactly the same object in memory
        // Even though both objects have identical content, they are separate instances with different memory addresses

        // Second approach: Comparing hashCode() with CreatePerson2
        // Without a custom hashCode() implementation, objects get default behavior based on memory address
        sameObject = sim.hashCode() == simDuplicate.hashCode();
        System.out.println("\nUsing default hashCode()");
        System.out.println("sim and duplicate are the same: " + sameObject);
        // Still returns 'false' because the default hashCode() is based on object identity, not content
        // Each distinct object instance gets its own hash code regardless of its data

        //--------------------------
        // Third approach: Using CreatePerson3 with overridden hashCode()

        // CreatePerson3 overrides hashCode() to calculate based on content (name, race, age)
        // This means objects with the same data will produce the same hash code
        sim = new CreatePerson3("John", "black", 26);
        CreatePerson3 simDuplicate2 = new CreatePerson3("John", "black", 26);
        sameObject = sim.hashCode() == simDuplicate2.hashCode();
        System.out.println("\nUsing overridden hashCode()");
        System.out.println("sim and duplicate are the same: " + sameObject);
        // Returns 'true' because our custom hashCode() implementation is based on the object's content
        // Now objects with the same name, race, and age will generate the same hash code


    //====================
    // COUNTING UNIQUE OBJECTS
    //=====================
    /*
    * Now let's explore a practical application: tracking unique objects using HashSet.
    * When working with collections of objects, we often need to filter out duplicates.
    * Java's HashSet is designed for this purpose, but it relies on proper implementation
    * of both hashCode() and equals() to correctly identify duplicates.
    * Let's see how different implementations affect HashSet's behavior.
    */

    System.out.println("---------------------------");
    System.out.println("OUTPUT FOR: COUNTING UNIQUE OBJECTS");
    
    
    //--------------------------
    // First attempt: Using CreatePerson3 (hashCode() overridden, but equals() not overridden)
    
    // HashSet uses both hashCode() and equals() to determine uniqueness
    Set<Object> uniquePeople = new HashSet<>();
    
    CreatePerson3 sim1 = new CreatePerson3("John", "black", 26);
    CreatePerson3 sim2 = new CreatePerson3("Susan", "white", 28);
    CreatePerson3 sim1Duplicate = new CreatePerson3("John", "black", 26);
    
    uniquePeople.add(sim1);
    uniquePeople.add(sim2);
    uniquePeople.add(sim1Duplicate); 
    
    // We would expect only 2 unique objects, but we get 3!
    System.out.println("\nHashSet with CreatePerson3 (only hashCode() overridden)");
    System.out.println("Count of unique people is: " + uniquePeople.size());
    System.out.println("Unique people: " + uniquePeople);
    // Returns count of 3 because HashSet uses a two-step process to determine uniqueness:
    // 1. First, it checks if hashCodes are equal (they are for sim1 and sim1Duplicate)
    // 2. Then, it calls equals() - but we haven't overridden equals(), so it uses the default
    //    implementation which compares object references using ==, not their content
    //
    // This is why we need to override equals() specifically for HashSet:
    // When HashSet.add() is called, it first uses hashCode() to determine which "bucket" to check
    // Then it iterates through that bucket and uses equals() to check if the object already exists
    // Without a proper equals() override, HashSet can't correctly identify when two objects with 
    // identical content are "equal" - it only sees they're different instances in memory
    
    //--------------------------
    // Second attempt: Using CreatePerson4 (both hashCode() and equals() overridden properly)
    uniquePeople = new HashSet<>();
    
    CreatePerson4 sim3 = new CreatePerson4("John", "black", 26);
    CreatePerson4 sim4 = new CreatePerson4("Susan", "white", 28);
    CreatePerson4 sim3Duplicate = new CreatePerson4("John", "black", 26);
    
    uniquePeople.add(sim3);
    uniquePeople.add(sim4);
    uniquePeople.add(sim3Duplicate); 
    
    // Now the HashSet correctly identifies duplicates!
    System.out.println("\nHashSet with CreatePerson4 (both hashCode() and equals() overridden)");
    System.out.println("Count of unique people is: " + uniquePeople.size());
    System.out.println("Unique people: " + uniquePeople);
    // Returns count of 2 because:
    // 1. hashCode() returns the same value for objects with identical content
    // 2. equals() confirms they're actually equal by comparing each field
    //
    // How HashSet uses equals() and hashCode() together:
    // - When you call add(object), HashSet first calculates object's hashCode()
    // - It uses this hashCode() to determine where to store the object in its internal structure
    // - If another object is already stored at that location, HashSet calls equals() to check
    //   if they are actually the same object in terms of content
    // - If equals() returns true, HashSet considers it a duplicate and doesn't add the new object
    // - If equals() returns false, both objects are stored at the same location (handling hash collisions)
    //
    // In CreatePerson4, our equals() method is overridden to compare:
    //    - this.name.equals(otherInstance.name)
    //    - this.race.equals(otherInstance.race) 
    //    - this.age == otherInstance.age
    // This ensures objects with identical field values are considered equal, even though
    // they are different object instances in memory
    //
    // The hashCode() and equals() contract in Java:
    // 1. If two objects are equal according to equals(), they MUST have the same hashCode()
    // 2. If two objects have the same hashCode(), they are NOT necessarily equal (called a collision)
    // 3. But for efficiency, unequal objects should have different hashCodes when possible
    // Breaking this contract will cause HashSet, HashMap, and other collections to behave incorrectly

    }
}