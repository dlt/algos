import java.io.*;
import java.util.*;

/**
 * Bracket Match
 * A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.
 * <p>
 * Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.
 * <p>
 * Explain the correctness of your code, and analyze its time and space complexities.
 * <p>
 * Time Complexity: O(N), where N is the length of text. We go through every character of text and for every character we carry out a constant number of steps.
 * <p>
 * Space Complexity: O(1) since we only used a constant amount of space throughout the algorithm.
 */
class Solution {

    static int bracketMatch(String text) {
        int openBrackets = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ')' && openBrackets <= 0) {
                openBrackets--;

            } else if (openBrackets < 0 && text.charAt(i) == '(') {
                openBrackets--;

            } else {

                if (text.charAt(i) == '(') {
                    openBrackets++;
                } else {
                    openBrackets--;
                }
            }
        }
        return Math.abs(openBrackets);
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("(("));
        System.out.println(bracketMatch("(())"));
        System.out.println(bracketMatch("()))(("));
    }
}