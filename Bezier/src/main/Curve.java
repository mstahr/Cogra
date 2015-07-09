
package main;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Curve
{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Curve (Point point1, Point point2, Point point3, Point point4)
    {
        this.setPoint1(point1);
        this.setPoint2(point2);
        this.setPoint3(point3);
        this.setPoint4(point4);
    }

    public void paint (Graphics2D g2d)
    {
        GeneralPath path = new GeneralPath();
        path.moveTo(point1.getX(), point1.getY());
        path.curveTo(point2.getX(), point2.getY(), point3.getX(), point3.getY(), point4.getX(), point4.getY());
        g2d.draw(path);
    }

    public Point getPoint1 ()
    {
        return point1;
    }

    public void setPoint1 (Point point1)
    {
        this.point1 = point1;
    }

    public Point getPoint2 ()
    {
        return point2;
    }

    public void setPoint2 (Point point2)
    {
        this.point2 = point2;
    }

    public Point getPoint3 ()
    {
        return point3;
    }

    public void setPoint3 (Point point3)
    {
        this.point3 = point3;
    }

    public Point getPoint4 ()
    {
        return point4;
    }

    public void setPoint4 (Point point4)
    {
        this.point4 = point4;
    }

}
