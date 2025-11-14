public class QuickSort{

    public void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int hoares_partition(int[] nums, int low,int high){
        /*
        * Elements smaller than pivot element must appear at index less than or equal to partition index.
        * Elements larger than or equal to pivot element must appear at index greater than partition index.
        * */

        int pivot = nums[low];
        int i = low - 1;
        int j = high + 1;

        while (true){
            do {
                i++;
            }while (nums[i] < pivot);

            do {
                j--;
            }while (nums[j] > pivot);

            if (i>=j){
                return j;
            }
            swap(nums,i,j);
        }

    }

    public void quickSort(int[] nums,int low,int high){
        if (low<high){
            int pivIdx = hoares_partition(nums,low,high);
            quickSort(nums,low,pivIdx);
            quickSort(nums,pivIdx+1,high);
        }
    }
}