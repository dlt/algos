import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String sumStringChars(String s) {
        return Integer.toString(Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum());
    }

    static int superDigit(String n, int k) {
        String input = n;
        String result = "";
        
  
        result = result + n;
        while (result.length() > 1) {
            result = sumStringChars(result);
        }

        result = buildString(result, k);
        while (result.length() > 1) {
            result = sumStringChars(result);
        }
    
        return Integer.parseInt(result);
    }

    static String buildString(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
