package slotMachine;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import backend.Slot.*;

public class SlotMachine extends JPanel{
    Logica Loser=new Logica();
    JPanel SlidingImage, SlidingImage2, SlidingImage3;
    JButton bottone;
    Timer timer;
    boolean first=true;
    Immagine [][] img;
    
    public SlotMachine() {
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
        
        JPanel Slot = new JPanel();
        Slot.setBounds(225, 0, 600, 575);
        gameArea.add(Slot);
        Slot.setLayout(new GridLayout(1, 3, 10, 10));
        
        JPanel Lane_1 = new JPanel();
        Lane_1.setBackground(new Color(128, 0, 0));
        Slot.add(Lane_1);
        Lane_1.setLayout(null);
        
        SlidingImage = new JPanel();
        SlidingImage.setBackground(new Color(0, 128, 255));
        SlidingImage.setBounds(10, -564, 173, 1128);
        Lane_1.add(SlidingImage);
        SlidingImage.setLayout(new GridLayout(6, 1, 10, 10));
        
        JPanel Lane_2 = new JPanel();
        Lane_2.setBackground(new Color(128, 0, 0));
        Slot.add(Lane_2);
        Lane_2.setLayout(null);
        
        SlidingImage2 = new JPanel();
        SlidingImage2.setBounds(10, -564, 173, 1128);
        Lane_2.add(SlidingImage2);
        SlidingImage2.setLayout(new GridLayout(6, 1, 10, 10));
        
        JPanel Lane_3 = new JPanel();
        Lane_3.setBackground(new Color(128, 0, 0));
        Slot.add(Lane_3);
        Lane_3.setLayout(null);
        
        SlidingImage3 = new JPanel();
        SlidingImage3.setBounds(10, -564, 173, 1128);
        Lane_3.add(SlidingImage3);
        SlidingImage3.setLayout(new GridLayout(6, 1, 10, 10));

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
        bottone = new JButton("Gioca");
        bottone.setBounds(320, 630, 200, 50);
        bottone.setFont(new Font("Arial", Font.PLAIN, 20));
        bottone.setForeground(Color.WHITE);
        bottone.setBackground(new Color(21, 25, 28));
        bottone.setFocusPainted(false);
        bottone.setBorder(null);
        add(bottone);
        bottone.addActionListener(e->{
            //quando ina la partità disabilita il pulsante
            enable();
        	SlidingImage.setLocation(SlidingImage.getX(), -564);
            SlidingImage2.setLocation(SlidingImage2.getX(), -564);
            SlidingImage3.setLocation(SlidingImage3.getX(), -564);
            if(first!=true){
                //rimuove le JLabel vecchie, se funziona.
                remove();
            }
            else{
                first=false;
            }
            Loser.Genera();
            Loser.setScommessa((int)Integer.parseInt(puntata.getSelectedItem().toString()));
            img=null;
            img=Loser.getNumeri();
            //aggiunge i componenti all'interno dei pannelli mobili
            Aggiunta();

        	timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //aggiorna la posizione dello slider 1
                	if(SlidingImage.getY()>=11){
                        SlidingImage.setLocation(SlidingImage.getX(), 11);
                    }
                	else {
                		SlidingImage.setLocation(SlidingImage.getX(), SlidingImage.getY()+10);
                	}
                	SlidingImage.repaint();
                    SlidingImage.revalidate();
                	
                	//aggiorna la posizione dello slider 2
                	if(SlidingImage2.getY()>=11){
                        SlidingImage2.setLocation(SlidingImage2.getX(), 11);
                    }
                	else {
                		SlidingImage2.setLocation(SlidingImage2.getX(), SlidingImage2.getY()+9);
                	}
                	SlidingImage2.repaint();
                    SlidingImage2.revalidate();
                	
                	//aggiorna la posizione dello slider 3
                	if(SlidingImage3.getY()>=11){
                        SlidingImage3.setLocation(SlidingImage3.getX(), 11);
                        timer.stop();
                    }
                	else {
                		SlidingImage3.setLocation(SlidingImage3.getX(), SlidingImage3.getY()+8);
                	}
                	SlidingImage3.repaint();
                    SlidingImage3.revalidate();                
                }
            });
            timer.start();
            
            //quando finisce la partità riabilita il pulsante
            int win=Loser.Win();
            if(win>0){
                JOptionPane.showMessageDialog(null, "Hai vinto "+win+" Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Hai perso "+win+" Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
            //TODO metodo che toglie/aggiunge al saldo
            
            enable();
        });
    }

    public void remove(){ 
        Component[] components = SlidingImage.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage.remove(component);
                SlidingImage.repaint();
                SlidingImage.revalidate();
            }
        }

        components=SlidingImage2.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage2.remove(component);
                SlidingImage2.repaint();
                SlidingImage2.revalidate();
            }
        }

        components=SlidingImage3.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage3.remove(component);
                SlidingImage3.repaint();
                SlidingImage3.revalidate();
            }
        }
    }

    public void Aggiunta(){
        for(int i=0;i<img.length;i++) {
            for(int j=0;j<img[i].length;j++){
                if(img[i][j]!=null){
                    switch(j+1){
                        case 1:
                            SlidingImage.add(img[i][j]);
                        break;

                        case 2:
                            SlidingImage2.add(img[i][j]);
                        break;

                        case 3:
                            SlidingImage3.add(img[i][j]);
                        break;
                    }
                }
                SlidingImage.repaint();
                SlidingImage2.repaint();
                SlidingImage3.repaint();
            }
        }
    }

    public void enable(){
        if(bottone.isEnabled()){
            bottone.setEnabled(false);
        }
        else{
            bottone.setEnabled(true);
        }
    }
}