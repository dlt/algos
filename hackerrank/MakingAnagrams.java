import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        Map<String, Integer> s1Letters = new HashMap<>();
        for (char c : s1.toCharArray()) {
            String s = "" + c;
            Integer count = s1Letters.get(s);
            if (count == null) {
                count = 0;
            }
            s1Letters.put(s, count + 1);
        }

        Map<String, Integer> s2Letters = new HashMap<>();
        for (char c : s2.toCharArray()) {
            String s = "" + c;
            Integer count = s2Letters.get(s);
            if (count == null) {
                count = 0;
            }
            s2Letters.put(s, count + 1);
        }
        Set<String> allLetters = new HashSet<>();

        allLetters.addAll(s1Letters.keySet());
        allLetters.addAll(s2Letters.keySet());

        int deletions = 0;
        for (String s : allLetters) {

            Integer count1 = s1Letters.get(s) == null ? 0 : s1Letters.get(s);
            Integer count2 = s2Letters.get(s) == null ? 0 : s2Letters.get(s);

            deletions += Math.abs(count1 - count2);
        }

        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
