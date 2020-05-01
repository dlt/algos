import java.io.*;
import java.util.*;

/*

You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid. The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n, the size of the grid’s axes, write a function numOfPathsToDest that returns the number of the possible paths the driverless car can take.

*/
class Solution {

    static int numOfPathsToDest(int n) {
        return findPath(0, 0, n);
    }

    static int findPath(int i, int j, int n) {
        if (i >= n || j >= n) return 0;
        if (i >= j) {
            if (i == n - 1 && j == n - 1) {
                return 1;
            }
            // 1, 0 -> 2, 0, 3, 0
            // 0, 1 ->
            // i >= j
            if (i >= j) {
                return findPath(i + 1, j, n) + findPath(i, j + 1, n);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}