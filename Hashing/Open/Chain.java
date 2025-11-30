package Open;
public class Chain {

    /*
    Insert operation for inserting element in sorted order.
     */

    public Node insert(Node root, int data){
        Node newNode = new Node(data);

        if (root == null || data < root.data){
            newNode.next = root;
            return newNode;
        }

            Node current = root;
            while (current.next != null && current.next.data < data){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        return root;
    }

    public Node search(Node root, int key){
        Node temp = root;
        while (temp != null && temp.data <= key)
        {
            if (temp.data == key){
                return temp;
            }
            temp = temp.next;
        }
    return null;
    }

    public Node delete(Node root, int key){
        if (root==null){
            return null;
        }
        if (root.data == key){
            return root.next;
        }
        Node temp = root;
        while (temp.next != null && temp.next.data < key){
            temp = temp.next;
        }
        if (temp.next!=null && temp.next.data == key){
            temp.next = temp.next.next;
        }

        return root;
    }

    public void display(Node root){
        if (root==null){
            return;
        }
        Node temp = root;
        System.out.print("[");
        while (temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }
}