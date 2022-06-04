
package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Admin;
import Domain.Client;
import Domain.User;

public  class UserData {
	
    private File usersRecord; 
	 
	public UserData() {
		this.usersRecord = new File("users.txt");
	}
	
	public void writeUser(User user) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(usersRecord,true));
		if(usersRecord.length()!=0)
			writer.newLine();
        writer.write(user.getName()+";"+user.getNameUser()+";"+user.getPassword());
        if(!user.isAdministrator()) {
        	Client clientUser = (Client) user;
        	writer.write(";"+clientUser.getClientCalification()
        				+";"+clientUser.getClientNationality()
        				+";"+clientUser.getClientGender()
        				+";"+clientUser.getClientAge()
        				+";"+clientUser.getClientID());
        }
		writer.flush();
		writer.close();
	}
	
	public User readUser(String nameUser) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(usersRecord));
		String line = reader.readLine();
		while(line != null) {
			String[] data = line.split(";");
			if(data[1].equals(nameUser)) //founded user
				if(data.length>3)
					return new Client(data[0], data[1], data[2], //name - userName password
							Integer.parseInt(data[3]), //client calification
							data[4], //nationality
							data[5], //gender
							Integer.parseInt(data[6]), //age
							data[7]); //ID
				else
					return new Admin(data[0], data[1], data[2]);
			line = reader.readLine();
		}
		reader.close();
		return null;
	}
	
	public ArrayList<User> readUsers() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(usersRecord));
		ArrayList<User> users = new ArrayList<>();
		String line = reader.readLine();
		while(line != null) {
			String[] data = line.split(";");
			System.out.println(data.length);
			if(data.length>3)
				users.add(new Client(data[0], data[1], data[2], //name - userName password
						Double.parseDouble(data[3]), //client calification
						data[4], //nationality
						data[5], //gender
						Integer.parseInt(data[6]), //age
						data[7])); //ID
			else
				users.add(new Admin(data[0], data[1], data[2]));
			line = reader.readLine();
		}
		reader.close();
		return users;
	}
	
	public ArrayList<Client> readClients() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(usersRecord));
		ArrayList<Client> clients = new ArrayList<>();
		String line = reader.readLine();
		while(line != null) {
			String[] data = line.split(";");
			if(data.length>3)
					clients.add(new Client(data[0], data[1], data[2], //name - userName password
							Integer.parseInt(data[3]), //client calification
							data[4], //nationality
							data[5], //gender
							Integer.parseInt(data[6]), //age
							data[7])); //ID
			line = reader.readLine();
		}
		reader.close();
		return clients;
	}
	
	public void updateUser(User user) throws IOException {
		ArrayList<User> users = readUsers();
		BufferedWriter overwriter = new BufferedWriter(new FileWriter(usersRecord));
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getNameUser().equals(user.getNameUser()))
				users.set(i, user);
			
			if(usersRecord.length()!=0)
				overwriter.newLine();
			overwriter.write(user.getName()+";"+user.getNameUser()+";"+user.getPassword());
	        if(user.isAdministrator()) {
	        	Client clientUser = (Client) user;
	        	overwriter.write(";"+clientUser.getClientCalification()
	        				+";"+clientUser.getClientNationality()
	        				+";"+clientUser.getClientGender()
	        				+";"+clientUser.getClientAge()
	        				+";"+clientUser.getClientID());
	        }
			overwriter.flush();
		}
		overwriter.close();
	}//updateUser
	
	public boolean exist(User user) throws IOException {
		return readUser(user.getNameUser())!=null;
	}
}//end class
