
import javax.swing.*;
import java.awt.*;

import auth.Sigin;

public class VirtualCasino extends JFrame{
	private Sigin login = new Sigin();	
	
	public VirtualCasino() {
		super("Il Casino Virtuale");
		this.setSize(1600, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createWindow();
		this.setVisible(true);
	}
	
	public void createWindow() {
		this.getContentPane().add(login);
	}
}
