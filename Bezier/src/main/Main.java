
package main;

public class Main
{

    public static void main (String[] args)
    {
        MainPanel panel = new MainPanel();
        panel.setLocation(50, 50);
        panel.setSize(1000, 600);
        panel.setTitle("Grafikprogramm");
        panel.setResizable(false);
        panel.setVisible(true);
    }
}
