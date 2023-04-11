package blackJack;

import javax.swing.*;
import javax.swing.border.LineBorder;

import standard.RoundedButton;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BlackJack extends JPanel{
    private JPanel box = new JPanel();
    private RoundedButton gioca = new RoundedButton("Gioca");
    private RoundedButton hit = new RoundedButton("Hit");
    private RoundedButton stand = new RoundedButton("Stand");
    private RoundedButton doppia = new RoundedButton("Doppia");
    private RoundedButton split = new RoundedButton("Split");

    private JTextField puntata = new JTextField("Inserisci la puntata");
    private JLabel saldo = new JLabel("Saldo: ");
    
    public BlackJack(){
        setSize(1300, 900);
        setLocation(300, 0);
        setLayout(null);
        setBackground(Color.white);

        inizializza();
    }

    private void inizializza() {
        //Style box
        box.setBounds(50, 20, 1130, 600);
        box.setBackground(new Color(217, 217, 217));
        box.setBorder(new LineBorder(Color.black, 2));
        add(box);

        //Style gioca button
        gioca.setBounds(50, 640, 330, 50);
        gioca.setBackground(new Color(217, 217, 217));
        gioca.setForeground(Color.black);
        gioca.setBorder(null);
        gioca.setFocusPainted(false);
        gioca.setFont(new Font("Arial", Font.PLAIN, 20));
        add(gioca);

        //Style hit button
        hit.setBounds(50, 710, 330, 50);
        hit.setBackground(new Color(217, 217, 217));
        hit.setForeground(Color.black);
        hit.setBorder(null);
        hit.setFocusPainted(false);
        hit.setFont(new Font("Arial", Font.PLAIN, 20));
        add(hit);

        //Style puntata text field
        puntata.setBounds(420, 640, 370, 50);
        puntata.setForeground(Color.black);
        puntata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        puntata.setFont(new Font("Arial", Font.PLAIN, 20));
        add(puntata);

        //Style stand button
        stand.setBounds(420, 710, 300, 50);
        stand.setBackground(new Color(217, 217, 217));
        stand.setForeground(Color.black);
        stand.setBorder(null);
        stand.setFocusPainted(false);
        stand.setFont(new Font("Arial", Font.PLAIN, 20));
        add(stand);

        //Style doppia button
        doppia.setBounds(848, 640, 330, 50);
        doppia.setBackground(new Color(217, 217, 217));
        doppia.setForeground(Color.black);
        doppia.setBorder(null);
        doppia.setFocusPainted(false);
        doppia.setFont(new Font("Arial", Font.PLAIN, 20));
        add(doppia);

        //Style split button
        split.setBounds(848, 710, 330, 50);
        split.setBackground(new Color(217, 217, 217));
        split.setForeground(Color.black);
        split.setBorder(null);
        split.setFocusPainted(false);
        split.setFont(new Font("Arial", Font.PLAIN, 20));
        add(split);

        //Style saldo label
        saldo.setBounds(1090, 780, 330, 20);
        saldo.setForeground(Color.black);
        saldo.setFont(new Font("Arial", Font.PLAIN, 15));
        add(saldo);


        //Focus Listener
        puntata.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (puntata.getText().equals("Inserisci la puntata")) {
					puntata.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (puntata.getText().equals("")) {
					puntata.setText("Inserisci la puntata");
				}
			}
		});
    }
}
