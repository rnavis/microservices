package com.rnavis.basics.ogla;

import java.util.Scanner;

/**
 * 1. Implement an array backed queue. Array is cirular to allow infite enqueue/dequeue
 * Time complexity read: o(1) write: o(1)
 * Space complexity o(n)
 *   - create a array
 *   - initiate front and rear to -1
 *   - check if full
 *      # is full if it array is not empty and the next for rear == front
 *   - enqueue will add to rear
 *      # if empty, add to rear and update front and rear pointers to 0
 *      # if not empty, change rear to (rear + 1) mod sizeOfArray, this will let us go in rounds. Add to rear
 *   - dequeue will remove from front
 *      # if empty, return
 *      # if not empty, the check if full, rear and front are equal
 *            if rear == front, then we have reached the end of queue, reset rear and front to -1
 *            else remove from front and change front to (front + 1) mod sizeOfArray
 *      # return the dequeued data
 *
 *  2. Impelement a linkedlist backed queue if size becomes a constraint in array queue
 *  Time complexity read: o(1) write: o(1)
 *  space complexity - o(n)
 *   - Create a linkedlist
 *   - initiate front and rear nodes to null
 *   - check if empty: if front and null are null
 *   - enqueue: add to rear
 *          front points to start (head)
 *          rear points to last added entry node
 *   - dequeue: remove from front
 *          front pointer moved front.next
 *          if front.next is null, then we can mark rear to blank signalling the queue has becom empty.
 *
 */
public class TestQueue {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size of the Queue ");
        int size = scanner.nextInt();
        ArrayBackedQueue<Integer> arrayBackedQueue = new ArrayBackedQueue(size);
        arrayBackedQueue.enqueue(90);
        arrayBackedQueue.enqueue(91);
        arrayBackedQueue.enqueue(92);
        arrayBackedQueue.enqueue(93);
        arrayBackedQueue.enqueue(94);
        arrayBackedQueue.enqueue(95);
        arrayBackedQueue.enqueue(10000);
        System.out.println(arrayBackedQueue.toString());
        System.out.println("Dequeued  "+arrayBackedQueue.dequeue());
        arrayBackedQueue.enqueue(96);
        System.out.println("Dequeued  "+arrayBackedQueue.dequeue());
        System.out.println("Dequeued  "+arrayBackedQueue.dequeue());
        System.out.println("Dequeued  "+arrayBackedQueue.dequeue());
        System.out.println("Dequeued  "+arrayBackedQueue.dequeue());

        LinkedListBackedQueue linkedListBackedQueue = new LinkedListBackedQueue();
        linkedListBackedQueue.enqueue(10);
        linkedListBackedQueue.enqueue(11);
        linkedListBackedQueue.enqueue(12);
        linkedListBackedQueue.enqueue(13);
        System.out.println(linkedListBackedQueue.toString());
        System.out.println(linkedListBackedQueue.dequeue());
        System.out.println(linkedListBackedQueue.dequeue());
        System.out.println(linkedListBackedQueue.dequeue());
        System.out.println(linkedListBackedQueue.dequeue());
        System.out.println(linkedListBackedQueue.dequeue());
        linkedListBackedQueue.enqueue(14);
        System.out.println(linkedListBackedQueue.toString());
    }
}

class ArrayBackedQueue<T> {
    T[] array;
    int arraySize;
    int front;
    int rear;
    ArrayBackedQueue(int size) {
        array = (T[])new Object[size];
        arraySize = size;
        front = -1;
        rear = -1;
    }

    boolean isEmpty(){
        return front ==-1 && rear ==-1;
    }

    boolean isFull() {
        return !isEmpty() && (rear +1)%arraySize == front;
    }

    void enqueue(T data) {
        if (isEmpty()) {
            front = (front + 1) % arraySize;
            rear = (rear + 1) % arraySize;
        } else if (isFull()) {
            System.out.println("Queue is full !!");
            return;
        } else{
            rear = (rear + 1) % arraySize;
        }
        array[rear] = data;
    }

    T dequeue() {
     if (isEmpty()) {
         return null;
     } else {
         T data = array[front];
         if (front == rear) {
             front = -1;
             rear = -1;
         } else {
             front = (front +1)%arraySize;
             return data;
         }
         return data;
     }
    }
    T front() {
        return array[front];
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            return "Empty....";
        }
        if (rear<front) {
            for (int i = front; i< arraySize;i++) {
                sb.append(array[i] + " - ");
            }
            for (int i=0; i<=rear;i++) {
                sb.append(array[i] + " - ");
            }

        } else {
            for (int i = 0; i< arraySize;i++) {
                if (i >= front && i <= rear) {
                    sb.append(array[i] + " - ");
                }
            }
        }
        return sb.toString();
    }
}

class LinkedListBackedQueue<T> {

    Node rear;
    Node front;

    T front() {
        return (T)front.data;
    }
    boolean isEmpty(){
        if (rear == null) {
            return true;
        }
        return false;
    }
    void enqueue(T data) {
        Node newData = new Node(data);
        if (isEmpty()) {
            front = newData;
            rear = newData;
            return;
        } else {
            rear.next = newData;
            rear = rear.next;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            if (front == null) {
                return null;
            }
            T data = (T)front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            return sb.toString();
        }
        Node current = front;
        sb.append(current.data + " -> ");
        while(current.next != null) {
            sb.append(current.next.data + " -> ");
            current = current.next;
        }
        return sb.toString();
    }
    private class Node<T> {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }
}