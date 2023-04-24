package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Tester.*;
import standard.RoundedButton;

public class Menu extends JPanel{
    private VirtualCasino istanza;
    private JButton shop;
    private JButton slotMachine;
    private JButton corsaCavalli;
    private JButton blackJack;
    private JLabel user;
    private JButton logout;

    public Menu(VirtualCasino istanza) {
        this.istanza = istanza;
        setSize(250, 900);
        setLayout(null);
        setBackground(new Color(52, 53 , 53));

        inizializza();
    }

    public void inizializza(){
        // Style shop button
        shop = new JButton("Store");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/store.png"));
            shop.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        shop.setContentAreaFilled(false);
        shop.setBounds(20, 250, 110, 50);
        shop.setForeground(Color.white);
        shop.setBorder(null);
        shop.setFocusPainted(false);
        shop.setFont(new Font("Arial", Font.PLAIN, 20));
        add(shop);

        // Style slot machine button
        slotMachine = new JButton("Slot Machine");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/money.png"));
            slotMachine.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        slotMachine.setBounds(20, 320, 170, 50);
        slotMachine.setForeground(Color.white);
        slotMachine.setBorder(null);
        slotMachine.setContentAreaFilled(false);
        slotMachine.setFocusPainted(false);
        slotMachine.setFont(new Font("Arial", Font.PLAIN, 20));
        add(slotMachine);

        // Style corsa cavalli button
        corsaCavalli = new JButton("Corsa Cavalli");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/horse.png"));
            corsaCavalli.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        corsaCavalli.setBounds(20, 380, 175, 50);
        corsaCavalli.setForeground(Color.white);
        corsaCavalli.setBorder(null);
        corsaCavalli.setContentAreaFilled(false);
        corsaCavalli.setFocusPainted(false);
        corsaCavalli.setFont(new Font("Arial", Font.PLAIN, 20));
        add(corsaCavalli);

        // Style black jack button
        blackJack = new JButton("Black Jack");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/circle.png"));
            blackJack.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        blackJack.setBounds(20, 440, 156, 50);
        blackJack.setForeground(Color.white);
        blackJack.setContentAreaFilled(false);
        blackJack.setBorder(null);
        blackJack.setFocusPainted(false);
        blackJack.setFont(new Font("Arial", Font.PLAIN, 20));
        add(blackJack);

        // Style user label
        user = new JLabel("Alessio Sarica");
        user.setBounds(70, 90, 200, 50);
        user.setForeground(Color.white);
        user.setFont(new Font("Arial", Font.PLAIN, 18));
        add(user);

        // Style logout button
        logout = new RoundedButton("Logout");
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/logout.png"));
            logout.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        logout.setBounds(20, 650, 180, 50);
        logout.setForeground(Color.white);
        logout.setContentAreaFilled(false);
        logout.setBorder(null);
        logout.setFocusPainted(false);
        logout.setFont(new Font("Arial", Font.PLAIN, 20));
        add(logout);

        // Action listener
        shop.addActionListener(e -> {
            istanza.setShop();
        });

        slotMachine.addActionListener(e -> {
            istanza.setSlotMachine();
        });

        corsaCavalli.addActionListener(e -> {
            istanza.setCorsaCavalli();
        });

        blackJack.addActionListener(e -> {
            istanza.setBlackJack();
        });
    }
}