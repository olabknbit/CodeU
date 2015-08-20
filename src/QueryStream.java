import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
    public Iterator<Query> iterator() {
        return new MyIterator();
    }
    boolean hasNext(){
        return false;
    }
    public class MyIterator implements Iterator<Query> {

        public boolean hasNext() {
            return false;
            //implement...
        }

        public Query next() {
            if(this.hasNext()){
                return QueryStream.this.list.get(0);
            }

            //implement...;
            return null;
        }


    }
}
