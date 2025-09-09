import java.util.Scanner;

class Stack {
    int[] stack = new int[5];
    int top = -1;
    Scanner sc = new Scanner(System.in);

    public void push() {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow.");
            return;
        }
        System.out.print("Enter element to push: ");
        int value = sc.nextInt();
        stack[++top] = value;
        System.out.println(value + " pushed.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println(stack[top--] + " popped.");
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1; // return a default value
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1; // number of elements in stack
    }

    public static void main(String[] args) {
        Stack s = new Stack();  // create stack object
        int choice;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Push\n2.Pop\n3.Top\n4.Is Stack Empty\n5.Size\n6.Exit");
            System.out.print("Enter Your Choice:- ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    int t = s.top();
                    if (t != -1) {
                        System.out.println("Topmost element is :- " + t);
                    }
                    break;
                case 4:
                    System.out.println(s.isEmpty() ? "Stack is Empty" : "Stack is not Empty");
                    break;
                case 5:
                    System.out.println("Current size: " + s.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
