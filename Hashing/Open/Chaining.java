package Open;

public class Chaining {
    /*
    It is the process which takes extra space and store the colided element in a linkedlist.
     */
    Node[] hashTable;
    Chain List;

    public Chaining(){
        this.hashTable = new Node[10];
        this.List = new Chain();
    }

    int hashFn(int x){
        return x%10;
    }

    public void buildTable(int[] nums){
        int index;
        System.out.println("Building Hash Table.");
        for (int num:nums){
            index = hashFn(num);
            hashTable[index] = List.insert(hashTable[index],num);
        }
        System.out.println("Done Buidling Hashtable");
    }

    public void search(int x){
        int index = hashFn(x);
        Node element = List.search(hashTable[index],x);
        if (element!= null){
            System.out.println("Element is present");
        }else {
            System.out.println("Elment not found.");
        }
    }

    public void delete(int x){
        int index = hashFn(x);
        System.out.println("Deletion in progress ......");
        hashTable[index] = List.delete(hashTable[index],x);
        System.out.println("Done Deleting");
    }

    public void display(){
        int index = 0;
        for (Node num:hashTable){
            System.out.print(index + ":");
            List.display(num);
            index++;
            System.out.println();
        }
    }
}