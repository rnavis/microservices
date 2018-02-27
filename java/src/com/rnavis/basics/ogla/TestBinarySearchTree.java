package com.rnavis.basics.ogla;

public class TestBinarySearchTree {

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(25);
        tree.insert(28);
        tree.insert(30);
        tree.insert(22);
        tree.insert(21);
        tree.insert(24);

        tree.search(24);
        tree.search(15);
        tree.search(0);
        tree.search(29);

        System.out.println("Minimum = "+ tree.minimum());
        System.out.println("Maximum = "+ tree.maximum());
        tree.insert(27);
        tree.insert(32);
        tree.insert(0);
        System.out.println("Minimum = "+ tree.minimum());
        System.out.println("Maximum = "+ tree.maximum());
    }
}
class BinarySearchTree {

    Node root;
    BinarySearchTree() {
        root = null;
    }
    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
    }
    private void insert(Node rootNode, int data) {
       if (rootNode.data >= data) {
           if (rootNode.left != null)
               insert(rootNode.left, data);
           else {
               rootNode.left = new Node(data);
               return;
           }
       } else if (rootNode.data < data) {
           if (rootNode.right != null)
               insert(rootNode.right, data);
            else {
               rootNode.right = new Node(data);
               return;
           }
       }

    }

    boolean search(int data) {
        return search(root, data);
    }
    private boolean search(Node current, int data) {
        if (current == null) {
            System.out.println("match not found");
            return false;
        }
        if (current.data == data) {
            System.out.println("match found");
            return true;
        }
        if (current.data < data) {
            return search(current.right, data);
        } else {
            return search(current.left, data);
        }
    }

    int minimum() {
        return minimum(root);
    }
    private int minimum(Node current) {
        if (current.left == null) {
            return current.data;
        } else {
            return minimum(current.left);
        }
    }

    int maximum() {
        return maximum(root);
    }
    private int maximum(Node current) {
        if (current.right == null) {
            return current.data;
        } else {
            return maximum(current.right);
        }
    }

    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
}
