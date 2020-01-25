import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float zeroes = 0;
        float positives = 0;
        float negatives = 0;

        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if (item == 0) zeroes++;
            if (item < 0) negatives++;
            if (item > 0) positives++;
        };
        float length = (float) arr.length;

        float fractionZ = zeroes == 0 ? zeroes : zeroes / length;
        float fractionP = positives == 0 ? positives : positives / length; 
        float fractionN = negatives == 0 ? negatives : negatives / length;


        System.out.println(fractionP);
        System.out.println(fractionN);
        System.out.println(fractionZ);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
