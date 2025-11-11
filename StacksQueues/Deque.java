class Dequeu{
    int[] queue;
    int front;
    int rear;
    int capacity;
    int size;

    Dequeu(){
        this.capacity = 10;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    void insertAtfront(int element){
        if (size==capacity){
            System.out.println("Queue is full.");
            return;
        }
        front = (front-1+capacity)%capacity;
        queue[front] = element;
        size++;
    }

    void insertAtrear(int element){
        if (size==capacity){
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear+size)%capacity;
        queue[rear] = element;
        size++;
    }

    int removeFromend(){
        if(size==0){
            System.out.println("Queue is empty.");
            return -1;
        }
        int element = queue[rear];
        rear = (rear+size-1)%capacity;
        size--;
        return element;
    }

    int removeFromfront(){
        if(size==0){
            System.out.println("Queue is empty.");
            return -1;
        }
        int element = queue[front];
        front = (front+1)%capacity;
        size--;
        return element;
    }

    boolean isEmpty(){
        if (size==0){
            return true;
        }else {
            return false;
        }
    }
    boolean isFull(){
        if (size==capacity){
            return true;
        }else {
            return false;
        }
    }
    int peekAtfront(){
        if (isEmpty()){
            System.out.println("Queue is Empty.");
            return -1;
        }
        return queue[front];
    }
    int peekAtend(){
        if (isEmpty()){
            System.out.println("Queue is Empty.");
            return -1;
        }
        return queue[rear];
    }

    void main(String[] args){
        System.out.println(args);
        int[] nums = {10,20,30,40,50,60,70,80,90,100};
        Dequeu dq = new Dequeu();
        dq.insertAtfront(nums[0]);
        dq.insertAtrear(nums[1]);
        dq.insertAtfront(nums[2]);
        dq.insertAtrear(nums[3]);
        dq.insertAtfront(nums[4]);
        dq.insertAtrear(nums[5]);
        System.out.println(dq.removeFromfront());
        System.out.println(dq.removeFromend());
    }
}