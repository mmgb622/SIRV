package Business;

import java.io.IOException;
import java.util.ArrayList;

import Data.UserData;
import Domain.Client;
import Domain.User;

public class UserBusiness {

	UserData userData;
	
	public UserBusiness() {
		this.userData = new UserData();
	}
	
	public void writeUser(User user) throws IOException {
		if(!userData.exist(user))
			this.userData.writeUser(user);
	}
	
	public User readUser(String nameUser) throws IOException {
		return this.userData.readUser(nameUser);
	}
	
	public ArrayList<User> readUsers() throws IOException {
		return this.userData.readUsers();
	}
	
	public ArrayList<Client> readClients() throws IOException{
		return this.userData.readClients();
	}
	
	public void updateUser(User user) throws IOException {
		if(exist(user) && user!=readUser(user.getNameUser()))
			this.userData.updateUser(user);
	}
	
	public boolean exist(User user) throws IOException {
		return this.userData.exist(user);
	}
	
}//end class
