package Logic;

public class Dijkstra {
	static final int V  = 9;

	private static int minDistance(int[] dist, boolean[] visitedVertex){
		
		int min = Integer.MAX_VALUE; int minIndex=0;
		
		for (int v = 0; v < V; v++)
			if (visitedVertex[v] == false && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}//if
		
		return minIndex;
		
	}//minDistance
	
	private static void printSolution(int[] dist, int n){
	
		System.out.println("Distance of a vertex from the origin\n");
	
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	
	}//printSolution
	
	public static void dijkstraMethod(int[][] graph, int src){
	
		int[] dist = new int[V];
 		boolean[] visitedVertex = new boolean[V]; 
		
 		for (int i = 0; i < V; i++) {
        dist[i] = Integer.MAX_VALUE;
        visitedVertex[i] = false;
		}//for
		
 		dist[src] = 0;
		
 		for (int count = 0; count < V-1; count++){
			int u = minDistance(dist, visitedVertex);
			visitedVertex[u] = true;
    	 for (int v = 0; v < V; v++)
    		 if (!visitedVertex[v] && graph[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
    			 dist[v] = dist[u] + graph[u][v];
     	}//for
     
 		printSolution(dist, V);
	
	}//dijkstraMethod

}//Dijkstra	