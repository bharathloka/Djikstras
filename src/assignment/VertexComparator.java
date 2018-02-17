package assignment;


import java.util.Comparator;

import assignment.Graph.Vertex;
/**
 * Class used for sorting elements in ascending order 
 *  @author - Rohith Pabbathi
 *
 */
public class VertexComparator implements Comparator<Vertex> {
	public int compare(Vertex x, Vertex y) {
		if (x.distance>y.distance)
			return 1;
		else
			return x.distance<y.distance ? -1 : 0;
	}
}
