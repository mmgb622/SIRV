package GUI.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Domain.Client;
import GUI.JMap;
import GUI.JUserMenu;
import GUI.Style;
import Logic.DynamicGraph;

public class JPClientPanel extends JPanel implements MouseListener{
 
	private BufferedImage img;
	private JLabel clientName;
	
	private JUserMenu menu;
	private JMap map;
	
	public JPClientPanel(Client user) {
		this.setPreferredSize(new Dimension(900, 750));
		this.setLayout(null);
		init(user);
	}

	private void init(Client user) {
		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/Assets/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.menu = new JUserMenu(user, 700, 0);
		this.menu.setVisible(false);
		this.add(menu);
		
		this.clientName = new JLabel(user.getName());
		this.clientName.setBounds(550, 0, 300, 150);
		Style.setSubtitle(clientName);
		this.clientName.setHorizontalAlignment(JLabel.RIGHT);
		this.clientName.addMouseListener(this);
		this.add(clientName);
		
		initMap();
	}//init
	
	private void initMap() {
		//here we required to load the graph from the file, an then give it to the map constructor
		//>>
		this.map = new JMap(new DynamicGraph(), 580, 570, false);
		this.map.setLocation(10, 170);
		this.add(this.map);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0, 0, 900, 750);
		
		g.setColor(Style.colors[3]);
		g.fillRect(0, 0, 900, 150);
		g.setColor(Style.colors[2]);
		g.fillRect(0, 150, 900, 10);
		g.drawImage(img, 0, 0, 360,150, null);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource().equals(this.clientName)) {
			this.clientName.setVisible(false);;
			this.menu.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//setters and getters
	public JLabel getClientName() {
		return clientName;
	}

	public void setClientName(JLabel clientName) {
		this.clientName = clientName;
	}

	public JUserMenu getMenu() {
		return menu;
	}

	public void setMenu(JUserMenu menu) {
		this.menu = menu;
	}
}//end class
