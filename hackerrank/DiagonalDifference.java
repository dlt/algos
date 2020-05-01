import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     * 1 2 3 4   1' 2 3 4 5 6' 7 8 9 1 2' 3 4 5 6 7'
     * 5 6 7 8
     * 9 1 2 3
     * 4 5 6 7
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int[] leftDiagonal = new int[size];

        for (int i = 0, j = 0; i < size; i++, j = i + 1) {
            if (j > i) j = i;
            leftDiagonal[i] = arr.get(i).get(j);
        }

        int[] rightDiagonal = new int[size];
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            rightDiagonal[j] = arr.get(i).get(j);
        }
        //System.out.println(Arrays.toString(rightDiagonal));

        return Math.abs(Arrays.stream(leftDiagonal).sum() - Arrays.stream(rightDiagonal).sum());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
