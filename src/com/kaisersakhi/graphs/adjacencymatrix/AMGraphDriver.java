package com.kaisersakhi.graphs.adjacencymatrix;

import com.kaisersakhi.graphs.GraphException;

public class AMGraphDriver {
    public static void main(String[] args) throws GraphException {
        AMGraph graph = new AMGraph(7, true);
        graph.addEdge(1,0, 1);
        graph.addEdge(2,0,1);
        graph.addEdge(2,1,1);
        graph.addEdge(3,0,1);

        graph.addEdge(3,2,1);
        graph.addEdge(4,2,1);
        graph.addEdge(4,3,1);
        graph.addEdge(5,4,1);
        graph.addEdge(6,4,1);

        graph.printEdges();
        graph.printMatrix();
        graph.bfs();
        graph.dfs();
    }
}
