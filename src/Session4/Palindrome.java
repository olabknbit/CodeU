package Session4;
import java.util.ArrayList;

/*
I used the attribute of a binary representation of a number that made my problem a lot easier: every binary number is
made up from itself divided by 2 plus a result of modulo operation on itself and 2.
That way if I had some numbers computed previously I can just use them to get my next number more easily,
and then just check if it is a palindrome or not, and keep all the record of the palindromes found as well.

 */

public class Palindrome {
    ArrayList<String> binaryRepresentation;
    ArrayList<Integer> palindromes;

    public Palindrome(){
        this.binaryRepresentation = new ArrayList<>();
        this.palindromes = new ArrayList<>();
        this.binaryRepresentation.add("0");
        this.binaryRepresentation.add("1");
        this.palindromes.add(0);
        this.palindromes.add(1);
    }

    int KthBinaryPalindrome(int k){
        for(int i = binaryRepresentation.size(); palindromes.size() <= k; i++) {
            String binaryNumber = binaryRepresentation.get(i/2);
            binaryNumber += i % 2;
            //System.out.println(binaryNumber);
            binaryRepresentation.add(binaryNumber);
            String reversedBinaryNumber = new StringBuffer(binaryNumber).reverse().toString();
            if(reversedBinaryNumber.equals(binaryNumber)){
                palindromes.add(i);
            }
        }
        return palindromes.get(k);
    }
    public static void main(String[] args){
        Palindrome p = new Palindrome();
        for(int i = 0; i < 100; i++) {
            System.out.println(i + " " + p.KthBinaryPalindrome(i));
        }
    }
}
