package Tester;
import login.*;

import javax.swing.*;

public class VirtualCasino extends JFrame{
	private loginPanel login = new loginPanel();
	
	public VirtualCasino() {
		super("Il Casino Virtuale");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createWindow();
		this.setVisible(true);
	}
	
	public void createWindow() {
		this.getContentPane().add(login);
	}
	
	
	public static void main(String[] args) {
		new VirtualCasino();
	}
}
