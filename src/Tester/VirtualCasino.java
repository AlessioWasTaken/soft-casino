package Tester;

import javax.swing.*;
import java.awt.*;

import auth.Signin;
import shopPage.Shop;
import Menu.Menu;
import homePage.Home;
import slotMachine.SlotMachine;
import corsaCavalli.CorsaCavalli;
import blackJack.BlackJack;

public class VirtualCasino extends JFrame{
	private Signin login = new Signin();
	private Menu menu = new Menu(this);	
	private Shop shop = new Shop();
	private Home home = new Home();
	private SlotMachine slotMachine = new SlotMachine();
	private CorsaCavalli corsaCavalli = new CorsaCavalli();
	private BlackJack blackJack = new BlackJack();
	
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

		slotMachine.setVisible(false);
		this.getContentPane().add(slotMachine);

		corsaCavalli.setVisible(false);
		this.getContentPane().add(corsaCavalli);

		blackJack.setVisible(false);
		this.getContentPane().add(blackJack);
	}

	public void setHome() {
		home.setVisible(true);
		menu.setVisible(true);
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
	}

	public void setShop() {
		home.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(true);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
	}

	public void setSlotMachine() {
		home.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(false);
		slotMachine.setVisible(true);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
	}

	public void setCorsaCavalli() {
		home.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(true);
		blackJack.setVisible(false);
	}

	public void setBlackJack() {
		home.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(true);
	}
}
