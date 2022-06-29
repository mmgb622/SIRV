package Domain;

import java.io.Serializable;

public class TaxiDriver implements Serializable{

	//atributes
	private String taxiDriverName;
	private double taxiDriverCalification;
	private String taxiDriverCar;
	private String taxiDriverPaymentType;
	
	public TaxiDriver(String taxiDriverName, double taxiDriverCalification, String taxiDriverCar,
			String taxiDriverPaymentType) {
		super();
		this.taxiDriverName = taxiDriverName;
		this.taxiDriverCalification = taxiDriverCalification;
		this.taxiDriverCar = taxiDriverCar;
		this.taxiDriverPaymentType = taxiDriverPaymentType;
	}//constructor


	//getters and setters
	
	public String getTaxiDriverName() {
		return taxiDriverName;
	}

	public void setTaxiDriverName(String taxiDriverName) {
		this.taxiDriverName = taxiDriverName;
	}

	public double getTaxiDriverCalification() {
		return taxiDriverCalification;
	}

	public void setTaxiDriverCalification(double taxiDriverCalification) {
		this.taxiDriverCalification = taxiDriverCalification;
	}

	public String getTaxiDriverCar() {
		return taxiDriverCar;
	}

	public void setTaxiDriverCar(String taxiDriverCar) {
		this.taxiDriverCar = taxiDriverCar;
	}

	public String getTaxiDriverPaymentType() {
		return taxiDriverPaymentType;
	}

	public void setTaxiDriverPaymentType(String taxiDriverPaymentType) {
		this.taxiDriverPaymentType = taxiDriverPaymentType;
	}
	
	
}//end class
