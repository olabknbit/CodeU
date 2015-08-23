package Session3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromHighestToSmallestIterator extends BinaryTreeIterator {
    private List<String> listOfNodesToProcess;
    public BinaryTreeFromHighestToSmallestIterator(BinaryTreeNode binaryTreeNode) {
        listOfNodesToProcess = new ArrayList<>();
        addToList(binaryTreeNode);
    }

    private void addToList(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode == null){
            return;
        }
        addToList(binaryTreeNode.leftChild);
        listOfNodesToProcess.add(binaryTreeNode.payload);
        addToList(binaryTreeNode.rightChild);
    }

    @Override
    public boolean hasNext() {
        return !listOfNodesToProcess.isEmpty();
    }

    @Override
    public String next() {
        int len = listOfNodesToProcess.size();
        String result = listOfNodesToProcess.get(len-1);
        listOfNodesToProcess.remove(len-1);
        return result;
    }

}
