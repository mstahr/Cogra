
package main;

import java.awt.Graphics2D;

public class Point
{
    private int x, y;

    public Point (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics2D g2d)
    {
        g2d.fillRect(x - 2, y - 2, 5, 5);
    }

    public void setPosition (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX ()
    {
        return x;
    }

    public int getY ()
    {
        return y;
    }
}
