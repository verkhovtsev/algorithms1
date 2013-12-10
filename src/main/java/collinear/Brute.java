
public class Brute {

    public static void main(String[] args) {
        Point[] points = readAndDrawPoints(args[0]);

        //p→q→r→s
        int len = points.length, p=0, q, r, s;
        while (p < len) {
            q = p+1;
            while (q < len) {

                if (q != p) {
                    r=q+1;
                    while (r < len) {
                        if (r != p && r != q) {
                            s=r+1;
                            while (s < len) {
                                if (s != p && s != q && s != r) {
                                    double pq = points[p].slopeTo(points[q]),
                                           pr = points[p].slopeTo(points[r]),
                                           ps = points[p].slopeTo(points[s]);
                                    if (pq == pr && pr == ps) {
                                        points[p].drawTo(points[q]);
                                        points[p].drawTo(points[r]);
                                        points[p].drawTo(points[s]);
                                        StdOut.printf("%s -> %s -> %s -> %s \n", points[p], points[q], points[r], points[s]);
                                    }
                                }
                                s++;
                            }
                        }
                        r++;
                    }
                }
                q++;
            }
            p++;
        }

    }

    private static Point[] readAndDrawPoints(String path) {
        StdOut.println("==============================================================");
        StdOut.printf("path = [%s]\n", path);
//        int[] coords = In.readInts("horizontal5.txt");
        int[] coords = In.readInts(path);
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
