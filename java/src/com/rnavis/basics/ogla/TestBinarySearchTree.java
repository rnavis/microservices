package com.rnavis.basics.ogla;

import java.util.*;
import java.util.LinkedList;

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
        System.out.println("My Height = "+tree.myheight());
        System.out.println("line of command - Bread First ");
        tree.breadthFirst();
        System.out.println("");
        System.out.println("line of command - Pre-Ordered ");
        tree.preOrder();
        System.out.println("");
        System.out.println("line of command - In-Ordered ");
        tree.inOrder();
        System.out.println("");
        System.out.println("line of command - Post-Ordered ");
        tree.postOrder();
        System.out.println("");
    }
}
class BinarySearchTree {

    Node root;
    BinarySearchTree() {
        root = null;
    }

    void postOrder() {
        if (root == null) {
            System.out.println("empty");
            return;
        } else {
            postOrder(root);
        }
    }

    private void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.data + " - ");
    }
    void inOrder() {
        if (root == null) {
            System.out.println("empty..");
            return;
        }
        inOrder(root);
    }
    private void inOrder(Node current) {
        if (current == null)
            return;
        inOrder(current.left);
        System.out.print(current.data + " - ");
        inOrder(current.right);
    }
    void preOrder() {
        if (root == null) {
            System.out.println("empty..");
            return;
        }
        preOrder(root);
    }
    private void preOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " - ");
        preOrder(current.left);
        preOrder(current.right);
    }

    void breadthFirst() {
        if (root == null) {
            System.out.println("empty..");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        breadthFirst(queue);

    }

    private void breadthFirst(Queue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        System.out.print(queue.peek().data+" - ");
        if (queue.peek().left != null)
            queue.add(queue.peek().left);
        if (queue.peek().right != null)
            queue.add(queue.peek().right);
        queue.remove();
        breadthFirst(queue);
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

    int myheight() {
        return myHeight(root);
    }

    private int myHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = myHeight(root.left);
        int rightHeight = myHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
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
