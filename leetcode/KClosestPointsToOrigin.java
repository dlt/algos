class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance() {
            int xx = Math.abs(x);
            int yy = Math.abs(y);
            return Math.sqrt(xx * xx + yy * yy);
        }

        public int compareTo(Point other) {
            if (distance() == other.distance()) return 0;

            if (distance() > other.distance()) return 1;

            return -1;
        }

    }


    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> q = new PriorityQueue<Point>();

        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            q.add(new Point(p[0], p[1]));
        }

        int[][] result = new int[K][2];
        int i = 0;

        while (i < K) {
            Point p = q.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }

        return result;
    }
}