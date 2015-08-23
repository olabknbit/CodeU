package Session3;

import java.util.ArrayList;
import java.util.List;

/**
 This strategy gives only the strings which length is even
 */
public class BinaryTreeOnlyEvensIterator extends BinaryTreeIterator {
    private List<String> listOfNodesToProcess;
    public BinaryTreeOnlyEvensIterator(BinaryTreeNode binaryTreeNode) {
        listOfNodesToProcess = new ArrayList<>();
        addToList(binaryTreeNode);
    }
    private void addToList(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode == null){
            return;
        }
        addToList(binaryTreeNode.rightChild);
        if(binaryTreeNode.payload.length() % 2 == 0){
            listOfNodesToProcess.add(binaryTreeNode.payload);
        }
        addToList(binaryTreeNode.leftChild);
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
