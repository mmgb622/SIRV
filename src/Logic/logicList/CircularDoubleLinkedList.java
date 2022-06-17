package Logic.logicList;

import java.util.ArrayList;

public class CircularDoubleLinkedList implements Lista{

	//atributes
	private Node start;
	private Node end;
	
	public CircularDoubleLinkedList() {
		this.start=null;
		this.end=null;
	}//constructor
	
	@Override
	public void addHead(Object element) {
		Node newNode = new Node(element);
		if(!isEmpty()) {
			this.start.before = newNode;
			newNode.next = this.start;
			this.start = newNode;
		} else { 
			this.start = newNode;
			this.end = newNode;
			this.start.next = this.end;
			this.end.before = this.start;
		}//if else	
		this.start.before = this.end;
		this.end.next = this.start;
	}//addHead
	
	@Override
	public void addEnd(Object element) {
		Node newNode = new Node(element);
		if(!isEmpty()) {
			this.end.next = newNode;
			newNode.before = this.end;
			this.end = newNode;
		} else { 
			this.start = newNode;
			this.end = newNode;
			this.start.next = this.end;
			this.end.before = this.start;
			}//if else
		this.start.before = this.end;
		this.end.next = this.start;
	}//addEnd

	public void addSort(int number) {
		Node newInt = new Node(number);
		if(isEmpty()) {
			this.start = this.end = newInt;
			this.start.next = this.start.before = end;
			this.end.next = this.end.before = start;
		}else if(number<(int)start.element) {
			this.end.next = this.start.before = newInt;
			newInt.before = this.end;
			newInt.next = this.start;
			this.start = newInt;
		}else if(number>(int)end.element) {
			this.end.next = this.start.before = newInt;
			newInt.before = this.end;
			newInt.next = this.start;
			this.end = newInt;
		} else {
			int start = 1, end = this.getSize();
			int temp = (end-start)/2 + start;
			Node aux = getNodeIn(temp);
			while(!((int)aux.element<=number && (int)aux.next.element>number)) {
				if((int)aux.element<number) {
					start = temp;
					temp = (end-start)/2 + start;
				}else {
					end = temp;
					temp = (end-start)/2 + start;
				}//if else
				aux = getNodeIn(temp);
			}//while
			Node ant = aux;
			Node sgt = ant.next;
			newInt.before = ant;
			newInt.next = sgt;
			ant.next = newInt;
			sgt.before = newInt;
		}//if else
	} //addSort
	
	@Override
	public boolean delete(Object element) {
		if(!isEmpty()) {
			if(this.start.element==element) {
				this.start = this.start.next;
				this.end.next = this.start;
				this.start.before = this.end;
				return true;
			} else if(this.end.element == element) {
				this.end = this.end.before;
				this.end.next = this.start;
				this.start.before = this.end;
				return true;
			} else {
				Node aux = this.start.next;
				do {
					if(aux.element.equals(element)) {
						Node before = aux.before;
						Node next = aux.next;
						before.next = next;
						next.before = before;
						return true;
					} //if
					aux = aux.next;
				} while (aux!=this.end);
			}//
		}//if else
		return false;
	}//delete ByElement

	@Override
	public boolean delete(int pos) {
		if(isEmpty() || pos<1 || pos>getSize())
			return false;
		Node before = getNodeIn(pos).before;
		Node next = getNodeIn(pos).next;
		before.next = next;
		next.before = before;
		return true;
	}//delete ByPos

	@Override
	public int getSize() {
		if(!isEmpty()) {
			int counter = 1;
			Node aux = this.start;
			while(aux.next!=start) {
				aux = aux.next;
				counter++;
			}//while
			return counter;
		}//if
		return 0;
		}//getSize

	@Override
	public boolean isEmpty() {
		return this.start==null;
	}//isEmpty

	@Override
	public void reset() {
		this.start=null;
		this.end = null;
	}//reset

	@Override
	public boolean exists(Object element) {
		if(!isEmpty()) {
			Node aux = this.start.next;
			do {
				if(aux.element==element)
					return true;
				aux = aux.next;
			} while(aux!=this.end);
		}//if
		return false;
	}//exists
	
	@Override
	public Node firstInList() {
		return this.start;
	}//firstInList

	@Override
	public Node lastInList() {
		return this.end;
	}//lastInList

	public String toString() {
		String info = "";
		for(int i = 1; i<=getSize();i++) {
			Node node = getNodeIn(i);
			info+=node.element.toString()+" ";
		}//for
		return info;
	}//toString

	@Override
	public Object get(int position) {
		if(!isEmpty()) {
			int count = 1;
			Node aux = this.start;
			do {
				if(count==position) {
					return aux.element;
				}else {
					aux = aux.next;
					count++;
				}//if else
			}while(aux!=start);
			return null;
		}//if 
		return null;
	}

	@Override
	public Node getNodeIn(int pos) {
		if(!isEmpty()) {
			int count = 1;
			Node aux = this.start;
			do {
				if(count==pos) {
					return aux;
				}else {
					aux = aux.next;
					count++;
				}//if else
			}while(aux!=start);
			return null;
		}//if 
		return null;
	}

	@Override
	public ArrayList<Node> getByValue(Object element) {
		if(!isEmpty()) {
			ArrayList<Node> nodes = new ArrayList<>();
			Node aux=this.start;
			do {
				if(aux.element.equals(element))
					nodes.add(aux);
				aux = aux.next;
			}while(aux!=null);
			return nodes;
		}
		return null;
	}

}//class
