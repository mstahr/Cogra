package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainPanel extends JFrame implements ActionListener {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	Container cp;
	PaintPanel p = new PaintPanel();

	public MainPanel() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(p, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
