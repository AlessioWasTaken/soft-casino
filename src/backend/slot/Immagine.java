package backend.slot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class used to create image of symbol on slot machine grid extending a JLabel
 */
public class Immagine extends JLabel{
	private int Num;

	/**
	 * This constructor generates an image for grid
	 */
	public Immagine() {
		super();
		Num = (int) ((Math.random() * 6) + 1);
		int chance=(int)(Math.random() * 200 + 1);
		if(chance==1) {
			Num=69420;
		}
		this.setSize(173, 180);
        this.setPreferredSize(new Dimension(120, 120));
        this.setBackground(Color.red);
        
        ImageIcon img = new ImageIcon("src/assets/Immagini/"+Num+".jpg");
        Image image = img.getImage();
        Image imgScaled = image.getScaledInstance(173, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScaled);
        this.setIcon(scaledIcon);
	}

	/**
	 * This method returns a number of images
	 * @return int of image number
	 */
	public int getNum() {
		return Num;
	}
}
