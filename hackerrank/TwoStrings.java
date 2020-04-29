import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int size = s2.length();
        Set<String> substrings = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                String sub = s1.substring(i, j + 1);
                substrings.add(sub);
            }
        }

        
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length() && i < j + 1; j++) {
                String sub = s2.substring(i, j + 1);
                if (substrings.contains(sub)) return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
