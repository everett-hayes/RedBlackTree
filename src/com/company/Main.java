package com.company;

public class Main {

    public static void main(String[] args) {
	    RedBlackTree tree = new RedBlackTree();
        RedBlackTreeTester tester = new RedBlackTreeTester();
	    RedBlackNode temp = new RedBlackNode(43);

        tree.insert(new RedBlackNode(8));
        tree.insert(new RedBlackNode(18));
        tree.insert(new RedBlackNode(5));
        System.out.println(tester.testSuite(tree));
        tree.insert(new RedBlackNode(15));
        tree.insert(new RedBlackNode(17));
        tree.insert(temp);
        System.out.println(tester.testSuite(tree));
        tree.insert(new RedBlackNode(25));
        tree.insert(new RedBlackNode(40));
        System.out.println(tester.testSuite(tree));
        tree.insert(new RedBlackNode(80));
        tree.delete(temp);
        System.out.println(tester.testSuite(tree));
    }
}
