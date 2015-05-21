
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

    public PaintPanel ()
    {
        this.setBackground(Color.white);
        this.addMouseListener(mlistener);
        this.addMouseMotionListener(motionlistener);
    }

    MouseAdapter       mlistener      = new MouseAdapter()
                                      {
                                          @Override
                                          public void mouseReleased (MouseEvent arg0)
                                          {
                                              int x = arg0.getX();
                                              int y = arg0.getY();
                                              point = new Point(x, y);
                                              list.add(point);
                                              repaint();
                                          }

                                          @Override
                                          public void mousePressed (MouseEvent arg0)
                                          {
                                              int x = arg0.getX();
                                              int y = arg0.getY();
                                              point = new Point(x, y);
                                              repaint();
                                          }
                                      };

    MouseMotionAdapter motionlistener = new MouseMotionAdapter()
                                      {
                                          @Override
                                          public void mouseDragged (MouseEvent arg0)
                                          {
                                              int x = arg0.getX();
                                              int y = arg0.getY();
                                              point = new Point(x, y);
                                              repaint();
                                          }
                                      };

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Point p : list)
        {
            p.paint(g2d);
        }
        if (point != null)
        {
            point.paint(g2d);
        }
    }

}