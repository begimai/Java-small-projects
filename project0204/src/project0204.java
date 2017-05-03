import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class project0204 extends JFrame {
	String title = "Animation Template";
	Color background = Color.BLACK;
	int delay =0 ;
	Random rnd = new Random();
	final int points = 50;
	final int numOfLines = 7;
	final int maxRadius = 5;
	final int maxDistance = 10;
	Color[] col = new Color[numOfLines];

	int[][] x = new int[numOfLines][points];
	int[][] y = new int[numOfLines][points];
	int[][] dx = new int[numOfLines][points];
	int[][] dy = new int[numOfLines][points];
	int radius = 1 + rnd.nextInt(maxRadius);
	int xc = getWidth() / 2;
	int yc = getHeight() / 2;

	void start() {
		for (int j = 0; j < numOfLines; j++) {
			col[j] = new Color(rnd.nextInt(255), rnd.nextInt(255),
					rnd.nextInt(255));

			x[j][0] = rnd.nextInt(getWidth());
			y[j][0] = rnd.nextInt(getHeight());
			dx[j][0] = 1 + rnd.nextInt(maxDistance);
			dy[j][0] = 1 + rnd.nextInt(maxDistance);
			

			for (int i = 1; i < points; i++) {
				if (x[j][i - 1] + dx[j][i - 1] + radius > getWidth())
					dx[j][i] = -dx[j][i - 1];
				else
					dx[j][i] = dx[j][i - 1];

				x[j][i] = x[j][i - 1] + dx[j][i];

				if (y[j][i - 1] + dy[j][i - 1] + radius > getHeight())
					dy[j][i] = -dy[j][i - 1];
				else
					dy[j][i] = dy[j][i - 1];

				y[j][i] = y[j][i - 1] + dy[j][i];

			}
		}
	}

	void update() {

		for (int j = 0; j < numOfLines; j++) {
			for (int i = 0; i < points; i++) {
				if (x[j][i] + dx[j][i] + radius > getWidth()
						|| x[j][i] + dx[j][i] + radius < 0) {
					dx[j][i] = -dx[j][i];
				}
				x[j][i] += dx[j][i];
				if (y[j][i] + dy[j][i] + radius > getHeight()
						|| y[j][i] + dy[j][i] + radius < 0) {
					dy[j][i] = -dy[j][i];
				}
				y[j][i] += dy[j][i];
			}
		}
	}

	void draw(Graphics g) {
		for (int j = 0; j < numOfLines; j++)
			for (int i = 0; i < points; i++) {
				g.setColor(col[j]);
				g.fillOval(x[j][i], y[j][i], 2 * radius, 2 * radius);
			}

	}

	public project0204() {
		setTitle(title);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawPanel panel = new DrawPanel();

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});

		add(panel);

		javax.swing.Timer timer = new javax.swing.Timer(delay,
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						update();
						repaint();
					}
				});

		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

		start();

		timer.start();
	}

	public static void main(String[] args) {
		new project0204();
	}

	class DrawPanel extends JPanel {
		public DrawPanel() {
			setBackground(background);
			setFocusable(true);
			requestFocusInWindow();
			setDoubleBuffered(true);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			draw(g);
		}
	}
}
