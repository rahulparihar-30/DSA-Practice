public class MergeSort {
    static void merge(int[] nums, int low,int mid,int high){
        int[] arr = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i<=mid && j <= high){
            if (nums[i] < nums[j]){
                arr[k] = nums[i];
                i++;
            }else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            arr[k] = nums[i];
            i++;
            k++;
        }

        while (j <= high){
            arr[k] = nums[j];
            j++;
            k++;
        }

        for(int m = low;m<=high;m++){
            nums[m] = arr[m-low];
        }
    }

    static void mergeSort(int[] nums,int n){
        for(int p = 2;p<=n;p=p*2){
            for (int i=0;i+p-1<n;i=i+p){
                // i = 0, p = 2, = 0+2-1 = 1 < 8
                int low = i,high = i+p-1;
                int mid = low + (high-low) / 2;
                // mid = 0 + (1-0) / 2 = 0.5 = 0;
                merge(nums,low,mid,high);
            }
            if (p/2 < n){
                merge(nums,0,p/2,n-1);
            }
        }
    }


    static void print(int[] nums){
        for (int num:nums){
            System.out.println(num);
        }
    }

    static void recursiveMergeSort(int[] nums, int low,int high){
        if (low< high){
            int mid = low + (high-low) / 2;
            recursiveMergeSort(nums,low,mid);
            recursiveMergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }
    public static void main(String[] args){
        int nums [] = {100,80,40,60,70,50,10,20,5};
        System.out.println("The Unsorted array is: ");
        print(nums);
        System.out.println();
//        mergeSort(nums,nums.length);
        recursiveMergeSort(nums,0,nums.length-1);
        print(nums);

    };
}