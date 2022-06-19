package GUI;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Domain.User;

public class JUserMenu extends JPanel {

	private JButton jbLogOut, jbSettings, jbClose;
	
	public JUserMenu(User user, int x, int y) {
		this.setSize(200,150);
		this.setLocation(x, y);
		this.setVisible(true);
		init(user);
	}

	private void init(User user) {
		if(!user.isAdministrator()) {
			this.setLayout(new GridLayout(3, 1));
			
			this.jbSettings = new JButton("Settings");
			Style.setButton(jbSettings);
			this.jbSettings.setBorder(null);
			this.add(jbSettings);
		}else {
			this.setLayout(new GridLayout(2, 1));
		}
		
		this.jbLogOut = new JButton("Log Out");
		Style.setButton(jbLogOut);
		this.jbLogOut.setBorder(null);
		this.add(jbLogOut);
		
		this.jbClose = new JButton("Close");
		Style.setButton(jbClose);
		this.jbClose.setBorder(null);
		this.add(jbClose);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	public void addActionListener(ActionListener a) {
		this.jbClose.addActionListener(a);
		this.jbLogOut.addActionListener(a);
		if(this.jbSettings!=null)
			this.jbSettings.addActionListener(a);
	}

	public JButton getJbLogOut() {
		return jbLogOut;
	}

	public void setJbLogOut(JButton jbLogOut) {
		this.jbLogOut = jbLogOut;
	}

	public JButton getJbSettings() {
		return jbSettings;
	}

	public void setJbSettings(JButton jbSettings) {
		this.jbSettings = jbSettings;
	}

	public JButton getJbClose() {
		return jbClose;
	}

	public void setJbClose(JButton jbClose) {
		this.jbClose = jbClose;
	}

	
}//class end
