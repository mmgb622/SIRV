package GUI.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Domain.Client;
import GUI.Style;

public class JPClientPanel extends JPanel{
 
	private BufferedImage img;
	private JLabel clientName;
	
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
}//end class
