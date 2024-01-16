package Homeworks.Homework05;
/*
 * Written By Ian Kruger, CSCE 146
 */
import javax.swing.*;
import java.awt.*;

public class SierpinskisTriangle extends Canvas
{
    //main function that runs the whole process
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Sierpinski's Triangle");
        frame.setSize(900, 900);
        SierpinskisTriangle sp = new SierpinskisTriangle();
        frame.add(sp);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        // make an instance of the graphics thing used to draw
        Graphics2D g2d = (Graphics2D) g;

        //determine the x and y of the center to draw base triangle
        int centerX = getWidth() / 2;
        int base = 300;
        int height = (int) (base * Math.sqrt(3) / 2);
        int x = centerX - base / 2;
        int y = getHeight() - height;

        // this is step 1 drawing the intial black triangle
        g2d.setColor(Color.BLACK);
        int[] xPoints = {x, x + base, x + base / 2};
        int[] yPoints = {y, y, y - height};
        int numberOfPoints = 3;
        g2d.fillPolygon(xPoints, yPoints, numberOfPoints);

        // this is step 2 and 3 drawing the first triangle then recursively calling the next middle top and bottom
        drawWhiteTriangles(x, y, base, height, numberOfPoints, g2d);
    }

    public void drawWhiteTriangles(int x, int y, int base, int height, int points, Graphics2D g)
    {
        // draws the new triangle that is called each iteration
        g.setColor(Color.WHITE);
        int[] xPoints2 = {x + base / 4, x + base * 3 / 4, x + base / 2};
        int[] yPoints2 = {y - height / 2, y - height / 2, y};
        g.fillPolygon(xPoints2, yPoints2, points);

        if(base>4)
        {
            //draw left; done by dividing base and height by 2
            drawWhiteTriangles(x, y, base/2, height/2, points, g);
            //draw top; subtracts the new height from the y, and adds the new base /2 to the x to put triangle on top
            drawWhiteTriangles(x + (base/4), y-(height/2), base/2, height/2, points, g);
            //draw right; similar to the left function, but shifts the triangles over to the right by adding the new base
            drawWhiteTriangles(x + (base/2), y, base/2, height/2, points, g);
        }
    }
}
