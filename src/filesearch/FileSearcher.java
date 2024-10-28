package filesearch;
/**
 * Extract consists of methods that extract information from a list of tweets.
 */import java.io.File;

public class FileSearcher {

    /**
     * Main method to handle command-line input, validate input, and initiate file search.
     * @param args Command-line arguments: args[0] = directory path, args[1] = file name(s) to search for.
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileSearcher <directory_path> <file_name(s)> [case_sensitive]");
            return;
        }

        String directoryPath = args[0];
        String[] fileNames = args[1].split(",");
        boolean caseSensitive = args.length > 2 && args[2].equalsIgnoreCase("true");

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist or is not a directory.");
            return;
        }

        for (String fileName : fileNames) {
            int count = searchForFile(directory, fileName, caseSensitive);
            if (count > 0) {
                System.out.println("Found " + fileName + " " + count + " time(s).");
            } else {
                System.out.println(fileName + " not found.");
            }
        }
    }

    /**
     * Recursively searches for a specified file within a directory and its subdirectories.
     * @param directory The root directory to start searching from.
     * @param fileName The file name to search for.
     * @param caseSensitive Whether the search should be case-sensitive.
     * @return The count of occurrences of the specified file name.
     */
    public static int searchForFile(File directory, String fileName, boolean caseSensitive) {
        int count = 0;

        File[] files = directory.listFiles();
        if (files == null) {
            return 0;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                count += searchForFile(file, fileName, caseSensitive);
            } else {
                String currentFileName = caseSensitive ? file.getName() : file.getName().toLowerCase();
                String searchFileName = caseSensitive ? fileName : fileName.toLowerCase();
                if (currentFileName.equals(searchFileName)) {
                    System.out.println("Found: " + file.getAbsolutePath());
                    count++;
                }
            }
        }
        return count;
    }
}
