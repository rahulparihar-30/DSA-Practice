public class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
    }

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Delete head
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete tail
    public void deleteTail() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // only one element
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at any position (1-based index)
    public void deleteAt(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) { // delete head
            head = head.next;
            return;
        }
        Node temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    // Main method to test
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("List after insertion:");
        list.display();

        // Delete head
        list.deleteHead();
        System.out.println("After deleting head:");
        list.display();

        // Delete tail
        list.deleteTail();
        System.out.println("After deleting tail:");
        list.display();

        // Delete at position 2 (1-based index)
        list.deleteAt(2);
        System.out.println("After deleting at position 2:");
        list.display();
    }
}
