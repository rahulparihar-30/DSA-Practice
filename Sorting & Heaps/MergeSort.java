public class MergeSort {
    public static void merge(int[] nums, int start,int mid,int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <=mid && j <= end){
            if (nums[i] >= nums[j]){
                temp[index] = nums[j];
                j+=1;
                index+=1;
            }else {
                temp[index] = nums[i];
                i+=1;
                index+=1;
            }
        }

        while (i<=mid){
            temp[index] = nums[i];
            i+=1;
            index+=1;
        }

        while (j <= end){
            temp[index] = nums[j];
            j+=1;
            index+=1;
        }

        for (int k = 0;k < temp.length;k++){
            nums[k+start] = temp[k];
        }
    };
    public static void mergeSort(int[] nums,int start,int end){
        if(start < end){
            int mid = start + (end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    };
    public static void print(int[] nums){
        for (int num:nums){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args){
        int nums [] = {100,80,40,60,70,50,10,20,5};
        System.out.println("The Unsorted array is: ");
        print(nums);
        System.out.println();
        mergeSort(nums,0,nums.length-1);
        print(nums);
    };
}