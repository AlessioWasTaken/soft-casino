package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import Tester.*;
import standard.RoundedButton;

public class Menu extends JPanel{
    private VirtualCasino istanza;

    RoundedButton home = new RoundedButton("Home");
    RoundedButton shop = new RoundedButton("Shop");
    RoundedButton slotMachine = new RoundedButton("Slot Machine");
    RoundedButton corsaCavalli = new RoundedButton("Corsa Cavalli");
    RoundedButton blackJack = new RoundedButton("Black Jack");

    JLabel sectionGiochi = new JLabel("Giochi");


    public Menu(VirtualCasino istanza) {
        this.istanza = istanza;
        setSize(300, 900);
        setLayout(null);
        setBackground(new Color(52, 53 , 53));

        inizializza();
    }

    public void inizializza(){
        //Style home button
        home.setBounds(20, 50, 250, 50);
        home.setBackground(new Color(217, 217 , 217));
        home.setForeground(Color.black);
        home.setBorder(null);
        home.setFocusPainted(false);
        home.setFont(new Font("Arial", Font.PLAIN, 20));
        add(home);

        // Style shop button
        shop.setBounds(20, 120, 250, 50);
        shop.setBackground(new Color(217, 217 , 217));
        shop.setForeground(Color.black);
        shop.setBorder(null);
        shop.setFocusPainted(false);
        shop.setFont(new Font("Arial", Font.PLAIN, 20));
        add(shop);

        // Style section giochi
        sectionGiochi.setBounds(20, 290, 250, 50);
        sectionGiochi.setForeground(Color.white);
        sectionGiochi.setBorder(null);
        sectionGiochi.setFont(new Font("Arial", Font.BOLD, 20));
        add(sectionGiochi);

        // Style slot machine button
        slotMachine.setBounds(20, 340, 250, 50);
        slotMachine.setBackground(new Color(217, 217 , 217));
        slotMachine.setForeground(Color.black);
        slotMachine.setBorder(null);
        slotMachine.setFocusPainted(false);
        slotMachine.setFont(new Font("Arial", Font.PLAIN, 20));
        add(slotMachine);

        // Style corsa cavalli button
        corsaCavalli.setBounds(20, 410, 250, 50);
        corsaCavalli.setBackground(new Color(217, 217 , 217));
        corsaCavalli.setForeground(Color.black);
        corsaCavalli.setBorder(null);
        corsaCavalli.setFocusPainted(false);
        corsaCavalli.setFont(new Font("Arial", Font.PLAIN, 20));
        add(corsaCavalli);

        // Style black jack button
        blackJack.setBounds(20, 480, 250, 50);
        blackJack.setBackground(new Color(217, 217 , 217));
        blackJack.setForeground(Color.black);
        blackJack.setBorder(null);
        blackJack.setFocusPainted(false);
        blackJack.setFont(new Font("Arial", Font.PLAIN, 20));
        add(blackJack);

        // Action listener
        home.addActionListener(e -> {
            istanza.setHome();
        });

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