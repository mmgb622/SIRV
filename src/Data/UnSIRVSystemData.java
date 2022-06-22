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
import Logic.DynamicGraph;

public class UnSIRVSystemData {

	private SIRVSystem sSIRVSystem;

	private String ruta;

	public UnSIRVSystemData() {
		this.ruta = "unSIRVSystem.dat";
		this.sSIRVSystem = new SIRVSystem();
	} // constructor

	public void writeSIRVSystem(SIRVSystem sSIRVSystem) throws FileNotFoundException, IOException {

		File archivo = new File(this.ruta);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archivo));
		output.writeUnshared(sSIRVSystem);
		output.close();

	} // registrarProducto

	public SIRVSystem getSIRVSystem() throws FileNotFoundException, IOException, ClassNotFoundException {
		File archivo = new File(this.ruta);
		SIRVSystem sSIRVSystem = null;
		if (archivo.exists()) {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = input.readObject();
			sSIRVSystem = (SIRVSystem) aux;
			input.close();
		} // fin
		return sSIRVSystem;
	} // obtenerProducto
	
	public void setSIRVSystem(DynamicGraph graph, ArrayList taxiDrivers, ArrayList tripType) throws FileNotFoundException, IOException, ClassNotFoundException {
		this.sSIRVSystem.setSIRVSystem(graph, taxiDrivers, tripType);
	} // obtenerProducto

	public void updateGraph(DynamicGraph graph) throws FileNotFoundException, IOException {
		SIRVSystem sSIRVSystem = new SIRVSystem(graph, this.sSIRVSystem.getTaxiDrivers(),
				this.sSIRVSystem.getTripType());
		writeSIRVSystem(sSIRVSystem);
	}// updateGraph

	public void updateTaxi(ArrayList taxiDrivers) throws FileNotFoundException, IOException{
		SIRVSystem sSIRVSystem = new SIRVSystem(this.sSIRVSystem.getGraph(), 
												taxiDrivers,
												this.sSIRVSystem.getTripType());
		writeSIRVSystem(sSIRVSystem);
	}// updateTaxi

	public void updateTripType(ArrayList tripType) throws FileNotFoundException, IOException{
		SIRVSystem sSIRVSystem = new SIRVSystem(this.sSIRVSystem.getGraph(), 
												this.sSIRVSystem.getTaxiDrivers(),
												tripType);
		writeSIRVSystem(sSIRVSystem);
	}// updateTripType

} // fin clase
