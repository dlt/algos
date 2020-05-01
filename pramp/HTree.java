
import java.util.*;

class Main {
    //drawLine(x1, y1, x2, y2)
  /*(x1,y1)            (x2,y1)
  *        |       |
    (x1,y) |___ ___| (x2,y)
           | (x,y) |
    (x1,y2)|       | (x2,y2)
  */
    void drawHTree(double x, double y, double length, int depth) {
        if (depth > 0) {
            double halfOfLength = length / 2.0;

            double x1 = x - halfOfLength;
            double x2 = x + halfOfLength;

            drawLine(x1, y, x2, y);

            double y1 = y - halfOfLength;
            double y2 = y + halfOfLength;

            drawLine(x1, y1, x1, y2);
            drawLine(x2, y1, x2, y2);

            double sqrt = Math.sqrt(length);

            drawHTree(x1, y1, sqrt, depth - 1);
            drawHTree(x1, y2, sqrt, depth - 1);
            drawHTree(x2, y1, sqrt, depth - 1);
            drawHTree(x2, y2, sqrt, depth - 1);
        }
    }

    static public void main(String args[]) {
        System.out.println("Practice makes Perfect!");
    }
}
