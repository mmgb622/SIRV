package Logic;

import Logic.logicList.DoubleLinkedList;

public class DynamicGraph implements Graph{

	private DoubleLinkedList vertex;
	
	public DynamicGraph() {
		this.vertex = new DoubleLinkedList();
	}

	
	public String DFS() {
		Vertex origin = (Vertex) this.vertex.get(1);
		String dfs =  traverse(origin);
		for(int i=1; i<=vertex.getSize();i++) {
			Vertex aux = (Vertex) this.vertex.get(i);
			aux.seen = false;
		}
		return dfs;
	}
	
	private String traverse(Vertex v) {
		if(v.asociatedVertex.isEmpty()) {
			v.seen = true;
			return " - "+(String) v.element;
		}else {
			String vTraverse = " - "+(String) v.element;
			v.seen = true;
			for (int i = 1; i <= v.asociatedVertex.getSize(); i++) {
				Vertex asociated = (Vertex) v.asociatedVertex.get(i);
				if(!asociated.seen)
					vTraverse += traverse(asociated);
			}
			return vTraverse;
		}
	}
	
	@Override
	public void reset() {
		this.vertex = new DoubleLinkedList();
	}

	@Override
	public boolean isEmpty() {
		return this.vertex.isEmpty();
	}

	@Override
	public int size() throws GraphException {
		return this.vertex.getSize();
	}
	
	public Vertex getByContent(Object element) {
		for(int i=1; i<=vertex.getSize(); i++) {
			Vertex v = (Vertex)vertex.getNodeIn(i).element;
			if(v.element.equals(element))
				return v;
		}
		return null;
	}

	@Override
	public boolean existVertex(Object element) {
		for(int i=1; i<=vertex.getSize(); i++) {
			Vertex v = (Vertex)vertex.getNodeIn(i).element;
			if(v.element.equals(element))
				return true;
		}
		return false;
	}

	@Override
	public boolean existEdge(Object v1, Object v2) throws GraphException {
		if(!existVertex(v1) || !existVertex(v2))
			throw new GraphException("One or both of the introduced elements don't exist on the graph");
		Vertex vertexOrigin = getByContent(v1);
		Vertex vertexEnd = getByContent(v2);
		return vertexOrigin.asociatedVertex.exists(vertexEnd);
	}

	@Override
	public void addVertex(Object element) throws GraphException {
		if(existVertex(element))
			throw new GraphException("This vertex already exists");
		this.vertex.addEnd(new Vertex(element));
	}

	@Override
	public void addEdge(Object nodeStart, Object nodeEnd) throws GraphException {
		if(existEdge(nodeStart, nodeEnd))
			throw new GraphException("This edge already exists");
		Vertex origin = getByContent(nodeStart);
		Vertex end = getByContent(nodeEnd);
		origin.asociatedVertex.addEnd(end);
		origin.weights.addEnd(1);
	}

	/**
	 * The method executes a double function, in case the edge already exists,
	 * it will give the specified weight to the edge. On the other hand, it creates 
	 * a new edge between the origin and the end
	 */
	@Override
	public void addEdge(Object nodeStart, Object nodeEnd, int weight) throws GraphException {
		if(existEdge(nodeStart, nodeEnd)) {
			Vertex origin = getByContent(nodeStart);
			Vertex end = getByContent(nodeEnd);
			for (int i = 1; i <= origin.asociatedVertex.getSize(); i++) {
				if(origin.asociatedVertex.getNodeIn(i).element.equals(end)) {
					origin.weights.getNodeIn(i).element = weight;
				}
			}
		}else {
			Vertex origin = getByContent(nodeStart);
			Vertex end = getByContent(nodeEnd);
			origin.asociatedVertex.addEnd(end);
			origin.weights.addEnd(weight);
		}
	}

	public String toString() {
		String info = "Graph information:\n";
		for (int i = 1; i <= vertex.getSize(); i++) {
			info+="> "+vertex.getNodeIn(i).element.toString()+"\n";
		}
		
		return info;
	}
}//class end
