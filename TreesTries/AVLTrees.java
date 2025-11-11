public class AVLTrees{
    static class TreeNode{
        TreeNode leftChild;
        int data;
        int balanceFactor;
        TreeNode rightChild;

        TreeNode(int data){
            this.leftChild = null;
            this.data = data;
            this.balanceFactor = 0;
            this.rightChild = null;
        }
    }

    public static TreeNode root = null;

    public static int balanceFactor(TreeNode node){
        int leftHeight = node!=null && node.leftChild!=null ? node.leftChild.balanceFactor:0;
        int rightHeight = node!=null && node.rightChild!=null ? node.rightChild.balanceFactor:0;
        return leftHeight - rightHeight;

    }
    public static int height(TreeNode node){
        // If node is not null and it has left and right child then return balanceFactor of left and right child else return 0
        int leftHeight = node!=null && node.leftChild!=null ? node.leftChild.balanceFactor:0;
        int rightHeight = node!=null && node.rightChild!=null ? node.rightChild.balanceFactor:0;
        return leftHeight>rightHeight ? leftHeight:rightHeight;
    }

//    public static void insert(int data){
//        TreeNode new_node = new TreeNode(data);
//        if (root==null){
//            root = new_node;
//            return;
//        }
//        TreeNode temp = root;
//        TreeNode tail = null;
//
//        while (temp!=null){
//            tail = temp;
//            if (temp.data == data){
//                System.out.println("Duplicate element");
//                return;
//            }else if (temp.data > data){
//                temp = temp.leftChild;
//            }else {
//                temp = temp.rightChild;
//            }
//        }
//
//        if (tail.data > data){
//            tail.leftChild = new_node;
//        }else {
//            tail.rightChild = new_node;
//        }
//        new_node.balanceFactor = height(new_node);
//
//    }

    public static TreeNode LL(TreeNode parent){
        TreeNode pl = parent.leftChild;
        TreeNode plr = pl.rightChild;

        parent.leftChild = plr;
        pl.rightChild = parent;

        parent.balanceFactor = height(parent);
        pl.balanceFactor = height(pl);
        if (parent == root){
            root = pl;
        }
        return pl;
    }

    public static TreeNode RR(TreeNode parent){
        TreeNode pr = parent.rightChild;

        parent.rightChild = pr.leftChild;
        pr.leftChild = parent;

        parent.balanceFactor = height(parent);
        pr.balanceFactor = height(pr);

        if (parent == root){
            root = pr;
        }
        return pr;
    }

    public static TreeNode LR(TreeNode parent){
        TreeNode pl = parent.leftChild;
        TreeNode plr = pl.rightChild;

        parent.rightChild = plr.rightChild;
        pl.rightChild = plr.leftChild;
        plr.leftChild = pl;
        plr.rightChild = parent;

        pl.balanceFactor = height(pl);
        plr.balanceFactor = height(plr);
        parent.balanceFactor = height(parent);

        if (root==parent) {
            root = plr;
        }
        return plr;

    }
    public static TreeNode RL(TreeNode parent){
        TreeNode pr = parent.rightChild;
        TreeNode prl = pr.leftChild;

        parent.rightChild = prl.leftChild;
        prl.leftChild = parent;
        pr.leftChild = prl.rightChild;
        prl.rightChild = pr;

        pr.balanceFactor = height(pr);
        prl.balanceFactor = height(prl);
        parent.balanceFactor = height(parent);

        if (parent == root){
            root = prl;
        }
        return prl;
    }

    public static TreeNode insert(TreeNode parent, int key){
        TreeNode tail = null;
        if(parent==null){
            tail = new TreeNode(key);
            tail.balanceFactor = 1;
            return tail;
        }
        if (parent.data > key){
            parent.leftChild =  insert(parent.leftChild,key);
        }else {
            parent.rightChild = insert(parent.rightChild,key);
        }
        parent.balanceFactor = height(parent);
        
        if (balanceFactor(parent) == 2 && balanceFactor(parent.leftChild) == 1){
            // LL Imbalance
            return LL(parent);
        } else if (balanceFactor(parent) == -2 && balanceFactor(parent.rightChild) == -1) {
            // RR Imbalance
            return RR(parent);
        } else if (balanceFactor(parent) == 2 && balanceFactor(parent.leftChild) == -1 ) {
            //LR Imbalance
            return LR(parent);
        } else if (balanceFactor(parent) == -2 && balanceFactor(parent.rightChild) == 1) {
            // RL Imbalance
            return RL(parent);
        }
        return parent;
    }

   public static void inOrder(TreeNode node){
        if (node==null){
            return;
        }
        // Left Node Right
        inOrder(node.leftChild);
        System.out.print(node.data+",");
        inOrder(node.rightChild);
    }

    public static void postOrder(TreeNode node){
        if (node==null){
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data+",");
    }

    public static void preOrder(TreeNode node){
        if (node==null){
            return;
        }
        System.out.print(node.data+",");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    public static  void main(String[] args){
        root = insert(root,10);
        insert(root,5);
        insert(root,2);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}

