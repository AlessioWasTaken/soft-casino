package backend.blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{
    private int value;
    private int number;
    private int suit;

    public Card(){
        number = (int) ((Math.random() * 13)+1);
        suit = (int) ((Math.random() * 4)+1);

        if (number > 10){
            value = 10;
        } else {
            value = number;
        }

        this.setSize(100, 120);
        this.setPreferredSize(new Dimension(120, 120));
        this.setBackground(Color.red);
        
        ImageIcon img = new ImageIcon("src/assets/"+suit+"/"+number+".png");
        Image image = img.getImage();
        Image imgScaled = image.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScaled);
        this.setIcon(scaledIcon);
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