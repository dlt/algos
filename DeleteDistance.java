import java.io.*;
import java.util.*;

class Solution {

  //  str1 = "abcd" str2 = "efghaa"
  //  8 char
  /*
    hash1 = str1.chars
    hash2 = str2.chars
    
    // {a: 1, b: 1, c: 1, d: 1}

    deletions = 0
    while str1 != str2:
      for char in str1:
        if !str2.contains char or str2.contains(char) and str1[char] != str2[char] //n = str2[char] - str1[char]
           str2.delete(char) // n times
           deletions += n


      for char in str2:
        if !str1.contains char or str1.contains(char) and str1[char] != str2[char] //n = str2[char] - str1[char]
           str1.delete(char) // n times
           deletions += n
           
        Map<Character, Integer> h1 = new HashMap<>();
    Map<Character, Integer> h2 = new HashMap<>();
    

    for (char c: str1.toCharArray())
      h1.put(Character.valueOf(c), h1.getOrDefault(c, 0) + 1);
    
    for (char c: str2.toCharArray())
      h2.put(Character.valueOf(c), h2.getOrDefault(c, 0) + 1);
    
    
    HashSet<Character> s1 = new HashSet<Character>();
    for (char c: str1.toCharArray())
      s1.add(c);
    
    HashSet<Character> s2 = new HashSet<Character>();
    for (char c: str2.toCharArray())
      s2.add(c); 
    
    
    int deletions = 0;
    int n = 0;  
    Set<Character> visited =new HashSet<Character>();
    for (char c: s1) {
      if (!s2.contains(Character.valueOf(c))) {
        n = h1.get(Character.valueOf(c));    
      } else if (s2.contains(Character.valueOf(c))) {
        n = Math.abs(h1.get(Character.valueOf(c)) - h2.get(Character.valueOf(c)));
      }
      deletions += n;
    }
    
    for (char c: s2) {
      if (!s1.contains(Character.valueOf(c))) {
        n = h2.get(Character.valueOf(c));    
      } else if (s1.contains(Character.valueOf(c))) {
        n = Math.abs(h2.get(Character.valueOf(c)) - h1.get(Character.valueOf(c)));
      }
      deletions += n;
    }
    
    return deletions;       

  */

  static int deletionDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    // if one of the strings is empty
    if (n * m == 0)
      return n + m;

    int [][] d = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0) {
          d[i][j] = j;
        } else if (j == 0) {
          d[i][j] = i;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          d[i][j] = d[i-1][j-1];
        } else {
          d[i][j] = Math.min(d[i-1][j],d[i][j-1]) + 1;
        }
      }
    }
    
    return d[n][m];
  }      
  
  public static void main(String[] args) {
    System.out.println(deletionDistance("", ""));
    System.out.println(deletionDistance("aa", "a"));
    System.out.println(deletionDistance("aab", "ab"));
  }

}