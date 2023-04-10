package Tester;

import javax.swing.*;
import java.awt.*;

import auth.Signin;
import shopPage.Shop;
import Menu.Menu;
import homePage.Home;

public class VirtualCasino extends JFrame{
	private Signin login = new Signin();
	private Menu menu = new Menu(this);	
	private Shop shop = new Shop();
	private Home home = new Home();
	
	public VirtualCasino() {
		super("Il Casino Virtuale");
		this.setSize(1600, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		createWindow();
		this.setVisible(true);
	}
	
	public void createWindow() {

		//this.getContentPane().add(login);
		this.getContentPane().add(menu);
		this.getContentPane().add(home);

		shop.setVisible(false);
		this.getContentPane().add(shop);
	}

	public void setHome() {
		home.setVisible(true);
		menu.setVisible(true);
		shop.setVisible(false);
	}

	public void setShop() {
		home.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(true);
	}
}
