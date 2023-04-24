package corsaCavalli;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class CorsaCavalli extends JPanel{
    
    public CorsaCavalli() {
        setSize(1300, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    private void init() {
        // Game area
        JPanel gameArea = new JPanel();
        gameArea.setBounds(0, 0, 1300, 600);
        gameArea.setLayout(null);
        gameArea.setBackground(new Color(21, 25, 28));
        add(gameArea);

        // Game area - Saldo
        JLabel saldo = new JLabel("Saldo: 1000");
        saldo.setBounds(20, 620, 200, 30);
        saldo.setFont(new Font("Arial", Font.PLAIN, 20));
        saldo.setForeground(Color.BLACK);
        add(saldo);

        // Game area - Puntata
        JComboBox<String> puntata = new JComboBox<String>();
        puntata.setBounds(20, 660, 200, 30);
        puntata.setFont(new Font("Arial", Font.PLAIN, 20));
        puntata.setForeground(Color.BLACK);
        puntata.addItem("10");
        puntata.addItem("20");
        puntata.addItem("50");
        puntata.addItem("100");
        puntata.addItem("200");
        puntata.addItem("500");
        puntata.addItem("1000");
        puntata.addItem("2000");
        add(puntata);

        // Game area - Bottone
        JButton bottone = new JButton("Gioca");
        bottone.setBounds(320, 630, 200, 50);
        bottone.setFont(new Font("Arial", Font.PLAIN, 20));
        bottone.setForeground(Color.WHITE);
        bottone.setBackground(new Color(21, 25, 28));
        bottone.setFocusPainted(false);
        bottone.setBorder(null);
        add(bottone);

        // Game area - Numero cavalli
        JComboBox<String> numeroCavalli = new JComboBox<String>();
        numeroCavalli.setBounds(540, 640, 200, 30);
        numeroCavalli.setFont(new Font("Arial", Font.PLAIN, 20));
        numeroCavalli.setForeground(Color.BLACK);
        numeroCavalli.addItem("2");
        numeroCavalli.addItem("3");
        numeroCavalli.addItem("4");
        numeroCavalli.addItem("5");
        numeroCavalli.addItem("6");
        numeroCavalli.addItem("7");
        add(numeroCavalli);
    }
}