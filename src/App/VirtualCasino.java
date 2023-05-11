package App;

import Menu.Menu;
import auth.Access;
import backend.json.JsonEdit;
import blackJack.BlackJack;
import corsaCavalli.CorsaCavalli;
import shopPage.Shop;
import slotMachine.SlotMachine;

import javax.swing.*;

/**
 * These projects simulate a Casino width 3 games
 * - Slot Machine
 * - Horse Run
 * - Black Jack
 * this file is Core of Virtual Casino.
 * It calls any part of casino and pass instance or data in to other component classes
 *
 * @author Alessio Sarica, Maurizio Napoli, Jiamin Miao, Cristian Stringari
 * <a href="https://github.com/AlessioDevv/Virtual-Casino">GitHub Code</a>
 * @version 1.0.0
 * @since 10-05-2023
 */
public class VirtualCasino extends JFrame {
    private final Access access = new Access(this);
    private final Menu menu = new Menu(this);
    private final Shop shop = new Shop();
    private final SlotMachine slotMachine = new SlotMachine();
    private final CorsaCavalli corsaCavalli = new CorsaCavalli();
    private final BlackJack blackJack = new BlackJack();
    private String isSelected = "";
    String[] userData;

    /**
     * This constructor creates a frame and setting a base option and delegate to style the method init()
     */
    public VirtualCasino() {
        super("The Virtual Casino");
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        init();

        setVisible(true);
    }

    /**
     * This method used automatically when you call a constructor.
     * The scope is generated any component of page Es. JLabel with style, Class Menu...
     */
    public void init() {
        // Settings of panels
        menu.setVisible(false);
        shop.setVisible(false);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(false);

        // Add panels to Frame
        this.getContentPane().add(access);
        this.getContentPane().add(menu);
        this.getContentPane().add(shop);
        this.getContentPane().add(slotMachine);
        this.getContentPane().add(corsaCavalli);
        this.getContentPane().add(blackJack);
    }

    /**
     * This method setting visible menu and hide component Access in auth
     */
    public void login() {
        access.setVisible(false);
        menu.setVisible(true);
        shop.setVisible(false);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(false);

    }

    /**
     * This method setting visible the component Access in auth and another component to hide
     */
    public void logout() {
        access.setVisible(true);
        menu.setVisible(false);
        shop.setVisible(false);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(false);
    }

    /**
     * This method setting visible the component Shop in shop and other components to hide
     * then setting the credit of user in a JLabel public with JSON Method passing user authentication
     */
    public void setShop() {
        isSelected = "shop";
        shop.setVisible(true);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(false);
        shop.saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
        shop.userData = userData;
    }

    /**
     * This method setting a visible Slot Machine component in slotMachine and other components to hide
     * Then setting credit of user in a JLabel public with JSON Method passing user authentication
     */
    public void setSlotMachine() {
        isSelected = "slotMachine";
        shop.setVisible(false);
        slotMachine.setVisible(true);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(false);
        slotMachine.saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
        slotMachine.userData = userData;
    }

    /**
     * This method setting visible the component CorsaCavalli in corsaCavalli and other to hide
     * Then set in a JLabel public the credit of user with JSON Method passing user authentication
     */
    public void setCorsaCavalli() {
        isSelected = "corsaCavalli";
        shop.setVisible(false);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(true);
        blackJack.setVisible(false);
        corsaCavalli.saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
        corsaCavalli.userData = userData;
    }

    /**
     * This method setting visible the BlackJack component in blackJack and another component to hide
     * Then set the coin of user to a public JLabel wit JSON Method passing user authentication
     */
    public void setBlackJack() {
        isSelected = "blackJack";
        shop.setVisible(false);
        slotMachine.setVisible(false);
        corsaCavalli.setVisible(false);
        blackJack.setVisible(true);
        blackJack.saldo.setText("Saldo: " + JsonEdit.readSaldo(userData[0], userData[1]) + " Fish");
        blackJack.userData = userData;
    }

    /**
     * This method return what component is selected
     *
     * @return string of name the component
     */
    public String getIsSelected() {
        return isSelected;
    }

    /**
     * This method called at login passing the email of user and repave full name used to authenticate of JSON Method
     *
     * @param email passing an email when user access to the app
     */
    public void setEmail(String email) {
        menu.user.setText(JsonEdit.getUser(email));
        userData = menu.user.getText().split(" ");
    }

    public static void main(String[] args) {
        new VirtualCasino();
    }
}