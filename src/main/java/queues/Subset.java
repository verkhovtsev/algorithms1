
public class Subset {
    public static void main(String[] args) {

        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            StdOut.println(queue.dequeue());
        }
    }
}