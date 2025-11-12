class Sorts{
    public static void print(int[] nums){
        for (int num:nums){
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args){
        BubbleSort b = new BubbleSort();
        InsertionSort i = new InsertionSort();
        int[] nums = {8,5,7,3,2};

        // Bubble Sort
        i.insertionSort(nums,nums.length);
        System.out.println("After Insertion Sort");
        print(nums);
    }
}