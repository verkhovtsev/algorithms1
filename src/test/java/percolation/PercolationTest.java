import org.junit.Test;

import static junit.framework.Assert.*;


public class PercolationTest {

    private Percolation percolation;

    //@Test
    public void should_create_percolation() {
        percolation = new Percolation(10);
        assertNotNull(percolation);

    }

    @Test
    public void should_not_be_full() {
        Percolation percolation = new Percolation(10);
        assertFalse(percolation.isFull(2, 10));
    }

    @Test
    public void input2no() {
        preparePercolation("input2-no.txt", 0, false);
        assertFalse(percolation.percolates());
    }

    @Test
    public void input1() {
        preparePercolation("input1.txt", 0, false);
        assertTrue(percolation.percolates());
    }
    @Test
    public void input2() {
        preparePercolation("input2.txt", 0, false);
        assertTrue(percolation.percolates());
    }
    @Test
    public void input6() {
        preparePercolation("input6.txt", 0, false);
        assertTrue(percolation.percolates());
    }
    @Test
    public void input10() {
        preparePercolation("input10.txt", 0, false);
        assertTrue(percolation.percolates());
    }
    @Test
    public void input8no() {
        preparePercolation("input8-no.txt", 0, false);
        assertFalse(percolation.percolates());
    }

    @Test
    public void input10no() {
        preparePercolation("input10-no.txt", 0, false);
        assertFalse(percolation.percolates());
    }
    @Test
    public void input20() {
        preparePercolation("input20.txt", 0, false);
        assertTrue(percolation.percolates());
    }

    @Test
    public void input50() {
        preparePercolation("input50.txt", 0, false);
        assertTrue(percolation.percolates());
    }


    @Test
    public void greeting_57() {
        preparePercolation("greeting57.txt", 0, false);
        assertFalse(percolation.percolates());
    }

    @Test
    public void input1no() {
        preparePercolation("input1-no.txt", 0, false);
        assertFalse(percolation.percolates());
    }

    @Test
    public void input7() {
        preparePercolation("input7.txt", 12, false);
        assertFalse(percolation.percolates());
    }

//    *  filename = input7.txt
//                  isFull(6, 1) returns wrong value [after 12 total calls to open()]
//            - student   = true
//            - reference = false

    private void preparePercolation(String path, int ii, boolean exp) {
        int[] ints = In.readInts(path);
        System.out.println("\n" + "File: "+ path + " length = " + ints.length + ", n = " + ints[0]);
        if(ints.length % 2 == 0) {
            throw new IllegalStateException("File: " + path + " has incorrect int numbers");
        }

//        System.out.println("Creating percolation.Percolation with " + ints[i]);
        percolation = new Percolation(ints[0]);
        int k=1;
        for(int i=1; i<ints.length; i=i+2 ) {

            System.out.print(ints[i] + " " + ints[i+1] + " | ");
            percolation.open(ints[i], ints[i+1]);
            if(ii > 0 && k == ii) {
                //percolation.printSites();
                assertFalse(percolation.isFull(6, 1));
            }
            k++;
        }

    }

}
