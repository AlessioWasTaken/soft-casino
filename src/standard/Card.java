package standard;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends RoundedPanel{
    // Formato data scadenda 12/2/23, CVV 123, Numero carta 1234 5678 9012 3456
    private JLabel nomeCognome;
    private JLabel endDate;
    private JLabel cvv;
    private JLabel numero;
    
    public Card(String nomeCognome, String endDate, String cvv, String numero) {
        setSize(350, 170);
        setLayout(null);
        setBackground(new Color(217, 217, 217));

        this.nomeCognome = new JLabel(nomeCognome);
        this.endDate = new JLabel(endDate);
        this.cvv = new JLabel(cvv);
        this.numero = new JLabel(numero);

        inizializza();
    }

    private void inizializza() {
        //Style nome/cognome
        nomeCognome.setBounds(30, 20, 350, 30);
        nomeCognome.setFont(new Font("Arial", Font.PLAIN, 20));
        add(nomeCognome);

        //Style data scadenza
        endDate.setBounds(30, 70, 100, 30);
        endDate.setFont(new Font("Arial", Font.PLAIN, 20));
        add(endDate);

        //Style cvv
        cvv.setBounds(160, 70, 100, 30);
        cvv.setFont(new Font("Arial", Font.PLAIN, 20));
        add(cvv);

        //Style numero carta
        numero.setBounds(30, 120, 350, 30);
        numero.setFont(new Font("Arial", Font.PLAIN, 20));
        add(numero);
    }
}
