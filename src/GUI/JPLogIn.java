package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Domain.Admin;
import Domain.Client;
import Domain.User;

public class JPLogIn extends JPanel implements ActionListener{

	private JLabel title,jl_Username, jl_Password, jl_ConfirmPass,jl_Name,jl_Age,jl_Gender,jl_ID,jl_Nationality;
	private JLabel showPassword;
	private JCheckBox administrator;
	private JButton jb_logIn, jb_cancel;
	private JComboBox<String> gender;
	private JTextField jtfUsername, jtf_name,jtf_age,jtf_ID,jtf_Nationality; 
	private JPasswordField jpf_Password, jpf_ConfirmPass;
	
	public char i;
	private BufferedImage picture;
	
	public JPLogIn() {
		this.setPreferredSize(new Dimension(900, 750));
		this.setLayout(null);
		this.setBackground(Style.colors[0]);
		init();
	}
	
	private void init() {
		try {
			this.picture = ImageIO.read(getClass().getResourceAsStream("/Assets/header.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//title
		this.title = new JLabel("Log In");
		this.title.setBounds(350,310,200,40);
		Style.setTitle(title);
		this.add(this.title);
		//username instruction
		this.jl_Username = new JLabel("Create a username");
		this.jl_Username.setBounds(50,350,200,30);
		Style.text(jl_Username);
		this.add(this.jl_Username);
		//username space
		this.jtfUsername = new JTextField();
		this.jtfUsername.setBounds(50,380,350,30);
		Style.setTextField(jtfUsername);
		this.add(this.jtfUsername);
		
		this.jl_Password = new JLabel("Create a password");
		this.jl_Password.setBounds(50,430,200,30);
		Style.text(jl_Password);
		this.add(this.jl_Password);
		
		this.jpf_Password = new JPasswordField();
		this.jpf_Password.setBounds(50, 460, 350, 30);
		this.i = this.jpf_Password.getEchoChar();
		Style.setTextField(jpf_Password);
		this.add(this.jpf_Password);
		
		this.jl_ConfirmPass = new JLabel("Confirm your password");
		this.jl_ConfirmPass.setBounds(50,510,200,30);
		Style.text(jl_ConfirmPass);
		this.add(this.jl_ConfirmPass);
		
		this.jpf_ConfirmPass = new JPasswordField();
		this.jpf_ConfirmPass.setBounds(50, 540, 350, 30);
		Style.setTextField(jpf_ConfirmPass);
		this.add(this.jpf_ConfirmPass);
		
		this.showPassword = new JLabel("Show Password");
		this.showPassword.setBounds(270, 580, 150, 20);
		Style.setSubtext(this.showPassword);
		this.add(this.showPassword);
		
		this.jl_Name = new JLabel("Insert your name");
		this.jl_Name.setBounds(500,350,200,30);
		Style.text(jl_Name);
		this.add(jl_Name);
		
		this.jtf_name = new JTextField();
		this.jtf_name.setBounds(500, 380, 350, 30);
		Style.setTextField(jtf_name);
		this.add(this.jtf_name);
		
		this.administrator = new JCheckBox("I'm administrator");
		this.administrator.setBounds(600, 420, 140, 20);
		this.administrator.setBackground(null);
		this.administrator.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.administrator.setForeground(Style.colors[5]);
		this.administrator.setFocusable(false);
		this.administrator.addActionListener(this);
		this.add(administrator);
		
		this.jl_Age = new JLabel("Age:");
		this.jl_Age.setBounds(500,450,100,30);
		Style.text(jl_Age);
		this.add(this.jl_Age);
		
		this.jtf_age = new JTextField();
		this.jtf_age.setBounds(540,450,125,30);
		Style.setTextField(jtf_age);
		this.add(jtf_age);
		
		this.jl_Gender = new JLabel("Gender:");
		this.jl_Gender.setBounds(675,450,100,30);
		Style.text(jl_Gender);
		this.add(this.jl_Gender);
		
		this.gender = new JComboBox<>();
		this.gender.addItem("Male");
		this.gender.addItem("Female");
		this.gender.setBounds(750, 450, 100, 30);
		this.gender.setBackground(Style.colors[6]);
		this.gender.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		this.gender.setFocusable(false);
		this.add(gender);
		
		this.jl_ID = new JLabel("Personal ID:");
		this.jl_ID.setBounds(500,500,150,30);
		Style.text(jl_ID);
		this.add(jl_ID);
		
		this.jtf_ID = new JTextField();
		this.jtf_ID.setBounds(600, 500, 250, 30);
		Style.setTextField(jtf_ID);
		this.add(jtf_ID);
		
		this.jl_Nationality = new JLabel("Nationality:");
		this.jl_Nationality.setBounds(500, 550, 150, 30);
		Style.text(jl_Nationality);
		this.add(jl_Nationality);
		
		this.jtf_Nationality = new JTextField();
		this.jtf_Nationality.setBounds(600, 550, 250, 30);
		Style.setTextField(jtf_Nationality);
		this.add(jtf_Nationality);
		
		this.jb_logIn = new JButton("Log In");
		this.jb_logIn.setBounds(250, 640, 175, 50);
		Style.setButton(jb_logIn);
		this.add(jb_logIn);
		
		this.jb_cancel = new JButton("Cancel");
		this.jb_cancel.setBounds(475, 640, 175, 50);
		Style.setButton(jb_cancel);
		this.add(jb_cancel);
	}//init

	public boolean validateFields() {
		boolean completed = true;
		String err = "Invalid information: ";
		if(this.jtf_name.getText().isBlank()) {
			completed = false;
			err+="\n >> Name is blank";
		} 
		if(this.jtfUsername.getText().isBlank()) {
			completed = false;
			err+="\n >> User name is blank";
		}
		char[] pass = this.jpf_Password.getPassword();
		char[] confirmPass = this.jpf_ConfirmPass.getPassword();
		if(pass.length==0) {
			completed = false;
			err+="\n >> Password is empty";
		}
		if(confirmPass.length==0) {
			completed = false;
			err+="\n >> Confirmation of password is empty";
		}
		if(pass.length>0 && confirmPass.length>0) {
			if(pass.length!=confirmPass.length) {
				completed = false;
				err+="\n >> Password confirmation is not equal";
			}else {
				for (int i = 0; i < confirmPass.length; i++) {
					if (pass[i]!=confirmPass[i]) {
						completed = false;
						err+="\n >> Password confirmation is not equal";
					}
				}
			}
			
		}
		
		if(!administratorUser()) {
			if(this.jtf_age.getText().isBlank()) {
				completed = false;
				err+="\n >> Age is blank";
			}
			if(this.jtf_ID.getText().isBlank()) {
				completed = false;
				err+="\n >> ID is blank";
			}
			if(this.jtf_Nationality.getText().isBlank()) {
				completed = false;
				err+="\n >> Nationality is blank";
			}
		}
		
		if(!completed)
			JOptionPane.showMessageDialog(this, err);
		return completed;
	}
	
	public User generateUser() {
		if(administratorUser()) {
			String password = "";
			char[] pass = this.jpf_Password.getPassword();
			for (int i = 0; i < pass.length; i++) {
				password +=  pass[i];
			}
			return new Admin(this.jtf_name.getText(),
					this.jtfUsername.getText(),password);
		}else {
			String password = "";
			char[] pass = this.jpf_Password.getPassword();
			for (int i = 0; i < pass.length; i++) {
				password +=  pass[i];
			}
			return new Client(this.jtf_name.getText(),
					this.jtfUsername.getText(),
					password,
					5,
					this.jtf_Nationality.getText(),
					(String)this.gender.getSelectedItem(),
					Integer.parseInt(this.jtf_age.getText()),
					this.jtf_ID.getText());
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0, 0, 900, 750);
		g.setColor(Style.colors[2]);
		g.fillRect(0, 0, 900, 250);
		g.fillRect(0, 270, 900, 20);
		g.drawImage(picture, 0, 20, null);
		g.drawLine(450, 360, 450, 600);
	}//paintComponent


	public void reset() {
		this.jtfUsername.setText("");
		this.jpf_ConfirmPass.setText("");
		this.jpf_Password.setText("");
		this.setVisible(false);
	}//reset
	
	public boolean administratorUser() {
		return this.administrator.isSelected();
	}
	
	//getters and setters
	public JLabel getShowPassword() {
		return showPassword;
	}

	public void setShowPassword(JLabel showPassword) {
		this.showPassword = showPassword;
	}

	public JButton getJb_logIn() {
		return jb_logIn;
	}

	public void setJb_logIn(JButton jb_logIn) {
		this.jb_logIn = jb_logIn;
	}

	public JButton getJb_cancel() {
		return jb_cancel;
	}

	public void setJb_cancel(JButton jb_cancel) {
		this.jb_cancel = jb_cancel;
	}

	public JTextField getJtfUsername() {
		return jtfUsername;
	}

	public void setJtfUsername(JTextField jtfUsername) {
		this.jtfUsername = jtfUsername;
	}

	public JPasswordField getJpf_Password() {
		return jpf_Password;
	}

	public void setJpf_Password(JPasswordField jpf_Password) {
		this.jpf_Password = jpf_Password;
	}

	public JPasswordField getJpf_ConfirmPass() {
		return jpf_ConfirmPass;
	}

	public void setJpf_ConfirmPass(JPasswordField jpf_ConfirmPass) {
		this.jpf_ConfirmPass = jpf_ConfirmPass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.administrator)) { //hides or shows all the info relative to clients
			if(administratorUser()) {
				this.jl_Age.setForeground(Style.colors[5]);
				this.jtf_age.setBackground(Style.colors[5]);
				this.jtf_age.setForeground(Style.colors[5]);
				this.jtf_age.setBorder(BorderFactory.createLineBorder(Style.colors[5]));
				this.jtf_age.setEditable(false);
				
				this.gender.setEnabled(false);
				this.jl_Gender.setForeground(Style.colors[5]);
				this.gender.setBackground(Style.colors[5]);
				this.gender.setForeground(Style.colors[5]);
				this.gender.setBorder(BorderFactory.createLineBorder(Style.colors[5]));
				
				
				this.jl_ID.setForeground(Style.colors[5]);
				this.jtf_ID.setBackground(Style.colors[5]);
				this.jtf_ID.setForeground(Style.colors[5]);
				this.jtf_ID.setBorder(BorderFactory.createLineBorder(Style.colors[5]));
				this.jtf_ID.setEditable(false);
				
				this.jl_Nationality.setForeground(Style.colors[5]);
				this.jtf_Nationality.setBackground(Style.colors[5]);
				this.jtf_Nationality.setForeground(Style.colors[5]);
				this.jtf_Nationality.setBorder(BorderFactory.createLineBorder(Style.colors[5]));
				this.jtf_Nationality.setEditable(false);
			} else {
				Style.text(jl_Age);
				Style.setTextField(jtf_age);
				this.jtf_age.setEditable(true);
				
				Style.text(jl_Gender);
				this.gender.setForeground(Style.colors[2]);
				this.gender.setBackground(Style.colors[6]);
				this.gender.setEnabled(true);
				
				Style.text(jl_ID);
				Style.setTextField(jtf_ID);
				this.jtf_ID.setEditable(true);
				
				Style.text(jl_Nationality);
				Style.setTextField(jtf_Nationality);
				this.jtf_Nationality.setEditable(true);
			} //conditional -> changes the style of some spaces whether the user is administrator or not
		}
		
	}//actionPerformed

	
} //class end
