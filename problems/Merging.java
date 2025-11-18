class Merging{
    public static int[] mergingSorted(int[] nums1,int[] nums2){
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int mergedLength = nums1Length + nums2Length;
        int[] mergedList = new int[mergedLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1Length && j < nums2Length){
            if (nums1[i] < nums2[j]){
                mergedList[k] = nums1[i];
                i++;
            }else {
                mergedList[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1Length){
            mergedList[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2Length){
            mergedList[k] = nums2[j];
            j++;
            k++;
        }
        return mergedList;
    }

    public static void main(String[] args){
        int[] nums1 = {2,10,18,20,23};
        int[] nums2 = {4,9,19,25};

        int[] newList = mergingSorted(nums1,nums2);
        for (int item: newList){
            System.out.println(item);
        }
    }
}