package my.algo.graph.breadthfirstsearch;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	// total no. of node or vertex in graph
	private int v;
	
   // linked adjacency list 
	private LinkedList<Integer> adj[];
	
   public Graph(int v) {
	   this.v = v;
	   adj = new LinkedList[v];
	   for(int i =0; i<v; i++) {
		   adj[i] = new LinkedList<Integer>();
	   }
   }
   
   public void addEdge(int v , int w) {
	   adj[v].add(w);
	   adj[w].add(v);
   }

// Prints BFS traversal from a given source
	public void bfs(int source) {

		// Mark all the vertices as not visited (by default set as false)
		boolean visited[] = new boolean[v];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {

			// Dequeue a vertex from queue and print it
			source = queue.poll();
			System.out.print(source + " ");

			// Get all adjacent vertices of the dequeued vertex source
			Iterator<Integer> iterator = adj[source].listIterator();

			// If an adjacent vertex has not been visited, then mark it visited and enqueue it
			while (iterator.hasNext()) {
				int n = iterator.next();

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	/*
	Graph
	  1 -- 2 -- 3
	 /      \    \
	0 -- 7   8 -- 4
	 \       |    /
	  5 ____ 6 __/
	*/
	public static void main(String args[]) {
		Graph g = new Graph(9);

		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(0, 7);
		g.addEdge(1, 2);
		g.addEdge(5, 6);
		g.addEdge(2, 8);
		g.addEdge(6, 8);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		g.addEdge(4, 6);
		g.addEdge(4, 8);

		System.out.println("Following is Breadth First Traversal (starting from vertex 0): ");
		g.bfs(0);
	}
}