package Domain;

public class Client extends User{

	//atributes
	private double clientCalification;
	private String clientNationality;
	private String clientGender;
	
	public Client(String name, String nameUser, String password, double clientCalification,
			String clientNationality, String clientGender) {
		super(name, nameUser, password);
		this.clientCalification = clientCalification;
		this.clientNationality = clientNationality;
		this.clientGender = clientGender;
	}//constructor

	//getters and setters
	public double getClientCalification() {
		return clientCalification;
	}

	public void setClientCalification(double clientCalification) {
		this.clientCalification = clientCalification;
	}

	public String getClientNationality() {
		return clientNationality;
	}

	public void setClientNationality(String clientNationality) {
		this.clientNationality = clientNationality;
	}

	public String getClientGender() {
		return clientGender;
	}

	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}

	@Override
	public boolean isAdministrator() {
		return false;
	}
		
}//end class
