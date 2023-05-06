package backend.Slot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Immagine extends JLabel{
	private int Num;

	public Immagine() {
		super();
		Num = (int) ((Math.random() * 6) + 1);
		int chance=(int)(Math.random() * 69420 + 1);
		if(chance== 1) {
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

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}
}
