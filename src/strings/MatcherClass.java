package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherClass {
        public static void main(String[] args) {

            // 1. Our sample text containing dataset trends
            String report = "Revenue grew from $5000 in 2023 to $12500 in 2025.";

            // 2. The Pattern: Look for a literal '$' followed by 1 or more digits
            // We put the digits in parentheses ( ) to create a "Capturing Group"
            String regex = "\\$(\\d+)";
            Pattern pattern = Pattern.compile(regex);

            // 3. The Matcher: Tied directly to our sample text
            Matcher matcher = pattern.matcher(report);

            System.out.println("--- 1. SCANNING AND EXTRACTING WITH MATCHER ---");

            // matcher.find() scans the text sequentially.
            // It returns true and moves to the next match every time it's called.
            while (matcher.find()) {
                // matcher.group() or matcher.group(0) returns the WHOLE match
                System.out.println("Full Match Found: " + matcher.group());

                // matcher.groupCount() number of matches found
                System.out.println("Number of Matches Found: " + matcher.groupCount());

                // matcher.group(1) extracts just the digits inside the first set of ( )
                System.out.println("Extracted Amount (Group 1): " + matcher.group(1));

                // matcher.start() and matcher.end() give the exact index boundaries in the string
                System.out.println("Located between string indices: " + matcher.start() + " and " + matcher.end());
                System.out.println("------------------------------------");
            }

            // --- Resetting the Matcher ---
            // Because the previous loop read all the way to the end of the string,
            // we reset it back to index 0 if we want to perform more operations.
            matcher.reset();

            System.out.println("\n--- 2. POWERFUL REPLACEMENT METHODS ---");

            // matcher.replaceAll() replaces every matched sequence with a new string
            String maskedReport = matcher.replaceAll("$[REDACTED]");
            // matcher.replaceFirst() replaces every matched sequence with a new string
            String maskedReport1 = matcher.replaceFirst("$[REDACTED]");
            System.out.println("Original: " + report);
            System.out.println("Masked:   " + maskedReport);
        }
}
