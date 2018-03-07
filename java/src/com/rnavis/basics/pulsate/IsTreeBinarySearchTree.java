package com.rnavis.basics.pulsate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class IsTreeBinarySearchTree {

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(30);
        tree.root.left = new Node(15);
        tree.root.right = new Node( 55);
        tree.root.left.right = new Node( 20);
        tree.root.left.left = new Node(7);
        tree.root.right.left = new Node( 35);
        tree.root.right.left.left = new Node(33);
        tree.root.right.right = new Node( 60);
        System.out.println("is bst = "+tree.isBinarySearchTree(tree.root));
        System.out.println("height ="+tree.height(tree.root));
        tree.printlevelwise(tree.root);
        System.out.println("");
        tree.printNodesAtLevel(tree.root, 3); //BFS
        System.out.println();
        tree.printAllLeafNodes(tree.root);
    }
}
class BinaryTree {

    void printAllLeafNodes(Node root) {
        if(root== null) {
            System.out.println("empty");
            return;
        }
        if (root.left== null && root.right == null)
            System.out.print(root.data + " ");
        if (root.left!= null)
            printAllLeafNodes(root.left);
        if (root.right != null)
            printAllLeafNodes(root.right);
    }
    void printNodesAtLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        printNodesAtLevel(root, height(root), level);
    }
    void printNodesAtLevel(Node root, int height, int level) {
        if (root == null) {
            return;
        }
        if (height == level) {
            System.out.print(root.data + " ");
        }
        printNodesAtLevel(root.left, height-1, level);
        printNodesAtLevel(root.right, height-1, level);
    }

    int height(Node root) {
        if (root == null) {
            return -1;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
    boolean isBinarySearchTree(Node root) {
        if (root == null)
            return true;
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree (Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data<min || root.data > max) {
            return false;
        }
        return isBinarySearchTree(root.left, min, root.data) &&
                isBinarySearchTree(root.right, root.data, max);
    }
    Node root;

    BinaryTree(int data) {
        root = new Node(data);

    }

    void printlevelwise(Node root) {
        if (root == null) {
            System.out.println("empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            System.out.print(queue.peek().data+ " ");
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.remove();
        }
    }
}
class Node {
    int data;
    public Node left;
    public Node right;
    Node(int data) {
        this.data = data;
    }
}

