package com.company;

public class Main {

    public static void main(String[] args) {
	    RedBlackTree tree = new RedBlackTree();

	    RedBlackNode temp = new RedBlackNode(43);

        tree.insert(new RedBlackNode(8));
        tree.insert(new RedBlackNode(18));
        tree.insert(new RedBlackNode(5));
        tree.insert(new RedBlackNode(15));
        tree.insert(new RedBlackNode(17));
        tree.insert(temp);
        tree.insert(new RedBlackNode(25));
        tree.insert(new RedBlackNode(40));
        tree.insert(new RedBlackNode(80));

        tree.delete(temp);

        RedBlackTreeTester tester = new RedBlackTreeTester();

        System.out.println(tester.rootIsBlack(tree));
        System.out.println(tester.noAdjacentRed(tree));
        System.out.println(tester.sameBlackPathLength(tree));
    }
}
