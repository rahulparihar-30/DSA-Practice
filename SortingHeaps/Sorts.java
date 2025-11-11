class Sorts{
    public static void print(int[] nums){
        for (int num:nums){
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args){
        BubbleSort b = new BubbleSort();
        int[] nums = {8,5,7,3,2};

        // Bubble Sort
        b.bubbleSort(nums,nums.length);
        System.out.println("After Bubble Sort");
        print(nums);

    }
}