package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Local imports
import Tester.*;

public class Menu extends JPanel{
    private VirtualCasino istanza;
    private JButton blackJack;
    private JButton logout;

    public Menu(VirtualCasino istanza) {
        this.istanza = istanza;
        setSize(250, 900);
        setLayout(null);
        setBackground(new Color(34, 40 , 44));

        init();
    }

    public void init(){
        // Logo
        JLabel logo = new JLabel();
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/logo.png")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            logo.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        logo.setBounds(20, 20, 200, 200);
        add(logo);

        // User
        JLabel user = new JLabel("Alessio Sarica");
        user.setBounds(20, 200, 200, 50);
        user.setForeground(Color.white);
        user.setFont(new Font("Arial", Font.PLAIN, 18));
        user.setHorizontalAlignment(JLabel.CENTER);
        add(user);

        // Shop button
        JButton shop = new JButton("Shop");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/shop.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            shop.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        shop.setBounds(20, 260, 170, 50);
        shop.setForeground(Color.white);
        shop.setBorder(null);
        shop.setContentAreaFilled(false);
        shop.setFocusPainted(false);
        shop.setFont(new Font("Arial", Font.PLAIN, 18));
        shop.setHorizontalAlignment(JLabel.LEFT);
        add(shop);

        // Slot machine button
        JButton slotMachine = new JButton("Slot Machine");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/slot-machine.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            slotMachine.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        slotMachine.setBounds(20, 320, 170, 50);
        slotMachine.setForeground(Color.white);
        slotMachine.setBorder(null);
        slotMachine.setContentAreaFilled(false);
        slotMachine.setFocusPainted(false);
        slotMachine.setFont(new Font("Arial", Font.PLAIN, 18));
        slotMachine.setHorizontalAlignment(JLabel.LEFT);
        add(slotMachine);

        // Corsa cavalli button
        JButton corsaCavalli = new JButton("Corsa Cavalli");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/corsa-cavalli.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            corsaCavalli.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        corsaCavalli.setBounds(20, 380, 170, 50);
        corsaCavalli.setForeground(Color.white);
        corsaCavalli.setBorder(null);
        corsaCavalli.setContentAreaFilled(false);
        corsaCavalli.setFocusPainted(false);
        corsaCavalli.setFont(new Font("Arial", Font.PLAIN, 18));
        corsaCavalli.setHorizontalAlignment(JLabel.LEFT);
        add(corsaCavalli);

        // Black Jack button
        blackJack = new JButton("Black Jack");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/blackjack.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            blackJack.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        blackJack.setBounds(20, 440, 170, 50);
        blackJack.setForeground(Color.white);
        blackJack.setBorder(null);
        blackJack.setContentAreaFilled(false);
        blackJack.setFocusPainted(false);
        blackJack.setFont(new Font("Arial", Font.PLAIN, 18));
        blackJack.setHorizontalAlignment(JLabel.LEFT);
        add(blackJack);

        // Logout button
        logout = new JButton("Logout");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/logout.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            logout.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        logout.setBounds(20, 500, 170, 50);
        logout.setForeground(Color.white);
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setFocusPainted(false);
        logout.setFont(new Font("Arial", Font.PLAIN, 18));
        logout.setHorizontalAlignment(JLabel.LEFT);
        add(logout);

        // Action listener
        shop.addActionListener(e -> {
            istanza.setShop();
        });

        slotMachine.addActionListener(e -> {
            istanza.setSlotMachine();
        });

    
    }
}