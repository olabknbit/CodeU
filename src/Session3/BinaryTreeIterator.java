package Session3;

import java.util.ArrayList;

/**
 You should implement your iterator as a abstract class called BinaryTreeIterator.
 Then you should implement at least two different concrete subclasses that implement different traversal strategies.
 The user will instantiate the specific iterator or iterators for the traversal strategies they need.

 */
public abstract class BinaryTreeIterator {
    public abstract boolean hasNext();
    public abstract String next();
}
