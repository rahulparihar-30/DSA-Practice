import java.util.Scanner;
class BinaryTree{
    static class TreeNode{
        TreeNode left;
        int data;
        TreeNode right;
        TreeNode(int data){
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    public TreeNode root;
    Queue<TreeNode> q;
    Scanner scan;

    BinaryTree(){
        this.root = null;
        this.q = new Queue<>();
        this.scan = new Scanner(System.in);
    }

    void create(){
        int data;
        System.out.print("Enter the root: ");
        data = scan.nextInt();
        TreeNode newNode = new TreeNode(data);
        root = newNode;
        q.enqueue(root);
        while (q.isEmpty()!=true){
            TreeNode node = q.dequeu();
            System.out.print("Enter the left child of "+ node.data+": ");
            data = scan.nextInt();
            if (data != -1){
                TreeNode leftLeaf = new TreeNode(data);
                node.left = leftLeaf;
                q.enqueue(leftLeaf);
            }
            System.out.print("Enter the right child of "+ node.data+": ");
            data = scan.nextInt();
            if (data!=-1){
                TreeNode rightLeaf = new TreeNode(data);
                node.right = rightLeaf;
                q.enqueue(rightLeaf);
            }
        }
    }

    void createTree(int[] tree){
        if (tree.length ==0 || tree == null || tree[0]==-1){
            return;
        }

        root = new TreeNode(tree[0]);
        q.enqueue(root);

        int i = 1;
        while (!q.isEmpty()){
            TreeNode parent = q.dequeu();
            if (parent == null) {
                continue;
            }
            if (i < tree.length){
                if (tree[i]!= -1){
                    TreeNode leftNode = new TreeNode(tree[i]);
                    parent.left = leftNode;
                    q.enqueue(leftNode);
                }
            }
            i++;
            if (i < tree.length){
                if (tree[i]!= -1){
                    TreeNode rightNode = new TreeNode(tree[i]);
                    parent.right = rightNode;
                    q.enqueue(rightNode);
                }
            }
            i++;
        }

    }

    void preOrder(TreeNode node){
        if (node==null){
            return;
        }
//        Node left Right;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        // Left Node Right
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void postOrder(TreeNode node){
        if (node==null){
            return;
        }
        // Left Right Node
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.data + " ");
    }

    void levelOrder(){
        if(root==null){
            return;
        }
        System.out.println();
        q.enqueue(root);
        while (!q.isEmpty()){
            TreeNode node = q.dequeu();
            System.out.print(node.data+" ");
            if (node.left!=null){
                q.enqueue(node.left);
            }
            if (node.right!=null){
                q.enqueue(node.right);
            }
        }
        System.out.println();
    }

    int countNodes(TreeNode parent){
        int x,y;
        if(parent!=null){
            x = countNodes(parent.left);
            y = countNodes(parent.right);
            return x+y+1;
        }
        return 0;
    }

    int countLeaf(TreeNode parent){
        int x,y;
        if (parent!=null){
            x = countLeaf(parent.left);
            y = countLeaf(parent.right);

            if (parent.left!=null && parent.right!=null){
                return x+y+1;
            }else {
                return x+y;
            }
        }
        return 0;
    }

    int sumOfTree(TreeNode parent){
        int x,y;
        if (parent!=null){
            x = sumOfTree(parent.left);
            y = sumOfTree(parent.right);
            return x+y+parent.data;
        }
        return 0;
    }

    int height(TreeNode parent){
        int x,y;
        if (parent!=null){
            x=height(parent.left);
            y=height(parent.right);
            if (x>y){
                return x+1;
            }else {
                return y+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] nums = {5, 8, 16, -1, 9, 13, -1, 4, -1, -1, 2, -1, -1};
        BinaryTree bt = new BinaryTree();
        System.out.println("Building Tree...");
//        bt.create();
        bt.createTree(nums);
        while (true){
            System.out.print("1.PreOrder\n2.InOrder\n3.PostOrder\n4.LevelOrder\n5.Count Nodes\n6.Count Leaf Nodes\n7. Sum of Tree\n8.Height\n9.Exit:- ");
            int choice = bt.scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Printing PreOrder:- ");
                    bt.preOrder(bt.root);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Printing InOrder:- ");
                    bt.inOrder(bt.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Printing PostOrder:- ");
                    bt.postOrder(bt.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Printing LevelOrder:- ");
                    bt.levelOrder();
                    break;
                case 5:System.out.println("Total Nodes in the trees are :- " + bt.countNodes(bt.root));
                    break;
                case 6:System.out.println("Total Leaf Nodes are:- "+ bt.countLeaf(bt.root));
                break;
                case 7: System.out.println("Sum of the tree is :- "+bt.sumOfTree(bt.root));
                break;
                case 8:System.out.println("Height of the tree is:- "+bt.height(bt.root));
                break;

                case 9:
                    System.out.print("Stopping the program");
                    return;
                default:
                    System.out.print("Choose from given options only!");
            }
        }
    }
}