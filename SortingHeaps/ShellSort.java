public class ShellSort {

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void shellSort(int[] nums, int n){
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                /*
                i = 2
                i = 3

                 */
                int temp = nums[i];
                /*
                temp = 7
                temp = 3
                 */
                int j = i;
                /*
                j = 2
                j = 3
                 */

                while (j >= gap && nums[j - gap] > temp) {
                    /*

                    2 >= 2 and nums[0]>temp (8 > 7) - > True
                    3>=2 and nums[2] > temp (8>3) -> T
                    2>=2 and nums[1] > temp (5>3) -> T
                     */
                    nums[j] = nums[j - gap];
                    /*
                    nums[2] = nums[0]-> 8
                    nums[3] = nums[2] ->8
                    nums[2] = nums[0]
                     */
                    j -= gap;
                    /*
                    1
                    2
                     */
                }
                nums[j] = temp;
                /*
                j = 1
                nums[j] = 7;
                 */
            }
        }
    }

}
