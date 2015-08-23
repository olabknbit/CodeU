package Session3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromSmallestToHighestIterator extends BinaryTreeIterator{
    private List<String> listOfNodesToProcess;

    public BinaryTreeFromSmallestToHighestIterator(BinaryTreeNode root) {
        listOfNodesToProcess = new ArrayList<>();
        addToList(root);
    }
    private void addToList(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode == null){
            return;
        }
        addToList(binaryTreeNode.rightChild);
        listOfNodesToProcess.add(binaryTreeNode.payload);
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
