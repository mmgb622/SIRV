package Domain;

public class Admin extends User{

	public Admin(String name, String nameUser, String password) {
		super(name, nameUser, password);
	}//constructor

	@Override
	public boolean isAdministrator() {
		// TODO Auto-generated method stub
		return true;
	}
	
}//Admin
