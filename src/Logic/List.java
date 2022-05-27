package Logic;

import java.util.ArrayList;

public interface List {
	
	//add new content at the beginning o the list
	public void addHead(Object element);
	
	//add new content to the end of the list
	public void addEnd(Object element);
	
	//insert a numeric element in odrder with the rest of the list
	public void addSort(int n);
	
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
	
	//returns the node on the specified position
	public Node getByPos(int pos);
	
	//returns an array of all nodes with the specified element
	public Object getByValue(Object element);
	
	//returns the first node of the list
	public Node firstInList();
	
	//returns the last element of the list
	public Node lastInList();
}
