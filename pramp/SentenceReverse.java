import java.io.*;
import java.util.*;

/*
Sentence Reverse
You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

Example:

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]
Constraints:

[time limit] 5000ms

[input] array.character arr

0 ≤ arr.length ≤ 100
[output] array.character


*/
class Solution {

    static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static char[] reverseWords(char[] arr) {
        int len = arr.length - 1;
        int i = 0;

        reverse(arr, 0, len);
        while (i < len) {
            int j = i + 1;
            while (j <= len && arr[j] != ' ') j++;

            if (i < j && j <= len + 1) {
                reverse(arr, i, j - 1);
            }

            if (j <= len && arr[j] == ' ')
                while (j <= len && arr[j] == ' ') j++;

            i = j;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseWords(new char[]{'p', 'u', 't', 'z', ' ', ' ', 'g', 'r', 'i', 'l', 'a'})));
    }

}
