public class BubbleSort{
    /*
    * Time Complexity average and best = O(n^2)
    * Spcae Complexity = O(1)
    * */



    void bubbleSort(int[] nums,int n){
        // Compairing adjacent elements and keep swapping.
        for (int i = 0;i<n-1;i++){
            for (int j = 0;j < n-1-i;j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /*
    * Time Compelxity average = O(n)
    * Time Complexity best = O(n^2)
    * Space Complexity = O(1)
    * */
    void bubbleSortOptimal(int[] nums,int n){
        boolean isSwapped = false;
        for (int i=0;i <n-1;i++){
            for (int j = 0;j<n-1-i;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped){
                break;
            }
        }
    }
}