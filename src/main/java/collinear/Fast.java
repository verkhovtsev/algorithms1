
public class Fast {

    public static void main(String[] args) {
        Point[] points = readAndDrawPoints(args[0]);
    }

    private static Point[] readAndDrawPoints(String path) {
        StdOut.println("==============================================================");
        StdOut.printf("path = [%s]\n", path);
        int[] coords = In.readInts("horizontal5.txt");
//        int[] coords = In.readInts(path);
        int length = coords[0];

        Point[] points = new Point[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (coords[i] > max) max = coords[i];
        }
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, max);
        for(int i = 0; i < length; i++) {
            int x = coords[i * 2 + 1];
            int y = coords[i * 2 + 2];
            Point point = new Point(x, y);
            System.out.println(point);
            point.draw();
            points[i] = point;
        }
        StdOut.println("==============================================================");
        return points;
    }
}
