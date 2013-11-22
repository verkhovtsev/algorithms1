
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomizedQueueTest {
    private RandomizedQueue<Integer> queue;
    @Before
    public void before() {
        queue = new RandomizedQueue<Integer>();
    }

    @Test
    public void first() {
        queue.enqueue(1);
        assert 1 == queue.size();
        assert 1 == queue.sample();
        assert 1 == queue.dequeue();
    }

    @Test
    public void second() {
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            Integer obj = new Integer(i);
            queue.enqueue(obj);
            nums.add(obj);
        }
        assert 10 == queue.size();
        for(int i = 0; i < 10; i++) {
            Integer n = queue.sample();
            assert nums.contains(n);
        }
        assert 10 == queue.size();
        for(int i = 0; i < 10; i++) {
            Integer n = queue.dequeue();
            assert 9 - i == queue.size();
            assert nums.contains(n);
        }
        assert 0 == queue.size();
    }
/*
    @Test
    public void third() {
        queue.addLast(2);
        queue.addLast(4);
        queue.addLast(5);

        assert 2 == queue.removeFirst();
        assert 4 == queue.removeFirst();
        assert 5 == queue.removeFirst();
        assert 0 == queue.size();
    }

    @Test
    public void fourth() {
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addFirst(0);

        assert 2 == queue.removeLast();
        assert 1 == queue.removeLast();
        assert 0 == queue.removeLast();
        assert 0 == queue.size();
    }

    @Test
    public void fifth() {
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addFirst(0);
        queue.addLast(3);
        queue.addLast(4);
        queue.addLast(5);

        Iterator<Integer> iter = queue.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            assertEquals(i, iter.next());
            i++;
        }
        assertEquals(new Integer(6), i);
    }

    @Test
    public void sixth() {
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addFirst(0);
        queue.removeLast();
        queue.removeLast();
        queue.removeLast();

        Iterator<Integer> iter = queue.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            assertEquals(i, iter.next());
            i++;
        }
        assertEquals(new Integer(0), i);
    }
*/
    @Test
    public void seventh() {
        int n = 100;
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            queue.enqueue(i+ 33 );
            nums.add(i + 33);
        }
        assert n == queue.size();

        Iterator<Integer> iter = queue.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            Integer obj = iter.next();
            assertTrue(nums.contains(obj));
            nums.remove(obj);
        }
        System.out.println(nums.size());

        assert 0 == nums.size();
    }

}
