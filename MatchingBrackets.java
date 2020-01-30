import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static class Stack {
        char[] stack;
        int pointer = 0;

        public Stack(int size) {
            this.stack = new char[size];
        }

        public char peek() {
            return stack[pointer - 1];
        }

        public void push(char c) {
            stack[pointer] = c;
            pointer++;
        }

        public char pop() {
            char c = stack[pointer];
            pointer--;
            return c;
        }
    }

    static boolean bracketsMatch(char previous, char current) {
        return ((previous == '(' && current == ')') ||
                (previous == '[' && current == ']') ||
                (previous == '{' && current == '}'));
    }

    static boolean isOpeningBracket(char c) {
        return c == '{' || c == '(' || c == '[';
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack stack = new Stack(s.length());
        // {([])}
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (i == 0) {
                stack.push(current);
            } else {
                if (stack.pointer == 0) {
                    if (isOpeningBracket(current)) {
                        stack.push(current);
                    } else {
                        return "NO";
                    }
                } else {
                    char previous = stack.peek();
                    if (bracketsMatch(previous, current)) {
                        stack.pop();
                    } else {
                        stack.push(current);
                    }
                }
            }
        }
        return stack.pointer == 0 ? "YES" : "NO";
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
