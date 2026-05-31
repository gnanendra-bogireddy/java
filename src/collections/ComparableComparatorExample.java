package collections;

import java.util.*;

/**
 * Comparable and Comparator are tools used to sort objects!
 * 
 * Think of it like organizing your books:
 * 1. Comparable (Natural Order): The book "knows" its place by its title (A-Z). 
 *    The sorting logic is INSIDE the book class itself.
 * 
 * 2. Comparator (Custom Order): You decide to organize books by Color or by Size. 
 *    The sorting logic is OUTSIDE the book class.
 */
public class ComparableComparatorExample {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Charlie", 95));
        students.add(new Student("Bob", 90));

        System.out.println("--- 1. Natural Sorting (Comparable) ---");
        // Comparable uses the compareTo() method inside Student
        // In this example, it sorts by Name (A-Z)
        Collections.sort(students);
        System.out.println("Sorted by Name: " + students);


        System.out.println("\n--- 2. Custom Sorting (Comparator) ---");
        // Comparator is a separate tool we hand to the sort method
        // Here we sort by Score (Highest to Lowest)
        Collections.sort(students, new ScoreComparator());
        System.out.println("Sorted by Score (High to Low): " + students);


        System.out.println("\n--- 3. Modern Sorting (Lambda) ---");
        // In modern Java, we don't always need a separate class!
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("Sorted by Name (Lambda): " + students);

        /*
         * Expected Output:
         * --- 1. Natural Sorting (Comparable) ---
         * Sorted by Name: [Alice (85), Bob (90), Charlie (95)]
         * 
         * --- 2. Custom Sorting (Comparator) ---
         * Sorted by Score (High to Low): [Charlie (95), Bob (90), Alice (85)]
         * 
         * --- 3. Modern Sorting (Lambda) ---
         * Sorted by Name (Lambda): [Alice (85), Bob (90), Charlie (95)]
         */
    }
}

/**
 * Comparable: The class implements this to define its "Natural Order".
 * We use 'compareTo'.
 */
class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public int compareTo(Student other) {
        // Natural order: Alphabetical by name
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }
}

/**
 * Comparator: A separate class used for "Custom Sorting".
 * We use 'compare'.
 */
class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Custom order: Highest score first
        return Integer.compare(s2.getScore(), s1.getScore());
    }
}
