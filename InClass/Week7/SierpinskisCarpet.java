package Week7;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SierpinskisCarpet extends Canvas
{

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Sierpinki's Carpet");
        frame.setSize(900,900);
        SierpinskisCarpet sp = new SierpinskisCarpet();
        frame.add(sp);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        drawCarpet(0, 0, this.getSize().height, g);
    }

    public void drawCarpet(int x, int y, int side, Graphics g)
    {
        int sub = side/3;
        g.fillRect(x+sub, y+sub, sub, sub);
        if(sub>=3)
        {
            //TOP LEFT
            drawCarpet(x, y, sub, g);
            // top middle
            drawCarpet(x+sub, y, sub, g);
            // top right
            drawCarpet(x+sub+sub, y, sub, g);
            //middle left
            drawCarpet(x, y+sub, sub, g);
            //middle right
            drawCarpet(x+sub+sub, y+sub, sub, g);
            //lower left
            drawCarpet(x, y+sub+sub, sub, g);
             //lower middle
            drawCarpet(x+sub, y+sub+sub, sub, g);
              //lower right
            drawCarpet(x+sub+sub, y+sub+sub, sub, g);
        }
    }
}
