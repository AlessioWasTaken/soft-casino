package slotMachine;

import javax.swing.*;
import javax.swing.border.LineBorder;

import standard.RoundedButton;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SlotMachine extends JPanel{
    private JPanel box = new JPanel();
    private RoundedButton gioca = new RoundedButton("Gioca");
    private JTextField puntata = new JTextField("Inserisci la puntata");
    private JLabel saldo = new JLabel("Saldo: ");
    
    public SlotMachine(){
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
        gioca.setBounds(50, 680, 330, 50);
        gioca.setBackground(new Color(217, 217, 217));
        gioca.setForeground(Color.black);
        gioca.setBorder(null);
        gioca.setFocusPainted(false);
        gioca.setFont(new Font("Arial", Font.PLAIN, 20));
        add(gioca);

        //Style puntata text field
        puntata.setBounds(400, 680, 370, 50);
        puntata.setForeground(Color.black);
        puntata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        puntata.setFont(new Font("Arial", Font.PLAIN, 20));
        add(puntata);

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
