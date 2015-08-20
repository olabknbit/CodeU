/**
 * Created by Olka on 2015-08-19.
 */
public class Question1{
    public static void main(String[] args) {

        String[] sampleArray = new String[]{"a","b","d","cat", "trial", "ocean","c",""};
        TrivialDictionary test1 = new TrivialDictionary(sampleArray);
        //6 times true
        for(String word : sampleArray) {
            System.out.println("Word '" +word + "' is in dictionary (" + test1.isInDictionary(word) +")");
        }
        String word = "e";
        //false
        System.out.println("Word '" + word + "' is in dictionary (" + test1.isInDictionary(word) + ")");
        TrivialDictionary.setDictionary(new String[]{"ala", "ela", "ela", "co", "cela"});
        //false
        System.out.println("Word '" + word + "' is in dictionary (" + test1.isInDictionary(word) + ")");
        word = "ela";
        //true
        System.out.println("Word '" +word + "' is in dictionary (" + test1.isInDictionary(word) + ")");
        word = "trial";
        //false
        System.out.println("Word '" + word + "' is in dictionary (" + test1.isInDictionary(word) + ")");
        TrivialDictionary.setDictionary(new String[]{});
        //false
        System.out.println("Word '" + word + "' is in dictionary (" + test1.isInDictionary(word) + ")");
    }
}
