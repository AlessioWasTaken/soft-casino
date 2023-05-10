package corsaCavalli;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.MatteBorder;

// Local imports
import backend.corsaCavalli.*;;

public class CorsaCavalli extends JPanel{
    // Deve essere pubblico per poter essere utilizzato da altre classi dopo
    // l'istanziazione
    public JLabel saldo;

    // Usata dagli altri per leggere il saldo e aggiornarlo
    public String[] userData;


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
        saldo = new JLabel("Saldo: 1000");
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
        bottone.addActionListener(e ->{
            Pista pista = new Pista();

            JPanel p1 = new JPanel();
            p1.setBackground(new Color(21, 25, 28));
            p1.setLayout(null);
            p1.setBounds(0, 0, 1300, 120);
            p1.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p1.add(pista.getCavallo().get(0));
            gameArea.add(p1);

            JPanel p2 = new JPanel();
            p2.setBackground(new Color(21, 25, 28));
            p2.setLayout(null);
            p2.setBounds(0, 120, 1300, 120);
            p2.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p2.add(pista.getCavallo().get(1));
            gameArea.add(p2);

            JPanel p3 = new JPanel();
            p3.setBackground(new Color(21, 25, 28));
            p3.setLayout(null);
            p3.setBounds(0, 240, 1300, 120);
            p3.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p3.add(pista.getCavallo().get(2));
            gameArea.add(p3);
            
            JPanel p4 = new JPanel();
            p4.setBackground(new Color(21, 25, 28));
            p4.setLayout(null);
            p4.setBounds(0, 360, 1300, 120);
            p4.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p4.add(pista.getCavallo().get(3));
            gameArea.add(p4);
            
            JPanel p5 = new JPanel();
            p5.setBackground(new Color(21, 25, 28));
            p5.setLayout(null);
            p5.setBounds(0, 480, 1300, 120);
            p5.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p5.add(pista.getCavallo().get(4));
            p5.revalidate();
            p5.repaint();
            gameArea.add(p5);


            pista.start();

            gameArea.revalidate();
            gameArea.repaint();
        });
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