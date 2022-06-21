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
import javax.swing.JTextField;

import Business.UserBusiness;
import Domain.TaxiDriver;
import GUI.Style;

public class JPManageTaxiDrivers extends JPanel implements ActionListener{

	private JComboBox<String> taxiDriverList;
	private ArrayList<TaxiDriver> taxiDriver;
	private JButton btnEdit, btnDelete, btnUpdate, btnAddNew, btnSave;
	private JTextField jtfTaxiDriverName, jtfTaxiDriverCalification, jtfTaxiDriverCar, jtfTaxiDriverPaymentType;
	
	public JPManageTaxiDrivers() {
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		this.setSize(900, 550);
		init();
	}
	
	private void init() {
//		try {
//			UserBusiness usb = new UserBusiness();
//			this.taxiDriver = usb.readTaxiDriver();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		JLabel title = new JLabel("Taxi Driver");
		title.setBounds(30, 30, 200, 40);
		Style.setTitle(title);
		this.add(title);
		
		this.taxiDriverList = new JComboBox<>();
		this.taxiDriverList.setBounds(60, 70, 400, 30);
		this.taxiDriverList.setBackground(Style.colors[6]);
		this.taxiDriverList.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.taxiDriverList.setFocusable(false);
		
//		for (int i = 0; i < taxiDriver.size(); i++) {
//			this.taxiDriverList.addItem(taxiDriver.get(i).getTaxiDriverName());
//		}
		this.add(taxiDriverList);
		
		this.btnEdit = new JButton("Edit info");
		this.btnEdit.setBounds(600, 60, 230, 50);
		Style.setButton(btnEdit);
		this.btnEdit.addActionListener(this);
		this.add(btnEdit);
		
		this.btnDelete = new JButton("Delete Taxi Driver");
		this.btnDelete.setBounds(600, 120, 230, 50);
		Style.setButton(btnDelete);
		this.btnDelete.addActionListener(this);
		this.add(btnDelete);
		
		this.btnAddNew = new JButton("New Taxi Driver");
		this.btnAddNew.setBounds(600, 180, 230, 50);
		Style.setButton(btnAddNew);
		this.btnAddNew.addActionListener(this);
		this.add(btnAddNew);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0,0,900, 550);
		g.setColor(Style.colors[1]);
		g.drawRect(20, 20, 860, 510);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.btnEdit)) {
			TaxiDriver taxiDriver = this.taxiDriver.get(this.taxiDriverList.getSelectedIndex());
			
			JLabel jlabelTaxiDriverName = new JLabel("Name");
			jlabelTaxiDriverName.setBounds(110,150,200,30);
			Style.text(jlabelTaxiDriverName);
			this.add(jlabelTaxiDriverName);
			
//			this.jtfTaxiDriverName = new JTextField(client.getName());
			jtfTaxiDriverName.setBounds(110, 180, 500, 30);
			Style.setTextField(jtfTaxiDriverName);
			this.add(jtfTaxiDriverName);

			JLabel jlabelTaxiDriverCalification = new JLabel("Calification");
			jlabelTaxiDriverCalification.setBounds(110,210,200,30);
			Style.text(jlabelTaxiDriverCalification);
			this.add(jlabelTaxiDriverCalification);

//			this.jtfTaxiDriverCalification = new JTextField(client.getName());
			jtfTaxiDriverCalification.setBounds(110, 240, 500, 30);
			Style.setTextField(jtfTaxiDriverCalification);
			this.add(jtfTaxiDriverCalification);
			
			JLabel jlabelTaxiDriverCar = new JLabel("Car:");
			jlabelTaxiDriverCar.setBounds(110, 270, 200, 30);
			Style.text(jlabelTaxiDriverCar);
			this.add(jlabelTaxiDriverCar);

//			this.jtfTaxiDriverCar = new JTextField(client.getName());
			jtfTaxiDriverCar.setBounds(110, 300, 500, 30);
			Style.setTextField(jtfTaxiDriverCar);
			this.add(jtfTaxiDriverCar);

			JLabel jlabelTaxiDriverPaymentType = new JLabel("Payment Type");
			jlabelTaxiDriverPaymentType.setBounds(110, 330, 200, 30);
			Style.text(jlabelTaxiDriverPaymentType);
			this.add(jlabelTaxiDriverPaymentType);

//			this.jtfTaxiDriverPaymentType = new JTextField(client.getName());
			jtfTaxiDriverPaymentType.setBounds(110, 360, 500, 30);
			Style.setTextField(jtfTaxiDriverPaymentType);
			this.add(jtfTaxiDriverPaymentType);
			
			this.btnUpdate = new JButton("Update");
			this.btnUpdate.setBounds(110, 360, 200, 40);
			Style.setButton(btnUpdate);
			this.btnUpdate.addActionListener(this);
			this.add(btnUpdate);
			
			repaint();
		}//if btnEdit was clicked
		
		if(e.getSource().equals(this.btnAddNew)) {
			
			JLabel jlabelTaxiDriverName = new JLabel("Name");
			jlabelTaxiDriverName.setBounds(110,150,200,30);
			Style.text(jlabelTaxiDriverName);
			this.add(jlabelTaxiDriverName);
			
			this.jtfTaxiDriverName = new JTextField();
			jtfTaxiDriverName.setBounds(110, 180, 500, 30);
			Style.setTextField(jtfTaxiDriverName);
			this.add(jtfTaxiDriverName);

			JLabel jlabelTaxiDriverCalification = new JLabel("Calification");
			jlabelTaxiDriverCalification.setBounds(110,210,200,30);
			Style.text(jlabelTaxiDriverCalification);
			this.add(jlabelTaxiDriverCalification);

			this.jtfTaxiDriverCalification = new JTextField();
			jtfTaxiDriverCalification.setBounds(110, 240, 500, 30);
			Style.setTextField(jtfTaxiDriverCalification);
			this.add(jtfTaxiDriverCalification);
			
			JLabel jlabelTaxiDriverCar = new JLabel("Car:");
			jlabelTaxiDriverCar.setBounds(110, 270, 200, 30);
			Style.text(jlabelTaxiDriverCar);
			this.add(jlabelTaxiDriverCar);

			this.jtfTaxiDriverCar = new JTextField();
			jtfTaxiDriverCar.setBounds(110, 300, 500, 30);
			Style.setTextField(jtfTaxiDriverCar);
			this.add(jtfTaxiDriverCar);

			JLabel jlabelTaxiDriverPaymentType = new JLabel("Payment Type");
			jlabelTaxiDriverPaymentType.setBounds(110, 330, 200, 30);
			Style.text(jlabelTaxiDriverPaymentType);
			this.add(jlabelTaxiDriverPaymentType);

			this.jtfTaxiDriverPaymentType = new JTextField();
			jtfTaxiDriverPaymentType.setBounds(110, 360, 500, 30);
			Style.setTextField(jtfTaxiDriverPaymentType);
			this.add(jtfTaxiDriverPaymentType);
			
			this.btnSave = new JButton("Save");
			this.btnSave.setBounds(110, 420, 200, 30);
			Style.setButton(btnSave);
			this.btnSave.addActionListener(this);
			this.add(btnSave);
			
			repaint();
			
		}//if btnAddNew was clicked
		if(e.getSource().equals(this.btnDelete)) {
			
			repaint();
		}//if btnDelete was clicked
	}//actionPerformed
}//class end
