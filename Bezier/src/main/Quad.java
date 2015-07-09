
package main;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Quad
{
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Quad (double x0, double y0, double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void paint (Graphics2D g2d)
    {
        GeneralPath path = new GeneralPath();
        path.moveTo(x0, y0);
        path.quadTo(x1, y1, x2, y2);
        g2d.draw(path);
    }

    public double getX0 ()
    {
        return x0;
    }

    public void setX0 (double x0)
    {
        this.x0 = x0;
    }

    public double getY0 ()
    {
        return y0;
    }

    public void setY0 (double y0)
    {
        this.y0 = y0;
    }

    public double getX1 ()
    {
        return x1;
    }

    public void setX1 (double x1)
    {
        this.x1 = x1;
    }

    public double getY1 ()
    {
        return y1;
    }

    public void setY1 (double y1)
    {
        this.y1 = y1;
    }

    public double getX2 ()
    {
        return x2;
    }

    public void setX2 (double x2)
    {
        this.x2 = x2;
    }

    public double getY2 ()
    {
        return y2;
    }

    public void setY2 (double y2)
    {
        this.y2 = y2;
    }

}
