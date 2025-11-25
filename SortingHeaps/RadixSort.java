public class RadixSort {
    int getMax(int[] nums){
        int max = nums[0];
        for (int num:nums){
            if (num>max){
                max = num;
            }
        }
        return max;
    }

    public void radixSort(int[] nums, int n){
        int max,place;
        // Init bins from 0 to 9
        int[][] bins = new int[10][n];
        int[] count = new int[10];
        //1. Get the max element from the array.
        max = getMax(nums);
        //2. Iterate till the length of the max element

        place = 1;
        while (max/place>0){
            // set the count to null
            for (int i=0;i<n;i++){
                count[i] = 0;
            }

            // 3. Put numbers in bins based on current digit
            for (int i=0;i<n;i++){
                int digit = (nums[i]/place)%10;
                bins[digit][count[digit]] = nums[i];
                count[digit]++;
            }

            // 4. Rebuild nums[] from bins
            int index = 0;
            for (int d = 0; d < 10; d++) {
                for (int j = 0; j < count[d]; j++) {
                    nums[index++] = bins[d][j];
                }
            }
            place*=10;
        }
    }
}