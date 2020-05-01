import java.io.*;
import java.util.*;

/*
Pancake Sort
Given an array of integers arr:

Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.
*/
class Solution {

    static void flip(int[] arr, int k) {
        int pivot = (int) Math.floor((k + 1) / 2);
        for (int i = 0; i < pivot; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = temp;
        }
    }

    static int findMaxIndexInPrefix(int[] haystack, int limit) {
        int index = 0;
        for (int i = 0; i <= limit; i++) {
            if (haystack[i] > haystack[index]) {
                index = i;
            }
        }
        return index;
    }

    // 1 3 1
    static int[] pancakeSort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            int maxIndex = findMaxIndexInPrefix(arr, i);
            flip(arr, maxIndex);
            flip(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1};
        pancakeSort(arr);
    }
}