class CircularQueue {
    int[] queue;
    int capacity;
    int REAR;
    int FRONT;
    int size;

    CircularQueue() {
        this.capacity = 10;
        this.queue = new int[capacity];
        this.REAR = -1;
        this.size = 0;
        this.FRONT = -1;
    }

    void enQueue(int element) {
        if ((REAR + 1) % capacity == FRONT) {
            System.out.println("Queue is full.\n");
            return;
        }
        REAR = (REAR + 1) % capacity;
        queue[REAR] = element;
        if (FRONT == -1) {
            FRONT = 0; // first element
        }
        size++;
    }

    void deQueue() {
        if (size == 0) {
            System.out.println("Queue is empty.\n");
            return;
        }
        int element = queue[FRONT];
        FRONT = (FRONT + 1) % capacity;
        size--;
        if (size == 0) { // reset to initial state
            FRONT = -1;
            REAR = -1;
        }
        System.out.println(element + "\n");
    }

    void peek() {
        if (size == 0) {
            System.out.println("Queue is empty.\n");
            return;
        }
        System.out.println(queue[FRONT] + "\n");
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 60};
        CircularQueue cq = new CircularQueue();

        System.out.println("Adding elements:");
        for (int num : nums) {
            cq.enQueue(num);
        }

        System.out.println("Peeking:");
        cq.peek(); // should print 10

        System.out.println("Dequeuing:");
        for (int i = 0; i < nums.length; i++) {
            cq.deQueue();
        }

        cq.deQueue(); // test empty condition
    }
}
