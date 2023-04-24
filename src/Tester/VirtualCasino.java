package Tester;

import javax.swing.*;

// Local imports
import auth.Access;
import shopPage.Shop;
import Menu.Menu;
import homePage.Home;
import slotMachine.SlotMachine;
import corsaCavalli.CorsaCavalli;
import blackJack.BlackJack;

public class VirtualCasino extends JFrame{
	private Access access;
	private Menu menu;	
	private Shop shop = new Shop();
	private Home home = new Home();
	private SlotMachine slotMachine = new SlotMachine();
	private CorsaCavalli corsaCavalli = new CorsaCavalli();
	private BlackJack blackJack = new BlackJack();
	
	public VirtualCasino() {
		super("Il Casino Virtuale");
		setSize(1300, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init();

		setVisible(true);
	}
	
	public void init() {
		// Aggiunta del pannello di login
		access = new Access(this);
		this.getContentPane().add(access);

		// Aggiunta del pannello di menu
		menu = new Menu(this);
		menu.setVisible(false);
		this.getContentPane().add(menu);

		// Aggiunta del pannello di home
		
		// Aggiunta dei pannelli
		//this.getContentPane().add(home);

		shop.setVisible(false);
		this.getContentPane().add(shop);

		slotMachine.setVisible(false);
		this.getContentPane().add(slotMachine);

		corsaCavalli.setVisible(false);
		this.getContentPane().add(corsaCavalli);

		blackJack.setVisible(false);
		this.getContentPane().add(blackJack);
	}

	public void login(){
		access.setVisible(false);
		menu.setVisible(true);
		home.setVisible(true);
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