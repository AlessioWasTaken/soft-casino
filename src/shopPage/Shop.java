package shopPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Shop extends JPanel{
    private int isSelected = 0;


    public Shop() {
        setSize(1050, 800);
        setLocation(250, 0);
        setLayout(null);
        setBackground(Color.white);

        init();
    }

    private void init() {
        // Titolo
        JLabel titolo = new JLabel("Seleziona un pacchetto");
        titolo.setBounds(0, 10, 1050, 800);
        titolo.setFont(new Font("Arial", Font.PLAIN, 30));
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setVerticalAlignment(JLabel.TOP);
        add(titolo);

        // Pacchetto 1
        JPanel pacchetto1 = new JPanel();
        pacchetto1.setBounds(20, 100, 290, 400);
        pacchetto1.setLayout(null);
        pacchetto1.setBackground(new Color(21, 25, 28));
        pacchetto1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 1;
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pacchetto1.setBackground(new Color(21, 25, 28));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pacchetto1.setBackground(new Color(34, 40, 44));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        }); 

        // Titolo pacchetto
        JLabel titoloPacchetto = new JLabel("Starter");
        titoloPacchetto.setBounds(30, 40, 290, 50);
        titoloPacchetto.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto.setForeground(Color.white);
        pacchetto1.add(titoloPacchetto);

        // Icona pacchetto
        JLabel iconaPacchetto = new JLabel();
        iconaPacchetto.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/starter.png")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            iconaPacchetto.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        pacchetto1.add(iconaPacchetto);

        // Quantità
        JLabel quantita = new JLabel("30 Fish");
        quantita.setBounds(30, 300, 290, 50);
        quantita.setFont(new Font("Arial", Font.PLAIN, 20));
        quantita.setHorizontalAlignment(JLabel.LEFT);
        quantita.setVerticalAlignment(JLabel.TOP);
        quantita.setForeground(Color.white);
        pacchetto1.add(quantita);

        // Prezzo pacchetto
        JLabel prezzoPacchetto = new JLabel("€ 10.99");
        prezzoPacchetto.setBounds(30, 350, 290, 50);
        prezzoPacchetto.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto.setForeground(Color.white);
        pacchetto1.add(prezzoPacchetto);
        add(pacchetto1);

        // Pacchetto 2
        JPanel pacchetto2 = new JPanel();
        pacchetto2.setBounds(350, 100, 290, 400);
        pacchetto2.setLayout(null);
        pacchetto2.setBackground(new Color(21, 25, 28));
        pacchetto2.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 2;
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pacchetto2.setBackground(new Color(21, 25, 28));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pacchetto2.setBackground(new Color(34, 40, 44));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });

        // Titolo pacchetto
        JLabel titoloPacchetto2 = new JLabel("Pro");
        titoloPacchetto2.setBounds(30, 40, 290, 50);
        titoloPacchetto2.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto2.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto2.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto2.setForeground(Color.white);
        pacchetto2.add(titoloPacchetto2);

        // Icona pacchetto
        JLabel iconaPacchetto2 = new JLabel();
        iconaPacchetto2.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/pro.png")).getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            iconaPacchetto2.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        pacchetto2.add(iconaPacchetto2);

        // Quantità
        JLabel quantita2 = new JLabel("100 Fish");
        quantita2.setBounds(30, 300, 290, 50);
        quantita2.setFont(new Font("Arial", Font.PLAIN, 20));
        quantita2.setHorizontalAlignment(JLabel.LEFT);
        quantita2.setVerticalAlignment(JLabel.TOP);
        quantita2.setForeground(Color.white);
        pacchetto2.add(quantita2);

        // Prezzo pacchetto
        JLabel prezzoPacchetto2 = new JLabel("€ 29.99");
        prezzoPacchetto2.setBounds(30, 350, 290, 50);
        prezzoPacchetto2.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto2.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto2.setForeground(Color.white);
        pacchetto2.add(prezzoPacchetto2);
        add(pacchetto2);

        // Pacchetto 3
        JPanel pacchetto3 = new JPanel();
        pacchetto3.setBounds(670, 100, 290, 400);
        pacchetto3.setLayout(null);
        pacchetto3.setBackground(new Color(21, 25, 28));
        pacchetto3.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                isSelected = 3;
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pacchetto3.setBackground(new Color(21, 25, 28));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pacchetto3.setBackground(new Color(34, 40, 44));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });

        // Titolo pacchetto
        JLabel titoloPacchetto3 = new JLabel("Premium");
        titoloPacchetto3.setBounds(30, 40, 290, 50);
        titoloPacchetto3.setFont(new Font("Arial", Font.PLAIN, 20));
        titoloPacchetto3.setHorizontalAlignment(JLabel.LEFT);
        titoloPacchetto3.setVerticalAlignment(JLabel.TOP);
        titoloPacchetto3.setForeground(Color.white);
        pacchetto3.add(titoloPacchetto3);

        // Icona pacchetto
        JLabel iconaPacchetto3 = new JLabel();
        iconaPacchetto3.setBounds(20, 50, 250, 250);
        try {
            Image img = ImageIO.read(getClass().getResource("../assets/premium.png")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            iconaPacchetto3.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        pacchetto3.add(iconaPacchetto3);

        // Quantità
        JLabel quantita3 = new JLabel("300 Fish");
        quantita3.setBounds(30, 300, 290, 50);
        quantita3.setFont(new Font("Arial", Font.PLAIN, 20));
        quantita3.setHorizontalAlignment(JLabel.LEFT);
        quantita3.setVerticalAlignment(JLabel.TOP);
        quantita3.setForeground(Color.white);
        pacchetto3.add(quantita3);

        // Prezzo pacchetto
        JLabel prezzoPacchetto3 = new JLabel("€ 49.99");
        prezzoPacchetto3.setBounds(30, 350, 290, 50);
        prezzoPacchetto3.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzoPacchetto3.setHorizontalAlignment(JLabel.LEFT);
        prezzoPacchetto3.setForeground(Color.white);
        pacchetto3.add(prezzoPacchetto3);
        add(pacchetto3);

        // Bottone acquista
        JButton acquista = new JButton("Acquista");
        acquista.setBounds(350, 550, 290, 50);
        acquista.setFont(new Font("Arial", Font.PLAIN, 20));
        acquista.setBackground(new Color(21, 25, 28));
        acquista.setForeground(Color.white);
        acquista.setBorder(BorderFactory.createLineBorder(Color.white));
        acquista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected == 1) {
                    System.out.println("Acquistato pacchetto 1");
                    // TODO: Implementare backend
                } else if (isSelected == 2) {
                    System.out.println("Acquistato pacchetto 2");
                    // TODO: Implementare backend
                } else if (isSelected == 3) {
                    System.out.println("Acquistato pacchetto 3");
                    // TODO: Implementare backend
                }
            }
        });
        add(acquista);
    }
}