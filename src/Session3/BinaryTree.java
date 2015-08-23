package Session3;

import java.util.*;

public class BinaryTree{
    BinaryTreeNode root;

    public BinaryTree(){
        this.root = null;
    }
    public BinaryTree(BinaryTreeNode binaryTreeNode){
        this.root = binaryTreeNode;
    }

    /*Getter*/
    public BinaryTreeNode getRoot(){
        return this.root;
    }

    public void insert(String data) {
        this.root = insert(this.root, data);
     }

    private BinaryTreeNode insert(BinaryTreeNode currentBinaryTreeNode, String data) {
        if (currentBinaryTreeNode == null) {
            return new BinaryTreeNode(data);
        }
        if (data.compareTo(currentBinaryTreeNode.payload) <= 0) {
            currentBinaryTreeNode.leftChild = insert(currentBinaryTreeNode.leftChild, data);
        } else {
            currentBinaryTreeNode.rightChild = insert(currentBinaryTreeNode.rightChild, data);
        }
        return currentBinaryTreeNode;
    }
    //The iterator can be used with three strategies, ascending strategy is a default one
    public BinaryTreeIterator iterator(String strategy){
        if(strategy == null || strategy.equals("ascending")){
            return new BinaryTreeFromSmallestToHighestIterator(this.root);
        }
        if(strategy.equals("descending")){
            return new BinaryTreeFromHighestToSmallestIterator(this.root);
        }
        if(strategy.equals("only evens")){
            return new BinaryTreeOnlyEvensIterator(this.root);
        }
        else return null;
    }
    public static void printMyList(Map<Integer,String> list){
        for (Map.Entry<Integer,String> entry  : list.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.insert("5");
        bt.insert("7");
        bt.insert("9");
        bt.insert("8");
        bt.insert("2");
        bt.insert("-9");
        bt.insert("//ef");
        bt.insert("rat");
        bt.insert("cat");
        bt.insert("12");
        bt.insert("13");
        bt.insert("99");
        bt.insert("tree");
        bt.insert("bean");
        bt.insert("salute");

        System.out.println("'Flattened' binary tree");
        BinaryTreeIterator binaryTreeIterator = bt.iterator("ascending");
        while(binaryTreeIterator.hasNext()){
            System.out.println(binaryTreeIterator.next());
        }
        System.out.println("Only even lengths now:");
        binaryTreeIterator = bt.iterator("only evens");
        while(binaryTreeIterator.hasNext()){
            System.out.println(binaryTreeIterator.next());
        }

        BinaryTree testNull = new BinaryTree();
        binaryTreeIterator = testNull.iterator(null);
        while(binaryTreeIterator.hasNext()){
            System.out.println(binaryTreeIterator.next());
        }
    }
}


