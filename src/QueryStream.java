import java.sql.Timestamp;
import java.util.*;

/**
 You are working on a system that uses a QueryStream class.
 A QueryStream is basically a list of Query objects.

 Write the definitions for QueryStream and Query.  Then, create an iterator for the QueryStream class.
 The iterator should implement hasNext() and next().
 Each call to next() should return the next word from the string of words in the current Query in the QueryStream
 (starting with the first) and advance to the next Query when the current Query’s string is exhausted.
 Also, between the strings of two consecutive Queries, the iterator should return the string “<NEWQUERY>”.
 hasNext() should return true as long as there are words for next() to return.


 */
public class QueryStream {
    public List<Query> list;

    public QueryStream(List<Query> list){
        this.list = list;
    }
    public Iterator<String> iterator() {
        return new QueryStreamIterator();
    }

    public class QueryStreamIterator implements Iterator<String> {

        private final QueryStream queryStream;
        private int currentQuery;
        private int currentIndexOfQueryList;
        private Scanner scanner;
        private String[] wordsArray;
        private Timestamp timestamp;

        QueryStreamIterator() {
            // this keeps our QueryStream instance
            this.queryStream = QueryStream.this;
            this.currentQuery = 0;
            this.currentIndexOfQueryList = 0;
            this.scanner = new Scanner(this.queryStream.list.get(this.currentQuery).words).useDelimiter(" ");
            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            this.wordsArray = words.toArray(new String[words.size()]);
            this.timestamp= new Timestamp(System.currentTimeMillis());

        }
        public boolean hasNext() {
            if(wordsArray.length > currentIndexOfQueryList){
                return true;
            }
            else if(queryStream.list.size() > currentQuery+1){
                currentQuery++;
                scanner = new Scanner(queryStream.list.get(currentQuery).words).useDelimiter(" ");
                List<String> words = new ArrayList<>();
                while (scanner.hasNext()) {
                    words.add(scanner.next());
                }
                wordsArray = words.toArray(new String[words.size()]);
                currentIndexOfQueryList = -1;
                return hasNext();
            }
            return false;
        }

        public String next() {

            if(this.hasNext()){
                if(currentIndexOfQueryList == -1){
                    Timestamp oldTimestamp = timestamp;
                    timestamp = new Timestamp(System.currentTimeMillis());
                    currentIndexOfQueryList++;
                   //System.out.println(oldTimestamp.getNanos());
                    //System.out.println(timestamp.getNanos());
                    return (new Long( timestamp.getNanos() - oldTimestamp.getNanos())).toString();
                }
                currentIndexOfQueryList++;
                return wordsArray[currentIndexOfQueryList-1];
            }
            return null;
        }


    }
    private void loopThrough() {
        Iterator<String> queryIterator = this.iterator();
        while (queryIterator.hasNext()){
            System.out.println(queryIterator.next());
        }
    }
    public static void main(String[] args){
        List<Query> list = new ArrayList<>();
        list.add(new Query("uno dos tres"));
        list.add(new Query("cuatro cinco cinco"));
        list.add(new Query("seis"));
        list.add(new Query(""));
        list.add(new Query("siete ocho"));
        QueryStream qs = new QueryStream(list);
        qs.loopThrough();
        System.out.println(new Timestamp(System.currentTimeMillis()).getNanos());

    }
}
