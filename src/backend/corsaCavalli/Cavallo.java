package backend.corsaCavalli;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cavallo extends JLabel implements Runnable{
    int speed;
    int position;
    int reactionTime;
    ImageIcon[] icons = new ImageIcon[6];

    public Cavallo(){
        speed = (int)(Math.random()*10) + 1;
        position = 10;
        reactionTime = (int)(Math.random()*25) + 1;

        this.setSize(150, 120);
        this.setPreferredSize(new Dimension(120, 120));
        this.setBackground(Color.red);
        
        for (int i = 0; i < icons.length; i++) {
            int j=i+1;
            ImageIcon img = new ImageIcon("src/assets/HorseAnimation/Horse"+j+".gif");
            Image image = img.getImage();
            Image imgScaled = image.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScaled);
            icons[i] = scaledIcon;
        }
        this.setIcon(icons[0]);
        this.repaint();
        this.revalidate();
    }

    public void run(){
        int counter = 0;
        int imageCounter = 0;
        try{
            Thread.sleep(reactionTime);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        while(position < 850){
            if(counter == 3){
                speed();
                counter = 0;
            }
            position += speed;
            this.setLocation(position, this.getY());
            this.setIcon(icons[imageCounter%6]);
            this.repaint();
            this.revalidate();
            try {
                Thread.sleep(40);
                counter++;
                imageCounter++;
            } catch (Exception e) {}
        }
    }

    public void speed(){
        speed = (int)(Math.random()*15) + 1;
    }

    public int getPosition(){
        return position;
    }
}

