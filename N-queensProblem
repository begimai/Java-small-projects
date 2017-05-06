import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class temp extends JFrame {     
	int originW = 1920;		int width = 1200;
	int originH = 1080;		int height = 800;
    Color background = new Color(135, 206, 250);
	Color cpColor = new Color(138, 150, 226);
	Color white = new Color(255, 255, 255);
	Color darkBlue = new Color(0, 75, 160);
	
    public temp() {
        initialize();
		DrawPanel controlPanel = new DrawPanel();
		
		Box box = Box.createVerticalBox();
		box.setMaximumSize(new Dimension(300, 700));
		
		JLabel titleLbl = new JLabel("Number of Queens");
		titleLbl.setForeground(Color.white);
		titleLbl.setFont(new Font("Serif", Font.PLAIN, 34));
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(4, 4, 12, 1);
		JSpinner spinner = new JSpinner(spinnerModel);
		
		JPanel btnPanel = new JPanel(new BorderLayout());
		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			startAnimation((Integer)spinner.getValue());
		  }
		});
		startBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		startBtn.setForeground(Color.white);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
		btnPanel.setBackground(cpColor);
		btnPanel.add(startBtn);
		
		JSlider slider = new JSlider(0, 10, 5);
		
		JPanel lblPanel = new JPanel(new BorderLayout());
		JLabel solutionLbl = new JLabel("Solutions");
		solutionLbl.setForeground(Color.white);
		solutionLbl.setFont(new Font("Serif", Font.PLAIN, 34));
		solutionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel.setBackground(cpColor);
		lblPanel.add(solutionLbl);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(white);
		textPane.setPreferredSize(new Dimension(200, 400));
		
		titleLbl.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spinner.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		slider.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		box.add(titleLbl);
		box.add(spinner);
		box.add(btnPanel);
		box.add(slider);
		box.add(lblPanel);
		box.add(textPane);
		//box.add(Box.createRigidArea(new Dimension(5,0)));
		
		controlPanel.add(box);
		
		JPanel gamePanel = new JPanel(new GridLayout(5,5));
		gamePanel.setBackground(background);
		gamePanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		
		for(int i = 0; i < 25; ++i)
		{
			JPanel temp = new JPanel();
			if(i % 2 == 0)
			{
				temp.setBackground(white);
			}
			else
			{
				temp.setBackground(darkBlue);
			}
			gamePanel.add(temp);
		}
		
		add(controlPanel, BorderLayout.EAST);
		add(gamePanel, BorderLayout.CENTER);
		pack();
		this.setSize(width, height);
		this.setLocation((originW - width)/2, (originH - height)/2);
    }
	
	private void initialize() {
		this.setTitle("Queens");
		this.getContentPane().setBackground(background);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800,600));
        setVisible(true);
	}
	
	class DrawPanel extends JPanel {
		public DrawPanel() {
			setBackground(cpColor);
			BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS); 
			setLayout(boxLayout);
			setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
		}
		
		public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
	}
    
    public static void main(String[] args) {
        new temp();
    }
	
	private void startAnimation(int n)
	{
		
	}
}
