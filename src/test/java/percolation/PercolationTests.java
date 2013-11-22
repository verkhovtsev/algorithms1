import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PercolationTests {

    @Test
    public void input6() {
        Percolation percolation = new Percolation(6);
        percolation.open(1, 6);
        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.open(4, 6);
        percolation.open(5, 6);
        percolation.open(5, 5);
        percolation.open(4, 4);
        percolation.open(3, 4);
        percolation.open(2, 4);
        percolation.open(2, 2);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(5, 2);
        percolation.open(6, 2);
        percolation.open(5, 4);
        percolation.open(2, 3);

        assertTrue(percolation.percolates());
        //assertTrue(percolation.isFull(6,2));
    }

    @Test
        public void input3() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);
        assertFalse(percolation.isFull(3,1));
        percolation.open(2, 1);
        percolation.open(1, 1);

        assertTrue(percolation.percolates());
        //assertTrue(percolation.isFull(6,2));
    }

    @Test
    public void input2() {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        percolation.open(1, 2);
        assertTrue(percolation.isFull(2,2));

        assertTrue(percolation.percolates());
        //assertTrue(percolation.isFull(6,2));
    }

//    *  filename = input3.txt
//                  isFull(3, 1) returns wrong value [after 4 total calls to open()]

}
