package com.company;

public class Main {

    public static void main(String[] args) {
	    RedBlackTree tree = new RedBlackTree();
        RedBlackTreeTester tester = new RedBlackTreeTester();
	    RedBlackNode temp = new RedBlackNode(43);
        RedBlackNode temp1 = new RedBlackNode(23);
        RedBlackNode temp2 = new RedBlackNode(27);
        RedBlackNode temp3 = new RedBlackNode(120);

        tree.insert(new RedBlackNode(8));
        tree.insert(new RedBlackNode(18));
        tree.insert(new RedBlackNode(5));
        tester.testSuite(tree);
        tree.insert(new RedBlackNode(15));
        tree.insert(new RedBlackNode(17));
        tree.insert(temp);
        tester.testSuite(tree);
        tree.insert(new RedBlackNode(25));
        tree.insert(temp1);
        tree.insert(new RedBlackNode(100));
        tree.delete(temp1);
        tester.testSuite(tree);
        tree.delete(temp);
        tester.testSuite(tree);
    }
}
