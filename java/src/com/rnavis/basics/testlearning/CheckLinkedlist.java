package com.rnavis.basics.testlearning;

/**
 * Created by sivanr on 8/5/2018.
 */
public class CheckLinkedlist {
    public static void main(String args[]) throws Exception{
/*        TLinkedList ll = new TLinkedList();
        ll.add(5);
        ll.add(10);
        ll.add(4);
        ll.add(15);
        ll.add(25);
        ll.add(34);

        System.out.println(ll.toString());
        ll.reverse();
        System.out.println("reverse =");
        System.out.println(ll.toString());
        System.out.println(ll.middleElementWithoutSize());*/

        int[] array = {5,10,4,15,25,23,2};
        System.out.println("middle "+ new CheckLinkedlist().middleElementOfArray(array));
    }

    public int middleElementOfArray(int[] array) {
     int slow =0;
     for (int i=0;i<array.length;i++) {
         if (i>0 && i%2==0) {
             slow++;
         }
     }
     return array[slow];


    }
}


class TLinkedList {

    TNode root;

    public void add(int data) {
        if (root == null) {
            root = new TNode(data);
            return;
        }
        TNode current = root;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new TNode(data);
    }

    public void reverse() {
        if (root == null) return ;
        TNode current = root;
        TNode prev = null;
        TNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root= prev;
    }

    public int size() {
        int size = 0;
        if (root ==null) return size;
        TNode current = root;
        while(current !=null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public int middleElementWithoutSize() throws Exception {
        if (root == null) throw new Exception("unfound");
        TNode slowPointer =root;
        TNode fastPointer = root;
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
    }
    public String toString() {
        if (root == null) return "";
        TNode current = root;
        StringBuilder sb = new StringBuilder(0);
        while(current!= null) {
            sb.append(current.data).append(" > ");
            current = current.next;
        }
        return sb.toString();
    }
}
class TNode {
    int data;
    TNode next;
    TNode(int data) {
        this.data  = data;
    }
}

class TestDoublyLinkedList {
    TBiNode root;

    public void add(int data) {
        if (root == null) {
            root = new TBiNode(data);
            return;
        }
        TBiNode current = root;
        while (current.right !=null) {
            current = current.right;
        }
        current.right = new TBiNode(data);
        current.right.left = current;
    }
}
class TBiNode {
    int data;
    TBiNode left;
    TBiNode right;
    TBiNode(int data) {
        this.data = data;
    }
}
