package blackJack;

import backend.blackjack.Table;
import backend.json.JsonEdit;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * This custom component Represents a Black Jack game with an internal component connected to backend file in package:
 * backend.blackjack
 */
public class BlackJack extends JPanel {
    private Table table;
    private JPanel player;
    private JPanel dealer;
    private int ContaPlayer, ContaDealer;
    private JButton play, hit, stand, doubleButton, forfeit;

    private boolean firstGame = true;

    public JLabel saldo;
    public String[] userData;

    /**
     * This constructor create a component with basic setting and delegate style to method init()
     */
    public BlackJack() {
        setSize(1050, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    /**
     * This method style internal component of Black Jack
     */
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
        JComboBox<String> puntata = new JComboBox<>();
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
            if (Objects.requireNonNull(puntata.getSelectedItem()).toString().equals("0")) {
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
                        if (!firstGame) {
                            remove();
                        } else {
                            firstGame = false;
                        }

                        table = new Table(Integer.parseInt(puntata.getSelectedItem().toString()));
                        table.deal();

                        setStatus(true);

                        ContaDealer = 2;
                        ContaPlayer = 2;

                        for (int i = 0; i < table.getDealerCard().size(); i++) {
                            dealer.add(table.getDealerCard().get(i));
                            dealer.repaint();
                            dealer.revalidate();
                        }
                        for (int i = 0; i < table.getPlayerCard().size(); i++) {
                            player.add(table.getPlayerCard().get(i));
                            player.repaint();
                            player.revalidate();
                        }

                        gameArea.repaint();
                        gameArea.revalidate();

                        if (table.getDealerValue() == 21 || table.getPlayerValue() == 21) {
                            result(table.win());
                            setStatus(false);
                        }
                    }
                }
            }
        });
        add(play);

        // Game area - Hit
        hit = new JButton("Hit");
        hit.setBounds(540, 610, 200, 40);
        hit.setFont(new Font("Arial", Font.PLAIN, 20));
        hit.setForeground(Color.WHITE);
        hit.setBackground(new Color(21, 25, 28));
        hit.setFocusPainted(false);
        hit.setBorder(null);
        hit.addActionListener(e -> {
            int win = table.hitPlayer();
            player.add(table.getPlayerCard().get(ContaPlayer));
            ContaPlayer++;
            player.repaint();
            player.revalidate();
            if (win != 69420 && table.getPlayerValue() >= 21) {
                result(win);
                setStatus(false);
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
        stand.addActionListener(e -> {
            table.stand();
            int win;
            while (table.getDealerValue() < 17) {
                if (table.getDealerValue() > table.getPlayerValue()) {
                    break;
                }
                table.hitDealer();
                dealer.add(table.getDealerCard().get(ContaDealer));
                ContaDealer++;
                dealer.repaint();
                dealer.revalidate();
            }
            table.setDealerTurn(false);
            win = table.win();
            if (win != 69420) {
                result(win);
                setStatus(false);
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
        doubleButton.addActionListener(e -> {
            double saldoRead = JsonEdit.readSaldo(userData[0], userData[1]);
            if (saldoRead < table.getbet() * 2) {
                JOptionPane.showMessageDialog(gameArea, "Non hai abbastanza soldi", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int win = table.Double();
                player.add(table.getPlayerCard().get(ContaPlayer));
                ContaPlayer++;
                player.repaint();
                player.revalidate();
                if (win != 69420 && table.getPlayerValue() >= 21) {
                    result(win);
                    setStatus(false);
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
        forfeit.addActionListener(e -> {
            int win = table.forfeit();

            JOptionPane.showMessageDialog(null, "Hai concesso la partita, " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
            double saldoRead = JsonEdit.readSaldo(userData[0], userData[1]);
            saldoRead += win;
            JsonEdit.writeSaldo(userData[0], userData[1], saldoRead);
            saldo.setText("Saldo: " + saldoRead);
            setStatus(false);
        });

        setStatus(false);
    }

    /**
     * This method set enable or disable buttons during playing
     *
     * @param A {@code true} to enable this component;
     *          otherwise {@code false}
     */
    public void setStatus(boolean A) {
        hit.setEnabled(A);
        stand.setEnabled(A);
        doubleButton.setEnabled(A);
        forfeit.setEnabled(A);
        play.setEnabled(!A);
    }

    /**
     * This method removes component on table after play
     */
    public void remove() {
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

    /**
     * This method is used to calculate a result of match and refresh credit re a Pop-up message of a result
     *
     * @param win is parameter to specific value 0 == Pareggio, >0 == Vinto other == Perso
     */
    public void result(int win) {
        if (win == 0) {
            JOptionPane.showMessageDialog(null, "Hai Pareggiato", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else if (win > 0) {
            JOptionPane.showMessageDialog(null, "Hai vinto " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Hai perso " + win + " Monete", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        double saldoRead = JsonEdit.readSaldo(userData[0], userData[1]);
        saldoRead += win;
        JsonEdit.writeSaldo(userData[0], userData[1], saldoRead);
        saldo.setText("Saldo: " + saldoRead + " Fish");
    }
}