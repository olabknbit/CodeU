import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Query {
    public Timestamp timestamp;
    /*
    some additional fields we don’t care about right now
     */
    //contains a list of words separated by white space.
    public String words;
    public Query(String words){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.words = words;
    }
}

