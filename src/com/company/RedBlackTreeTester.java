package com.company;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTreeTester {

    boolean testSuite(RedBlackTree tree) {
        return rootIsBlack(tree) && noAdjacentRed(tree) && sameBlackPathLength(tree);
    }

    private boolean rootIsBlack(RedBlackTree tree) {
        return !tree.root.isRed;
    }

    private boolean noAdjacentRed(RedBlackTree tree) {
        return !noAdjacentRedHelper(tree.root);
    }

    private boolean sameBlackPathLength(RedBlackTree tree) {
        List<Integer> lengths = new ArrayList<>();

        sameBlackPathLengthHelper(tree.root, 0, lengths);

        for (int i = 1; i < lengths.size(); i++) {
            if (lengths.get(i) != lengths.get(i-1)) {
                return false;
            }
        }

        return true;
    }

    // Every path from the root to any of the leaf nodes must have the same number of black nodes.
    private void sameBlackPathLengthHelper(RedBlackNode curr, int height, List<Integer> list) {

        // at a leaf
        if (curr == null) {
            height += 1; // null leaf counts as black
            list.add(height);
            return;
        }

        if (!curr.isRed) {
            height += 1;
        }

        sameBlackPathLengthHelper(curr.left, height, list);
        sameBlackPathLengthHelper(curr.left, height, list);
    }

    private boolean noAdjacentRedHelper(RedBlackNode node) {

        if (node == null) {
            return false;
        }

        if (node.left != null && node.isRed && node.left.isRed) {
            return true;
        }

        if (node.right != null && node.isRed && node.right.isRed) {
            return true;
        }

        return noAdjacentRedHelper(node.left) || noAdjacentRedHelper(node.right);
    }
}
