package Domain;

public class Client extends User{

	//atributes
	private String clientID;
	private int clientAge;
	private double clientCalification;
	private String clientNationality;
	private String clientGender;
	
	public Client(String name, String nameUser, String password, double clientCalification,
			String clientNationality, String clientGender, int clientAge, String clientID) {
		super(name, nameUser, password);
		this.clientCalification = clientCalification;
		this.clientNationality = clientNationality;
		this.clientGender = clientGender;
		this.clientAge = clientAge;
		this.clientID = clientID;
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
	
	

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public int getClientAge() {
		return clientAge;
	}

	public void setClientAge(int clientAge) {
		this.clientAge = clientAge;
	}

	@Override
	public boolean isAdministrator() {
		return false;
	}
		
}//end class
