package Business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Data.UnSIRVSystemData;
import Domain.SIRVSystem;
import Domain.TaxiDriver;
import Logic.DynamicGraph;
import Logic.logicList.CircularDoubleLinkedList;
//import ObjetosDePueba_YaExistentes.DynamicGraph;

public class UnSIRVSystemBusiness {

	private UnSIRVSystemData unSIRVSystemData;

	public UnSIRVSystemBusiness() {
		this.unSIRVSystemData = new UnSIRVSystemData();
	} // constructor

	public void writeSIRVSystem(SIRVSystem sSIRVSystem) throws FileNotFoundException, IOException {
		if (sSIRVSystem!= null)
			this.unSIRVSystemData.writeSIRVSystem(sSIRVSystem);
	}// writeSIRVSystem

	public SIRVSystem getSIRVSystem() throws FileNotFoundException, IOException, ClassNotFoundException {
		return this.unSIRVSystemData.getSIRVSystem();
	}// getSIRVSystem

	public void updateGraph(DynamicGraph graph) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (graph != null)
			this.unSIRVSystemData.updateGraph(graph);
	}//updateGraph

	public void updateTaxi(ArrayList<TaxiDriver> taxiDrivers) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (taxiDrivers != null)
			this.unSIRVSystemData.updateTaxi(taxiDrivers);
	}//updateTaxi

	public void updateTripType(CircularDoubleLinkedList tripType)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		if (tripType != null)
			this.unSIRVSystemData.updateTripType(tripType);
	}//updateTripType

} // fin clase
