import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        final Stack<Character> brackets = new Stack<>();

        final char openSquare = '[';
        final char openCurly = '{';
        final char openParen = '(';
        final char closedSquare = ']';
        final char closedCurly = '}';
        final char closedParen = ')';


        for (char c : s.toCharArray()) {
            switch (c) {
                case openSquare:
                    brackets.push(c);
                    break;
                case openCurly:
                    brackets.push(c);
                    break;

                case openParen:
                    brackets.push(c);
                    break;

                case closedSquare:
                    if (!brackets.isEmpty() && brackets.peek() == openSquare) {
                        brackets.pop();
                    } else {
                        brackets.push(c);
                    }
                    break;

                case closedCurly:
                    if (!brackets.isEmpty() && brackets.peek() == openCurly) {
                        brackets.pop();
                    } else {
                        brackets.push(c);
                    }
                    break;
                case closedParen:
                    if (!brackets.isEmpty() && brackets.peek() == openParen) {
                        brackets.pop();
                    } else {
                        brackets.push(c);
                    }
                    break;
            }
        }

        if (brackets.isEmpty()) return "YES";

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
