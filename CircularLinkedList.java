public class CircularLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at any position (1-based index)
    public void insertAtAny(int pos, int data) {
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int cnt = 1;
        while (cnt < pos - 1 && temp.next != head) {
            temp = temp.next;
            cnt++;
        }
        if (cnt != pos - 1) {
            System.out.println("Index out of bound");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete head
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.next == head) { // only one node
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    // Delete end
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    // Delete any position
    public void deleteAny(int pos) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (pos == 1) {
            deleteHead();
            return;
        }
        Node temp = head;
        int cnt = 1;
        while (cnt < pos - 1 && temp.next != head) {
            temp = temp.next;
            cnt++;
        }
        if (temp.next == head) {
            System.out.println("Index out of bound");
            return;
        }
        temp.next = temp.next.next;
    }

    // Display
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    // Main function to test
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Insert at head
        cll.insertAtHead(10);
        cll.insertAtHead(20);
        cll.insertAtHead(30);
        cll.display(); // 30 -> 20 -> 10 -> HEAD

        // Insert at end
        cll.insertAtEnd(40);
        cll.insertAtEnd(50);
        cll.display(); // 30 -> 20 -> 10 -> 40 -> 50 -> HEAD

        // Insert at position
        cll.insertAtAny(3, 99);
        cll.display(); // 30 -> 20 -> 99 -> 10 -> 40 -> 50 -> HEAD

        // Delete head
        cll.deleteHead();
        cll.display(); // 20 -> 99 -> 10 -> 40 -> 50 -> HEAD

        // Delete end
        cll.deleteEnd();
        cll.display(); // 20 -> 99 -> 10 -> 40 -> HEAD

        // Delete at position
        cll.deleteAny(2);
        cll.display(); // 20 -> 10 -> 40 -> HEAD
    }
}
