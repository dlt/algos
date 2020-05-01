import java.io.*;
import java.util.*;
/*
In this question we’ll implement a function root that calculates the n’th root of a number. The function takes a nonnegative number x and a positive integer n, and returns the positive n’th root of x within an error of 0.001 (i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).
*/
class Solution {

  static double root(double x, int n) {
    if (x == 0) {
      return 0;
    }
    double start = 0.001;
    double end = Math.max(1, x);
    double mid = (end + start) / 2.0;

    while (end - start >= 0.001) {
      double pow = Math.pow(mid, n);
      if (pow > x) {
        end = mid;
      } else if (pow < x) {
        start = mid;
      } else {
        return mid;
      }
      mid = (end + start) / 2.0;
    }
    return mid;
  }

  public static void main(String[] args) {
  }
}