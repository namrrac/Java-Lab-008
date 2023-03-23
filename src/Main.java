/**
 * @author Trevor Horton
 * @author Jason Carr
 *
 * @since Version 1.0
 */


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        Path filePath;
        while (true) {
            System.out.print("Enter the path to a file or Q to quit: ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            filePath = Paths.get("resources", input);
            System.out.println(filePath.toAbsolutePath());

            // Ask the user if they would like to skip whitespace
            System.out.print("Should we skip whitespace (y/n): ");
            // Create a variable called skipWs that stores the user's response as a boolean
            String yn = scanner.nextLine();
            boolean skipWs = false;
            if (yn.equals("y")) {
                skipWs = true;
                System.out.println("Skipping whitespace.");
            } else {
                System.out.println("Not skipping whitespace.");
            }
            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats fileStats = new FileStats(filePath.toFile(), skipWs);
                // You will need to call the fs.read method, which you need to implement!
                fileStats.read();
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
                int lines = fileStats.getNumLines();
                int words = fileStats.getNumWords();
                int chars = fileStats.getNumChars();
                String name = fileStats.getFileName();

                System.out.printf("lines - %d, words - %d, chars - %d %s%n", lines, words, chars, name);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}



