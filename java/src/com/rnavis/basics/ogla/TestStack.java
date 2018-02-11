package com.rnavis.basics.ogla;

public class TestStack {

    public static void main(String args[]) {
        ArrayBackedStack<Integer> arrayBackedStack = new ArrayBackedStack<>(10);
        arrayBackedStack.push(1);
        arrayBackedStack.push(2);
        arrayBackedStack.push(3);
        arrayBackedStack.push(4);
        System.out.println(arrayBackedStack);
        arrayBackedStack.pop();
        System.out.println(arrayBackedStack.top().toString());
        System.out.println(arrayBackedStack);
        arrayBackedStack.pop();
        arrayBackedStack.pop();
        arrayBackedStack.pop();
        System.out.println(arrayBackedStack.isEmpty());

        LinkedListBackedStack<Integer> linkedListBackedStack = new LinkedListBackedStack<>();
        linkedListBackedStack.push(1);
        linkedListBackedStack.push(2);
        linkedListBackedStack.push(3);
        System.out.println(linkedListBackedStack.toString());
        linkedListBackedStack.pop();
        System.out.println(linkedListBackedStack.toString());
        System.out.println("top >>"+linkedListBackedStack.top());
        System.out.println("is Empty >>"+ linkedListBackedStack.isEmpty());
        linkedListBackedStack.pop();
        linkedListBackedStack.pop();
        linkedListBackedStack.pop();
        System.out.println("is Empty >>"+ linkedListBackedStack.isEmpty());
        linkedListBackedStack.push(100);
        linkedListBackedStack.push(200);
        linkedListBackedStack.push(300);
        linkedListBackedStack.push(400);
        linkedListBackedStack.push(500);
        System.out.println(linkedListBackedStack.toString());
        linkedListBackedStack.pop();
        System.out.println(linkedListBackedStack.toString());

        LinkedList list = new LinkedList();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

    }


}

class ArrayBackedStack<T> {

    int top = -1;
    T[] stack;
    ArrayBackedStack(int size) {
        stack = (T[])new Object[size];
    }

    void push(T data) {
        top= top +1;
        stack[top] = data;
    }

    void pop() {
        top = top -1;
        //not explicitly removing the data as this idx will be reused anyways
    }
    T top() {
        return stack[top];
    }
    boolean isEmpty() {
        return top == -1;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (top == -1) {
            return builder.toString();
        }
        int i =0;
        while (i <= top) {
            builder.append(stack[i]).append(" ->");
            i++;
        }
        return builder.toString();

    }
}

class LinkedListBackedStack<T> {

    Node head;

    // Always push at first
    public void push(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    // Always pop at first
    public void pop() {
        if (head == null) {
            return;
        }
        Node current = head.next;
        head = current;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node top() {
        return head;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (head == null) {
            return builder.toString();
        }
        Node current = head;
        builder.append(current.data).append(" -> ");
        while(current.next != null){
            builder.append(current.next.data).append(" -> ");
            current = current.next;
        }
        return builder.toString();
    }

    private class Node<T>{
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
        public String toString() {
            return data.toString();
        }
    }
}

