import Open.*;
class Hashing{
    public static void main(String[] args){
        Chaining ch = new Chaining();
        int[] nums = {16,12,25,39,6,122,5,68,75};
        ch.buildTable(nums);
        ch.display();
        ch.search(122);
        ch.search(123);
        ch.delete(25);
        ch.display();
        ch.delete(80);
    }
}