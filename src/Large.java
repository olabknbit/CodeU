import java.util.Random;

/**
 Create a class with:
 (1) a constructor that accepts an unordered array or vector of integers (your choice), and
 (2) a method nthLargest() that returns the nth largest integer from the original vector.
 For example, with an input of { 5, 3, 9, 4, 3, 3, 8, 3, 3 }, nthLargest(1) should return 9,
 and nthLargest(4) should return 4.  For inputs of zero or greater than the size of the input,
 nthLargest() should throw an exception.  The input array will be very large (but you can make a copy),
 and the input to nthLargest() may also be large, so a linear search algorithm is not acceptable.

 Hint:  If you ask “may I sort the input”, the answer will be “yes, but there is a more efficient approach”.
 If you ask for a hint regarding the more efficient approach,
 I’ll ask if it is necessary to fully sort the input to implement nthLargest().
 If that doesn’t help, I’ll suggest you proceed with the sort-based approach, then explore other possibilities.

 */
public class Large {
    int[] numbers;
    // place to where the numbers are sorted: numbers[sortedIndex] == nthLargest(sortedIndex+1)

    public Large(int[] numbers){
        this.numbers = numbers;
    }
    //swap elemts of numbers array at the specified indexes
    void swap(int index1, int index2){
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
    //sort from start inclusive to end exclusive (only parts that matter)
    int quicksort(int index, int start, int end){
        if(start == end) {
            return numbers[index];
        }
        if(end - start == 1){
            if (numbers[end] > numbers[start]){
                this.swap(start, end);
            }
            return numbers[index];
        }
        int pivot = numbers[start];
        int left = start;
        int right = end;
        while(left <= right ){
            while(left < end && numbers[left] > pivot){
                left++;
            }
            while(right >=0 && numbers[right] < pivot){
                right--;
            }
            if(left <= right){
                swap(right, left);
                left++;
                right--;
            }
        }


        if(start < left && index < right){
            return this.quicksort(index, start, right);
        }
        if( index == right){
            return numbers[index];
        }
        return this.quicksort(index, left , end);

    }

    public int nthLargest(int nth){
        if(nth >= numbers.length || nth == 0){
            throw new IllegalArgumentException("You have to ask for a number less than length of an array " +
                    "and greater than 0 in function nthLargest()");
        }
        return this.quicksort(nth-1, 0, numbers.length-1);
    }

    public static int[] createRandomArray(){
        Random random = new Random();
        int rows;
        rows = random.nextInt(10)+1;
        int[] test = new int[rows];
        // for each matrix I fill it with random numbers from 0 to 9,
        for(int j = 0 ; j<rows; j++){
            test[j] = random.nextInt(10);
        }
        return test;
    }
    void show(){
        for(int i : numbers){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random random = new Random();
        Large test1 = new Large(createRandomArray());
        test1.show();
        int index = random.nextInt(test1.numbers.length)+1;

        System.out.println(index + ": " +  test1.nthLargest(index));
        test1.show();

        Large test2 = new Large(new int[]{});
        System.out.println(index + ": " + test2.nthLargest(0));


    }

}
