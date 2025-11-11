public class mArrayTrees {
    static class Node{
        Node leftChild;
        int k1,k2;
        Node rightChild;

        Node(int k1=null,int k2=null){
            this.leftChild = null;
            this.k1 = k1;
            this.k2 = k2;
            this.leftChild = null;
        }
    }

    Node head;
    mArrayTrees(){
        this.head = null;
    }

    static void addNode(int data){
        if (head==null){
            head = Node(data);
            return;
        }

        /* Bottom To up Upporach
        * Check if */

    }
}