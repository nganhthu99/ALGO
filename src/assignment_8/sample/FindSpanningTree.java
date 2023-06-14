package assignment_8.sample;


import java.util.*;

public class FindSpanningTree extends BreadthFirstSearch {
	private ArrayList<Edge> tree = new ArrayList<Edge>();
	public FindSpanningTree(Graph graph) {
		super(graph);
	}
	protected void processEdge(Edge e) {
			tree.add(e);
	}

	public Graph computeSpanningTree() {
		start();
		//tree has been populated
		Edge[] edges = tree.toArray(new Edge[0]);
		Graph newG  = new Graph(edges);
		return newG;
	}
}