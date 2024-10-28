package filesearch;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class RecursiveStringPermutation {

    /**
     * Main method to test the generatePermutations method with sample input.
     * @param args command-line arguments (not used here).
     */
    public static void main(String[] args) {
        String input = "ABC";
        boolean includeDuplicates = false; // Set to true to include duplicate permutations

        List<String> permutations = generatePermutations(input, includeDuplicates);
        System.out.println("Permutations of \"" + input + "\": " + permutations);
    }

    /**
     * Generates all permutations of the given string using a recursive approach.
     * @param str The input string for which permutations are generated.
     * @param includeDuplicates Flag indicating whether duplicate permutations should be included.
     * @return List of permutations.
     */
    public static List<String> generatePermutations(String str, boolean includeDuplicates) {
        List<String> results = new ArrayList<>();
        
        if (str == null || str.isEmpty()) {
            System.out.println("Input string is empty or null.");
            return results;
        }

        if (includeDuplicates) {
            generatePermutationsHelper(str, "", results);
        } else {
            Set<String> uniquePermutations = new HashSet<>();
            generatePermutationsHelper(str, "", uniquePermutations);
            results.addAll(uniquePermutations);
        }

        return results;
    }

    /**
     * Recursive helper method to generate permutations without duplicate elimination.
     * @param str Remaining string to permute.
     * @param prefix Current permutation being formed.
     * @param results List to store generated permutations.
     */
    private static void generatePermutationsHelper(String str, String prefix, List<String> results) {
        if (str.isEmpty()) {
            results.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String remaining = str.substring(0, i) + str.substring(i + 1);
                generatePermutationsHelper(remaining, prefix + str.charAt(i), results);
            }
        }
    }

    /**
     * Recursive helper method to generate unique permutations by using a Set to avoid duplicates.
     * @param str Remaining string to permute.
     * @param prefix Current permutation being formed.
     * @param uniquePermutations Set to store unique permutations.
     */
    private static void generatePermutationsHelper(String str, String prefix, Set<String> uniquePermutations) {
        if (str.isEmpty()) {
            uniquePermutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String remaining = str.substring(0, i) + str.substring(i + 1);
                generatePermutationsHelper(remaining, prefix + str.charAt(i), uniquePermutations);
            }
        }
    }
}
