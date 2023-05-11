package slotMachine;

import backend.slot.Immagine;
import backend.slot.Logica;
import backend.json.JsonEdit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

/**
 * This custom component manages a Slot machine game and connected to Virtual Casino File
 */
public class SlotMachine extends JPanel {
    public JLabel saldo;
    public String[] userData;
    private JPanel SlidingImage, SlidingImage2, SlidingImage3;
    private JButton play;
    JComboBox<String> puntata;
    private Timer timer, timerVincita;
    private Immagine[][] img;
    private boolean firstGame = true;

    /**
     * This constructor creates a basic setting of this component and delegate style to method init()
     */
    public SlotMachine() {
        setSize(1050, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    /**
     * This method manages the style of internal components
     */
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
        Slot.setBorder(new LineBorder(Color.white, 2));
        Slot.setLayout(new GridLayout(1, 3, 10, 10));
        gameArea.add(Slot);

        // Game area - Slot - Lane1
        JPanel Lane_1 = new JPanel();
        Lane_1.setBackground(new Color(21, 25, 28));
        Lane_1.setLayout(null);

        // Game area - Slot - Images
        SlidingImage = new JPanel();
        SlidingImage.setBackground(new Color(21, 25, 28));
        SlidingImage.setBounds(10, -564, 173, 1128);
        Lane_1.add(SlidingImage);
        SlidingImage.setLayout(new GridLayout(6, 1, 10, 10));
        Slot.add(Lane_1);

        // Game area - Slot - Lane2
        JPanel Lane_2 = new JPanel();
        Lane_2.setBackground(new Color(21, 25, 28));
        Lane_2.setLayout(null);

        // Game area - Slot - Images
        SlidingImage2 = new JPanel();
        SlidingImage2.setBackground(new Color(21, 25, 28));
        SlidingImage2.setBounds(10, -564, 173, 1128);
        SlidingImage2.setLayout(new GridLayout(6, 1, 10, 10));
        Lane_2.add(SlidingImage2);
        Slot.add(Lane_2);

        // Game area - Slot - Lane3
        JPanel Lane_3 = new JPanel();
        Lane_3.setBackground(new Color(21, 25, 28));
        Lane_3.setLayout(null);

        // Game area - Slot - Images
        SlidingImage3 = new JPanel();
        SlidingImage3.setBackground(new Color(21, 25, 28));
        SlidingImage3.setBounds(10, -564, 173, 1128);
        SlidingImage3.setLayout(new GridLayout(6, 1, 10, 10));
        Lane_3.add(SlidingImage3);
        Slot.add(Lane_3);

        // Game area - Saldo
        saldo = new JLabel("Saldo: ");
        saldo.setBounds(20, 620, 200, 30);
        saldo.setFont(new Font("Arial", Font.PLAIN, 20));
        saldo.setForeground(Color.BLACK);
        add(saldo);

        // Game area - Puntata
        puntata = new JComboBox<>();
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
        puntata.addItem("5000");
        puntata.addItem("10000");
        puntata.addItem("25000");
        puntata.addItem("50000");
        puntata.addItem("100000");
        add(puntata);

        // Game area - Play button
        play = new JButton("Gioca");
        play.setBounds(320, 630, 200, 50);
        play.setFont(new Font("Arial", Font.PLAIN, 20));
        play.setForeground(Color.WHITE);
        play.setBackground(new Color(21, 25, 28));
        play.setFocusPainted(false);
        play.setBorder(null);
        play.addActionListener(e -> {
            Logica logica = new Logica();
            if (Objects.requireNonNull(puntata.getSelectedItem()).toString().equals("0")) {
                JOptionPane.showMessageDialog(Slot, "Seleziona una puntata", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (JsonEdit.readSaldo(userData[0], userData[1]) == 0 || JsonEdit.readSaldo(userData[0], userData[1]) < Double
                        .parseDouble(puntata.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(Slot, "Non hai abbastanza soldi", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setStatus();

                    // Imposta la posizione dell immagini
                    SlidingImage.setLocation(SlidingImage.getX(), -564);
                    SlidingImage2.setLocation(SlidingImage2.getX(), -564);
                    SlidingImage3.setLocation(SlidingImage3.getX(), -564);

                    // Se non è la prima partita rimuove le JLabel vecchie
                    if (!firstGame) {
                        remove();
                    } else {
                        firstGame = false;
                    }

                    logica.Genera();

                    logica.setScommessa(Integer.parseInt(puntata.getSelectedItem().toString()));

                    // Imposta le immagini
                    img = logica.getNumeri();
                    addImage();
                    timer = new Timer(1, e1 -> {
                        if (SlidingImage.getY() >= 11) {
                            SlidingImage.setLocation(SlidingImage.getX(), 11);
                        } else {
                            SlidingImage.setLocation(SlidingImage.getX(), SlidingImage.getY() + 10);
                        }

                        // Ricarica le immagini
                        SlidingImage.repaint();
                        SlidingImage.revalidate();

                        if (SlidingImage2.getY() >= 11) {
                            SlidingImage2.setLocation(SlidingImage2.getX(), 11);
                        } else {
                            SlidingImage2.setLocation(SlidingImage2.getX(), SlidingImage2.getY() + 9);
                        }

                        // Ricarica le immagini
                        SlidingImage2.repaint();
                        SlidingImage2.revalidate();

                        if (SlidingImage3.getY() >= 11) {
                            SlidingImage3.setLocation(SlidingImage3.getX(), 11);
                            timer.stop();
                        } else {
                            SlidingImage3.setLocation(SlidingImage3.getX(), SlidingImage3.getY() + 8);
                        }

                        // Ricarica le immagini
                        SlidingImage3.repaint();
                        SlidingImage3.revalidate();
                    });
                    timer.start();

                    // Controlla se hai vinto
                    int win = logica.Win();
                    timerVincita = new Timer(2000, e12 -> {
                        if (win > 0) {
                            JOptionPane.showMessageDialog(null, "Hai vinto " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Hai perso " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
                        }
                        double saldoRead = JsonEdit.readSaldo(userData[0], userData[1]);
                        saldoRead += win;
                        JsonEdit.writeSaldo(userData[0], userData[1], saldoRead);
                        saldo.setText("Saldo: " + saldoRead + " Fish");
                        setStatus();
                        timerVincita.stop();
                    });

                    timerVincita.start();
                }
            }

        });
        add(play);
    }

    /**
     * This method removes components before start a new game
     */
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

    /**
     * This method adds images to the grid of Slot on gui
     */
    public void addImage() {
        for (Immagine[] immagines : img) {
            for (int j = 0; j < immagines.length; j++) {
                if (immagines[j] != null) {
                    switch (j + 1) {
                        case 1 -> SlidingImage.add(immagines[j]);
                        case 2 -> SlidingImage2.add(immagines[j]);
                        case 3 -> SlidingImage3.add(immagines[j]);
                    }
                }
                SlidingImage.repaint();
                SlidingImage2.repaint();
                SlidingImage3.repaint();
            }
        }
    }

    /**
     * This method disables or enables button if a game is started or not
     */
    public void setStatus() {
        if (play.isEnabled()) {
            play.setEnabled(false);
            puntata.setEnabled(false);
        } else {
            play.setEnabled(true);
            puntata.setEnabled(true);
        }
    }
}