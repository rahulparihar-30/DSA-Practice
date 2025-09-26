class PriorityQueueElement{
    int[] queue;
    int size;
    int capacity;
    PriorityQueueElement(int capacity){
        this.queue = new int[capacity] ;
        this.size = 0;
        this.capacity = capacity;
    }

    void enQueue(int element){
        if(size == capacity){
            System.out.println("Queue is full\n");
            return;
        }
        queue[size++] = element;
    }

    void enqueue(int element) {
        if (size == capacity) {
            System.out.println("Queue is full.");
            return;
        }

        int idx = 0;
        // Find the correct position to insert
        while (idx < size && queue[idx] < element) {
            idx++;
        }

        // Shift elements to the right
        for (int i = size; i > idx; i--) {
            queue[i] = queue[i - 1];
        }

        // Insert the element
        queue[idx] = element;
        size++;
    }


    int dequeue(){
        if (size==0){
            System.out.println("Queue is empty.");
            return -1;
        }
        int element = queue[0];
        for (int i=0;i<size-1;i++){
            queue[i] = queue[i+1];
        }
        return element;
    }
    int deQueue(){
        if (size==0){
            System.out.println("Queue is empty.");
            return -1;
        }
        int minIdx = 0;
        for (int i = 0;i<size;i++){
            if (queue[minIdx] > queue[i]){
                minIdx = i;
            }
        }

        int min = queue[minIdx];
        for (int i=minIdx;i<size-1;i++){
            queue[i] = queue[i+1];
        }
        size--;
        return min;
    }

    void display(){
        if (size==0){
            System.out.println("Queue is empty.");
            return;
        }
        for (int i=0;i<size;i++){
            System.out.println(queue[i]+"\n");
        }
    }
}