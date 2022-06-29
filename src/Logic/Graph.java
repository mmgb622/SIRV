package Logic;

import java.io.Serializable;

public interface Graph extends Serializable {

	//return the graph to its basic state, empty
	public void reset();
	
	//true if the graph doesn't have vertex
	public boolean isEmpty();
	
	//returns the number of vertex in the graph
	public int size() throws GraphException;
	
	//ask for the content in a vertex, true if there is (at least) one with it
	public boolean existVertex(Object element);
	
	//ask for the relations between the specified vertex, true if it exists
	public boolean existEdge(Object v1, Object v2) throws GraphException;
	
	//add a new vertex to the graph
	public void addVertex(Object element) throws GraphException;
	
	//Creates a default edge between the specified vertex, throws an exception if the vertex don't exist
	public void addEdge(Object nodeStart, Object nodeEnd) throws GraphException;
	
	//Creates a weighted edge between the specified vertex, if the edge already exist
	//it will set the weight
	public void addEdge(Object nodeStart, Object nodeEnd, int weight) throws GraphException;
}
