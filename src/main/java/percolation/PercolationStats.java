
public class PercolationStats {

    private double[] xt;
    private int N, T;
    private Double m, s, lo, hi;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <=0 ){
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;
        xt = runTests();
//        for (int i = 0; i < T; i++) {
//            System.out.print(xt[i] + " | ");
//        }
//        System.out.println();
    }

    private double[] runTests() {
        double[] xt = new double[T];
        for (int t = 0; t < T; t++) {
            Percolation percolation = new Percolation(N);
            int opened = 0;
            do {
                int i, j;
                do {
                    i = StdRandom.uniform(1, N + 1);
                    j = StdRandom.uniform(1, N + 1);
                } while (percolation.isOpen(i, j));
                percolation.open(i, j);
                opened++;

            } while (!percolation.percolates());
//            percolation.printSites();
//            System.out.println();
            xt[t] = new Double(opened) / (N * N);
        }
        return xt;  //To change body of created methods use File | Settings | File Templates.
    }

    // sample mean of percolation threshold
    public double mean() {
        if (m == null) {
            double sum = 0.0;
            for (int i = 0; i < T; i++) {
                sum += xt[i];
            }
            m = sum / T;
        }
        return m;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (s == null) {
            double m = mean();
            double sum = 0.0;
            for (int i = 0; i < T; i++) {
                sum += Math.pow((xt[i] - m), 2.0);
            }
            s = Math.sqrt(sum / (T - 1));
        }
        return s;
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        if (lo == null) {
            lo = mean() - ((1.96 * stddev()) / Math.sqrt(T));
        }
        return lo;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        if (hi == null) {
            hi = mean() + ((1.96 * stddev()) / Math.sqrt(T));
        }
        return hi;
    }

//        mean                    = 0.5929934999999997
//        stddev                  = 0.00876990421552567
//        95% confidence interval = 0.5912745987737567, 0.5947124012262428
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("===");
        }
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(stats);
    }

//    @Override
//    public String toString() {
//        StringBuffer buff = new StringBuffer();
//        buff.append(String.format("mean \t = %.16f \n", mean()));
//        buff.append(String.format("stddev \t = %.16f \n", stddev()));
//        buff.append(String.format("lo, hi \t = %.16f, %.16f \n", confidenceLo(), confidenceHi()));
//        return buff.toString();
//    }
}