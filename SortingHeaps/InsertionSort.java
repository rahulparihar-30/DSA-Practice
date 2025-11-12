public class InsertionSort{
    public void insertionSort(int[] nums,int n){
        // Maintain two parts sorted and unsorted.
        for (int i =1;i<n;i++){
            int j = i-1;
            int x = nums[i];

            while (j>=0 && nums[j] > x){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = x;
        }
    }
}