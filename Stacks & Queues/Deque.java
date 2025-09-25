public class Deque {
    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public Deque() {
        this.queue = new int[10];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
        this.capacity = 10;
    }

    public void insertFront(int data) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) { // first element
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        queue[front] = data;
        size++;
    }

    public void insertRear(int data) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) { // first element
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = data;
        size++;
    }

    public int deleteFront() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int element = queue[front];
        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return element;
    }

    public int deleteRear() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int element = queue[rear];
        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        return element;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertFront(2);

        dq.display(); // 2 5 10 20

        System.out.println("Deleted from front: " + dq.deleteFront()); // 2
        dq.display(); // 5 10 20

        System.out.println("Deleted from rear: " + dq.deleteRear()); // 20
        dq.display(); // 5 10

        dq.insertRear(30);
        dq.display(); // 5 10 30
    }
}
