package eu.jpereira.regex;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.security.x509.IPAddressName;

public class RegexTest {

    public static void main(String... args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console found");
            System.exit(0);
        }

        while (true) {
            
            String inputMessage = "%nEnter the RegEx: ";
            String inputRegex = console.readLine(inputMessage);
            
            String input = console.readLine("Enter the String to search: ");
            Pattern pattern = Pattern.compile(inputRegex);
            
            Matcher matcher = pattern.matcher(input);
            boolean found = false;
            while (matcher.find()) {
                
                console.format("Found %s starting at %d and ending at %d.%n", matcher.group(), matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found) {
                System.err.println("No matches found!!");
            }
        }

    }
}
