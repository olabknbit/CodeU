import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
A collection has a majority if a particular value appears more than 50% of the time.
For example { 5, 3, 9, 4, 3, 3, 8, 3, 3 } has a majority value of 3, and { 5, 3, 9, 4, 3, 3, 8, 3 } has no majority.
Write a boolean function hasMajority() that accepts an unordered collection of integers
(you can choose what collection type you would like to use)
and returns an Integer object with the majority value, or null if the collection has no majority.
 */
public class Majority {
    List<Integer> collection;

    public Majority(int[] collection){
        Integer[] list = new Integer[collection.length];
        for(int i = 0; i < collection.length; i++){
            list[i] = collection[i];
        }
        this.collection = new ArrayList<>(Arrays.asList(list));
    }
    boolean hasMajority(){

        Integer[] list = collection.toArray(new Integer[collection.size()]);
        int length = list.length;
        if(length == 0 ) {
            return false;
        }
        Arrays.sort(list);

        return list[0].equals(list[length / 2]) ||
                (length % 2 == 0 && list[length - 1].equals(list[length / 2 - 1])) ||
                (length % 2 == 1 && list[length - 1].equals(list[length / 2]));
    }

    public static void main(String[] args){
        Majority test1 = new Majority(new int[]{ 5, 3, 9, 4, 3, 3, 8, 3, 3 });
        Majority test2 = new Majority(new int[]{ 5, 3, 9, 4, 3, 3, 8, 3 });
        Majority test3 = new Majority(new int[]{});
        Majority test4 = new Majority(new int[]{1});
        System.out.println("true: " + test1.hasMajority());
        System.out.println("false: " + test2.hasMajority());
        System.out.println("false: " + test3.hasMajority());
        System.out.println("true: " + test4.hasMajority());



    }
}
