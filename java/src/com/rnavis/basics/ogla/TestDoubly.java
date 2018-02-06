package com.rnavis.basics.ogla;

/**
 * Created by sivanr on 2/5/2018.
 */
public class TestDoubly {
    public static void main(String args[]) {
        Doubly list = new Doubly();
        list.addAtFront(1);
        list.addAtFront(2);
        list.addAtFront(3);
        list.addAtEnd(8);
        list.addAtEnd(9);
        list.addAtFront(0);
        System.out.println(list.toString());
        list.popAtFront();
        System.out.println(list.toString());
        list.popAtEnd();
        System.out.println(list.toString());
    }
}
class Doubly {
    DNode head;
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        DNode current= head;
        while(current != null) {
            builder.append(current.data+ " ->");
            current =current.next;
        }
        return builder.toString();
    }

    void addAtEnd(int data) {
        DNode temp = new DNode(data);
        if (head == null){
            head = temp;
        } else {
            DNode current = head;
            while(current != null) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    break;
                }
            }
            current.next = temp;
            temp.prev = current;
        }
    }

    void addAtFront(int data) {
        DNode temp = new DNode(data);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    void popAtFront() {
        if (head == null) {
            return;
        }
        DNode temp = head.next;
        temp.prev = null;
        head = temp;
    }

    void popAtEnd() {
        if (head == null) {
            return;
        }
        DNode current = head;
        while(current != null) {
            if (current.next != null) {
                current = current.next;
            } else {
                break;
            }
        }
        current.prev.next = null;
        current.next = null;
    }
}
class DNode {
    DNode prev;
    DNode next;
    int data;
    DNode(int data) {
        this.data = data;
    }
}
