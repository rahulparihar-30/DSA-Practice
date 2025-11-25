public class BucketSort {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public int getMax(int[] nums){
        int max = nums[0];
        for (int num:nums){
            if (max<num){
                max = num;
            }
        }
        return max;
    }
    public void bucketSort(int[] nums,int n){
        int j=0;
        int max = getMax(nums);
        ListNode[] bins = new ListNode[max+1];

        for (int num:nums){
            ListNode newNode = new ListNode(num);
            if (bins[num]==null){
                bins[num] =newNode;
            }else{
                ListNode temp = bins[num];
                while (temp.next!=null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        for (int i=0;i<max+1;i++){
            while(bins[i]!=null){
                nums[j++] = bins[i].data;
                bins[i] = bins[i].next;
            }
        }
    }
}