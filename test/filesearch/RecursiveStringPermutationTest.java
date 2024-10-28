package filesearch;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;


public class RecursiveStringPermutationTest {

    @Test
    public void testPermutationsWithDistinctCharacters() {
        String input = "ABC";
        List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Check that the result contains all expected permutations
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
        assertEquals(expected.size(), result.size()); // Confirm no duplicates
    }

    @Test
    public void testPermutationsWithDuplicatesIncluded() {
        String input = "AAB";
        List<String> expected = Arrays.asList("AAB", "ABA", "BAA", "AAB", "ABA", "BAA");
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Check that result contains all expected permutations including duplicates
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testPermutationsWithDuplicatesExcluded() {
        String input = "AAB";
        List<String> expected = Arrays.asList("AAB", "ABA", "BAA");
        List<String> result = RecursiveStringPermutation.generatePermutations(input, false);

        // Check that result contains only unique permutations
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
        assertEquals(expected.size(), result.size()); // Confirm duplicates are excluded
    }

    @Test
    public void testEmptyString() {
        String input = "";
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Expected to be empty list since input is empty
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullString() {
        String input = null;
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Expected to be empty list since input is null
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacterString() {
        String input = "A";
        List<String> expected = Arrays.asList("A");
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Single character should only produce one permutation
        assertEquals(expected, result);
    }

    @Test
    public void testPerformanceWithLargerInput() {
        String input = "ABCD"; // This has 4! = 24 permutations
        List<String> result = RecursiveStringPermutation.generatePermutations(input, true);

        // Check if we have exactly 24 permutations
        assertEquals(24, result.size());
    }
}
