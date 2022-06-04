package Domain;

public abstract class User {

	//atributes
	private String name;
	private String nameUser;
	private String password;
	
	public abstract boolean isAdministrator();
	
	public User(String name, String nameUser, String password) {
		this.name= name;
		this.nameUser = nameUser;
		this.password = password;
	}//constructor
	
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}//User
