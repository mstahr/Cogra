
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel
{

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    ArrayList<Point>          list             = new ArrayList<Point>();
    Point                     point;
    Point                     draggedPoint;
    boolean                   dragging;

    public PaintPanel ()
    {
        this.setBackground(Color.white);
        this.addMouseListener(mlistener);
        this.addMouseMotionListener(motionlistener);
    }

    MouseAdapter       mlistener      = new MouseAdapter()
                                      {
                                          @Override
                                          public void mouseClicked (MouseEvent arg0)
                                          {
                                              point = new Point(arg0.getX(), arg0.getY());
                                              if (arg0.getButton() == MouseEvent.BUTTON1)
                                              {
                                                  if (isInPoint(point) == null)
                                                  {
                                                      list.add(point);
                                                  }
                                              }
                                              if (arg0.getButton() == MouseEvent.BUTTON3)
                                              {
                                                  if (isInPoint(point) != null)
                                                  {
                                                      list.remove(isInPoint(point));
                                                  }
                                              }
                                          }

                                          @Override
                                          public void mouseReleased (MouseEvent arg0)
                                          {
                                              repaint();
                                              dragging = false;
                                          }

                                          @Override
                                          public void mousePressed (MouseEvent arg0)
                                          {
                                              point = new Point(arg0.getX(), arg0.getY());
                                              if (isInPoint(point) == null)
                                              {
                                                  dragging = false;
                                              } else
                                              {
                                                  dragging = true;
                                                  draggedPoint = isInPoint(point);
                                              }
                                          }
                                      };

    MouseMotionAdapter motionlistener = new MouseMotionAdapter()
                                      {
                                          @Override
                                          public void mouseDragged (MouseEvent arg0)
                                          {
                                              if (dragging)
                                              {
                                                  draggedPoint.setPosition(arg0.getX(), arg0.getY());
                                                  repaint();
                                              }
                                          }
                                      };

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Point lastPoint = null;
        for (Point p : list)
        {
            if (lastPoint != null)
            {
                g.setColor(Color.gray);
                Line2D line = new Line2D.Double(lastPoint.getX(), lastPoint.getY(), p.getX(), p.getY());
                g2d.draw(line);
            }
            lastPoint = p;
            g.setColor(Color.blue);
            p.paint(g2d);

            g.setColor(Color.red);

            // TODO Bézier-Kurve

        }
    }

    /**
     * Clears the ArrayList of Points in the PaintPanel
     */
    public void clearList ()
    {
        list.clear();
    }

    /**
     * Deletes the last Point in the ArrayList of Points in the PaintPanel
     */
    public void undoList ()
    {
        if (list.size() > 0)
        {
            list.remove(list.size() - 1);
            repaint();
        }
    }

    /**
     * Checks if the parameter is within one of the Points in the ArrayList
     */
    public Point isInPoint (Point point)
    {
        for (Point p : list)
        {
            if (point.getX() >= p.getX() - 2 && point.getX() <= p.getX() + 2 && point.getY() >= p.getY() - 2 && point.getY() <= p.getY() + 2)
            {
                return p;
            }
        }
        return null;
    }

}