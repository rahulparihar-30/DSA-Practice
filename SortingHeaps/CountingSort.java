public class CountingSort {
    int max(int[] nums,int n){
        int maxx = nums[0];

        for (int i = 1;i<n;i++){
            if (maxx < nums[i]){
                maxx = nums[i];
            }
        }
        return maxx;
    }

    public void countingSort(int[] nums,int n){
        int maxx,k,c;
        int[] frequency;

        //1. Calculate the max element from the array.
        maxx = max(nums,n); // n

        //2. initialize the array with the size of the max element
        frequency = new int[maxx+1];

        //3. Count the frequency.

        for (int i = 0;i<n;i++){
            frequency[nums[i]]+=1;
        }
        // n

        //4. Copy back the in to original array;
         k = 0;
        /*
        for (int i=0;i<maxx+1;i++){
            while (frequency[i]!=0){
                nums[k++] = i;
                frequency[i]-=1;
            }
        }
        Time Complexity = O(n+k)
        */
        c = 0;
        while (c < maxx+1){
            if (frequency[c] > 0){
                nums[k++] = c;
                frequency[c]--;
            }else {
                c++;
            }
        }
//        Time Complexity = O(n)
    }
}