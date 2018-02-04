package com.rnavis.basics.ogla;

public class TestLinkedList {

    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList();
        list.add("test");
        list.add("ncn");
        list.add("cnp");
        list.add("pc");
        list.add("cn");
        list.add("jest");
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println(list.get(2).data);
        //System.out.println("removal status "+list.remove("test"));
        //System.out.println(list.toString());
        System.out.println(list.getSize());
        //System.out.println(list.get(2).data);
        list.reverse();
        System.out.println(list.toString());
    }
}

class LinkedList<T> {

    Node head;
    int size;

    public void add(T data) {

        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.setNext(new Node(data));
        size++;
    }

    public void reverse() {
        Node current = head;
        Node next = null;
        Node previous = null;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head= previous;
    }
    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        Node current = head;
        if (current.data.equals(data)) {
            head = current.next;
            size--;
            return true;
        }
        while(current.next != null) {
            if (data.equals(current.next.data)) {
                if (current.next.next != null) {
                    current.next.data = current.next.next.data;
                    current.next = current.next.next;
                } else {
                    current.next = null;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node<T> get(int index) {
        Node current = head;
        int currentindex = 0;
        if (index == 0) {
            return head;
        }
        while(current.getNext() != null) {
            current = current.getNext();
            currentindex++;
            if (currentindex == index) {
                return current;
            }
        }
        return null;
    }
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (head.next== null) {
            builder.append(head.data);
        } else {
            Node current = head;
            while(current.next != null) {
                builder.append(current.data).append(" ->");
                current = current.next;
            }
            builder.append(current.data);
        }
        return builder.toString();
    }

}

class Node<T> {
    T data;
    Node next;
    Node(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
