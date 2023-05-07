package blackJack;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import backend.blackjack.*;
import backend.json.JsonEdit;

public class BlackJack extends JPanel{
    private String inputButton = "";
    private Table table;
    private JPanel player;
    private JPanel dealer;
    JComboBox<String> puntata;
    private int ContaPlayer, ContaDealer;
    private JButton bottone, hit, stand, doubleButton, forfeit;

    private boolean firstGame=true;

    // Deve essere pubblico per poter essere utilizzato da altre classi dopo
    // l'istanziazione
    public JLabel saldo;

    // Usata dagli altri per leggere il saldo e aggiornarlo
    public String[] userData;
    
    public BlackJack() {
        setSize(1050, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    private void init() {
        // Game area
        JPanel gameArea = new JPanel();
        gameArea.setBounds(0, 0, 1050, 600);
        gameArea.setLayout(null);
        gameArea.setBackground(new Color(21, 25, 28));
        add(gameArea);

        dealer = new JPanel();
        dealer.setBounds(96, 147, 828, 140);
        dealer.setBackground(new Color(21, 25, 28));
        gameArea.add(dealer);
        dealer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        player = new JPanel();
        player.setBounds(96, 377, 828, 140);
        player.setBackground(new Color(21, 25, 28));
        gameArea.add(player);
        player.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

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
        puntata.addItem("0");
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
        bottone = new JButton("Gioca");
        bottone.setBounds(320, 630, 200, 50);
        bottone.setFont(new Font("Arial", Font.PLAIN, 20));
        bottone.setForeground(Color.WHITE);
        bottone.setBackground(new Color(21, 25, 28));
        bottone.setFocusPainted(false);
        bottone.setBorder(null);
        bottone.addActionListener(e ->{
            if (puntata.getSelectedItem().toString().equals("0")) {
                JOptionPane.showMessageDialog(gameArea, "Seleziona una puntata", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (JsonEdit.readSaldo(userData[0], userData[1]) == 0) {
                    JOptionPane.showMessageDialog(gameArea, "Non hai abbastanza soldi", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (JsonEdit.readSaldo(userData[0], userData[1]) < Double
                            .parseDouble(puntata.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(gameArea, "Non hai abbastanza soldi", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (firstGame != true) {
                            // rimuove le JLabel vecchie, se funziona.
                            remove();
                        }else {
                            firstGame = false;
                        }
    
                        table = new Table(Integer.parseInt(puntata.getSelectedItem().toString()));
                        table.deal();
    
                        enable(true);
                        
                        ContaDealer=2;
                        ContaPlayer=2;
                
                        for(int i = 0; i<table.getDealerCard().size(); i++){
                            dealer.add(table.getDealerCard().get(i));
                            dealer.repaint();
                            dealer.revalidate();
                        }
                        for(int i = 0; i<table.getPlayerCard().size(); i++){
                            player.add(table.getPlayerCard().get(i));
                            player.repaint();
                            player.revalidate();
                        }
    
                        gameArea.repaint();
                        gameArea.revalidate();
    
                        if(table.getDealerValue()==21 || table.getPlayerValue()==21){
                            result(table.win());
                            enable(false);
                        }
                    }
                }
            }
        });
        add(bottone);

        // Game area - Hit
        hit = new JButton("Hit");
        hit.setBounds(540, 610, 200, 40);
        hit.setFont(new Font("Arial", Font.PLAIN, 20));
        hit.setForeground(Color.WHITE);
        hit.setBackground(new Color(21, 25, 28));
        hit.setFocusPainted(false);
        hit.setBorder(null);
        hit.addActionListener(e ->{
            int win=table.hitPlayer();
            player.add(table.getPlayerCard().get(ContaPlayer));
            ContaPlayer++;
            player.repaint();
            player.revalidate();
            if(win!=69420 && table.getPlayerValue()>=21){
                result(win);
                enable(false);
            }
        });
        add(hit);

        // Game area - Stand
        stand = new JButton("Stand");
        stand.setBounds(540, 650, 200, 40);
        stand.setFont(new Font("Arial", Font.PLAIN, 20));
        stand.setForeground(Color.WHITE);
        stand.setBackground(new Color(21, 25, 28));
        stand.setFocusPainted(false);
        stand.setBorder(null);
        stand.addActionListener(e ->{
            table.stand();
            int win;
            while(table.getDealerValue()<17){
                if(table.getDealerValue()>table.getPlayerValue()){
                    break;
                }
                win=table.hitDealer();
                dealer.add(table.getDealerCard().get(ContaDealer));
                ContaDealer++;
                dealer.repaint();
                dealer.revalidate();
            }
            table.setDealerTurn(false);
            win=table.win();
            if(win!=69420){
                result(win);
                enable(false);
            }
        });
        add(stand);

        // Game area - Double
        doubleButton = new JButton("Double");
        doubleButton.setBounds(740, 610, 200, 40);
        doubleButton.setFont(new Font("Arial", Font.PLAIN, 20));
        doubleButton.setForeground(Color.WHITE);
        doubleButton.setBackground(new Color(21, 25, 28));
        doubleButton.setFocusPainted(false);
        doubleButton.setBorder(null);
        doubleButton.addActionListener(e ->{
            Double saldoReaded = JsonEdit.readSaldo(userData[0], userData[1]);
            if(saldoReaded<table.getbet()*2){
                JOptionPane.showMessageDialog(gameArea, "Non hai abbastanza soldi", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int win=table.Double();
                player.add(table.getPlayerCard().get(ContaPlayer));
                ContaPlayer++;
                player.repaint();
                player.revalidate();
                if(win!=69420 && table.getPlayerValue()>=21){
                    result(win);
                    enable(false);
                }
                hit.setEnabled(false);
                doubleButton.setEnabled(false);
            }
        });
        add(doubleButton);

        // Game area - Split
        forfeit = new JButton("Forfeit");
        forfeit.setBounds(740, 650, 200, 40);
        forfeit.setFont(new Font("Arial", Font.PLAIN, 20));
        forfeit.setForeground(Color.WHITE);
        forfeit.setBackground(new Color(21, 25, 28));
        forfeit.setFocusPainted(false);
        forfeit.setBorder(null);
        add(forfeit);
        forfeit.addActionListener(e ->{
            int win=table.forfeit();

            JOptionPane.showMessageDialog(null, "Hai concesso la partita, " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
            Double saldoReaded = JsonEdit.readSaldo(userData[0], userData[1]);
            saldoReaded += win;
            JsonEdit.writeSaldo(userData[0], userData[1], saldoReaded);
            saldo.setText("Saldo: " + saldoReaded);
            enable(false);
        });

        enable(false);
    }

    public void enable(boolean A){
        hit.setEnabled(A);
        stand.setEnabled(A);
        doubleButton.setEnabled(A);
        forfeit.setEnabled(A);
        if(A==false){
            bottone.setEnabled(true);
        }
        else{
            bottone.setEnabled(false);
        }
    }

    public void remove(){
        Component[] components = player.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                player.remove(component);
                player.repaint();
                player.revalidate();
            }
        }

        components = dealer.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                dealer.remove(component);
                dealer.repaint();
                dealer.revalidate();
            }
        }
    }

    public void result(int win){
        if(win==0){
            JOptionPane.showMessageDialog(null, "Hai Pareggiato","Result", JOptionPane.INFORMATION_MESSAGE);
        }else if (win > 0) {
            JOptionPane.showMessageDialog(null, "Hai vinto " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(null, "Hai perso " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        Double saldoReaded = JsonEdit.readSaldo(userData[0], userData[1]);
        saldoReaded += win;
        JsonEdit.writeSaldo(userData[0], userData[1], saldoReaded);
        saldo.setText("Saldo: " + saldoReaded);
    }
}