package com.company;

public class RedBlackNode {

    int val;
    RedBlackNode parent;
    RedBlackNode left;
    RedBlackNode right;
    Boolean isRed;

    public RedBlackNode() {}

    public RedBlackNode(int val) {
        this.val = val;
    }
}
