package HeapTopic;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapInJava {
    public static void main(String[] args) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();//minHeap
        PriorityQueue<Integer> hp1 = new PriorityQueue<>(Collections.reverseOrder());//MaxHeap
        hp.add(10);
        hp.add(20);
        hp.add(30);
        hp.add(1);
        hp.add(5);
        hp.add(7);
        hp.add(3);
        hp.add(2);
        hp.add(-4);
        System.out.println(hp);
        System.out.println(hp.remove());
        System.out.println(hp);

    }
}
