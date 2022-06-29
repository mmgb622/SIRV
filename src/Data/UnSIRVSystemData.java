package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Domain.SIRVSystem;
import Domain.TaxiDriver;
import Logic.DynamicGraph;
import Logic.logicList.CircularDoubleLinkedList;

public class UnSIRVSystemData {

	private String route;

	public UnSIRVSystemData() {
		this.route = "unSIRVSystem.dat";
	} // constructor

	public void writeSIRVSystem(SIRVSystem sSIRVSystem) throws FileNotFoundException, IOException {

		File archive = new File(this.route);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archive));
		output.writeUnshared(sSIRVSystem);
		output.close();

	} // writeSIRVSystem

	public SIRVSystem getSIRVSystem() throws FileNotFoundException, IOException, ClassNotFoundException {
		File archivo = new File(this.route);
		SIRVSystem sSIRVSystem = null;
		if (archivo.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = input.readObject();
			sSIRVSystem = (SIRVSystem) aux;
			input.close();
		} // if_end
		return sSIRVSystem;
	} // getSIRVSystem

	public void updateGraph(DynamicGraph graph) throws  ClassNotFoundException, FileNotFoundException, IOException {
		SIRVSystem aux = this.getSIRVSystem();// read the system that is already in the file
		 aux. setGraph(graph);// the specific element is modified
		 this.writeSIRVSystem(aux);// system is overwritten
	}// updateGraph

	public void updateTaxi(ArrayList<TaxiDriver> taxiDrivers) throws FileNotFoundException, IOException, ClassNotFoundException{
		SIRVSystem aux = this.getSIRVSystem();// read the system that is already in the file
		 aux. setTaxiDrivers(taxiDrivers);// the specific element is modified
		 this.writeSIRVSystem(aux);// system is overwritten
	}// updateTaxi

	public void updateRideType(CircularDoubleLinkedList rideType) throws FileNotFoundException, IOException, ClassNotFoundException{
		SIRVSystem aux = this.getSIRVSystem();// read the system that is already in the file
		 aux. setRideType(rideType);// the specific element is modified
		 this.writeSIRVSystem(aux);// system is overwritten
	}// updateTripType

} // fin clase
