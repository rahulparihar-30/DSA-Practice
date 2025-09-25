class Queue{
    static int[] queue = new int[10];
    static int capacity = 10;
    static int front = -1;
    static int rear = -1;

    public static void enQueue(int element){
        if(rear == capacity-1){
            System.out.println("Queue if full.");
            return;
        }
        if (rear == -1){
            rear++;
            front++;
        }else {
            rear++;
        }
        queue[rear] = element;
    }

    public static int deQueue(){
        if (front==-1){
            System.out.println("Queue is empty.");
            return 0;
        }
        int element  = queue[front++];
        if (front > rear){
            front = -1;
            rear = -1;
        }
        return element;
    }

    public static int peek(){
        if (front==-1){
            System.out.println("Queue is empty.");
            return 0;
        }
        return queue[front];
    }

    public static void main(String[] args){
        int[] nums = {10,20,30,40,60};

        System.out.print("Adding elements to the queue.\n");
        for(int num:nums){
            enQueue(num);
        }
        System.out.print("Done Adding\n");
        System.out.print("Dequeue in process.\n");
        for (int num:nums){
            System.out.print(deQueue()+"\n");
        }

    }
}