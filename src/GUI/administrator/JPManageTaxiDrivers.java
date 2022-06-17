package GUI.administrator;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Business.UserBusiness;
import Domain.TaxiDriver;
import GUI.Style;

public class JPManageTaxiDrivers extends JPanel implements ActionListener{

	private JComboBox<String> taxiDriverList;
	private ArrayList<TaxiDriver> taxiDriver;
	private JButton viewMore;
	
	public JPManageTaxiDrivers() {
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		this.setSize(900, 550);
		init();
	}
	
	private void init() {
		try {
			UserBusiness usb = new UserBusiness();
			this.taxiDriver = usb.readTaxiDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel title = new JLabel("Taxi Driver");
		title.setBounds(30, 30, 200, 40);
		Style.setTitle(title);
		this.add(title);
		
		this.taxiDriverList = new JComboBox<>();
		this.taxiDriverList.setBounds(60, 70, 400, 30);
		this.taxiDriverList.setBackground(Style.colors[6]);
		this.taxiDriverList.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.taxiDriverList.setFocusable(false);
		
		for (int i = 0; i < taxiDriver.size(); i++) {
			this.taxiDriverList.addItem(taxiDriver.get(i).getNameUser());
		}
		this.add(taxiDriverList);
		
		this.viewMore = new JButton("View more info");
		this.viewMore.setBounds(600, 60, 230, 50);
		Style.setButton(viewMore);
		this.viewMore.addActionListener(this);
		this.add(viewMore);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0,0,900, 550);
		g.setColor(Style.colors[1]);
		g.drawRect(20, 20, 860, 510);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.viewMore)) {
			TaxiDriver taxiDriver = this.taxiDriver.get(this.taxiDriverList.getSelectedIndex());
			JLabel userName = new JLabel(client.getNameUser());
			userName.setBounds(100,120,200,40);
			Style.setSubtitle(userName);
			this.add(userName);
			
			JLabel name = new JLabel("Name: "+client.getName());
			name.setBounds(110, 180, 500, 30);
			Style.text(name);
			this.add(name);
			
			JLabel age = new JLabel("Age: " + client.getClientAge());
			age.setBounds(110, 210, 500, 30);
			Style.text(age);
			this.add(age);
			
			JLabel id = new JLabel("ID: " + client.getClientID());
			id.setBounds(110, 240, 500, 30);
			Style.text(id);
			this.add(id);
			
			JLabel gender = new JLabel("Gender: " + client.getClientGender());
			gender.setBounds(110, 270, 500, 30);
			Style.text(gender);
			this.add(gender);
			
			JLabel nationality = new JLabel("Nacionality: " + client.getClientNationality());
			nationality.setBounds(110, 300, 500, 30);
			Style.text(nationality);
			this.add(nationality);
			
			JLabel calification = new JLabel("Calification: " + client.getClientCalification());
			calification.setBounds(110, 330, 500, 30);
			Style.text(calification);
			this.add(calification);
			
			repaint();
		}
	}//actionPerformed
}//class end
