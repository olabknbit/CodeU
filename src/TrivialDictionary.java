import java.util.Arrays;
import java.util.Objects;

public class TrivialDictionary {
    private static String[] dictionary;
    private static boolean dictionaryHasChanged;
    private static int length;

    public static void setDictionary(String[] dictionary){
        Arrays.sort(dictionary);
        TrivialDictionary.dictionary = dictionary;
        dictionaryHasChanged = true;
    }
    public TrivialDictionary(String[] dictionary){
        TrivialDictionary.setDictionary(dictionary);
    }
    public static String wordAt(int index){
        return index < dictionary.length ? dictionary[index] : null;
    }
    public static int findTheLengthOfDictionary(){
        if(!dictionaryHasChanged){
            return length;
        }
        dictionaryHasChanged = false;

        //when number of words in the dictionary is less than 26
        // it is better to iterete through it in order to find the length
        if(TrivialDictionary.wordAt(26) == null){
            int index = 0;
            while(TrivialDictionary.wordAt(index) != null){
                index++;
            }
            length = index;
            return length;
        }
        //otherwise I binarysearch the end
        int right = Integer.MAX_VALUE-1;
        int last = Integer.MAX_VALUE;
        while((TrivialDictionary.wordAt(right) == null) && (last != right)){
            last = right;
            right = right/2;
        }
        int middle;
        while(!(TrivialDictionary.wordAt(right) != null && TrivialDictionary.wordAt(right + 1) == null)) {
            middle = ( right + last ) / 2;
            if (TrivialDictionary.wordAt(middle) != null) {
                right = middle;
            } else {
                last = middle;
            }
        }
        length = right+1;
        return length;
    }
    public boolean isInDictionary(String word){
        //assuming we cannot use dictionary.length


        int left = 0;
        int right = TrivialDictionary.findTheLengthOfDictionary();
        if(right == 0) return false;
        int middle = left+1;
        while(left < right-1 || left < middle){
            middle = ( right + left ) / 2;
            int result = word.compareTo(TrivialDictionary.wordAt(middle));
            if (result == 0){
                return true;
            }
            if(result < 0){
                right = middle;
            }
            else {

                left = middle;
            }
        }
        return left + 1 == right && word.equals(TrivialDictionary.wordAt(right));

    }

}
