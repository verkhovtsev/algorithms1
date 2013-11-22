
public class Percolation {
    private WeightedQuickUnionUF grid;
    private int n, size, top, bottom;
    private int[][] sites;

    public Percolation(int N) {              // create N-by-N grid, with all sites blocked
        n = N;
        size = n * n;
        grid = new WeightedQuickUnionUF(size + 2);
        top = size;
        bottom = size + 1;
        sites = new int[n][n];
        connectTopAndBottom();

    }

    private void connectTopAndBottom() {
        for (int i = 0; i < n; i++) {
            grid.union(top, i);
            grid.union(bottom, size - i - 1);
        }
    }

    public void open(int i, int j) {        // open site (row i, column j) if it is not already
        if (!isOpen(i, j)) {
            sites[i - 1][j - 1] = 1;
            int p = number(i, j);
            connectIfExist(p, i - 1, j);
            connectIfExist(p, i + 1, j);
            connectIfExist(p, i, j - 1);
            connectIfExist(p, i, j + 1);
        }
    }

    private void connectIfExist(int p, int i, int j) {
        if (i >= 1 && i <= n && j >= 1 && j <= n && isOpen(i, j)) {
            grid.union(p, number(i, j));
        }
    }

    public boolean isOpen(int i, int j) {   // is site (row i, column j) open?
        check(i, j);
        return sites[i - 1][j - 1] == 1;
    }

    public boolean isFull(int i, int j) {   // is site (row i, column j) full?
        //printSites();

        if (isOpen(i, j) && grid.connected(top, number(i, j))) {
            if (n > 1 && i == n) {
                for (int k = j; k > 0; k--) {
                    if (sites[i - 1][k - 1] == 1) {
                        if (isFull(i - 1, k)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
                for (int k = j + 1; k <= n; k++) {
                    if (sites[i - 1][k - 1] == 1) {
                        if (isFull(i - 1, k)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean percolates() {           // does the system percolate?
        return n == 1 ? isOpen(1, 1) : grid.connected(top, bottom);
    }

    private int number(int i, int j) {
        return (i - 1) * n + (j - 1);
    }

    private void check(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new IndexOutOfBoundsException("i and j must be within [1, " + n + "], actual: " + i + " " + j);
        }
    }

    private void printSites() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sites[i][j] + " ");
            }
            System.out.println();
        }
    }
}