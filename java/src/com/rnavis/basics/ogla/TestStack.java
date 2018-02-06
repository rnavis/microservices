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
