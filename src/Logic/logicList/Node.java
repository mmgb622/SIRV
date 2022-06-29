package Logic.logicList;

import java.io.Serializable;

public class Node implements Serializable{

	public Object element;
	public Node next;
	public Node before;
	
	public Node(Object element) {
		this.element = element;
		this.next = null;
		this.before = null;
	}
	
	
}
