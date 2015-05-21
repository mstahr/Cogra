package main;

import java.awt.Color;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int tmpx1;
	int tmpy1;

	public PaintPanel() {
		this.setBackground(Color.white);
		// this.addMouseListener(mlistener);
		// this.addMouseMotionListener(motionlistener);
	}

//	MouseListener mlistener = new MouseAdapter() {
//		@Override
//		public void mouseReleased(MouseEvent arg0) {
//			int x = arg0.getX();
//			int y = arg0.getY();
//
//		}
//
//		@Override
//		public void mousePressed(MouseEvent arg0) {
//			int x = arg0.getX();
//			int y = arg0.getY();
//
//		}
//	};
//
//	MouseMotionAdapter motionlistener = new MouseMotionAdapter() {
//		@Override
//		public void mouseDragged(MouseEvent arg0) {
//
//			int x = arg0.getX();
//			int y = arg0.getY();
//
//		}
//	};
//
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//
//	}

}