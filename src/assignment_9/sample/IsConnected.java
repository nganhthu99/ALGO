package assignment_9.sample;

public class IsConnected extends BreadthFirstSearch {
	private int numComponents = 0;
	public IsConnected(Graph graph) {
		super(graph);
	}

	@Override
	public void additionalProcessing() {
		numComponents++;
	}

	public boolean isConnected() {
		start();
		return numComponents == 1;
	}
}
