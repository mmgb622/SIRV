package Logic;

import java.util.Iterator;

public class GraphAdyacenceMatrix implements Graph{

	private Vertex[] nodes;
	private Object[][] adyacenceMatrix;
	private int counter;
	private int n;
	
	/**
	 * Constructor of the graph
	 * @param size 
	 * the amount limit of nodes that the graph could have
	 * @throws GraphException 
	 */
	public GraphAdyacenceMatrix(int size) throws GraphException {
		if(size<=0) {
			throw new GraphException("The amount of nodes cannot be 0 or negative");
		}
		this.n = size;
		this.counter = 0;
		this.nodes = new Vertex[n];
		this.adyacenceMatrix = new Object[n][n];
		
		init();
	}

	private void init() {
		for(int i = 0; i<n;i++) {
			for (int j = 0; j < n; j++) {
				this.adyacenceMatrix[i][j]=0;
			}
		}
	}


	@Override
	public void reset() {
		for (int i = 0; i < this.counter; i++) {
			nodes[i]=null;
		}
		this.counter=0;
		init();
	}

	@Override
	public boolean isEmpty() {
		return this.counter==0;
	}

	@Override
	public int size() throws GraphException {
		if (isEmpty()) {
			throw new GraphException("The graph is empty");
		}
		return this.counter;
	}

	@Override
	public void addVertex(Object element) throws GraphException {
		if(counter>=n) {
			throw new GraphException("The graph is full");
		}
		nodes[counter++] = new Vertex(element);
	}

	@Override
	public void addEdge(Object nodeStart, Object nodeEnd) throws GraphException {
		int n1 = -1;
		int n2 = -1;
		for (int i = 0; i < n; i++) {
			if(nodes[i].element==nodeStart)
				n1=i;
			if(nodes[i].element==nodeEnd)
				n2=i;
		}
		if(n1 == -1 || n2==-1)
			throw new GraphException("One or both of the introduced nodes don't exist");
		
		if((int)this.adyacenceMatrix[n1][n2]>0)
			throw new GraphException("The relation already exists");
		
		this.adyacenceMatrix[n1][n2]=1;
		this.adyacenceMatrix[n2][n1]=1;
	}

	@Override
	public void addEdge(Object nodeStart, Object nodeEnd, int weigth) throws GraphException {
		int n1 = -1;
		int n2 = -1;
		for (int i = 0; i < n; i++) {
			if(nodes[i].element==nodeStart)
				n1=i;
			if(nodes[i].element==nodeEnd)
				n2=i;
		}
		if(n1 == -1 || n2==-1)
			throw new GraphException("One or both of the introduced nodes don't exist");
		
		if((int)this.adyacenceMatrix[n1][n2]>0)
			throw new GraphException("The relation already exists");
		
		if(weigth<=0)
			throw new GraphException("Weigth cannot be under 0");
		
		this.adyacenceMatrix[n1][n2]=weigth;
		this.adyacenceMatrix[n2][n1]=weigth;
	}
	
	public String toString() {
		String info = "GRAPH INFORMATION: \n";
		info+="Nodes of the graph: \n" 
				+ "-----------------------------------------\n";
		for (int i = 0; i < counter; i++) {
			info+="The node on position "+i+" is: "+nodes[i].element+"\n";
		}
		
		info+="\n Adyacence matrix:\n";
		for (int i = 0; i < adyacenceMatrix.length; i++) {
			for (int j = 0; j < adyacenceMatrix.length; j++) {
				info+=adyacenceMatrix[i][j]+"  ";
			}
			info+="\n";
		}
		
		return info;
	}

	@Override
	public boolean existVertex(Object element) {
		for (int i = 0; i < n; i++) {
			if(nodes[i].element==element)
				return true;
		}
		return false;
	}

	@Override
	public boolean existEdge(Object v1, Object v2) throws GraphException {
		int n1 = -1;
		int n2 = -1;
		for (int i = 0; i < n; i++) {
			if(nodes[i].element==v1)
				n1=i;
			if(nodes[i].element==v2)
				n2=i;
		}
		if(n1 == -1 || n2==-1)
			throw new GraphException("One or both of the introduced nodes don't exist");
		
		return (int)this.adyacenceMatrix[n1][n2]>0;
	}

	
}
