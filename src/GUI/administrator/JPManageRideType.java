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
import GUI.Style;
import Logic.logicList.CircularDoubleLinkedList;

public class JPManageRideType extends JPanel implements ActionListener{

	private JComboBox<String> rideTypes;
	private ArrayList<Integer> costs =  new ArrayList<Integer>();
	
	private JButton add;
	private JButton delete;
	private JButton edit;
	
	private JTextField name;
	private JTextField cost;
	
	private CircularDoubleLinkedList rides = new CircularDoubleLinkedList();
	


	
	public JPManageRideType() {
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		this.setSize(900, 550);
		init();
	}
	
	private void refreshCombo() {
		this.rideTypes.removeAllItems();
		for (int i = 0; i < rides.getSize(); i++) {
			System.out.println(i);
			this.rideTypes.addItem((String)rides.get(i));
		}
		this.add(rideTypes);
		
	}
	private void init() {


		rides.addEnd("UberX");
		costs.add(300);
		rides.addEnd("UberPlanet");
		costs.add(400);
		rides.addEnd("Flash");
		costs.add(500);
		rides.addEnd("UberXL");
		costs.add(250);
		rides.addEnd("Ubercomfort");
		costs.add(123);
		rides.addEnd("UberVIP");
		costs.add(111);
		rides.addEnd("nulo");
		costs.add(200);
		System.out.println(rides.getSize());
		JLabel title = new JLabel("Manage Ride Types");
		title.setBounds(20, 30, 300, 39);
		Style.setTitle(title);
		this.add(title);
		
		this.rideTypes = new JComboBox<>();
		this.rideTypes.setBounds(600, 44, 200, 22);
		this.rideTypes.setBackground(Style.colors[6]);
		this.rideTypes.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.rideTypes.setFocusable(false);

		
		for (int i = 0; i < rides.getSize(); i++) {
			
			this.rideTypes.addItem((String)rides.get(i));
		}
		this.add(rideTypes);
		
		this.add = new JButton("Add");
		this.add.setBounds(25, 150, 89, 23);
		Style.setButton(add);
		this.add.addActionListener(this);
		this.add(add);
		

		this.edit = new JButton("Edit");
		this.edit.setBounds(25, 190, 89, 23);
		Style.setButton(edit);
		this.edit.addActionListener(this);
		this.edit.setEnabled(false);
		this.add(edit);
		
		this.delete = new JButton("Delete");
		this.delete.setBounds(25, 230,89, 23);
		Style.setButton(delete);
		this.delete.addActionListener(this);
		this.add(delete);
		
		JLabel lname = new JLabel("Name");
		lname.setBounds(600, 110, 200, 22);
		Style.setTitle(lname);
		this.add(lname);
		
		this.name = new JTextField();
		this.name.setBounds(600, 140, 200, 22);
		add(this.name);
		
		JLabel lCost = new JLabel("Cost");
		lCost.setBounds(600, 180, 200, 22);
		Style.setTitle(lCost);
		this.add(lCost);
		
		this.cost = new JTextField();
		this.cost.setBounds(600, 210, 200, 22);
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
			rides.addHead(name.getText());
			name.setText("");
			refreshCombo();
			repaint();
		}
		if(e.getSource().equals(this.rideTypes)) {
			if(rideTypes.getSelectedItem()!=null) {
			name.setText(rideTypes.getSelectedItem().toString());
			cost.setText(costs.get(rideTypes.getSelectedIndex()-1).toString());
			}
		}
		if(e.getSource().equals(this.delete)) {
			System.out.println("se borro");
			rides.delete(rideTypes.getSelectedIndex());
			name.setText("");
			cost.setText("");
			refreshCombo();
			repaint();
		}
		
	}//actionPerformed
}//class end
