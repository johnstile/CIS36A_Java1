package dotsAndLines;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

// This program accepts clicks and draws them connected by lines.
// We'll talk about the "extends" keyword soon.
@SuppressWarnings("serial")
public class DotGame extends MouseListenerDrawer {
	private int debug = 0;
	/*
	 * Holds all the points
	 */
	private final int DOT_RADIUS = 5;
	private ArrayList<Point> points;
	/*
	 * How many lines have been drawn
	 */
	private int totalLines = 0;
	/*
	 * When the user clicks close to he first dot, mark the shape as 'closed' I
	 * am using a sentinel value for this
	 */
	public boolean closed_state = false;
	/*
	 * Once the shape is closed we being the game state
	 */
	private static final String STATE_BEGIN = "Beginning";
	private static final String STATE_FIRST_ROUND = "FirstRound";
	private static final String STATE_WINNER = "Winner";
	private static final String STATE_STILL_PLAYING = "StillPlaying";
	// Initial state
	private String gameState = STATE_BEGIN;
	/*
	 * Lab2 Part A, section 3. Create 2 arrayLists of lines
	 */
	ArrayList<Line> allPossibleLines;
	private ArrayList<Line> lines_on;
	private ArrayList<Line> lines_off;
	private Point p_clicked;

	/*
	 * Constructor
	 */
	public DotGame() {
		points = new ArrayList<>();
		lines_on = new ArrayList<>();
		lines_off = new ArrayList<>();
	}

	// This gets called whenever the user presses their mouse button in the
	// window
	public void mousePressed(MouseEvent event) {
		// where did the user click?
		p_clicked = new Point(event.getX(), event.getY());
		/*
		 * If the point is near an existing point, use the existing point,
		 * because it is hard to pick the exact same point
		 */
		for (Point point : points) {
			if (closeTo(point, p_clicked)) {
				p_clicked = point;
				break;
			}
		}
		/*
		 * Part 2A Test for Closure: Require more than two points to set closure
		 */
		if (points.size() > 2) {
			/*
			 * if set_closed is not true yet, check if it should be changed
			 */
			if (closed_state == false) {
				/*
				 * Determine if this point is next to the first point
				 */
				closed_state = closeTo(points.get(0), p_clicked);
				if (closed_state == true) {
					System.out.println("Clicked to close. Mark closed!");
					// generating lines (outside are visible; inside are
					// invisible)
				}
			}
		}
		/*
		 * Part 2A: Don't let the user add any more dots
		 */
		if (closed_state == false) {
			points.add(p_clicked);
		}

		// always redraw the screen
		repaint();
	}

	// This gets called whenever Java needs to draw to the window.
	// Basic method: first erase the window, then redraw it. Simple!
	public void paintComponent(Graphics g) {
		// erase the window
		erase(g);

		// Determine quantity of points in the array
		int totalPoints = points.size();

		// Draw all points always
		int lastIndex = totalPoints - 1;
		for (int i = 0; i < totalPoints; i++) {
			Point p = points.get(i);
			// until shape is closed we make the starting point a different
			// color
			Color color = (closed_state == false && i == 0) ? Color.green
					: Color.red;
			drawPoint(g, p, color);
			if (closed_state == false && i != lastIndex) {
				drawLine(g, p, points.get(i + 1));
			}
		}

		// Detect Stage change
		String beforeState = gameState;
		if (closed_state == true) {
			if (lines_on.size() == 0 && lines_off.size() == 0) {
				gameState = STATE_FIRST_ROUND;
			} else if (isWinner() == true) {
				gameState = STATE_WINNER;
			} else {
				gameState = STATE_STILL_PLAYING;
			}
		}

		// Handle the state
		if (gameState == STATE_FIRST_ROUND) {
			// Create lines and add to lines_on
			for (int i = 0; i < points.size(); i++) {
				Line myLine;
				if (i < (points.size() - 1)) {
					myLine = new Line(points.get(i), points.get(i + 1));
				} else {
					myLine = new Line(points.get(i), points.get(0));
				}
				lines_on.add(myLine);
			}
			// add up all the lines that are empty
			allPossibleLines = getAllPossibleLines(points);
			for (Line l : allPossibleLines) {
				if (lines_on.contains(l) == false) {
					lines_off.add(l);
				}
			}
		} else if (gameState == STATE_STILL_PLAYING) {
			toggleLine(p_clicked, lines_on, lines_off);
			// RON: this seems like a strange pace to check state
			if (isWinner() == true) {
				gameState = STATE_WINNER;
				repaint();
			}

		} else if (gameState == STATE_WINNER) {
			wonGame(g, points);
		} else {
			// 
			return;
		}
		
		// Print some meaningful info for the user
		if (gameState == STATE_BEGIN) {
			g.setColor(Color.black);
			g.drawString("Game State:   " + gameState, 50, 50);
			g.drawString("Directions: click 2 or more points, then click green dot", 50, 60);
		} else if (gameState == STATE_FIRST_ROUND) {
			g.setColor(Color.black);
			g.drawString("Game State:   " + gameState, 50, 50);
			g.drawString("Directions: Click a dot to toggle lines. Try to remove all lines.", 50, 60);
		} else if (gameState == STATE_STILL_PLAYING ){
		//if (beforeState != gameState) {
			g.setColor(Color.black);
			g.drawString("Game State:   " + gameState, 50, 50);
			g.drawString("Lines Visible:" + lines_on.size(), 50, 60);
			g.drawString("Lines Hidden: " + lines_off.size(), 50, 70);
		}
		/*
		 * Draw all visible lines
		 */
		for (Line j : lines_on) {
			drawLine(g, j.getPoint1(), j.getPoint2());
		}
	}

