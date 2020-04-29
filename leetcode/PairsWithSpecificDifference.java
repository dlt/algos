import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    HashMap<Integer, Integer> cache = new HashMap<>();
    ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
    
    
    for (int i = 0; i < arr.length; i++) {
      int x = arr[i];
      int y = x - k;
      cache.put(y, x);
    }
    // input = 4, 1
    // cache = [7, 4]
    
    for (int i = 0; i < arr.length; i++) {
      if (cache.containsKey(arr[i])) {
        ArrayList<Integer> pair = new ArrayList<>();
        
        pair.add(cache.get(arr[i]));
        pair.add(arr[i]);
        
        pairs.add(pair);
      }
    }
    
    int[][] result = new int[pairs.size()][2];
    int i = 0;
    
    for (List<Integer> pair: pairs) {
      result[i][0] = pair.get(0);
      result[i][1] = pair.get(1);
      i++;
    }
    
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findPairsWithGivenDifference(new int[] {0, -1, -2, 2, 1}, 1));
  }
}