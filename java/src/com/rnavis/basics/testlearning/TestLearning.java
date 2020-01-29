package com.rnavis.basics.testlearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree<T> {

    Node<T> root;

    public void add(T data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        add(root, data);
    }

    public boolean isPresent(T data) {
        if (root == null) {
            System.out.println("Empty tree.");
            return false;
        }
        return isPresent(root, data);
    }

    private boolean isPresent(Node current, T data) {
        if (current.compareTo(current.data, data) == 0) {
            return true;
        } else if (current.compareTo(current.data, data) > 0) {
            if (current.left == null) {
                return false;
            }
            return isPresent(current.left, data);
        } else {
            if (current.right == null) {
                return false;
            }
            return isPresent(current.right, data);
        }
    }

    private void add(Node current, T data) {
        if (current.compareTo(current.data, data) <= 0) {
            if (current.right == null) {
                current.right = new Node(data);
                return;
            }
            add(current.right, data);
        } else {
            if (current.left == null) {
                current.left = new Node(data);
                return;
            }
            add(current.left, data);
        }
    }

    public Object minimum() {
        if (root == null) {
            System.out.println("tree is empty");
            return null;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public Object maximum() {
        if (root == null) {
            System.out.println("tree is empty");
            return null;
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public void breadthFirstPrint() {
            if (root == null) {
                return;
            }
            StringBuffer sb = new StringBuffer();
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                sb.append(queue.remove().data + " > ");
            }
        System.out.println(sb.toString());

    }

    public void preOrder() {
        if (root == null) {
            return;
        }
        preOrder(root);

    }
    public void preOrder(Node node) {
        System.out.print(node.data +" >>");
        while (node.left!= null) {
            preOrder(node.left);
        }
        while(node.right!=null) {
            preOrder(node.right);
        }
    }

    public List<T> inOrder() {
        if (root == null) {
            return null;
        }
        List result = new ArrayList();
        inOrder(root,result);
        return result;
    }

    public void inOrder(Node node, List result) {
        if (node == null){
            return;
        }
        inOrder(node.left, result);
        result.add(node.data);
        inOrder(node.right,result);
    }

    public List postOrder() {
        if (root == null) {
            return null;
        }
        List result = new ArrayList();
        postOrder(root,result);
        return result;
    }

    public void postOrder(Node node, List result) {
        if (node == null) {
            return;
        }
        postOrder(node.left, result);
        postOrder(node.right,result);
        result.add(node.data);
    }

    public void invert() {
        if (root == null) {
            return;
        }
        invert(root);
        System.out.println(" inverted "+ root);
    }
    public void invert(Node root) {
        if (root == null){
            return;
        }
        Node temp = null;
        invert(root.left);
        invert(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T data) {
        this.data = data;
    }

    public int compareTo(T first, T second) {
        if (first instanceof String) {
            return ((String) first).compareTo((String) second);
        }
        if (first instanceof Integer) {
            return (Integer) first - (Integer) second;
        } else {
            return 0;
        }
    }
}

public class TestLearning {
    public static void main(String args[]) {
        try {
            BinaryTree stringTree = new BinaryTree();
            BinaryTree integerTree = new BinaryTree();
            integerTree.add(15);
            integerTree.add(17);
            integerTree.add(9);
            integerTree.add(14);
            integerTree.add(3);
            integerTree.add(32);
            integerTree.add(16);
            integerTree.add(28);
            integerTree.add(-1);
            integerTree.add(-32);
            integerTree.add(7);
            integerTree.add(5);
            integerTree.add(4);

            stringTree.add("j");
            stringTree.add("m");
            stringTree.add("f");
            stringTree.add("h");
            stringTree.add("i");
            stringTree.add("g");
            stringTree.add("d");
            stringTree.add("e");
            stringTree.add("b");
            stringTree.add("c");
            stringTree.add("q");
            stringTree.add("t");
            stringTree.add("p");
            stringTree.add("k");
            stringTree.add("z");
            System.out.println(stringTree);
            System.out.println("minimum =" + stringTree.minimum());
            System.out.println("maximum =" + stringTree.maximum());
            System.out.println(integerTree);
            System.out.println("minimum =" + integerTree.minimum());
            System.out.println("maximum =" + integerTree.maximum());
            System.out.println("is present = " + integerTree.isPresent(24));
            System.out.println("is present = " + integerTree.isPresent(-32));
            System.out.println("is present = " + integerTree.isPresent(17));
            System.out.println("is present = " + integerTree.isPresent(18));
            System.out.print("breadth first traversal ");
            stringTree.breadthFirstPrint();
            System.out.println("");
            System.out.print("integer breadth first traversal ");
            integerTree.breadthFirstPrint();
            System.out.println("");
           // System.out.print("Pre-order ");
           // integerTree.preOrder();
           // System.out.println("");
            System.out.print("In-order ");
            List inSorted = integerTree.inOrder();
            for (Object t: inSorted) {
                System.out.print(t.toString() + " > ");
            }
            System.out.println("");
            //System.out.print("Post-order ");
            //integerTree.postOrder();

            integerTree.invert();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}