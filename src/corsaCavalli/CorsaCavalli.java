package corsaCavalli;

import java.awt.Component;
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

    JPanel p1, p2, p3, p4, p5;

    private boolean FirstGame=true;


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
            if(FirstGame==true){
                FirstGame=false;
            }else{
                remove();
            }

            JPanel Border1=new JPanel();
            Border1.setBounds(858, 0, 1, 120);
            Border1.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p1 = new JPanel();
            p1.setBackground(new Color(21, 25, 28));
            p1.setLayout(null);
            p1.setBounds(0, 0, 1200, 120);
            p1.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p1.add(pista.getCavallo().get(0));
            p1.add(Border1);
            gameArea.add(p1);

            JPanel Border2=new JPanel();
            Border2.setBounds(858, 0, 1, 120);
            Border2.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p2 = new JPanel();
            p2.setBackground(new Color(21, 25, 28));
            p2.setLayout(null);
            p2.setBounds(0, 120, 1200, 120);
            p2.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p2.add(pista.getCavallo().get(1));
            p2.add(Border2);
            gameArea.add(p2);

            JPanel Border3=new JPanel();
            Border3.setBounds(858, 0, 1, 120);
            Border3.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p3 = new JPanel();
            p3.setBackground(new Color(21, 25, 28));
            p3.setLayout(null);
            p3.setBounds(0, 240, 1200, 120);
            p3.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p3.add(pista.getCavallo().get(2));
            p3.add(Border3);
            gameArea.add(p3);
            
            JPanel Border4=new JPanel();
            Border4.setBounds(858, 0, 1, 120);
            Border4.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p4 = new JPanel();
            p4.setBackground(new Color(21, 25, 28));
            p4.setLayout(null);
            p4.setBounds(0, 360, 1200, 120);
            p4.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p4.add(pista.getCavallo().get(3));
            p4.add(Border4);
            gameArea.add(p4);
            
            JPanel Border5=new JPanel();
            Border5.setBounds(858, 0, 1, 120);
            Border5.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p5 = new JPanel();
            p5.setBackground(new Color(21, 25, 28));
            p5.setLayout(null);
            p5.setBounds(0, 480, 1200, 120);
            p5.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
            p5.add(pista.getCavallo().get(4));
            p5.add(Border5);
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
        numeroCavalli.addItem("1");
        numeroCavalli.addItem("2");
        numeroCavalli.addItem("3");
        numeroCavalli.addItem("4");
        numeroCavalli.addItem("5");
        add(numeroCavalli);
    }

    public void remove() {
        Component[] components = p1.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p1.remove(component);
                p1.repaint();
                p1.revalidate();
            }
        }

        components = p2.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p2.remove(component);
                p2.repaint();
                p2.revalidate();
            }
        }

        components = p3.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p3.remove(component);
                p3.repaint();
                p3.revalidate();
            }
        }
        components = p3.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p3.remove(component);
                p3.repaint();
                p3.revalidate();
            }
        }
        components = p3.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p3.remove(component);
                p3.repaint();
                p3.revalidate();
            }
        }

        components = p4.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p4.remove(component);
                p4.repaint();
                p4.revalidate();
            }
        }

        components = p5.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                p5.remove(component);
                p5.repaint();
                p5.revalidate();
            }
        }
    }
}