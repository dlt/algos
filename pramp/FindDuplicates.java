import java.io.*;
import java.util.*;

/*
Find The Duplicates
Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space complexities of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.
*/
class Solution {
    // Time: O(N + M)
    // Space: O(N)
    static int[] _findDuplicates(int[] arr1, int[] arr2) {
        int len1 = arr1.length; // 3 [1, 2, 9000]
        int len2 = arr2.length; // 300.000 [1, 2, .................. 9000]
        int i1 = 0, i2 = 0;

        List<Integer> result = new ArrayList<>();

        // a1[1, 2, 3] a2[2,3]
        // i1 - 2 i2 1
        while (i1 < len1 && i2 < len2) {
            int left = arr1[i1]; //2
            int right = arr2[i2]; //2


            if (left == right) {
                result.add(left); // add
                i1++;
                i2++;
            } else if (left < right) {
                i1++;
            } else {
                i2++;
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);

        return res;

    }

    // Time: O(N(log(M)))
    // Space: O(N)
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        List<Integer> duplicates = new ArrayList<>();
        for (int num : arr1) {
            if (binarySearch(arr2, num) != -1) {
                duplicates.add(num);
            }
        }
        return duplicates.stream().mapToInt(i -> i).toArray();
    }

    static int binarySearch(int[] haystack, int needle) {
        int begin = 0;
        int end = haystack.length - 1;
        int mid;

        while (begin <= end) {
            mid = begin + (int) Math.floor((end - begin) / 2);
            if (haystack[mid] == needle) return mid;

            if (haystack[mid] < needle) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}