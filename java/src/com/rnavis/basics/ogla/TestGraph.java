package com.rnavis.basics.ogla;

import java.util.*;
import java.util.LinkedList;

public class TestGraph {

    boolean isDigraph;
    int countOfVertices;
    LinkedList<Integer> adjacencyList[];

    public TestGraph(boolean isDigraph, int countOfVertices) {
        this.isDigraph = isDigraph;
        this.countOfVertices = countOfVertices;
        adjacencyList = new LinkedList[countOfVertices];
        for (int i=0;i<countOfVertices;i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String args[]) {
        System.out.println("Is it digraph true/false");
        Scanner sc = new Scanner(System.in);
        boolean isDigraph = sc.nextBoolean();
        System.out.println("No of vertices:");
        int vertices= 14;
        TestGraph graph = new TestGraph(isDigraph, vertices);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(3,7);
        graph.addEdge(5,8);
        graph.addEdge(6,9);
        graph.addEdge(7,10);
        graph.addEdge(8,11);
        graph.addEdge(9,11);
        graph.addEdge(10,11);
        graph.addEdge(10,12);
        graph.addEdge(12,13);
        while(true) {
            System.out.println("");
            /*System.out.println("Get neighbors of vertex");
            System.out.println("");
            graph.printNeighbours(sc.nextInt());*/
            System.out.println("Get start source vertex");
            System.out.println("");

            graph.breadthFirstSearch(sc.nextInt());
        }
    }
    public void breadthFirstSearch(int source) {
        boolean[] visited = new boolean[this.countOfVertices];
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        visited[source] =true;
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            LinkedList<Integer> neighbors = adjacencyList[vertex];
            if (!neighbors.isEmpty()) {
                for (Integer i: neighbors) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].addFirst(destination);
        if (!isDigraph) {
            adjacencyList[destination].addFirst(source);
        }
    }

    public void printNeighbours(int source) {
        if (adjacencyList[source] == null) {
            System.out.println("Non existent vertex");
            return;
        }
        LinkedList<Integer> neighbours = adjacencyList[source];
        for (Integer i:neighbours) {
            System.out.print("  " + i + " ");
        }
    }
}


