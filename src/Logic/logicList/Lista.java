package Logic.logicList;

import java.io.Serializable;
import java.util.ArrayList;

public interface Lista extends Serializable {
	
	//add a new node at the beginning of the list
	public void addHead(Object element);
	
	//add new content to the list
	public void addEnd(Object element);
	
	//delete elements
	public boolean delete(Object element);
	
	public boolean delete(int pos);
	
	//number of nodes from the list
	public int getSize();
	
	//true if the list is empty
	public boolean isEmpty();
	
	//reset all the list
	public void reset();
	
	//true if the element is in the list
	public boolean exists(Object element);
	
	//returns the element on the specified pos
	public Object get(int position);
	
	//returns the node on the specified position
	public Node getNodeIn(int pos);

	//returns all the nodes that contains the spacified element
	public ArrayList<Node> getByValue(Object element);
	
	//returns the first node of the list
	public Node firstInList();
	
	//returns the last element of the list
	public Node lastInList();
}
