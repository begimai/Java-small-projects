import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class project0201 extends JFrame {
	String title = "Animation Template";
	Color background = Color.BLACK;
	int delay = 20;

	Random rnd = new Random();;
	final int N = 45;
	int maxRadius = 15;
	int[] x = new int[N];
	int[] y = new int[N];
	int[] r = new int[N];
	int[] dx = new int[N];
	int[] dy = new int[N];
	Color[] c = new Color[N];

	void start() {
		for (int i = 0; i < N; ++i) {
			x[i] = 10 + rnd.nextInt(getWidth()-10);
			y[i] = 10 + rnd.nextInt(getHeight()-10);
			r[i] = 9 + rnd.nextInt(maxRadius);
			dx[i] = -r[i] + rnd.nextInt(2 * r[i]);
			dy[i] = -r[i] + rnd.nextInt(2 * r[i]);
			c[i] = new Color(rnd.nextInt(256), rnd.nextInt(256),
					rnd.nextInt(256));
		}
	}

	void update() {
		int w = getWidth();
		int h = getHeight();
		for (int i = 0; i < N; ++i) {
			if (x[i] + dx[i] > w || x[i] + dx[i] < 0) {
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
			g.setColor(c[i]);
			g.fillOval(x[i] - r[i], y[i] - r[i], 2 * r[i], 2 * r[i]);
		}
	}

	public project0201() {
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
		new project0201();
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
