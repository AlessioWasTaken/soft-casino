package shopPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import standard.RoundedButton;

public class Shop extends JPanel{
    JLabel welcome = new JLabel("Benevenuto " + "marco.rossi@gmail.com");
    JLabel paymentText = new JLabel("Metodi di Pagamento inseriti");
    JLabel fish = new JLabel(new ImageIcon("assets/Fish.jpg"));
    JTextField fishPrice = new JTextField("Inserire la quantita di fish da acquistare");
    RoundedButton buyFish = new RoundedButton("Acquista Ora");

    public Shop() {
        setSize(1300, 900);
        setLocation(300, 0);
        setLayout(null);
        setBackground(Color.white);

        inizializza();
    }

    private void inizializza() {
        //Style Welocme label
        welcome.setBounds(50, 50, 500, 50);
        welcome.setFont(new Font("Arial", Font.PLAIN, 20));
        add(welcome);

        //Style paymentText label
        paymentText.setBounds(700, 50, 500, 50);
        paymentText.setFont(new Font("Arial", Font.PLAIN, 20));
        add(paymentText);
        
        //Style fish image
        fish.setBounds(50, 150, 500, 500);
        add(fish);

        //Style fishPrice textfield
        fishPrice.setBounds(50, 750, 450, 50);
        fishPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        fishPrice.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(fishPrice);

        //Style buyFish button
        buyFish.setBounds(700, 750, 300, 50);
        buyFish.setBackground(new Color(217, 217, 217));
        buyFish.setFont(new Font("Arial", Font.PLAIN, 20));
        buyFish.setBorder(null);
        add(buyFish);


        fishPrice.addFocusListener(new FocusListener() {
    
            @Override
            public void focusGained(FocusEvent e) {
                if (fishPrice.getText().equals("Inserire la quantita di fish da acquistare")) {
                    fishPrice.setText("");
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if (fishPrice.getText().equals("")) {
                    fishPrice.setText("Inserire la quantita di fish da acquistare");
                }
            }
        });
    }

    public void loadPaymentMethods() {
        //TODO: Load payment methods
    }
}
