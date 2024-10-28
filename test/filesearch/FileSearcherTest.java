/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package filesearch;

import static org.junit.Assert.*;
import org.junit.Test;



import java.io.File;

public class FileSearcherTest {

    @Test
    public void testFileFound() {
        File testDir = new File("C:\\Users\\Ahmar Kamran\\OneDrive\\Desktop"); // Assume testDirectory contains the test files
        int count = FileSearcher.searchForFile(testDir, "textfile.txt", true);
        assertEquals(2, count); // Assuming only one instance of testFile.txt
    }

    @Test
    public void testFileNotFound() {
        File testDir = new File("C:\\Users\\Ahmar Kamran\\OneDrive\\Desktop");
        int count = FileSearcher.searchForFile(testDir, "nonExistentFile.txt", true);
        assertEquals(0, count);
    }

    @Test
    public void testCaseInsensitiveSearch() {
        File testDir = new File("C:\\Users\\Ahmar Kamran\\OneDrive\\Desktop");
        int count = FileSearcher.searchForFile(testDir, "TextFile.TXT", false);
        assertEquals(2, count); // Assuming case-insensitive match
    }

    @Test
    public void testMultipleOccurrences() {
        File testDir = new File("C:\\Users\\Ahmar Kamran\\OneDrive\\Desktop"); // Assume multiple instances of testFile.txt exist
        int count = FileSearcher.searchForFile(testDir, "textfile.txt", true);
        assertEquals(2, count); // Assuming 2 occurrences
    }
}
