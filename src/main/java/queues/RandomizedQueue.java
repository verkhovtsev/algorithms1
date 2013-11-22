import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_CAPACITY = 5;
    private int mult = 2;
    private int div = 4;
    private int capacity;
    private int initialCapacity;
    private int size = 0;
    private Item[] data;

    public RandomizedQueue() {          // construct an empty randomized queue
        this(DEFAULT_CAPACITY);
    }

    private RandomizedQueue(int iCapacity) {          // construct an empty randomized queue
        data = (Item[]) new Object[iCapacity];
        capacity = iCapacity;
        initialCapacity = iCapacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }           // is the queue empty?

    public int size() {
        return size;
    }                 // return the number of items on the queue

    public void enqueue(Item item) {    // add the item
        if (item == null) throw new NullPointerException("add null");
        data[size] = item;
        size++;
        if (size == capacity) {
            int newCapacity = capacity * mult;
            createNewArray(newCapacity);
        }
    }

    public Item dequeue() {             // delete and return a random item
        if (size == 0) throw new NoSuchElementException("dequeue on empty queue");
        int i = StdRandom.uniform(size);
        Item item = data[i];
        if (i != size - 1) {
            data[i] = data[size - 1];
        }
        data[size - 1] = null;
        size--;
        if (size > 0 && capacity > initialCapacity && size <= capacity / div) {
            int newCapacity = capacity / mult;
            if (newCapacity < initialCapacity) {
                newCapacity = initialCapacity;
            }
            createNewArray(newCapacity);
        }
        return item;
    }

    private void createNewArray(int newCapacity) {
        Item[] newData = (Item[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
    }

    public Item sample() {              // return (but do not delete) a random item
        if (size == 0) throw new NoSuchElementException("sample on empty queue");
        int i = StdRandom.uniform(size);
        Item item = data[i];
        return item;
    }

    public Iterator<Item> iterator() {  // return an independent iterator over items in random order
        Item[] newData = (Item[]) new Object[size];
        System.arraycopy(data, 0, newData, 0, size);
        return new RandomizedQueueIterator(newData);
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] data;
        private int cur = 0;

        public RandomizedQueueIterator(Item[] items) {
            StdRandom.shuffle(items);
            this.data = items;
        }

        @Override
        public boolean hasNext() {
            return cur != data.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("you reached the end of the queue");
            return data[cur++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }
    }
}