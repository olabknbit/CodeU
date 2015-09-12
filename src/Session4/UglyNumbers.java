package Session4;
/*
in this excersise I probably compute to much. but I am not sure how to decrease it.
Also I think I could gain some efficiency by declaring my ascendingList as an attribute of the class and reusing it,
but to do so I would have to put it into an array or something not to lose data during polling.
This is what I wrote in around 20-15 minutes and I know it is not very good but at this point I suppose
I would need some tips from the interviewer in order to know what to do next, or do some research in the web, or maybe
have like an hour or so to think and analyze it carefully.

 */
import java.util.PriorityQueue;
public class UglyNumbers {
    public int kthUglyNumber(int k){
        if(k < 1) return 0;
        PriorityQueue<Integer> ascendingList = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            int number2 = (int) Math.pow(2,i);
            for(int j = 0; j < k - i; j++){
                int number3 = number2;
                number3*= Math.pow(3,j);
                for(int l = 0; l < k - i - j; l++){
                    int number5 = number3;
                    number5 *= Math.pow(5,l);
                    ascendingList.add(number5);
                }
            }

        }
        for(int i = 1; i < k; i++){
            ascendingList.poll();
        }
        return ascendingList.poll();

    }
    public static void main(String[] args){
        UglyNumbers uglyNumbers = new UglyNumbers();
        for(int i = 0; i < 50; i++){
            System.out.println(uglyNumbers.kthUglyNumber(i));
        }
    }
}
