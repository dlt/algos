import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        List<String> lines = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String spaces = buildSpaces(n - i);
            String steps = new String(new char[i]).replace("\0", "#");
            System.out.println(spaces + steps);
        }
    }

    static String buildSpaces(int n) {
        if (n == 0) return "";
        return new String(new char[n]).replace("\0", " ");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        staircase(n);
        scanner.close();
    }
}
