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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Business.UserBusiness;
import Domain.Client;
import Domain.RideType;
import GUI.Style;
import Logic.logicList.CircularDoubleLinkedList;

public class JPManageRideType extends JPanel implements ActionListener{

	private JComboBox<String> rideTypes;
	private ArrayList<RideType> costs =  new ArrayList<RideType>();
	
	private JButton add;
	private JButton delete;
	private JButton edit;
	
	private JTextField name;
	private JTextField cost;
	
	//private CircularDoubleLinkedList rides = new CircularDoubleLinkedList();
	


	
	public JPManageRideType() {
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		this.setSize(900, 550);
		init();
	}
	
	private void refreshCombo() {
		this.rideTypes.removeAllItems();
		
		for (int i = 0; i < costs.size(); i++) {
			this.rideTypes.addItem(costs.get(i).getName());
		}
		this.add(rideTypes);
		
	}
	private void init() {


		//rides.addEnd("UberX");
		costs.add(new RideType("UberX",300));
		costs.add(new RideType("Flash",300));
		costs.add(new RideType("UberXL",300));
		costs.add(new RideType("Ubercomfort",300));
		costs.add(new RideType("UberVIP",300));
		
		
		
		JLabel title = new JLabel("Manage Ride Types");
		title.setBounds(20, 30, 300, 39);
		Style.setTitle(title);
		this.add(title);
		
		this.rideTypes = new JComboBox<>();
		this.rideTypes.setBounds(600, 44, 200, 22);
		this.rideTypes.setBackground(Style.colors[6]);
		this.rideTypes.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.rideTypes.setFocusable(false);

		
		refreshCombo();
		this.add(rideTypes);
		
		this.add = new JButton("Add");
		this.add.setBounds(25, 150, 150, 30);
		Style.setButton(add);
		this.add.addActionListener(this);
		this.add(add);
		

		this.edit = new JButton("Edit");
		this.edit.setBounds(25, 190, 150, 30);
		Style.setButton(edit);
		this.edit.addActionListener(this);
		this.edit.setEnabled(false);
		this.add(edit);
		
		this.delete = new JButton("Delete");
		this.delete.setBounds(25, 230, 150, 30);
		Style.setButton(delete);
		this.delete.addActionListener(this);
		this.add(delete);
		
		JLabel lname = new JLabel("Name");
		lname.setBounds(600, 110, 200, 22);
		Style.setTitle(lname);
		this.add(lname);
		this.name = new JTextField();
		this.name.setBounds(600, 140, 200, 22);
		this.name.addActionListener(this);
		add(this.name);
		
		JLabel lCost = new JLabel("Cost");
		lCost.setBounds(600, 170, 200, 50);
		Style.setTitle(lCost);
		this.add(lCost);
		
		this.cost = new JTextField();
		this.cost.setBounds(600, 220, 200, 22);
		this.cost.addActionListener(this);
		add(this.cost);
		
	
		rideTypes.addActionListener(this);

		name.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	if(!name.getText().equals( rideTypes.getSelectedItem().toString())) {
		    		edit.setEnabled(true);
		    	}
		 
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		      //  edit.setEnabled(true);
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		       // edit.setEnabled(true);
		    }
		});
		
	}

	
	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0,0,900, 550);
		g.setColor(Style.colors[1]);
		g.drawRect(20, 20, 860, 510);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.add)) {
			System.out.println(name.getText());
			costs.add(new RideType(name.getText(),Integer.parseInt(cost.getText())));
			name.setText("");
			cost.setText("");
			refreshCombo();
			repaint();
		}
		if(e.getSource().equals(this.rideTypes)) {
			if(rideTypes.getSelectedItem()!=null) {
			name.setText(rideTypes.getSelectedItem().toString());
			System.out.println(rideTypes.getSelectedItem());
			cost.setText(String.valueOf(costs.get(rideTypes.getSelectedIndex()).getDistanceCost()));
			}
		}
		if(e.getSource().equals(this.delete)) {
			System.out.println("se borro");
			costs.remove(rideTypes.getSelectedIndex());
			name.setText("");
			cost.setText("");
			refreshCombo();
			repaint();
		}
		if(e.getSource().equals(this.name)) {
			System.out.println("holii");
			this.edit.setEnabled(true);
		}
		if(e.getSource().equals(this.edit)) {
			costs.get(rideTypes.getSelectedIndex()).setName(name.getText());
			costs.get(rideTypes.getSelectedIndex()).setDistanceCost(Integer.parseInt(cost.getText()));
			refreshCombo();
			repaint();
			name.setText("");
			cost.setText("");
			edit.setEnabled(false);
		}
	}//actionPerformed
}//class end
