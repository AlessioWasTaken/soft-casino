package corsaCavalli;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.MatteBorder;

// Local imports
import backend.corsaCavalli.*;
import backend.json.JsonEdit;

public class CorsaCavalli extends JPanel{
    // Deve essere pubblico per poter essere utilizzato da altre classi dopo
    // l'istanziazione
    public JLabel saldo;

    // Usata dagli altri per leggere il saldo e aggiornarlo
    public String[] userData;

    JComboBox<String> numeroCavalli, puntata;
    JButton bottone;
    JPanel p1, p2, p3, p4, p5;

    Timer timerVincita;
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
        puntata = new JComboBox<String>();
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
        puntata.addItem("5000");
        puntata.addItem("10000");
        puntata.addItem("25000");
        puntata.addItem("50000");
        puntata.addItem("100000");
        add(puntata);

        // Game area - Bottone
        bottone = new JButton("Gioca");
        bottone.setBounds(320, 630, 200, 50);
        bottone.setFont(new Font("Arial", Font.PLAIN, 20));
        bottone.setForeground(Color.WHITE);
        bottone.setBackground(new Color(21, 25, 28));
        bottone.setFocusPainted(false);
        bottone.setBorder(null);
        bottone.addActionListener(e ->{
            if (puntata.getSelectedItem().toString().equals("0")) {
                JOptionPane.showMessageDialog(this, "Seleziona una puntata", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (JsonEdit.readSaldo(userData[0], userData[1]) == 0) {
                    JOptionPane.showMessageDialog(this, "Non hai abbastanza soldi", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (JsonEdit.readSaldo(userData[0], userData[1]) < Double
                            .parseDouble(puntata.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(this, "Non hai abbastanza soldi", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        enable();
                        Pista pista = new Pista();
                        if(FirstGame==true){
                            FirstGame=false;
                        }else{
                            remove();
                        }
                        
                        JLabel Number1=new JLabel("1");
                        Number1.setBounds(0, 50, 10, 10);
                        Number1.setFont(new Font("Arial", Font.PLAIN, 15));
                        Number1.setForeground(Color.WHITE);
                        JPanel Border1=new JPanel();
                        Border1.setBounds(850, 0, 1, 120);
                        Border1.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p1 = new JPanel();
                        p1.setBackground(new Color(21, 25, 28));
                        p1.setLayout(null);
                        p1.setBounds(0, 0, 1200, 120);
                        p1.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p1.add(pista.getCavallo().get(0));
                        p1.add(Border1);
                        p1.add(Number1);
                        gameArea.add(p1);
            

                        JLabel Number2=new JLabel("2");
                        Number2.setBounds(0, 50, 10, 10);
                        Number2.setFont(new Font("Arial", Font.PLAIN, 15));
                        Number2.setForeground(Color.WHITE);
                        JPanel Border2=new JPanel();
                        Border2.setBounds(850, 0, 1, 120);
                        Border2.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p2 = new JPanel();
                        p2.setBackground(new Color(21, 25, 28));
                        p2.setLayout(null);
                        p2.setBounds(0, 120, 1200, 120);
                        p2.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p2.add(pista.getCavallo().get(1));
                        p2.add(Border2);
                        p2.add(Number2);
                        gameArea.add(p2);
            

                        JLabel Number3=new JLabel("3");
                        Number3.setBounds(0, 50, 10, 10);
                        Number3.setFont(new Font("Arial", Font.PLAIN, 15));
                        Number3.setForeground(Color.WHITE);
                        JPanel Border3=new JPanel();
                        Border3.setBounds(850, 0, 1, 120);
                        Border3.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p3 = new JPanel();
                        p3.setBackground(new Color(21, 25, 28));
                        p3.setLayout(null);
                        p3.setBounds(0, 240, 1200, 120);
                        p3.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p3.add(pista.getCavallo().get(2));
                        p3.add(Border3);
                        p3.add(Number3);
                        gameArea.add(p3);
                        

                        JLabel Number4=new JLabel("4");
                        Number4.setBounds(0, 50, 10, 10);
                        Number4.setFont(new Font("Arial", Font.PLAIN, 15));
                        Number4.setForeground(Color.WHITE);
                        JPanel Border4=new JPanel();
                        Border4.setBounds(850, 0, 1, 120);
                        Border4.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p4 = new JPanel();
                        p4.setBackground(new Color(21, 25, 28));
                        p4.setLayout(null);
                        p4.setBounds(0, 360, 1200, 120);
                        p4.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p4.add(pista.getCavallo().get(3));
                        p4.add(Border4);
                        p4.add(Number4);
                        gameArea.add(p4);
                        

                        JLabel Number5=new JLabel("5");
                        Number5.setBounds(0, 50, 10, 10);
                        Number5.setFont(new Font("Arial", Font.PLAIN, 15));
                        Number5.setForeground(Color.WHITE);
                        JPanel Border5=new JPanel();
                        Border5.setBounds(850, 0, 1, 120);
                        Border5.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p5 = new JPanel();
                        p5.setBackground(new Color(21, 25, 28));
                        p5.setLayout(null);
                        p5.setBounds(0, 480, 1200, 120);
                        p5.setBorder(new MatteBorder(new Insets(0, 0, 2, 2), Color.white));
                        p5.add(pista.getCavallo().get(4));
                        p5.add(Border5);
                        p5.add(Number5);
                        gameArea.add(p5);
                        pista.start();
            
                        timerVincita = new Timer(5000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int win=Integer.parseInt(puntata.getSelectedItem().toString());;
                                if(pista.Win().equals(numeroCavalli.getSelectedItem())){
                                    win= win*1;
                                }
                                else{
                                    win=win*-1;
                                }
                                if (win > 0) {
                                    JOptionPane.showMessageDialog(null, "Hai vinto, " + win + " Monete", "The Winner is Horse "+pista.Win(), JOptionPane.INFORMATION_MESSAGE);
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Hai perso, " + win + " Monete", "The Winner is Horse "+pista.Win(), JOptionPane.INFORMATION_MESSAGE);
                                }
                                Double saldoReaded = JsonEdit.readSaldo(userData[0], userData[1]);
                                saldoReaded += win;
                                JsonEdit.writeSaldo(userData[0], userData[1], saldoReaded);
                                saldo.setText("Saldo: " + saldoReaded + " FishCoin");
                                enable();
                                timerVincita.stop();
                            }
                        });
                        
                        timerVincita.start();
                        gameArea.revalidate();
                        gameArea.repaint();
                    }
                }
            }
        });
        add(bottone);

        // Game area - Numero cavalli
        numeroCavalli = new JComboBox<String>();
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
    public void enable() {
        if (bottone.isEnabled()) {
            bottone.setEnabled(false);
            puntata.setEnabled(false);
            numeroCavalli.setEnabled(false);
        } else {
            bottone.setEnabled(true);
            puntata.setEnabled(true);
            numeroCavalli.setEnabled(true);
        }
    }
}