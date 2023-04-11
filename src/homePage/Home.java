package homePage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import standard.RoundedButton;

public class Home extends JPanel{
    private JLabel welcome = new JLabel("Benvenuto " + "mario.rossi@gmail.com");
    private JLabel paymentMethod = new JLabel("Imposta il metodo di pagamento");
    private JTextField intestatario = new JTextField("Intestatario");
    private JTextField dataScadenza = new JTextField("Data Scadenza");
    private JTextField cvv = new JTextField("CVV");
    private JTextField numeroCarta = new JTextField("Numero Carta");
    private RoundedButton conferma = new RoundedButton("Conferma");
    private JLabel insertedPayment = new JLabel("Metodi di pagamento inseriti: ");

    public Home() {
        setSize(1300, 900);
        setLocation(300, 0);
        setLayout(null);
        setBackground(Color.white);

        inizializza();
    }

    private void inizializza() {
        //Style welcome label
        welcome.setBounds(50, 50, 700, 50);
        welcome.setFont(new Font("Arial", Font.BOLD, 25));
        add(welcome);

        //Style paymentMethod label
        paymentMethod.setBounds(50, 120, 500, 50);
        paymentMethod.setFont(new Font("Arial", Font.PLAIN, 20));
        add(paymentMethod);

        //Style intestatario textfield
        intestatario.setBounds(50, 200, 400, 50);
        intestatario.setFont(new Font("Arial", Font.PLAIN, 20));
        intestatario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(intestatario);

        //Style dataScadenza textfield
        dataScadenza.setBounds(600, 200, 400, 50);
        dataScadenza.setFont(new Font("Arial", Font.PLAIN, 20));
        dataScadenza.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(dataScadenza);

        //Style cvv textfield
        cvv.setBounds(50, 300, 400, 50);
        cvv.setFont(new Font("Arial", Font.PLAIN, 20));
        cvv.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(cvv);

        //Style numeroCarta textfield
        numeroCarta.setBounds(600, 300, 400, 50);
        numeroCarta.setFont(new Font("Arial", Font.PLAIN, 20));
        numeroCarta.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        add(numeroCarta);

        //Style conferma button
        conferma.setBounds(50, 400, 400, 50);
        conferma.setFont(new Font("Arial", Font.PLAIN, 20));
        conferma.setBackground(new Color(217, 217, 217));
        conferma.setBorder(null);
        add(conferma);

        //Style insertedPayment label
        insertedPayment.setBounds(50, 500, 500, 50);
        insertedPayment.setFont(new Font("Arial", Font.PLAIN, 20));
        add(insertedPayment);

        loadPaymentMethods();


        intestatario.addFocusListener(new FocusListener() {
    
            @Override
            public void focusGained(FocusEvent e) {
                if (intestatario.getText().equals("Intestatario")) {
                    intestatario.setText("");
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if (intestatario.getText().equals("")) {
                    intestatario.setText("Intestatario");
                }
            }
        });

        dataScadenza.addFocusListener(new FocusListener() {
    
            @Override
            public void focusGained(FocusEvent e) {
                if (dataScadenza.getText().equals("Data Scadenza")) {
                    dataScadenza.setText("");
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if (dataScadenza.getText().equals("")) {
                    dataScadenza.setText("Data Scadenza");
                }
            }
        });

        cvv.addFocusListener(new FocusListener() {
    
            @Override
            public void focusGained(FocusEvent e) {
                if (cvv.getText().equals("CVV")) {
                    cvv.setText("");
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if (cvv.getText().equals("")) {
                    cvv.setText("CVV");
                }
            }
        });

        numeroCarta.addFocusListener(new FocusListener() {
    
            @Override
            public void focusGained(FocusEvent e) {
                if (numeroCarta.getText().equals("Numero Carta")) {
                    numeroCarta.setText("");
                }
            }
    
            @Override
            public void focusLost(FocusEvent e) {
                if (numeroCarta.getText().equals("")) {
                    numeroCarta.setText("Numero Carta");
                }
            }
        });
    }

    public void loadPaymentMethods() {
        //TODO
    }

}
