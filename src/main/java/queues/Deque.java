
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Elem first, last;
    private int size;

    public Deque() {                     // construct an empty deque
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {                 // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {    // insert the item at the front
        if (item == null) throw new NullPointerException("addFirst null");
        size += 1;
        Elem newFirst = new Elem(null, item, first);
        if (first != null) first.head = newFirst;
        first = newFirst;
        if (last == null) last = first;
    }

    public void addLast(Item item) {     // insert the item at the end
        if (item == null) throw new NullPointerException("addlast null");
        size += 1;
        Elem newLast = new Elem(last, item, null);
        if (last != null) last.tail = newLast;
        last = newLast;
        if (first == null) first = last;

    }

    public Item removeFirst() {          // delete and return the item at the front
        if (isEmpty()) throw new NoSuchElementException("removeFirst on empty deque");
        size -= 1;
        Item firstItem = first.item;
        if (size > 0) {
            first = first.tail;
            if (first != null) first.head = null;
        } else {
            first = null;
            last = null;
        }
        return firstItem;
    }

    public Item removeLast() {           // delete and return the item at the end
        if (isEmpty()) throw new NoSuchElementException("removeLast on empty deque");
        size -= 1;
        Item lastItem = last.item;
        if (size > 0) {
            last = last.head;
            if (last != null) last.tail = null;
        } else {
            first = null;
            last = null;
        }
        return lastItem;
    }

    public Iterator<Item> iterator() {   // return an iterator over items in order from front to end
        return new DequeIterator(first);
    }

    private class DequeIterator implements Iterator<Item> {
        Elem next;

        private DequeIterator(Elem next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Item next() {
            if (next == null) throw new NoSuchElementException("next on empty iterator");
            Item item = next.item;
            next = next.tail;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }
    }

    private class Elem {
        Elem head;
        Item item;
        Elem tail;

        private Elem(Elem h, Item i, Elem t) {
            this.head = h;
            this.item = i;
            this.tail = t;
        }
    }
}