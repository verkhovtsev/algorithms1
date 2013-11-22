
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class DequeTest {
    private Deque<Integer> deque;
    @Before
    public void before() {
        deque = new Deque<Integer>();
    }

    @Test
    public void first() {
        deque.addFirst(1);
        deque.removeLast();
        assert 0 == deque.size();
    }

    @Test
    public void second() {
        deque.addFirst(4);
        deque.addLast(5);
        deque.addFirst(3);
        deque.addLast(6);
        assert 3 == deque.removeFirst();
        assert 4 == deque.removeFirst();
        assert 5 == deque.removeFirst();
        assert 6 == deque.removeFirst();
        assert 0 == deque.size();
    }

    @Test
    public void third() {
        deque.addLast(2);
        deque.addLast(4);
        deque.addLast(5);

        assert 2 == deque.removeFirst();
        assert 4 == deque.removeFirst();
        assert 5 == deque.removeFirst();
        assert 0 == deque.size();
    }

    @Test
    public void fourth() {
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(0);

        assert 2 == deque.removeLast();
        assert 1 == deque.removeLast();
        assert 0 == deque.removeLast();
        assert 0 == deque.size();
    }

    @Test
    public void fourth_1() {
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(0);

        assert 2 == deque.removeLast();
        assert 1 == deque.removeLast();
        assert 0 == deque.removeLast();
        assert 0 == deque.size();

        deque.addLast(7);
        deque.addFirst(6);
        deque.addFirst(5);
        deque.addFirst(4);

        assert 4 == deque.size();
        assert 4 == deque.removeFirst();
        assert 7 == deque.removeLast();
        assert 5 == deque.removeFirst();
        assert 6 == deque.removeLast();
        assert 0 == deque.size();

    }

    @Test
    public void fifth() {
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(0);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);

        Iterator<Integer> iter = deque.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            assertEquals(i, iter.next());
            i++;
        }
        assertEquals(new Integer(6), i);
    }

    @Test
    public void sixth() {
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(0);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();

        Iterator<Integer> iter = deque.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            assertEquals(i, iter.next());
            i++;
        }
        assertEquals(new Integer(0), i);
    }

    @Test
    public void seventh() {
        deque.addLast(-1);
        deque.addLast(0);
        deque.addLast(1);
        deque.removeFirst();

        Iterator<Integer> iter = deque.iterator();
        Integer i = 0;
        while(iter.hasNext()) {
            assertEquals(i, iter.next());
            i++;
        }
        assertEquals(new Integer(2), i);
    }
}
