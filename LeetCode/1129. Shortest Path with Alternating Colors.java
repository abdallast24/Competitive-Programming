import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Solution {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

		// Initialization

		ArrayList<Child> edges[] = new ArrayList[n];
		int distance[] = new int[n];
		boolean vis[][] = new boolean[n][2];

		vis[0][1] = vis[0][0] = true;
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<Child>();
			distance[i] = -1;
		}

		for (int i = 0; i < redEdges.length; i++)
			edges[redEdges[i][0]].add(new Child(redEdges[i][1], true));

		for (int i = 0; i < blueEdges.length; i++)
			edges[blueEdges[i][0]].add(new Child(blueEdges[i][1], false));

		// BFS implementation

		ArrayDeque<Child> q = new ArrayDeque<Child>();
		q.addLast(new Child(0, true));
		distance[0] = 0;

		Child node;

		while (!q.isEmpty())
		{
			node = q.removeFirst();
			for (Child child : edges[node.node])
				if ((node.node == 0 && child.node != 0 || node.isEdgeRed && !child.isEdgeRed && !vis[child.node][0]
						|| !node.isEdgeRed && child.isEdgeRed && !vis[child.node][1])) {

					child.cost = node.cost + 1;
					q.addLast(child);

					if (distance[child.node] == -1)
						distance[child.node] = child.cost;

					if (child.isEdgeRed)
						vis[child.node][1] = true;
					else
						vis[child.node][0] = true;

				}

		}

		return distance;

	}
}

class Child {

	int node;
	boolean isEdgeRed;
	int cost;

	public Child(int node, boolean isEdgeRed) {
		this.node = node;
		this.isEdgeRed = isEdgeRed;
	}

}
