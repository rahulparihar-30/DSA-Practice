import java.util.Scanner;
class Sorts{
    public static void print(int[] nums){
        for (int num:nums){
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BubbleSort b = new BubbleSort();
        InsertionSort i = new InsertionSort();
        SelectionSort s = new SelectionSort();
        int choice;
        int[] nums = {8,5,7,3,2};

        while (true){
            System.out.print("\n1.BubbleSort\n2.InsertionSort\n3.SelectionSort\n4.MergeSort\n5.QuickSort\nEnter your Choice:- ");
            choice = scan.nextInt();
            switch (choice){
                case 1: b.bubbleSort(nums,nums.length);
                    System.out.println("After BubbleSort");
                    print(nums);
                    break;
                case 2:i.insertionSort(nums,nums.length);
                    System.out.println("After InsertionSort");
                    print(nums);
                    break;
                case 3:s.selectionSort(nums,nums.length);
                    System.out.println("After SelectionSort");
                    print(nums);
                    break;
                default:System.out.println("Wrong Choice");
            }
            nums = new int[]{8,5,7,3,2};
        }
    }
}