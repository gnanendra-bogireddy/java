package dsa;

import java.util.*;

/**
 * ============================================================================
 * TOP COMMONLY ASKED DSA QUESTIONS FOR AUTOMATION LEADS
 * ============================================================================
 * This file contains the most frequently asked practical coding questions.
 * Focus: HashMaps, Strings, Stacks, Arrays, and Sliding Windows.
 * Each method includes the Code, Use Case, Explanation, and Console Output.
 */
public class TopDSAInterviewQuestions {

    public static void main(String[] args) {
        System.out.println("========== RUNNING TOP DSA INTERVIEW QUESTIONS ==========\n");

        solveValidParentheses();
        solveTwoSum();
        solveCompareVersionNumbers();
        solveMergeIntervals();
        solveGroupAnagrams();
        simulateLRUCache();
    }

    /**
     * 1. VALID PARENTHESES (Stack)
     * ---------------------------------------------------------
     * USE CASE: Validating if an API returned a properly formatted JSON or XML 
     * string where all opening brackets have matching closing brackets.
     * 
     * EXPLANATION: We use a Stack (like a stack of plates). 
     * If we see an open bracket '(', we push the expected close bracket ')' onto the stack.
     * If we see a close bracket, we check if it matches the top plate on the stack.
     * Time: O(n), Space: O(n)
     */
    public static void solveValidParentheses() {
        System.out.println("--- 1. Valid Parentheses ---");
        String input = "{[()]}";
        boolean isValid = isValid(input);
        
        System.out.println("Input: " + input);
        System.out.println("Is Valid JSON/Bracket Structure? " + isValid);
        System.out.println();
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false; // Mismatch or empty stack!
            }
        }
        return stack.isEmpty(); // True if all brackets matched
    }

    /**
     * 2. TWO SUM (HashMap)
     * ---------------------------------------------------------
     * USE CASE: You have a list of transaction amounts in a ledger and you need 
     * to find the two exact transactions that add up to a specific expected total.
     * 
     * EXPLANATION: Instead of checking every pair (which is slow O(n^2)), 
     * we use a HashMap to "remember" numbers we've seen. 
     * We ask: "Target is 9, I am 2. Have I seen a 7 before?". 
     * Time: O(n), Space: O(n)
     */
    public static void solveTwoSum() {
        System.out.println("--- 2. Two Sum ---");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // What number do I need?
            if (map.containsKey(complement)) {
                result[0] = map.get(complement); // Found it! Get its index.
                result[1] = i;
                break;
            }
            map.put(nums[i], i); // Remember this number and its index.
        }

        System.out.println("Array: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Indices that add up to target: " + Arrays.toString(result));
        System.out.println();
    }

    /**
     * 3. COMPARE VERSION NUMBERS (String Parsing)
     * ---------------------------------------------------------
     * USE CASE: Extremely common SDET task. You need to check if the currently 
     * installed mobile app version (e.g., "1.0.1") requires a forced update 
     * because the minimum required version is "1.0.2".
     * 
     * EXPLANATION: Split the strings by the dot ("\\."). Compare each chunk 
     * as an integer. If one version is longer (like "1.0" vs "1.0.0"), treat 
     * the missing parts as 0.
     * Time: O(n), Space: O(n)
     */
    public static void solveCompareVersionNumbers() {
        System.out.println("--- 3. Compare Version Numbers ---");
        String version1 = "1.01";
        String version2 = "1.001.0";
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int length = Math.max(v1.length, v2.length);
        int result = 0; // 0 means equal, 1 means v1 > v2, -1 means v1 < v2
        
        for (int i = 0; i < length; i++) {
            // Parse integer, or use 0 if we ran out of chunks
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) { result = -1; break; }
            if (num1 > num2) { result = 1; break; }
        }

        System.out.println("Version 1: " + version1);
        System.out.println("Version 2: " + version2);
        System.out.println("Result (0=Equal, 1=V1 is newer, -1=V2 is newer): " + result);
        System.out.println();
    }

    /**
     * 4. MERGE INTERVALS (Arrays & Sorting)
     * ---------------------------------------------------------
     * USE CASE: You have a list of scheduled automated test runs. Some of them 
     * overlap in time. You need to merge overlapping runs to find out the true 
     * continuous blocks of time the testing lab will be busy.
     * 
     * EXPLANATION: First, sort the intervals by their start time. 
     * Then, compare the 'end' of the previous interval with the 'start' of the current. 
     * If they overlap, update the 'end' to be the maximum of both.
     * Time: O(n log n) due to sorting, Space: O(n)
     */
    public static void solveMergeIntervals() {
        System.out.println("--- 4. Merge Intervals ---");
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if (currentEnd >= nextBegin) { // Overlap!
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // No overlap, add the new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        System.out.print("Original Intervals: ");
        for(int[] i : intervals) System.out.print(Arrays.toString(i) + " ");
        
        System.out.print("\nMerged Intervals: ");
        for(int[] i : merged) System.out.print(Arrays.toString(i) + " ");
        System.out.println("\n");
    }

    /**
     * 5. GROUP ANAGRAMS (HashMap + Strings)
     * ---------------------------------------------------------
     * USE CASE: You have thousands of log entries or API search queries, and 
     * you want to cluster/group similar search queries that contain the exact 
     * same characters, just in different orders.
     * 
     * EXPLANATION: Sort the letters of each word. "eat" becomes "aet". "tea" 
     * also becomes "aet". We use "aet" as the Key in a HashMap, and store a 
     * List of the original words as the Value!
     * Time: O(N * K log K) where N is words and K is max word length.
     */
    public static void solveGroupAnagrams() {
        System.out.println("--- 5. Group Anagrams ---");
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // Sort letters alphabetically
            String sortedWord = new String(chars);
            
            // If the map doesn't have this sorted key yet, add an empty list
            map.putIfAbsent(sortedWord, new ArrayList<>());
            // Add the original word to the list
            map.get(sortedWord).add(word); 
        }

        System.out.println("Input Words: " + Arrays.toString(strs));
        System.out.println("Grouped Anagrams: " + map.values());
        System.out.println();
    }

    /**
     * 6. LRU CACHE (LinkedHashMap / System Design)
     * ---------------------------------------------------------
     * USE CASE: You are building a mock API server for your automation framework. 
     * You want it to cache the last 3 database queries to return them instantly, 
     * but if a 4th query comes in, it must delete the "Least Recently Used" (LRU) query.
     * 
     * EXPLANATION: Java's LinkedHashMap has a built-in method called `removeEldestEntry`.
     * By overriding it, we can create a fully functional LRU cache in just a few lines!
     */
    public static void simulateLRUCache() {
        System.out.println("--- 6. LRU Cache Simulation ---");
        
        final int CACHE_CAPACITY = 3;
        
        // true = access-order (moves accessed items to the end of the list)
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>(CACHE_CAPACITY, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > CACHE_CAPACITY; // Delete oldest if we exceed capacity!
            }
        };
        
        cache.put(1, "Mock Response A");
        cache.put(2, "Mock Response B");
        cache.put(3, "Mock Response C");
        System.out.println("Cache full: " + cache);
        
        // We read Key 1. It is now the "Most Recently Used"!
        cache.get(1); 
        System.out.println("Read Key 1 (Moves to end): " + cache);
        
        // We add Key 4. The cache is full! It will delete Key 2 (Least Recently Used).
        cache.put(4, "Mock Response D");
        System.out.println("Added Key 4 (Key 2 gets deleted): " + cache);
    }
}