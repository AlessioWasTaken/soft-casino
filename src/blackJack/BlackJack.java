package blackJack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import backend.blackjack.*;;

public class BlackJack extends JPanel{
    private String inputButton = "";
    private Table table;
    private JPanel player;
    private JPanel dealer;
    private int ContaPlayer, ContaDealer;
    private JButton bottone, hit, stand, doubleButton;
    
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
            if(puntata.getSelectedIndex() == 0){
              System.out.println("Seleziona la puntata");
            }else{
                table = new Table(Integer.parseInt(puntata.getSelectedItem().toString()));
                table.deal();

                enable(true);
                
                // @audit-info : ContaPlayer e ContaDealer sono inutili perche non vengono mai usati
                ContaDealer=2;
                ContaPlayer=2;

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
        
                for(int i = 0; i<table.getDealerCard().size(); i++){
                    dealer.add(table.getDealerCard().get(i));
                }
                for(int i = 0; i<table.getPlayerCard().size(); i++){
                    player.add(table.getPlayerCard().get(i));
                }

                gameArea.revalidate();

                if(table.getDealerValue()==21 || table.getPlayerValue()==21){
                    table.win();
                    enable(false);
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
            if(win!=69420){
                //aggiungere metodo per modificare il saldo
                enable(false);
            }
            gameArea.revalidate();
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
            while(table.getDealerValue()<17){
                int win=table.hitDealer();
                dealer.add(table.getPlayerCard().get(ContaDealer));
                ContaDealer++;
                if(win!=69420){
                    //aggiungere metodo per modificare il saldo
                    enable(false);
                }
                gameArea.revalidate();
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
            table.Double();
        });
        add(doubleButton);

        // Game area - Split
        JButton split = new JButton("Split");
        split.setBounds(740, 650, 200, 40);
        split.setFont(new Font("Arial", Font.PLAIN, 20));
        split.setForeground(Color.WHITE);
        split.setBackground(new Color(21, 25, 28));
        split.setFocusPainted(false);
        split.setBorder(null);
        add(split);

        enable(false);
    }

    public void enable(boolean A){
        hit.setEnabled(A);
        stand.setEnabled(A);
        doubleButton.setEnabled(A);
        if(A==false){
            bottone.setEnabled(true);
        }
        else{
            bottone.setEnabled(false);
        }
    }
}