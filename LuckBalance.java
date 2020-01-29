import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static class Contest {
        public boolean isImportant;
        public int luck;

        public Contest(int luck, int important) {
            this.luck = luck;
            this.isImportant = important == 1;
        }

    }

    private static class ContestComparator implements Comparator<Contest> {
        public int compare(Contest dis, Contest dat) {
            if (dis.isImportant && dat.isImportant) {
                return 10 * (dat.luck - dis.luck);
            }
            if (!dis.isImportant && dat.isImportant) {
                return -1;
            }
            return 1;
        }
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        List<Contest> contestsList = new ArrayList<>();
        for (int i = 0; i < contests.length; i++) {
            int[] contestData = contests[i];
            contestsList.add(new Contest(contestData[0], contestData[1]));
        }

        Collections.sort(contestsList, new ContestComparator());
        int firstImportantIndex = 0;

        for (int i = 0; i < contestsList.size(); i++) {
            firstImportantIndex = i;
            if (contestsList.get(i).isImportant) {
                break;
            }
        }

        int totalLuck = 0;
        int winIndex;
        
        if (k == 0) {
            if (firstImportantIndex == 0) {
                winIndex = 0;
            } else {
                winIndex = contestsList.size();
            } 
         } else {
             winIndex = firstImportantIndex + k;
         }

        for (int i = 0; i < contestsList.size(); i++) {
            Contest contest = contestsList.get(i);

            if (i < winIndex) {
                totalLuck += contest.luck;
            } else {
                totalLuck -= contest.luck;
            }
        }
        return totalLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
