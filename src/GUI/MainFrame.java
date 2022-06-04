package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Business.UserBusiness;
import Domain.Admin;
import Domain.Client;
import Domain.User;
import GUI.administrator.JPAdministratorPanel;
import GUI.client.JPClientPanel;

public class MainFrame extends JFrame implements ActionListener,MouseListener{

	//data management
	private UserBusiness userBusiness;
	
	//panels
	private JPSingUp singUp;
	private JPLogIn logIn;
	private JPAdministratorPanel adminPanel;
	private JPClientPanel clientPanel;
	
	public MainFrame() {
		
		init();
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.requestFocus();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void init() {
		this.singUp = new JPSingUp();
		this.singUp.getShowPassword().addMouseListener(this);
		this.singUp.getRegisterQuestion().addMouseListener(this);
		this.singUp.getSingUp().addActionListener(this);
		this.add(singUp);
		
		this.logIn = new JPLogIn();
		this.logIn.getShowPassword().addMouseListener(this);
		this.logIn.getJb_cancel().addActionListener(this);
		this.logIn.getJb_logIn().addActionListener(this);
		
		try {
			this.userBusiness = new UserBusiness();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource().equals(this.singUp.getRegisterQuestion())) { //register a new user
			this.singUp.reset();
			this.remove(singUp);
			this.add(logIn);
			this.logIn.setVisible(true);
		} else if(e.getSource().equals(this.singUp.getShowPassword())) { //show password in sing up panel
			if(this.singUp.getJpfPassword().getEchoChar()!=((char)0)) {
				this.singUp.getJpfPassword().setEchoChar((char)0);
				this.singUp.getShowPassword().setText("Hide Password");
			}else {
				this.singUp.getJpfPassword().setEchoChar(this.singUp.i);
				this.singUp.getShowPassword().setText("Show Password");
			}
		} else if(e.getSource().equals(this.logIn.getShowPassword())) {
			if(this.logIn.getJpf_Password().getEchoChar()!=((char)0)) {
				this.logIn.getJpf_Password().setEchoChar((char)0);
				this.logIn.getJpf_ConfirmPass().setEchoChar((char)0);
				this.logIn.getShowPassword().setText("Hide Password");
			}else {
				this.logIn.getJpf_Password().setEchoChar(this.logIn.i);
				this.logIn.getJpf_ConfirmPass().setEchoChar(this.logIn.i);
				this.logIn.getShowPassword().setText("Show Password");
			}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.logIn.getJb_cancel())) {
			this.logIn.reset();
			this.add(singUp);
			this.singUp.setVisible(true);
		}else if(e.getSource().equals(this.logIn.getJb_logIn())) {
			if(this.logIn.validateFields()) {
				User generated = this.logIn.generateUser();
				try {
					if(userBusiness.exist(generated))
						JOptionPane.showMessageDialog(this, "Username already registered, try a new one");
					else
						userBusiness.writeUser(generated);
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}else if(e.getSource().equals(this.singUp.getSingUp())) {
			if(this.singUp.validateFields()) {
				try {
					User temp = this.userBusiness.readUser(this.singUp.getJtfUsername().getText());
					if(temp==null)
						JOptionPane.showMessageDialog(this, "This user name is not registered");
					else {
						char[] password = this.singUp.getJpfPassword().getPassword();
						String pass = "";
						for (int i = 0; i < password.length; i++)
							pass+=password[i];
						
						if(!temp.getPassword().equals(pass))
							JOptionPane.showMessageDialog(this, "Incorrect password");
						else {
							if(temp.isAdministrator()) {
								Admin admin = (Admin) temp;
								this.remove(singUp);
								this.singUp.reset();
								this.adminPanel = new JPAdministratorPanel(admin);
								this.adminPanel.setVisible(true);
								this.add(adminPanel);
								this.pack();
								this.repaint();
							}else {
								Client client = (Client) temp;
								this.remove(singUp);
								this.singUp.reset();
								this.clientPanel = new JPClientPanel(client);
								this.clientPanel.setVisible(true);
								this.add(clientPanel);
								this.pack();
								this.repaint();
							}
						}
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(this, e1);
				}//try catch
			}//validation of completed fields	
		}//else if events
		
	}//actionPerformed
	
	
}//class end
