package com.company;

public class RedBlackTree {

    RedBlackNode root;

    public RedBlackTree() {
        this.root = null;
    }

    public RedBlackTree(RedBlackNode x) {
        this.root = x;
    }

    private void leftRotate(RedBlackNode x) {

        RedBlackNode y = x.right;
        x.right = y.left;

        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RedBlackNode x) {

        RedBlackNode y = x.left;
        x.left = y.right;

        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    private void insert_fixup(RedBlackNode z) {

        while (z.parent != null && z.parent.isRed) {

            if (z.parent == z.parent.parent.left) {
                RedBlackNode y = z.parent.parent.right;


                if (y != null && y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    z = z.parent;
                    leftRotate(z);
                } else {
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                RedBlackNode y = z.parent.parent.left;

                if (y != null && y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else if (z == z.parent.left) {
                    z = z.parent;
                    rightRotate(z);
                } else {
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    leftRotate(z.parent.parent);
                }
            }
        }

        root.isRed = false;
    }

    void insert(RedBlackNode z) {

        RedBlackNode y = null;
        RedBlackNode x = root;

        while (x != null) {

            y = x;

            if (z.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;

        if (y == null) {
            root = z;
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }

        z.left = null;
        z.right = null;
        z.isRed = true;

        insert_fixup(z);
    }

    private void delete_fixup(RedBlackNode x) {

        while (x != root && !x.isRed) {

            if (x == x.parent.left) {
                RedBlackNode w = x.parent.right;

                if (w.isRed) {
                    w.isRed = false;
                    x.parent.isRed = true;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }

                if (!w.left.isRed && !w.right.isRed) {
                    w.isRed = true;
                    x = x.parent;
                } else if (!w.right.isRed) {
                    w.left.isRed = false;
                    w.isRed = true;
                    rightRotate(w);
                    w = x.parent.right;
                } else {
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    w.right.isRed = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                RedBlackNode w = x.parent.left;

                if (w.isRed) {
                    w.isRed = false;
                    x.parent.isRed = true;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }

                if (!w.right.isRed && !w.left.isRed) {
                    w.isRed = true;
                    x = x.parent;
                } else if (!w.left.isRed) {
                    w.right.isRed = false;
                    w.isRed = true;
                    leftRotate(w);
                    w = x.parent.left;
                } else {
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    w.left.isRed = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
    }

    RedBlackNode treeMinimum(RedBlackNode x) {

        while (x.left != null) {
            x = x.left;
        }

        return x;
    }

    RedBlackNode treeSuccessor(RedBlackNode x) {

        if (x.right != null) {
            return treeMinimum(x.right);
        }

        RedBlackNode y = x.parent;

        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    RedBlackNode delete(RedBlackNode z) {

        RedBlackNode y = null;

        if (z.left == null || z.right == null) {
            System.out.println("if true");
            y = z;
        } else {
            System.out.println("if false");
            y = treeSuccessor(z);
        }

        RedBlackNode x = null;

        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }

        if (x != null) {
            x.parent = y.parent;
        }

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        if (y != z) {
            z.val = y.val;
        }

        if (!y.isRed) {
            delete_fixup(x);
        }

        return y;
    }
}
