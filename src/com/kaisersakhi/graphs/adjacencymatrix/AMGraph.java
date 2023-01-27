package com.kaisersakhi.graphs.adjacencymatrix;

import com.kaisersakhi.graphs.GraphException;
import com.kaisersakhi.queue.Queue;
import com.kaisersakhi.stack.Stack;

public class AMGraph {
    protected int[][] matrix;
    protected int nodeSize;

    protected boolean isUndirected;

    public AMGraph(int initialNodeCount, boolean isUndirected) {
        nodeSize = initialNodeCount > 0 ? initialNodeCount : 5;
        this.matrix = new int[nodeSize][nodeSize];
        this.isUndirected = isUndirected;
    }

    public void addEdge(int v, int u, int edgeCost) throws GraphException {
        if (v >= nodeSize || u >= nodeSize)
            throw new GraphException("Invalid node index V or U.");

        this.matrix[v][u] = edgeCost;
        if (isUndirected)
            this.matrix[u][v] = edgeCost;
    }

    public void removeEdge(int v, int u) {
        if (v < nodeSize && u < nodeSize) {
            this.matrix[v][u] = 0;
            if (isUndirected)
                matrix[u][v] = 0;
        }
    }

    public void printEdges() {
        String printMsg =
                isUndirected ?
                        "Remember Graph is Undirected, if (x,y) is there then (y,x) is also present." :
                        "Remember Graph is Directed, These are all the edges present.";
        System.out.println(printMsg);
        System.out.print("[");

        for (int i = 0; i < nodeSize; ++i) {
            for (int j = 0; j < (isUndirected ? i : nodeSize); ++j) {
                if (matrix[i][j] != 0)
                    System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.print("]");
    }

    public void printMatrix() {
        for (int i = 0; i < nodeSize; ++i) {
            for (int j = 0; j < nodeSize; j++)
                System.out.print("" + matrix[i][j] + ", ");

            System.out.println();

        }
    }

    public void bfs(){
        System.out.println();
        Queue<Integer> queue = new Queue<>();
        int[] visitTable = new int[nodeSize];
        queue.enqueue(nodeSize - 1);
        System.out.print("Visiting Nodes : "+(nodeSize-1)+", ");
        visitTable[nodeSize - 1] = 1;
        int node;
        while (queue.isNotEmpty()){
            node = queue.dequeue();
            for (int i = 0; i < nodeSize; ++i){
                if (matrix[node][i] != 0 && visitTable[i] == 0){
                    visitTable[i] = 1;
                    System.out.print(""+i+", ");
                    queue.enqueue(i);
                }
            }

        }
    }

    public void dfs(){
        System.out.println("\nPerforming Depth First Search.....");
        Stack<Integer> stack = new Stack<>();
        int vertex = nodeSize -1;
        int[] visitTable = new int[nodeSize];
        System.out.print(""+vertex+", ");
        visitTable[vertex] = 1;
        stack.push(vertex);

        while (stack.isNotEmpty()){
            vertex = stack.pop();
            for (int i = 0; i < nodeSize; ++i){
                if (matrix[vertex][i] != 0 && visitTable[i] == 0){
                    System.out.print(""+i+", ");
                    stack.push(i);
                    visitTable[i] = 1;
                    //reset loop to new vertex
                    vertex = i;
                    i = 0;
                }
            }
        }
    }
}
