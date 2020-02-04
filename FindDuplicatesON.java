import java.io.*;
import java.util.*;

class Solution {
   /*n * O(log(m))
   O(M+N) = O(N^c + N) = O(N^c)
   O(N*logN^c)= O(C*N*logN) = O(NlogN)
   M=N^c*/
  static int[] findDuplicates(int[] arr1, int[] arr2) {
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

  public static void main(String[] args) {

  }

}