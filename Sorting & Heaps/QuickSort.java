class QuickSort{
    public  static void swap(int[] nums,int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public  static int lomuto_partition(int[] nums,int low,int high){
        int pivot = nums[high];
        int i=low-1;
        int j = low;
        int temp;
        while (j < high){
            if (nums[j] < pivot){
                i++;
                swap(nums,i,j);
            }
            j++;
        }

        swap(nums,i+1,high);
        return i+1;
    };

    public static int hoares_partion(int[] nums,int low,int high){
        // The fastest Partioning Algorithm
        // Traverse the array from both  the side and keep swapping.
        int pivot = nums[low];
        int i = low-1;
        int j = high +1;

        while (true){
            do {
                i++;

            }while (nums[i]<pivot);

            do {
                j--;
            }while (nums[j] > pivot);

            if(i>=j){
                return j;
            }
            swap(nums,i,j);
        }

    };

    public static void quickSort(int[] nums,int low,int high){
        if (low<high){
            int pivIdx = hoares_partion(nums,low,high); //lomuto_partition(nums,low,high);
            quickSort(nums,low,pivIdx);
            quickSort(nums,pivIdx+1,high);
        }
    }

    public static void print(int[] nums){
        System.out.print("[");
        for (int num:nums){
            System.out.print(num + ",");
        }
        System.out.print("]");
    }

    public static void main(String[] args){
        System.out.println("--Quick Sort--");
        int[] nums = {100,50,40,10,60,70,20,80,30,90};

        System.out.println("Following is the nums array.");
        print(nums);
        System.out.println();
        quickSort(nums,0,nums.length-1);
        System.out.println("Following is the sorted nums array.");
        print(nums);
    }
}