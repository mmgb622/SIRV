package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Style {
	
	public static Color colors[] = {Color.decode("#EDEEC0"),Color.decode("#6E6A3B"),Color.decode("#433E0E"), Color.decode("#7C9082"), Color.decode("#A7A284"),Color.decode("#BCB589"), Color.decode("#D0C88E")};

	public static void setTitle(JLabel label) {
		label.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 30));
		label.setForeground(colors[1]);
		label.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public static void setSubtitle(JLabel label) {
		label.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
		label.setForeground(colors[6]);
		label.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public static void text(JLabel label) {
		label.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 16));
		label.setForeground(colors[3]);
	}
	
	public static void setSubtext(JLabel label) {
		label.setFont(new Font("Calibri", Font.BOLD, 11));
		label.setForeground(colors[4]);
		label.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public static void setTextField(JTextField textField) {
		textField.setBackground(colors[6]);
		textField.setBorder(BorderFactory.createLineBorder(colors[2], 1));
		textField.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		textField.setForeground(colors[2]);
	}//setTextField
	
	public static void setButton(JButton button) {
		button.setFocusable(false);
		button.setBackground(colors[3]);
		button.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 25));
		button.setForeground(colors[6]);
		button.setBorder(BorderFactory.createEtchedBorder());
	}
	
}//class end
