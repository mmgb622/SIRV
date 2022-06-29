package Domain;

import java.io.Serializable;
import java.util.ArrayList;

import Logic.DynamicGraph;
import Logic.logicList.CircularDoubleLinkedList;

public class SIRVSystem implements Serializable{
	
	private DynamicGraph graph ;
	private ArrayList <TaxiDriver> taxiDrivers;
	private CircularDoubleLinkedList rideType;
	

	public SIRVSystem() {
		this.graph= new DynamicGraph();
		this.taxiDrivers= new ArrayList();
		this.rideType= new CircularDoubleLinkedList();
	}
	
	public SIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, CircularDoubleLinkedList rideType) {
		this.graph= graph;
		this.taxiDrivers= taxiDrivers;
		this.rideType= rideType;
	}
	
	public void setSIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, CircularDoubleLinkedList rideType) {
		this.graph= graph;
		this.taxiDrivers= taxiDrivers;
		this.rideType= rideType;
	}

	public DynamicGraph getGraph() {
		return graph;
	}

	public void setGraph(DynamicGraph graph) {
		this.graph = graph;
	}

	public ArrayList<TaxiDriver> getTaxiDrivers() {
		return taxiDrivers;
	}

	public void setTaxiDrivers(ArrayList<TaxiDriver> taxiDrivers) {
		this.taxiDrivers = taxiDrivers;
	}

	public CircularDoubleLinkedList getRideType() {
		return rideType;
	}

	public void setRideType(CircularDoubleLinkedList rideType) {
		this.rideType = rideType;
	}

}
