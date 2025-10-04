class Tree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    Tree(){
        this.root = null;
    }

    void insert(int element ){
        Node newNode = Node(element);
        if (root==null){
            root = newNode;
            return;
        }
        Node temp = root;
        while (temp!=null){
            if (temp.data == element) {
                System.out.println(element + " Already Exists!");
                return;
            } else if (temp.data > element) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if(temp.data> element){
            temp.left = newNode;
        }else {
            temp.right = newNode;
        }
    }

    // Traversal's Algorithm's
    void preOrder(Node temp){
        if (root==null){
            System.out.println("Root is null");
            return;
        }
        System.out.println(temp.data);
        preOrder(temp.left);
        preOrder(temp.right);
    }

    void inOrder(Node temp){
        if (root==null){
            System.out.println("Root is null");
            return;
        }
        inOrder(temp.left);
        System.out.println(temp.data);
        inOrder(temp.right);
    }

    void postOrder(Node temp){
        if (root==null){
            System.out.println("Root is null");
            return;
        }
        postOrder(temp.left);
        postOrder(temp.right);
        System.out.println(temp.data);
    }

    int search(int element){
        if (root==null){
            System.out.println("Root is null");
            return;
        }
        Node temp = root;
        while (temp!=null){
            if (temp.data==element){
                return temp.data;
            } else if (temp.data>element) {
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return -1
    }

    int delete(int element){
        if (root==null){
            System.out.println("Root is null");
            return -1;
        }

        Node temp = root;

        while (temp!=null){
            if (temp.data>element){
                temp = temp.left;
            } else if (temp.data<element) {
                temp = temp.right;
            }else {
                if (temp.left == null && temp.right==null){
                    temp = null;
                } else if (temp.left == null) {
                    temp = temp.right;
                } else if (temp.right == null) {
                    temp = temp.left;
                }else {
                        //Pending
                }
            }
        }
    }
}