package standard;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class RoundedButton extends JButton {
  public RoundedButton(String text) {
    super(text);
    setOpaque(false);
  }

  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(new Color(217, 217 , 217));
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

    super.paintComponent(g);
  }

  protected void paintBorder(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(new Color(217, 217 , 217));
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);

  }
}
