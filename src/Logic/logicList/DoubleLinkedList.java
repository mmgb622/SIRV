package Logic.logicList;

import java.util.ArrayList;
import java.util.Iterator;

public class DoubleLinkedList implements Lista{

	public Node start;
	
	public DoubleLinkedList() {
		this.start=null;
	}
	
	@Override
	public void addHead(Object element) {
		Node newStart = new Node(element);
		this.start.before = newStart;
		newStart.next = this.start;
		this.start = newStart;
	}
	
	@Override
	public void addEnd(Object element) {
		Node newNode = new Node(element);
		if(isEmpty())
			this.start = newNode;
		else {
			Node aux = lastInList();
			aux.next = newNode;
			newNode.before = aux;
		}
	}//add

	@Override
	public boolean delete(Object element) {
		if(isEmpty())
			return false;
		if(this.start.element == element) {
			this.start = start.next;
			return true;
		}else if(lastInList().element == element) {
			Node newFinal = lastInList().before;
			newFinal.next=null;
			return true;
		}else {
			Node aux = this.start.next;
			while(aux.next!=null) {
				if(aux.element==element) {
					Node before = aux.before;
					Node next = aux.next;
					before.next = next;
					next.before = before;
					return true;
				}
				aux = aux.next;
			}
				
		}
		return false;
	}//delete

	@Override
	public boolean delete(int pos) {
		if(pos<1 || pos>getSize())
			return false;
		Node deleted = getNodeIn(pos);
		Node before = deleted.before;
		Node next = deleted.next;
		before.next = next;
		next.before = before;
		return true;
	}

	@Override
	public int getSize() {
		if(isEmpty())
			return 0;
		
		int counter = 0;
		Node aux = this.start;
		while(aux!=null) {
			aux = aux.next;
			counter++;
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return this.start==null;
	}

	@Override
	public void reset() {
		this.start=null;
	}

	@Override
	public boolean exists(Object elements) {
		Node aux = this.start;
		while(aux!=null) {
			if(aux.element==elements)
				return true;
			aux = aux.next;
		}
		
		return false;
	}//exists

	public Object get(int position) {
		if(position<=0 || isEmpty())
			return null;
		
		int counter = 1;
		Node aux = this.start;
		while(aux!=null) {
			if(counter==position)
				return aux.element;
			aux = aux.next;
			counter++;
		}
		return null;
	}
	
	@Override
	public Node getNodeIn(int pos) {
		if(pos<=0 || isEmpty())
			return null;
		
		int counter = 1;
		Node aux = this.start;
		while(aux!=null) {
			if(counter==pos)
				return aux;
			aux = aux.next;
			counter++;
		}
		return null;
	}
 
	@Override
	public Node firstInList() {
		return this.start;
	}

	@Override
	public Node lastInList() {
		Node aux = this.start;
		if(this.start==null || this.start.next==null) //lista vacía o con solo un elemento
			return start;
		
		while(aux.next!=null)
			aux = aux.next;
		
		return aux;
	}

	public String toString() {
		String info = "";
		for(int i = 1; i<=getSize();i++) {
			Node node = getNodeIn(i);
			info+="["+i+"] "+ node.element.toString()+"\n";
		}
		return info;
	}

	@Override
	public ArrayList<Node> getByValue(Object element) {
		ArrayList<Node> nodos = new ArrayList<Node>();
		
		for (int i = 0; i < this.getSize(); i++) {
			if(this.getNodeIn(i+1).element==element)
				nodos.add(this.getNodeIn(i+1));
		}
		if(nodos.size()==0)
			return null;
		return nodos;
	}
}//class end
