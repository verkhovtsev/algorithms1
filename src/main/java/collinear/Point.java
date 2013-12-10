import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    // the point (x1, y1) is less than the point (x2, y2) if and only if the slope (y1 − y0) / (x1 − x0)
    // is less than the slope (y2 − y0) / (x2 − x0).
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            double s01 = Point.this.slopeTo(o1);
            double s02 = Point.this.slopeTo(o2);

/*            if (s01 == s02 && s02 == Double.NEGATIVE_INFINITY) return 0;
            else if (s01 == s02 && s02 == Double.POSITIVE_INFINITY) return 0;
            else if (s01 == s02 && s02 == +0.0) return +0;
            else*/ return Double.compare(s01, s02);
        }
    };       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
//point (x0, y0) is less than (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1
    public int compareTo(Point that) {               // is this point lexicographically smaller than that point?
        if (y == that.y && x == that.x) return 0;
        else if (y < that.y || (y == that.y && x < that.x)) return -1;
        else return 1;
    }
//point (x0, y0) and the argument point (x1, y1), which is given by the formula (y1 − y0) / (x1 − x0)
    public double slopeTo(Point that) {                 // the slope between this point and that point
        if (y == that.y && x == that.x) return Double.NEGATIVE_INFINITY;
        else if (x == that.x)           return Double.POSITIVE_INFINITY;
        else if (y == that.y)           return (+0.0);
        else                            return ((double) (that.y - y)) / ((double)(that.x - x));
    }
}