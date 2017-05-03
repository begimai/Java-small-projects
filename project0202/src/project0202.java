import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class project0202 extends JFrame {
	String title = "Animation Template";
	Color background = Color.BLACK;
	int delay = 150;
	Random rnd = new Random();
	int N = 200;
	int maxRaduis = 17;
	int[] x = new int[N];
	int[] y = new int[N];
	int[] radius = new int[N];
	int[] dx = new int[N];
	int[] dy = new int[N];
	Color[] c = new Color[N];

	void start() {

		for (int i = 0; i < N; ++i) {
			x[i] = rnd.nextInt(getWidth());
			y[i] = rnd.nextInt(getHeight());
			radius[i] = 3 + rnd.nextInt(maxRaduis);
			dx[i] = 9 + rnd.nextInt(2 * radius[i]);
			dy[i] = 40 + rnd.nextInt(2 * radius[i]);
			int red = 80 + rnd.nextInt(155);
			int green = 80 + rnd.nextInt(125);
			int blue = 80 + rnd.nextInt(155);
			c[i] = new Color(red, green, blue);
		}
	}

	void update() {
		int w = getWidth();
		int h = getHeight();
		for (int i = 0; i < N; ++i) {
			if (dx[i] - x[i] > w || x[i] - dx[i] < w) {
				dx[i] = -dx[i];
			}
			x[i] += dx[i];
			if (y[i] + dy[i] >= h) {
				y[i] = 0;
			}
			y[i] += dy[i];
		}
	}

	void draw(Graphics g) {
		for (int i = 0; i < N; ++i) {
			g.setColor(c[i]);
			drawStar(g, x[i], y[i], radius[i]);
		}
	}

	void drawStar(Graphics g, int x, int y, int radius) {
		int x1 = x - radius;// влево
		int y1 = y;
		int x2 = x; // вверх
		int y2 = y - radius;
		int x3 = x + radius; // вправо
		int y3 = y;
		int x4 = x; // вниз
		int y4 = y + radius;
		int x5 = x - radius / 2; // слева сверху
		int y5 = y - radius / 2;
		int x6 = x + radius / 2;
		int y6 = y - radius / 2;
		int x7 = x + radius / 2; // справа снизу
		int y7 = y + radius / 2;
		int x8 = x - radius / 2;
		int y8 = y + radius / 2;

		g.drawLine(x1, y1, x3, y3);
		g.drawLine(x2, y2, x4, y4);
		g.drawLine(x5, y5, x7, y7);
		g.drawLine(x6, y6, x8, y8);

	}

	public project0202() {
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
		new project0202();
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
