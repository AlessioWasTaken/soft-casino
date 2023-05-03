package backend.blackjack;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{
    private int value;
    private int number;
    private int suit;

    public Card(){
        super("hhh");
        number = (int) ((Math.random() * 13)+1);
        suit = (int) ((Math.random() * 4)+1);

        if (number > 10){
            value = 10;
        } else {
            value = number;
        }

        this.setSize(40, 56);
        this.setBackground(Color.red);
        try {
            //Image img = ImageIO.read(getClass().getResource("C:\\Users\\Alessio Sarica\\Desktop\\Virtual-Casino\\src\\assets\\bg-access.jpg"));//.getScaledInstance(40, 56, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon("C:\\Users\\Alessio Sarica\\Desktop\\Virtual-Casino\\src\\assets\\1\\1.png");
            Image img2 = img.getImage().getScaledInstance(40, 56, Image.SCALE_SMOOTH);
            this.setIcon((Icon) img2);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int getValue(){
        return value;
    }

    public int getNumber(){
        return number;
    }

    public int getSuit(){
        return suit;
    }
}
