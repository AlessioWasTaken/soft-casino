package standard;
import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton{
    private int radius;

    public RoundedButton() {
        super();
        this.radius = 30;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Dimension arcs = new Dimension(radius, radius);
        int width = getWidth();
        int height = getHeight();

        //Draws the rounded panel with borders.
        g.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);

        g.fillRoundRect(0, 0, width-1, height-1, radius, radius);
    }
}