	boolean isWinner() {
		return (lines_on.size() == 0 ? true : false);
	}

	// /////// point methods

	private ArrayList<Line> getAllPossibleLines(ArrayList<Point> p) {
		ArrayList<Line> l = new ArrayList<>();
		for (int i = 0; i < p.size(); i++) {
			for (int j = i + 1; j < p.size(); j++) {
				Line myLine = new Line(p.get(i), p.get(j));
				l.add(myLine);
			}
		}
		return l;
	}

	private void wonGame(Graphics g, ArrayList<Point> p) {
		System.out.println("********WINNER******");
		Random rnd = new Random();
        int k = rnd.nextInt(10);
		for (int i = 0; i < p.size(); i++) {
			for (int j = i + 1; j < p.size(); j++) {
				/*
				 * This counter used to pick a new color
				 */
				k++;
				/*
				 * Adjacent points are black. Other points are a rainbow. First
				 * and last points are considered Adjacent
				 */
				Color line_color = getRainbowColor(k);

				/*
				 * Draw the line
				 */
				// drawLine( g, points.get( i ), points.get( j ) );
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(3));
				g2.setColor(line_color);
				g2.draw(new Line2D.Float(points.get(i), points.get(j)));
				g2.setColor(Color.black);
				g2.drawString("********WINNER: Points:" + points.size()
						+ "*******", 50, 50);

			}
		}
		// System.exit(0);
	}

	private void toggleLine(Point p_clicked2, ArrayList<Line> lines_on2,
			ArrayList<Line> lines_off2) {
		ArrayList<Line> toogle_off = new ArrayList<>();
		ArrayList<Line> toogle_on = new ArrayList<>();
		ArrayList<Line> lines_have_point = new ArrayList<>();
		/*
		 * RON: CAN THESE BE IN ONE FOR LOOP
		 */
		for (Line l : lines_on2) {
			if (l.hasPoint(p_clicked2) == true) {
				lines_have_point.add(l);
			}
		}
		for (Line l : lines_off2) {
			if (l.hasPoint(p_clicked2) == true) {
				lines_have_point.add(l);
			}
		}
		// Record what to toggle
		for (Line l : lines_have_point) {
			if (lines_on.contains(l)) {
				toogle_off.add(l);
			}
			if (lines_off.contains(l)) {
				toogle_on.add(l);
			}
		}
		// Do the toggle
		for (Line l : toogle_off) {
			if (debug == 1) {
				System.out.println("tooogle_off");
			}
			lines_on.remove(l);
			lines_off.add(l);
		}
		for (Line l : toogle_on) {
			if (debug == 1) {
				System.out.println("tooogle_on");
			}
			lines_off.remove(l);
			lines_on.add(l);
		}
	}

	// returns true if the two points are "close"
	private boolean closeTo(Point p1, Point p2) {
		return (distanceBetween(p1, p2) < DOT_RADIUS);
	}

	// returns the distance between two points
	private double distanceBetween(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	// /////// drawing methods

	// this one draws a black point
	private void drawPoint(Graphics g, Point p) {
		drawPoint(g, p, Color.black);
	}

	// this one draws a point with a certain color
	private void drawPoint(Graphics g, Point p, Color c) {
		g.setColor(c);
		g.fillOval(p.x - DOT_RADIUS, p.y - DOT_RADIUS, DOT_RADIUS * 2,
				DOT_RADIUS * 2);
	}

	// draws a black line
	private void drawLine(Graphics g, Point p1, Point p2) {
		drawLine(g, p1, p2, Color.black);
	}

	// draws a line of a certain color
	private void drawLine(Graphics g, Point p1, Point p2, Color c) {
		g.setColor(c);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	public static void main(String[] args) {
		DotGame me = new DotGame();
	}

	// /////// color methods

	// returns the perspective color in the rainbow
	private Color getRainbowColor(int k) {
		/*
		 * REF: http://krazydad.com/tutorials/makecolors.php Observed a color
		 * chart, As one cycles though the rainbow, Red, green, and blue follow
		 * the same repeating pattern, 0 to max to 0 however, each color is but
		 * out of phase by 1/3. By using sin() to oscillate from 1 to -1,
		 * shifting the phase such that each color is 1/3 off another and
		 * converting all values to positive, I can make a complete visual
		 * spectrum..
		 */

		// Generate a phase shift for each color.
		double red_phase = 0 * Math.PI / 3;
		double green_phase = 2 * Math.PI / 3;
		double blue_phase = 4 * Math.PI / 3;

		// Get the sign of k, shifted by the colors phase
		double red = Math.sin(red_phase + k);
		double green = Math.sin(green_phase + k);
		double blue = Math.sin(blue_phase + k);

		// Can only use positive numbers
		red = Math.abs(red);
		green = Math.abs(green);
		blue = Math.abs(blue);
		if (debug == 1) {
			System.out.println("k:" + k + ", red:" + red + ", green:" + green
					+ ", blue:" + blue);
		}
		/*
		 * Color(float r, float g, float b, float a) Creates an sRGB color with
		 * the specified red, green, blue, and alpha values in the range (0.0 -
		 * 1.0).
		 */
		return new Color((float) red, (float) green, (float) blue);
	}

}
