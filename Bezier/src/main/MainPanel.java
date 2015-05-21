
package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainPanel extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;
    Container                 cp;
    PaintPanel                p                = new PaintPanel();

    JMenuBar                  menuBar          = new JMenuBar();

    JMenu                     menuFile         = new JMenu("File");
    JMenu                     menuEdit         = new JMenu("Edit");
    JMenu                     menuHelp         = new JMenu("Help");

    JMenuItem                 itemClose        = new JMenuItem("Close");
    JMenuItem                 itemClear        = new JMenuItem("Clear");
    JMenuItem                 itemInfo         = new JMenuItem("Info");

    public MainPanel ()
    {
        initMenu();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(p, BorderLayout.CENTER);
    }

    /**
     * Initiates the MenuBar
     */
    private void initMenu ()
    {
        itemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
        itemClear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        itemInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));

        itemClose.addActionListener(this);
        itemClear.addActionListener(this);
        itemInfo.addActionListener(this);

        menuFile.add(itemClose);
        menuEdit.add(itemClear);
        menuHelp.add(itemInfo);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuHelp);
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == itemClose)
        {
            System.exit(0);
        }
        if (e.getSource() == itemClear)
        {
            p.clearList();
            p.repaint();
        }
        if (e.getSource() == itemInfo)
        {
            JOptionPane.showMessageDialog(null, "This Program was created by Richard Isensee and Michael Stahr.\n\n"
                    + "      Create points (Blue) by clicking into the painting area.\n"
                    + "                 Move the points by dragging them around.\n" + "                     Remove them by right-clicking them. \n"
                    + "     Control lines (Gray) are generated between the points,\n" + "                        as well as the Bézier curve (Red).");
        }
    }
}
