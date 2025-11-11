public class BinaryHeap {
    int[] heap;
    int capacity,size;

    BinaryHeap(){
        this.capacity = 10;
        this.heap = new int[this.capacity];
        this.size = 1;
    }

    public void insert(int num){
        if (size==capacity){
            System.out.println("Heap is Full.");
            return;
        }
        int i = size;
        heap[i] = num;
        while (i > 1 && num > heap[i/2]){
            heap[i] = heap[i/2];
        }
        heap[i] = num;
        size++;
    }

    public int delete(){
        int topMost = heap[1];
        int i = 1;
        int j = i*2;
        heap[1] = heap[size];
        heap[size] = topMost;
        size--;
        while (j < size){
            if (heap[j+1] > heap[j]){
                j+=1;
            }
            if (heap[i] < heap[j]){
                int temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
                i=j;
                j=2*i;
            }else {
                break;
            }
        }
        return topMost;
    }

    public void heapify(int[] nums,int n,int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i + 2;

        if (left < n && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest!=i){
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(nums,n,largest);
        }
    }

    public void heapSort(int[] nums){
        int n = nums.length;
        for (int i=n/2;i<n;i++){
            heapify(nums,n,i);
        }

        for (int i = n-1;i>0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums,n,0);
        }

        print(nums);
    }
    public void print(int[] nums){
        for (int num: nums){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        System.out.println("Binary Heap Demo\n");

        BinaryHeap bh = new BinaryHeap();

        int[] elements = {50, 30, 40, 10, 20, 35, 25};
        System.out.println("Inserting elements into heap...");
        for (int element : elements) {
            bh.insert(element);
        }

        System.out.println("\nHeap elements (1-based index):");
        for (int i = 1; i <= bh.size; i++) {
            System.out.print(bh.heap[i] + " ");
        }

        System.out.println("\n\nDeleting top (max) element: " + bh.delete());

        System.out.println("\nHeap after deletion:");
        for (int i = 1; i <= bh.size; i++) {
            System.out.print(bh.heap[i] + " ");
        }

        // Test Heap Sort separately
        System.out.println("\n\nHeap Sort Example:");
        int[] nums = {10, 40, 20, 50, 60, 30};
        bh.heapSort(nums);
    }


}
