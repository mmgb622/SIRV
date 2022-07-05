package GUI.client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Domain.Client;
import GUI.JMap;
import GUI.Style;

public class JPClientPanel extends JPanel implements ActionListener, KeyListener{
 
	private BufferedImage img;
	private JLabel clientName, jlMap;
	
	private JPDestinySelection jpDestinySelection;
	private JPChooseRide jpChooseRide;
	
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
		
		this.jpDestinySelection= new JPDestinySelection(400, 750);
//		this.jpChooseRide = new JPChooseRide(400, 750, Object element);
//		this.map = new JMap();
		
		this.jlMap = new JLabel();
		this.jlMap.setBounds(10, 10, 500, 500);
		this.jlMap.add(this.map);
		this.add(jlMap);
		
		
		jpDestinySelection.getJbAccept().addActionListener(this);
		jpChooseRide.getJbtConfirm().addActionListener(this);
		jpChooseRide.getJcomboPayType().addActionListener(this);
		
		this.clientName = new JLabel(user.getName());
		this.clientName.setBounds(550, 0, 300, 150);
		Style.setSubtitle(clientName);
		this.clientName.setHorizontalAlignment(JLabel.RIGHT);
		this.add(clientName);
		
	}//init
	
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
			jpChooseRide.setJlRideType("");
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			jpChooseRide.setJlRideType("");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jpDestinySelection.getJbAccept())) {}
		
		if(e.getSource().equals(jpChooseRide.getJbtConfirm())) {}
		
		if(e.getSource().equals(jpChooseRide.getJcomboPayType())) {
			String selectedItem = ""+jpChooseRide.getJcomboPayType().getSelectedItem();
			
		}
	}
}//end class
