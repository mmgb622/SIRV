package Logic;

public class Node {

	public Object element;
	public Node next;
	public Node before;
	
	public Node(Object element) {
		this.element = element;
		this.next = null;
		this.before = null;
	}
	
	
}
