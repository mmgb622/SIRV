package Domain;

import java.io.Serializable;
import java.util.ArrayList;

import Logic.DynamicGraph;

public class SIRVSystem implements Serializable{
	
	private DynamicGraph graph;
	private ArrayList taxiDrivers;
	private ArrayList tripType;
	

	public SIRVSystem() {
		this.graph= new DynamicGraph();
		this.taxiDrivers= new ArrayList();
		this.tripType= new ArrayList();
	}
	
	public SIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, ArrayList tripType) {
		this.graph= graph;
		this.taxiDrivers= taxiDrivers;
		this.tripType= tripType;
	}
	
	public void setSIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, ArrayList tripType) {
		this.graph= graph;
		this.taxiDrivers= taxiDrivers;
		this.tripType= tripType;
	}

	public DynamicGraph getGraph() {
		return graph;
	}

	public void setGraph(DynamicGraph graph) {
		this.graph = graph;
	}

	public ArrayList getTaxiDrivers() {
		return taxiDrivers;
	}

	public void setTaxiDrivers(ArrayList taxiDrivers) {
		this.taxiDrivers = taxiDrivers;
	}

	public ArrayList getTripType() {
		return tripType;
	}

	public void setTripType(ArrayList tripType) {
		this.tripType = tripType;
	}

}
