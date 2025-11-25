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
        QuickSort q = new QuickSort();
        CountingSort c = new CountingSort();
        BinSort bin = new BinSort();
        BucketSort bucket = new BucketSort();

        int choice;
        int[] nums = {8,5,7,3,2};

        while (true){
            System.out.print("\n1.BubbleSort\n2.InsertionSort\n3.SelectionSort\n4.MergeSort\n5.CountingSort\n6.BinSort\n7.RadixSort\n8.ShellSort\nEnter your Choice:- ");
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
                case 4:q.quickSort(nums,0,nums.length-1);
                    System.out.println("After SelectionSort");
                    print(nums);
                    break;
                case 5:c.countingSort(nums,nums.length);
                    System.out.println("After CountingSort");
                    print(nums);
                    break;
                case 6:bucket.bucketSort(nums,nums.length);
                    System.out.println("After BinSort");
                    print(nums);
                    break;
                default:System.out.println("Wrong Choice");
            }
            nums = new int[]{8,5,7,3,2};
        }
    }
}