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
        System.out.println(arrayBackedStack.top());
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
        System.out.println("popped=" +linkedListBackedStack.pop());
        System.out.println(linkedListBackedStack.toString());
        System.out.println("top >>"+linkedListBackedStack.top());
        System.out.println("is Empty >>"+ linkedListBackedStack.isEmpty());
        System.out.println("popped=" +linkedListBackedStack.pop());
        System.out.println("popped=" +linkedListBackedStack.pop());
        System.out.println("popped=" +linkedListBackedStack.pop());
        System.out.println("is Empty >>"+ linkedListBackedStack.isEmpty());
        linkedListBackedStack.push(100);
        linkedListBackedStack.push(200);
        linkedListBackedStack.push(300);
        System.out.println(linkedListBackedStack.toString());

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
    public T pop() {
        if (head == null) {
            return null;
        }
        T data = (T)head.data;
        Node current = head.next;
        head = current;
        return data;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public T top() {
        if(head == null){
            return null;
        }
        return (T)head.data;
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
    }
}

