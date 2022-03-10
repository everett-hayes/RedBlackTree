package com.company;

/* Academic Honesty Certification
 * Written sources used:
 * (Include textbook(s), complete citations for web or other written sources.
 * Note that you are only allowed to use the web for syntax.
 * Write "none" if no sources used.)
 *
 * none
 *
 * Help obtained: (Include names of anyone other than the instructor.)
 *
 * none
 *
 * My written or typed signature below confirms that the above list
 * of sources is complete.
 * Signatures:
 *  Everett Hayes
 *  Himanshu Bainwala
 * */
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
