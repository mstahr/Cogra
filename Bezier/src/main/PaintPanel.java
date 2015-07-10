package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	ArrayList<Point> kurvenpunkte = new ArrayList<Point>();
	ArrayList<Point> kontrollpunkte = new ArrayList<Point>();
	ArrayList<Quad> listOfCurves = new ArrayList<Quad>();

	Point bezierPoint = null;
	Point lastBezierPoint = null;

	Point point;
	Point draggedPoint;
	boolean dragging;

	public PaintPanel() {
		this.setBackground(Color.white);
		this.addMouseListener(mlistener);
		this.addMouseMotionListener(motionlistener);
	}

	MouseAdapter mlistener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (arg0.getClickCount() == 1) {

				point = new Point(arg0.getX(), arg0.getY());
				if (arg0.getButton() == MouseEvent.BUTTON1
						&& kontrollpunkte.size() < 4) {
					if (isInPoint(point) == null) {
						kontrollpunkte.add(point);
					}
				}
				if (arg0.getButton() == MouseEvent.BUTTON3) {
					if (isInPoint(point) != null) {
						kontrollpunkte.remove(isInPoint(point));
						bezierPoint = null;
						lastBezierPoint = null;
					}
				}
			} else if (arg0.getClickCount() == 2 && kurvenpunkte.size() >= 4) {
				System.out.println("double");
				point = new Point(arg0.getX(), arg0.getY());
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					if (isInPoint(point) == null) {
						kurvenpunkte.add(point);
						System.out.println(kurvenpunkte.size());
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			repaint();
			dragging = false;
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			point = new Point(arg0.getX(), arg0.getY());
			if (isInPoint(point) == null) {
				dragging = false;
			} else {
				dragging = true;
				draggedPoint = isInPoint(point);
			}
		}
	};

	MouseMotionAdapter motionlistener = new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			if (dragging) {
				draggedPoint.setPosition(arg0.getX(), arg0.getY());
				repaint();
			}
		}
	};

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Point lastPoint = null;
		// GeneralPath path = new GeneralPath();
		for (Point p : kontrollpunkte) {
			if (lastPoint != null) {
				g.setColor(Color.gray);
				Line2D line = new Line2D.Double(lastPoint.getX(),
						lastPoint.getY(), p.getX(), p.getY());
				g2d.setStroke(new BasicStroke());
				g2d.draw(line);
			}

			lastPoint = p;
			g.setColor(Color.blue);
			p.paint(g2d);

			double delta = 0.01;

			if (kontrollpunkte.size() == 4) {
				for (int i = 0; i < 1 / delta; i++) {
					double t = i * delta;
					double t1 = 1 - t;
					Double curvePointX = kontrollpunkte.get(0).getX() * t1 * t1
							* t1 + kontrollpunkte.get(1).getX() * 3 * t * t1
							* t1 + kontrollpunkte.get(2).getX() * 3 * t * t
							* t1 + kontrollpunkte.get(3).getX() * t * t * t;
					Double curvePointY = kontrollpunkte.get(0).getY() * t1 * t1
							* t1 + kontrollpunkte.get(1).getY() * 3 * t * t1
							* t1 + kontrollpunkte.get(2).getY() * 3 * t * t
							* t1 + kontrollpunkte.get(3).getY() * t * t * t;
					bezierPoint = new Point(Integer.valueOf(curvePointX
							.intValue()), Integer.valueOf(curvePointY
							.intValue()));
					g.setColor(Color.red);
					g2d.setStroke(new BasicStroke(2));
					if (i > 0) {

						Line2D line = new Line2D.Double(lastBezierPoint.getX(),
								lastBezierPoint.getY(), bezierPoint.getX(),
								bezierPoint.getY());
						g2d.draw(line);
					}
					lastBezierPoint = bezierPoint;
				}
				g2d.draw(new Line2D.Double(lastBezierPoint.getX(),
						lastBezierPoint.getY(), kontrollpunkte.get(3).getX(),
						kontrollpunkte.get(3).getY()));
			}

			// if (kurvenpunkte.size() >= 4) {
			// path.moveTo(kurvenpunkte.get(0).getX(), kurvenpunkte.get(0)
			// .getY());
			// path.curveTo(kurvenpunkte.get(1).getX(), kurvenpunkte.get(1)
			// .getY(), kurvenpunkte.get(2).getX(), kurvenpunkte
			// .get(2).getY(), kurvenpunkte.get(3).getX(),
			// kurvenpunkte.get(3).getY());
			// g.setColor(Color.red);
			// g2d.setStroke(new BasicStroke(2));
			// g2d.draw(path);
			// }

		}
	}

	/**
	 * Clears the ArrayList of Points in the PaintPanel
	 */
	public void clearList() {
		kurvenpunkte.clear();
	}

	/**
	 * Deletes the last Point in the ArrayList of Points in the PaintPanel
	 */
	public void undoList() {
		if (kurvenpunkte.size() > 0) {
			kurvenpunkte.remove(kurvenpunkte.size() - 1);
			repaint();
		}
	}

	/**
	 * Checks if the parameter is within one of the Points in the ArrayList
	 */
	public Point isInPoint(Point point) {
		for (Point p : kurvenpunkte) {
			if (point.getX() >= p.getX() - 2 && point.getX() <= p.getX() + 2
					&& point.getY() >= p.getY() - 2
					&& point.getY() <= p.getY() + 2) {
				return p;
			}
		}
		for (Point p : kontrollpunkte) {
			if (point.getX() >= p.getX() - 2 && point.getX() <= p.getX() + 2
					&& point.getY() >= p.getY() - 2
					&& point.getY() <= p.getY() + 2) {
				return p;
			}
		}
		return null;
	}

}