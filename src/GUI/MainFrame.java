package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener,MouseListener{

	JPSingUp singUp;
	JPLogIn logIn;
	
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
		this.add(singUp);
		
		this.logIn = new JPLogIn();
		this.logIn.getShowPassword().addMouseListener(this);
		this.logIn.getJb_cancel().addActionListener(this);
		this.logIn.getJb_logIn().addActionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource().equals(this.singUp.getRegisterQuestion())) {
			this.singUp.reset();
			this.add(logIn);
			this.logIn.setVisible(true);
		} else if(e.getSource().equals(this.singUp.getShowPassword())) {
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
			this.singUp.setVisible(true);
		}
		
	}
	
	
}
