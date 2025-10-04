class Queue<T>{
    static class qNode<T>{
        private T data;
        private qNode<T> next;

        qNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    private qNode<T> front;
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