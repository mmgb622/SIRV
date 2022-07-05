package GUI.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Style;
import Logic.logicList.CircularDoubleLinkedList;

public class JPChooseRide extends JPanel  {
	
	private JLabel jlRideType , jlTRideType, jlTPayType;

	private JComboBox jcomboPayType;
	private JButton jbtConfirm;
	
//	private CircularDoubleLinkedList rideType;
	
	public JPChooseRide(int width, int height) {
		
//		this.rideType= rideType;
		
		this.setPreferredSize(new Dimension(width, height));		
		this.setLayout(null);
		this.setBackground(Color.red);
		
		init();

	}

	private void init() {
		
		jlTRideType = new JLabel("Type of ride  ");
//		jlTRideType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlTRideType.setBounds(33, 27, 100, 30);
		Style.setTitle(jlTRideType);
		this.add(jlTRideType);
		
		jlRideType = new JLabel("Press the arrow up or down"); 
//		jlRideType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlRideType.setBounds(33, 67, 200, 30);
		Style.setSubtext(jlRideType);
		this.add(jlRideType);
		
		jlTPayType = new JLabel("Payment type  ");
//		jlTPayType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlTPayType.setBounds(33, 120, 110, 30);
		Style.setTitle(jlTPayType);
		this.add(jlTPayType);
		
		
		jcomboPayType = new JComboBox();
		jcomboPayType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jcomboPayType.addItem("Cash");
		jcomboPayType.addItem("Card");
		jcomboPayType.setBounds(33, 160, 200, 30);
		this.add(jcomboPayType);

		jbtConfirm = new JButton("Confirm Ride");
//		jbtConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbtConfirm.setBounds(33, 263, 200, 30);
		Style.setButton(jbtConfirm);
		this.add(jbtConfirm);
		
	}
	
	public void jpChooseRideOff() {
		this.setVisible(false);
	}

	public JLabel getJlRideType() {
		return jlRideType;
	}

	public void setJlRideType(String RideType) {
		this.jlRideType.setText(RideType);
	}
	
	public JComboBox getJcomboPayType() {
		return jcomboPayType;
	}

	public void setJcomboPayType(JComboBox jcomboPayType) {
		this.jcomboPayType = jcomboPayType;
	}

	public JButton getJbtConfirm() {
		return jbtConfirm;
	}

	public void setJbtConfirm(JButton jbtConfirm) {
		this.jbtConfirm = jbtConfirm;
	}

	

}
