package Session4;
import java.util.*;
/*
My first question that I would ask an interviewer is:
what should return this function when applied with a word that is not in the dictionary?
for example with a dictionary with "abba" and "jack" in it, and asking for split("aja") or split("ajack")??
should it throw an exception or maybe not change the word at all and return "aja" and "ajack"? or "a jack" in the second case
Then I thought of how I would write the easy split function:
    I would iterate through the input string and at each iteration
    I would check if the first and the second part of it are in the dictionary, if so I would then put those words
    (merged with a space in between) into the output list.
Then I started writing this harder function. Firstly I wanted to make a list of all the possiblities on the go,
but I thought that by making an array of indexes, my function could be more reusable
At the end I added a dictionary in main and tested it a bit with various inputs
I am aware that in function makeListOfStrings I could have reused some parts that were already produced,
but I had no more time to do so. Also I could have written my function split
so that it would remember all the possible options from the index at which it starts: for example:(given my dictionary in main)
at index 8 there are 3 possibilities: "a la", "al a", "ala"
at index 5 there are 4 possibilities: "kot a la", "kotal a", "kot ala", "kota la"
that way I would remember more but compute less I suppose, but as I wrote,
 my time which I was suppose to spend on the excersises was already extended a bit so I am submitting just this.

 */
public class Spliting {
    Map<String, String> dictionary;
    ArrayList<String> split(String words){
        // at each row,(for example at ith row) which represents ith index of a string word,
        // there are listed indexes at which may start the new string -
        // for example if we have string alamakotala with the dictionary which contains the words provided in main
        // at index 5 we have to existing words - "kot" and "kota"
        // so we put the possible indexes of the next word - 8 and 9 in this row
        if(words.length() < 1){
            ArrayList<String> result = new ArrayList<>();
            result.add("no input");
            return result;
        }
        int[][] indexes = new int[words.length()][];
        for(int i = 0; i < words.length(); i++){
            int counterForEachRow = 0;
            indexes[i] = new int[words.length()-i];
            for(int j = i+1; j <= words.length(); j++){
                String word = words.substring(i,j);
                if(dictionary.containsKey(word)){
                    indexes[i][counterForEachRow] = j;
                    counterForEachRow++;
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        makeListOfStrings(list, indexes,0,0,words,"");
        if(list.isEmpty()){
            list.add("The input you provided is incorrect!!!");
        }
        return list;
    }

   void makeListOfStrings(ArrayList<String> list, int[][] indexes, int row, int column, String word, String result){
       int counter = column;

        while(counter < indexes[row].length && indexes[row][counter] != 0){
            String result1 = result + word.substring(row, indexes[row][counter]) + " ";

            if(indexes[row][counter] == word.length()){
                list.add(result1);

            }
            else makeListOfStrings(list, indexes, indexes[row][counter],0, word, result1);
            counter ++;
        }
    }

    public static void main(String[] args){
        Spliting spliting = new Spliting();
        spliting.dictionary = new LinkedHashMap<>(); // konstruktor
        spliting.dictionary.put("a", "1");
        spliting.dictionary.put("al","2");
        spliting.dictionary.put("ala", "3");
        spliting.dictionary.put("kot", "4");
        spliting.dictionary.put("kota", "5");
        spliting.dictionary.put("la","6");
        spliting.dictionary.put("ma","7");
        spliting.dictionary.put("makota","8");
        spliting.dictionary.put("zola", "9");
        ArrayList <String> list = spliting.split("alamakotala");
        for(String s : list){
            System.out.println(s);

        }
        list = spliting.split("");
        for(String s : list){
            System.out.println(s);

        }
        list = spliting.split("miko");
        for(String s : list){
            System.out.println(s);

        }
    }

}
