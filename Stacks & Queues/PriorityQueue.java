//import PriorityQueueElement.*;

class PriorityQueue{
    public static void main(String[] args) {
        PriorityQueueElement p1 = new PriorityQueueElement(10);

        System.out.println("Testing enQueue / deQueue (unsorted):");
        p1.enQueue(30);
        p1.enQueue(10);
        p1.enQueue(20);
        p1.enQueue(40);

        System.out.print("Queue elements: ");
        p1.display();

        int removed = p1.deQueue(); // returns min
        System.out.println("Removed element with highest priority: " + removed);

        System.out.print("Queue after deQueue: ");
        p1.display();

        // ---------- Test sorted enqueue / dequeue ----------
        PriorityQueueElement p2 = new PriorityQueueElement(10);

        System.out.println("\nTesting enqueue / deqeuue (sorted insert):");
        p2.enqueue(30);
        p2.enqueue(10);
        p2.enqueue(20);
        p2.enqueue(40);
        p2.enqueue(25);

        System.out.print("Queue elements after sorted enqueue: ");
        p2.display();

        int removedSorted = p2.dequeue(); // just remove first or last depending on your definition
        System.out.println("Removed element with highest priority: " + removedSorted);

        System.out.print("Queue after deqeuue: ");
        p2.display();
    }
}