//Queue for storing anytype of data. Data can be of any type LinkedList, Integer, String etc. In the form of LinkedList.
// T represents the type which is a placeholder as of now.
class Queue<T>{

    // This represents the node of the linkedlist.
    static class qNode<T>{

        private T data; // Data part of singly linkedlist
        private qNode<T> next;// Address of the next element.
        // Constructor for Node class
        qNode(T data){
            this.data = data;
            this.next = null; // so that we don't have to initialize it everytime to nulll.
        }
    }

    private qNode<T> front; // front
    private qNode<T> rear;

    public boolean isEmpty(){
        if (front==null){
            return true;
        }else {
            return false;
        }
    }
    public void enqueue(T data){
        qNode<T> node = new qNode<>(data);
        if(rear!=null){
            rear.next = node;
        }
        rear = node;
        if (front==null){
            front = rear;
        }
    }

    public T dequeu(){
        if (isEmpty()){
            System.out.println("Queue is null.");
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front==null){
            rear = null;
        }
        return data;
    }
}