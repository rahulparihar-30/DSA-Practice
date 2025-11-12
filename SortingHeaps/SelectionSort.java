public class SelectionSort {
    public void selectionSort(int[] nums,int n){
        int min_idx;
        for (int i=0;i<n-1;i++){
            min_idx = i;
            for (int j = i+1;j<n;j++){
                if (nums[min_idx] > nums[j]){
                    min_idx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = temp;
        }
    }
}