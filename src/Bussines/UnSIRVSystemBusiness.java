package Bussines;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Data.UnSIRVSystemData;
import Domain.SIRVSystem;
import Logic.DynamicGraph;
//import ObjetosDePueba_YaExistentes.DynamicGraph;

public class UnSIRVSystemBusiness {

	private UnSIRVSystemData unSIRVSystemData;
	
	public UnSIRVSystemBusiness() {
		this.unSIRVSystemData=new UnSIRVSystemData();
	} // constructor
	
	public void writeSIRVSystem(SIRVSystem sSIRVSystem) throws FileNotFoundException, IOException {
//		if (sSIRVSystem!= null)
			this.unSIRVSystemData.writeSIRVSystem(sSIRVSystem);
	}//writeSIRVSystem
	
	public SIRVSystem getSIRVSystem() throws FileNotFoundException, IOException, ClassNotFoundException {
		return this.unSIRVSystemData.getSIRVSystem();
	}//getSIRVSystem
	
	public void setSIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, ArrayList tripType) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (graph!= null&& taxiDrivers!= null&&tripType!=null)
			this.unSIRVSystemData.setSIRVSystem(graph, taxiDrivers, tripType);
	}
	
	public void updateGraph(DynamicGraph graph) throws FileNotFoundException, IOException{
		if (graph!= null)
		this.unSIRVSystemData.updateGraph(graph);
	}
	
	public void updateTaxi(ArrayList taxiDrivers) throws FileNotFoundException, IOException{
		if (taxiDrivers!= null)
		this.unSIRVSystemData.updateTaxi(taxiDrivers);
	}
	
	public void updateTripType(ArrayList tripType) throws FileNotFoundException, IOException{
		if (tripType!= null)
		this.unSIRVSystemData.updateTripType(tripType);
	}
	
} // fin clase
