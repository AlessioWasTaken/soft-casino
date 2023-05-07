package slotMachine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import Menu.Menu;
import backend.Slot.Immagine;
import backend.Slot.Logica;
import backend.json.JsonEdit;

public class SlotMachine extends JPanel {
    private Menu istanzaMenu;
    // Deve essere pubblico per poter essere utilizzato da altre classi dopo
    // l'istanziazione
    public JLabel saldo;

    // Usata dagli altri per leggere il saldo e aggiornarlo
    public String[] userData;

    // Logica delle slot
    private Logica logica = new Logica();

    // Pannelli per le immagini
    private JPanel SlidingImage, SlidingImage2, SlidingImage3;

    // Bottone per giocare
    private JButton bottone;

    // Box con le varie puntate
    JComboBox<String> puntata;

    // Timer per le animazioni e per la vincita
    private Timer timer, timerVincita;

    // Array di immagini
    private Immagine[][] img;

    private boolean firstGame = true;

    public SlotMachine(Menu istanzaMenu) {
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

        // Game area - Slot
        JPanel Slot = new JPanel();
        Slot.setBackground(new Color(21, 25, 28));
        Slot.setBounds(225, 10, 600, 584);
        gameArea.add(Slot);
        Slot.setBorder(new LineBorder(Color.white, 2));
        Slot.setLayout(new GridLayout(1, 3, 10, 10));

        // Game area - Slot - Lane1
        JPanel Lane_1 = new JPanel();
        Lane_1.setBackground(new Color(21, 25, 28));
        Slot.add(Lane_1);
        Lane_1.setLayout(null);

        // Game area - Slot - Images
        SlidingImage = new JPanel();
        SlidingImage.setBackground(new Color(21, 25, 28));
        SlidingImage.setBounds(10, -564, 173, 1128);
        Lane_1.add(SlidingImage);
        SlidingImage.setLayout(new GridLayout(6, 1, 10, 10));

        // Game area - Slot - Lane2
        JPanel Lane_2 = new JPanel();
        Lane_2.setBackground(new Color(21, 25, 28));
        Slot.add(Lane_2);
        Lane_2.setLayout(null);

        // Game area - Slot - Images
        SlidingImage2 = new JPanel();
        SlidingImage2.setBackground(new Color(21, 25, 28));
        SlidingImage2.setBounds(10, -564, 173, 1128);
        Lane_2.add(SlidingImage2);
        SlidingImage2.setLayout(new GridLayout(6, 1, 10, 10));

        // Game area - Slot - Lane3
        JPanel Lane_3 = new JPanel();
        Lane_3.setBackground(new Color(21, 25, 28));
        Slot.add(Lane_3);
        Lane_3.setLayout(null);

        // Game area - Slot - Images
        SlidingImage3 = new JPanel();
        SlidingImage3.setBackground(new Color(21, 25, 28));
        SlidingImage3.setBounds(10, -564, 173, 1128);
        Lane_3.add(SlidingImage3);
        SlidingImage3.setLayout(new GridLayout(6, 1, 10, 10));

        // Game area - Saldo
        saldo = new JLabel("Saldo: ");
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
        add(bottone);
        bottone.addActionListener(e -> {
            if (puntata.getSelectedItem().toString().equals("0")) {
                JOptionPane.showMessageDialog(Slot, "Seleziona una puntata", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (JsonEdit.readSaldo(userData[0], userData[1]) == 0) {
                    JOptionPane.showMessageDialog(Slot, "Non hai abbastanza soldi", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (JsonEdit.readSaldo(userData[0], userData[1]) < Double
                            .parseDouble(puntata.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(Slot, "Non hai abbastanza soldi", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        // quando inizia la partità disabilita il pulsante
                        enable();

                        // Imposta la posizione
                        SlidingImage.setLocation(SlidingImage.getX(), -564);
                        SlidingImage2.setLocation(SlidingImage2.getX(), -564);
                        SlidingImage3.setLocation(SlidingImage3.getX(), -564);

                        // Se non è la prima partita rimuove le JLabel vecchie
                        if (firstGame != true) {
                            // rimuove le JLabel vecchie, se funziona.
                            remove();
                        } else {
                            firstGame = false;
                        }

                        // genera i numeri
                        logica.Genera();

                        // imposta la scommessa

                        logica.setScommessa((int) Integer.parseInt(puntata.getSelectedItem().toString()));

                        // Impota le immagini
                        img = logica.getNumeri();

                        // aggiunge i componenti all'interno dei pannelli mobili
                        Aggiunta();

                        // avvia il timer
                        timer = new Timer(1, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // aggiorna la posizione dello slider 1
                                if (SlidingImage.getY() >= 11) {
                                    SlidingImage.setLocation(SlidingImage.getX(), 11);
                                } else {
                                    SlidingImage.setLocation(SlidingImage.getX(), SlidingImage.getY() + 10);
                                }

                                // Ricarica le immagini
                                SlidingImage.repaint();
                                SlidingImage.revalidate();

                                // aggiorna la posizione dello slider 2
                                if (SlidingImage2.getY() >= 11) {
                                    SlidingImage2.setLocation(SlidingImage2.getX(), 11);
                                } else {
                                    SlidingImage2.setLocation(SlidingImage2.getX(), SlidingImage2.getY() + 9);
                                }

                                // Ricarica le immagini
                                SlidingImage2.repaint();
                                SlidingImage2.revalidate();

                                // aggiorna la posizione dello slider 3
                                if (SlidingImage3.getY() >= 11) {
                                    SlidingImage3.setLocation(SlidingImage3.getX(), 11);
                                    timer.stop();
                                } else {
                                    SlidingImage3.setLocation(SlidingImage3.getX(), SlidingImage3.getY() + 8);
                                }

                                // Ricarica le immagini
                                SlidingImage3.repaint();
                                SlidingImage3.revalidate();
                            }
                        });
                        timer.start();

                        // Controlla se hai vinto
                        int win = logica.Win();

                        // Timer per il risultato che parte dopo che lo slider si è fermato
                        timerVincita = new Timer(2000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (win > 0) {
                                    JOptionPane.showMessageDialog(null, "Hai vinto " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Hai perso " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
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
                    }
                }
            }
        });
    }

    public void remove() {
        Component[] components = SlidingImage.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage.remove(component);
                SlidingImage.repaint();
                SlidingImage.revalidate();
            }
        }

        components = SlidingImage2.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage2.remove(component);
                SlidingImage2.repaint();
                SlidingImage2.revalidate();
            }
        }

        components = SlidingImage3.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                SlidingImage3.remove(component);
                SlidingImage3.repaint();
                SlidingImage3.revalidate();
            }
        }
    }

    public void Aggiunta() {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                if (img[i][j] != null) {
                    switch (j + 1) {
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

    public void enable() {
        if (bottone.isEnabled()) {
            bottone.setEnabled(false);
            puntata.setEnabled(false);
        } else {
            bottone.setEnabled(true);
            puntata.setEnabled(true);
        }
    }

    public void setUserData(String[] userData) {
        this.userData = userData;
    }
}