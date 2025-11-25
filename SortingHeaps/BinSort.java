public class BinSort {
    int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public void binSort(int[] nums, int n) {
        int max = getMax(nums);
        int[][] bins = new int[max + 1][nums.length];
        int[] count = new int[max + 1];

        //insert element in the bin

        for (int num : nums) {
            bins[num][count[num]] = num;
            count[num]++;
        }

        // 4. Collect elements back
        int idx = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[idx++] = bins[i][j];
            }
        }
    }
}