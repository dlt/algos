import java.io.*;
import java.util.*;

/*
Array of Array Products
Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.

Solve without using division and analyze your solution’s time and space complexities.
*/
class Solution {
    // ans =  [24 12  8 6]
    // arr =  [1   2  3 4]
    // lefts= [1   1  2 6]
    // rights=[24 12  4 1]
    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr.length == 0) return arr;
        if (arr.length == 1) return new int[0];

        int[] lefts = new int[arr.length];
        int[] rights = new int[arr.length];

        lefts[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            lefts[i] = arr[i - 1] * lefts[i - 1];
        }

        rights[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            rights[i] = arr[i + 1] * rights[i + 1];
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = lefts[i] * rights[i];
        }

        return result;
    }

    public static void main(String[] args) {
    }

}