package assignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

import assignment.Graph.Edge;
import assignment.Graph.Vertex;
/**
 * Class to find the shortest path in a graph
 * 
 * @authors 
 * 		- Bharath Loka	 
 * 					
 *          			
 */
public class Dijkstra {
	public static void main(String args[]) throws FileNotFoundException {
Scanner in;
		
		if (args.length > 0) {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		} else {
			in = new Scanner(System.in);
		}
		Graph g = Graph.readDirectedGraph(in);
		System.out.println("\nEnter source vertex ");
		Vertex s=g.getVertex(in.nextInt());
		System.out.println("Enter Destination vertex");
		Vertex d=g.getVertex(in.nextInt());
		dijkstra(g,s,d);
		Vertex r=d.parent;
		Stack<Vertex> st=new Stack<>();
		System.out.println("The Shortest path from "+(s.name+1) +" to "+(d.name+1)+" is :");
		if (d.name==s.name) {
			System.out.println(d.name);
			System.out.println("Distance "+d.distance);
		}
		else {
		while (r.name!=s.name) {
		st.push(r);
		r=r.parent;
		}
		System.out.print(s.name+1+" -> ");
		while (!st.isEmpty())
			System.out.print((st.pop().name+1) +" -> ");
		System.out.println(d.name+1);
		System.out.println("Distance : "+d.distance);
	}
	}
/**
 * Internal method to find the shortest path in a given graph g
 * @param g
 * @param s
 * @param d
 */
	private static void dijkstra(Graph g, Vertex s, Vertex d) {
		
		
		for (Vertex u : g) {
			u.seen=false;
			u.parent=null;
			u.distance=Integer.MAX_VALUE;
		}
		s.distance=0;
	    Comparator<Vertex> comparator = new VertexComparator();
		PriorityQueue<Vertex> pq=new PriorityQueue<>(g.v.length, comparator);
		pq.add(s);
		while (!pq.isEmpty()) {
			Vertex u=pq.remove();
			if (u.name!=d.name) {
			u.seen=true;
			for (Edge e:u) {
				relax(e);
				pq.add(e.to);

				
			}
		}
			else {
				break;
			}
		}
	
	}
/**
 * Method to relax the edges 
 * @param e
 * @return
 */
public static boolean relax(Edge e) {
	
	Vertex u=e.from;
	Vertex v=e.to;
	
	if (v.distance>u.distance+e.weight) {
		v.distance=u.distance+e.weight;
		v.parent=u;
		return true;
	}
	return false;
}

	

}
