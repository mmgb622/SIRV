package GUI.administrator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Domain.Admin;
import GUI.Style;

public class JPAdministratorPanel extends JPanel implements MouseListener{

	private BufferedImage img;
	private JLabel adminName, manageTaxiDrivers, manageMap, manageRideTypes, seeUsers;
	
	private JPViewClients jpClients;
	private JPManageMap jpMap;
	private JPManageRideType jpRideType;
	
	public JPAdministratorPanel(Admin user) {
		this.setPreferredSize(new Dimension(900, 750));
		this.setLayout(null);
		init(user);
	}

	private void init(Admin user) {
		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/Assets/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.adminName = new JLabel(user.getName());
		this.adminName.setBounds(550, 0, 300, 150);
		Style.setSubtitle(adminName);
		this.adminName.setHorizontalAlignment(JLabel.RIGHT);
		this.add(adminName);
		
		this.manageTaxiDrivers = new JLabel("Taxi Drivers");
		this.manageTaxiDrivers.setBounds(0,150,225,40);
		Style.text(manageTaxiDrivers);
		this.manageTaxiDrivers.setHorizontalAlignment(JLabel.CENTER);
		this.manageTaxiDrivers.addMouseListener(this);
		this.add(manageTaxiDrivers);
		
		this.manageMap = new JLabel("Map");
		this.manageMap.setBounds(225,150,225,40);
		Style.text(manageMap);
		this.manageMap.setHorizontalAlignment(JLabel.CENTER);
		this.manageMap.addMouseListener(this);
		this.add(manageMap);
		
		this.manageRideTypes = new JLabel("Ride Types");
		this.manageRideTypes.setBounds(450,150,225,40);
		Style.text(manageRideTypes);
		this.manageRideTypes.setHorizontalAlignment(JLabel.CENTER);
		this.manageRideTypes.addMouseListener(this);
		this.add(manageRideTypes);
		
		this.seeUsers = new JLabel("Clients");
		this.seeUsers.setBounds(675,150,225,40);
		Style.text(seeUsers);
		this.seeUsers.setHorizontalAlignment(JLabel.CENTER);
		this.seeUsers.addMouseListener(this);
		this.add(seeUsers);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0, 0, 900, 750);
		
		g.setColor(Style.colors[3]);
		g.fillRect(0, 0, 900, 150);
		g.setColor(Style.colors[2]);
		g.fillRect(0, 150, 900, 40);
		g.drawImage(img, 0, 0, 360,150, null);
		
	}
	
	private void reset() {
		if(this.jpClients!= null)
			this.remove(jpClients);
		if(this.jpMap != null)
			this.remove(jpMap);
		if(this.jpRideType != null)
			this.remove(jpRideType);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(this.seeUsers)) {
			this.reset();
			System.out.println("Clientes presionado");
			this.jpClients = new JPViewClients();
			this.jpClients.setLocation(0, 200);
			this.jpClients.setVisible(true);
			this.add(jpClients);
			repaint();
		}else if(e.getSource().equals(this.manageMap)) {
			this.reset();
			System.out.println("Mapa presionado");
			this.jpMap = new JPManageMap();
			this.jpMap.setLocation(0, 200);
			this.jpMap.setVisible(true);
			this.add(jpMap);
			repaint();
		}else if(e.getSource().equals(this.manageRideTypes)) {
			this.reset();
			this.jpRideType = new JPManageRideType();
			this.jpRideType.setLocation(0,200);
			this.jpRideType.setVisible(true);
			this.add(jpRideType);
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(this.manageTaxiDrivers)) {
			this.manageTaxiDrivers.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
			this.manageTaxiDrivers.setForeground(Style.colors[0]);
		}else if(e.getSource().equals(this.manageMap)) {
			this.manageMap.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
			this.manageMap.setForeground(Style.colors[0]);
		}else if(e.getSource().equals(this.manageRideTypes)) {
			this.manageRideTypes.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
			this.manageRideTypes.setForeground(Style.colors[0]);
		}else if(e.getSource().equals(this.seeUsers)) {
			this.seeUsers.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
			this.seeUsers.setForeground(Style.colors[0]);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(this.manageTaxiDrivers)) {
			Style.text(manageTaxiDrivers);
		}else if(e.getSource().equals(this.manageMap)) {
			Style.text(manageMap);
		}else if(e.getSource().equals(this.manageRideTypes)) {
			Style.text(manageRideTypes);
		}else if(e.getSource().equals(this.seeUsers)) {
			Style.text(seeUsers);
		}
	}
}
