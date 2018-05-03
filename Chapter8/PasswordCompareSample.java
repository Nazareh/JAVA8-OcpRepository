import java.io.*;
import java.util.*;
public class PasswordCompareSample {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            char[] password = console.readPassword("Enter your password: ");
            console.format("Enter your password again: ");
            char[] verify = console.readPassword();
            boolean match = Arrays.equals(password,verify);

            Arrays.fill(password,'x');
            Arrays.fill(verify,'x');

            console.format("Your password was "+(match ? "correct." : "incorrect."));

        }
    }
}