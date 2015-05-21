
package main;

import java.awt.Graphics2D;

public class Point
{
    private int x, y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void paint (Graphics2D g2d) {
        g2d.fillRect(x-1, y-1, 3, 3);
    }
}
