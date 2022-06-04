package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPSingUp extends JPanel {
	
	private JLabel title, jlUsername, jlPassword;
	private JLabel registerQuestion, showPassword;
	private JButton singUp;
	private JTextField jtfUsername; 
	private JPasswordField jpfPassword;
	public char i;
	private BufferedImage picture;
	
	public JPSingUp() {
		this.setPreferredSize(new Dimension(900, 750));
		this.setLayout(null);
		init();
	}
	
	private void init() {
		try {
			this.picture = ImageIO.read(getClass().getResourceAsStream("/Assets/header.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.title = new JLabel("Sing up");
		this.title.setBounds(350,310,200,40);
		Style.setTitle(title);
		this.add(this.title);
		
		this.jlUsername = new JLabel("Introduce your username");
		this.jlUsername.setBounds(225,350,200,30);
		Style.text(jlUsername);
		this.add(this.jlUsername);
		
		this.jtfUsername = new JTextField();
		this.jtfUsername.setBounds(225,390,450,30);
		Style.setTextField(jtfUsername);
		this.add(this.jtfUsername);
		
		this.jlPassword = new JLabel("Introduce your password");
		this.jlPassword.setBounds(225,450,200,30);
		Style.text(jlPassword);
		this.add(this.jlPassword);
		
		this.jpfPassword = new JPasswordField();
		this.jpfPassword.setBounds(225, 490, 450, 30);
		this.i = this.jpfPassword.getEchoChar();
		Style.setTextField(jpfPassword);
		this.add(this.jpfPassword);
		
		this.showPassword = new JLabel("Show Password");
		this.showPassword.setBounds(550, 525, 150, 20);
		Style.setSubtext(this.showPassword);
		this.add(this.showPassword);
		
		this.singUp = new JButton("Sing Up");
		this.singUp.setBounds(275, 580, 350, 50);
		Style.setButton(singUp);
		this.add(this.singUp);
		
		this.registerQuestion = new JLabel("Don't you have an account yet? Register here");
		this.registerQuestion.setBounds(275, 640, 350, 20);
		Style.setSubtext(registerQuestion);
		this.add(this.registerQuestion);
	}

	public boolean validateFields() {
		boolean completed = true;
		String err = "Invalid information:";
		if(this.jtfUsername.getText().isBlank()) {
			completed=false;
			err+="\n >> Username is blank";
		}
		if(this.jpfPassword.getPassword().length==0) {
			completed=false;
			err+="\n >> Password is empty";
		}
		
		if(!completed)
			JOptionPane.showMessageDialog(this, err);
		return completed;
	}
	public void paintComponent(Graphics g) {
		g.setColor(Style.colors[0]);
		g.fillRect(0, 0, 900, 750);
		g.setColor(Style.colors[2]);
		g.fillRect(0, 0, 900, 250);
		g.fillRect(0, 270, 900, 20);
		g.drawImage(picture, 0, 20, null);
	}

	public void reset() {
		this.jtfUsername.setText("");
		this.jpfPassword.setText("");
		this.setVisible(false);
	}
	

	//getters and setters
	public JLabel getRegisterQuestion() {
		return registerQuestion;
	}

	public void setRegisterQuestion(JLabel registerQuestion) {
		this.registerQuestion = registerQuestion;
	}

	public JLabel getShowPassword() {
		return showPassword;
	}

	public void setShowPassword(JLabel showPassword) {
		this.showPassword = showPassword;
	}

	public JButton getSingUp() {
		return singUp;
	}

	public void setSingUp(JButton singUp) {
		this.singUp = singUp;
	}

	public JTextField getJtfUsername() {
		return jtfUsername;
	}

	public void setJtfUsername(JTextField jtfUsername) {
		this.jtfUsername = jtfUsername;
	}

	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}

	public void setJpfPassword(JPasswordField jpfPassword) {
		this.jpfPassword = jpfPassword;
	}

	
}//class end
