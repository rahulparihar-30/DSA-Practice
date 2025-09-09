import java.util.Scanner;

class Queue {
    public static int[] queue = new int[5];
    public static int front = -1;
    public static int rear = -1;
    public static Scanner sc = new Scanner(System.in);

    public static boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public static boolean isFull() {
        return rear == queue.length - 1;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return -1;
        }
        return queue[front];
    }

    public static void enqueue() {
        if (isFull()) {
            System.out.println("The queue is Full.");
            return;
        }

        System.out.print("Enter the number to be added:- ");
        int value = sc.nextInt();

        if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear++;
        }

        queue[rear] = value;
        System.out.println(value + " added to queue.");
    }

    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println(queue[front] + " removed from queue.");

        if (rear == front) {
            rear = front = -1; // reset queue
        } else {
            front++;
        }
    }

    // ✅ Main function here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1.Enqueue\n2.Dequeue\n3.Peek\n4.Is Queue Empty?\n5.Exit");
            System.out.print("Enter Your Choice:- ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    enqueue();
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    int val = peek();
                    if (val != -1) {
                        System.out.println("Front element is: " + val);
                    }
                    break;
                case 4:
                    System.out.println(isEmpty() ? "Queue is Empty" : "Queue has elements");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
