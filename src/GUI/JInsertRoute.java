package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JInsertRoute extends JPanel {

	JLabel jlTitle, jlRoute, jlDestiny;
	JTextField jtfRoute, jtfDestiny;
	JButton jbAccept;
	
	
	public JInsertRoute() {
		this.setPreferredSize(new Dimension(225, 300));
		this.setLayout(null);
		this.setBackground(Color.GREEN);
		init();
	}


	private void init() {
		this.jlTitle = new JLabel("Define Route ");
		jlTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		this.jlTitle.setBounds(20, 20, 150, 30);
		this.add(this.jlTitle);
		
		this.jlRoute = new JLabel("Route:  ");
		jlRoute.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.jlRoute.setBounds(20, 70, 100, 30);
		this.add(this.jlRoute);

		this.jtfRoute = new JTextField();
		this.jtfRoute.setBounds(20, 100, 150, 30);
		this.add(this.jtfRoute);
		
		this.jlDestiny = new JLabel("Destiny: ");
		jlDestiny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.jlDestiny.setBounds(20, 150, 100, 30);
		this.add(this.jlDestiny);
		
		this.jtfDestiny = new JTextField();
		this.jtfDestiny.setBounds(20, 180, 150, 30);
		this.add(this.jtfDestiny);

		this.jbAccept = new JButton("Accept");
		jbAccept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.jbAccept.setBounds(50, 230, 100, 30);
//		this.jbAccept.addActionListener(this);
		this.add(this.jbAccept);
		
	}

}
