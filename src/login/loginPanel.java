package login;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;

import javax.swing.JPanel;

public class loginPanel extends JPanel {
	ImageIcon img = new ImageIcon("C:\\Users\\Alessio Sarica\\Documents\\Eclipse\\Virtual Casino\\assets\\BackgroundLogin.jpg");
	/**
	 * Create the panel.
	 */
	public loginPanel() {

	}
	
	
	public void paint(Graphics g) {
		g.drawImage(img.getImage(), 0, 0, 1200, 700, this);
		g.setColor(Color.white);
		g.fillRoundRect(100, 10, 300, 400, 10, 10);
	}

}
