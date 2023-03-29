package auth;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import standard.RoundedPanel;

public class Sigin extends JPanel {

	/**
	 * Create the panel.
	 */
	public Sigin() {
		setSize(new Dimension(1600, 900));
		setLayout(null);
		
		JLabel Background = new JLabel("New label");
		
		Background.setIcon(new ImageIcon("C:\\Users\\saric\\Documents\\Eclipse\\Virtual-Casino\\assets\\BackgroundLogin[1600x900].jpg"));
		Background.setBounds(0, 0, 1600, 900);
		RoundedPanel data = new RoundedPanel();
		
		data.setBounds(569, 162, 500, 600);
		data.setBackground(Color.white);
		add(data);
		add(Background);

	}

}
