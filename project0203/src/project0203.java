import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class project0203 extends JFrame {
	String title = "Animation Template";
	Color background = Color.BLACK;
	int delay = 3;
	Random rnd = new Random();
	final int N = 30;

	int[] x = new int[N];
	int[] y = new int[N];
	int[] radius = new int[N];
	int[] dx = new int[N];
	int[] dy = new int[N];
	Color c = Color.RED;

	void start() {

		x[0] = N*3 + rnd.nextInt(getWidth() - N);
		y[0] = N*3 + rnd.nextInt(getHeight() - N);

		for (int i = 1; i < N; ++i) {
			x[i] = x[i - 1] - 8;
			y[i] = y[i - 1] - 8;
			radius[i] = 4;
			dx[i] = radius[i];
			dy[i] = radius[i];
			c = Color.red;
		}
	}

	void update() {
		int w = getWidth();
		int h = getHeight();
		for (int i = 0; i < N; ++i) {
			if (dx[i] + x[i] > w || x[i] + dx[i] < 0) {
				dx[i] = -dx[i];
			}
			x[i] += dx[i];
			if (y[i] + dy[i] > h || y[i] + dy[i] < 0) {
				dy[i] = -dy[i];
			}
			y[i] += dy[i];
		}
	}

	void draw(Graphics g) {
		for (int i = 0; i < N; ++i) {
			g.setColor(c);
			g.fillOval(x[i] - radius[i], y[i] - radius[i], 2 * radius[i],
					2 * radius[i]);
		}
	}

	public project0203() {
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
		new project0203();
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
