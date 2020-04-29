import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int hourglassSum(int[][] arr) {
        List<Integer> hourglassSums = new ArrayList<>();
        Integer max = null;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Integer[] hourglass = hourglassFields(i, j, arr);
                Integer sum = Arrays.asList(hourglass).stream().mapToInt(Integer::intValue).sum();

                if (max == null || max < sum) {
                    max = sum;
                }
            }
        }
        
        return max;
    }

    static Integer[] hourglassFields(int i, int j, int[][]arr) {
        return new Integer[] { arr[i][j], arr[i][j + 1], arr[i][j + 2], arr[i + 1][j + 1], arr[i + 2][j], arr[i + 2][j + 1], arr[i + 2][j + 2] };
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
