import java.util.Scanner;

// previous node <- Node -> next node
public class DoublyLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head, tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at any position (0-based index)
    public void insertAtAny(int pos, int data) {
        if (pos == 0) {
            insertAtHead(data);
            return;
        }

        Node temp = head;
        int cnt = 0;
        while (cnt < pos - 1 && temp != null) {
            temp = temp.next;
            cnt++;
        }

        if (temp == null) {
            System.out.println("Index out of bound.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode; // if inserted at the end
        }
        temp.next = newNode;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Delete head
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }
        System.out.println("Deleted: " + head.data);

        if (head.next == null) { // only one node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete at given position (0-based index)
    public void deleteAny(int pos) {
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        Node temp = head;
        int cnt = 0;

        while (cnt < pos && temp != null) {
            temp = temp.next;
            cnt++;
        }

        if (temp == null) {
            System.out.println("Invalid Position.");
            return;
        }

        System.out.println("Deleted: " + temp.data);

        // If head node
        if (temp == head) {
            deleteHead();
        }
        // If tail node
        else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        }
        // Middle node
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Forward traversal
    public void forward() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Backward traversal
    public void backward() {
        if (tail == null) {
            System.out.println("Linked list is empty!");
            return;
        }

        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Main method with menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        while (true) {
            System.out.println("\n===== Doubly Linked List Menu =====");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete Head");
            System.out.println("5. Delete at Position");
            System.out.println("6. Display Forward");
            System.out.println("7. Display Backward");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    dll.insertAtHead(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    dll.insertAtTail(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter position (0-based): ");
                    int pos = sc.nextInt();
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    dll.insertAtAny(pos, data);
                    break;
                case 4:
                    dll.deleteHead();
                    break;
                case 5:
                    System.out.print("Enter position (0-based): ");
                    dll.deleteAny(sc.nextInt());
                    break;
                case 6:
                    dll.forward();
                    break;
                case 7:
                    dll.backward();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
