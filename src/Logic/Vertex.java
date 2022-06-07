package Logic;

import Logic.logicList.DoubleLinkedList;

public class Vertex {
	//basic content
	public Object element;
	
	//elements for a dynamic graph
	public DoubleLinkedList asociatedVertex;
	public DoubleLinkedList weights;
	
	//flag for traverse
	public boolean seen;
	
	
	public Vertex(Object element) {
		super();
		this.seen = false;
		this.element = element;
		this.asociatedVertex = new DoubleLinkedList();
		this.weights = new DoubleLinkedList();
	}
	
	public String toString() {
		String info = element.toString()+" -> ";
		for (int i = 1; i <= asociatedVertex.getSize(); i++) {
			Vertex v = (Vertex) this.asociatedVertex.get(i);
			info+="("+v.element+","+this.weights.get(i)+")";
			if(i<asociatedVertex.getSize())
				info+=" - ";
		}
		return info;
	}
}
