import java.io.*;
import java.util.*;

/*
Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
*/
class Solution {

    /*
    Time: O(n)
    Space: O(n)
    */
    static int _getDifferentNumber(int[] arr) {
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            visited.add(arr[i]);
        }

        for (int i = 0; i < Integer.MAX_VALUE - 1; i++) {
            if (!visited.contains(i)) return i;
        }

        return Integer.MAX_VALUE;
    }

    /*
    Time: O(n)
    Space: O(1)
    */
    static int getDifferentNumber(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int num = arr[i];
            // each number is moved at most once
            while (num < len && arr[num] != num) {
                int temp = arr[num];
                arr[num] = num;
                num = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != i) return i;
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(getDifferentNumber(new int[]{1, 2, 3, 7, 10}));
        System.out.println(getDifferentNumber(new int[]{0, 1, 2, 3, 7, 10}));
    }
}