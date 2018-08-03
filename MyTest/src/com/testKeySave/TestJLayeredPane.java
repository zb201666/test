package com.testKeySave;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TestJLayeredPane extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJLayeredPane() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		// TODO 自动生成的构造函数存根
		JLayeredPane jlp = new JLayeredPane();
		JPanel panel01 = createPanel(Color.RED,"L=100,p=1",30,30,100,100);
		jlp.add(panel01, new Integer(100));
		JPanel panel02 = createPanel(Color.GREEN,"L=200,p=0",70,70,100,100);
		jlp.add(panel02, new Integer(200),0);
		JPanel panel03 = createPanel(Color.YELLOW,"L=200,p=1",150,150,100,100);
		jlp.add(panel03, new Integer(200),1);
		JPanel panel04 = createPanel(Color.BLUE,"L=300",180,180,100,100);
		jlp.add(panel04, new Integer(300));
		myJFrame.setContentPane(jlp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	

	private JPanel createPanel(Color bg, String title, int x, int y, int width,
			int height) {
		// TODO 自动生成的方法存根
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setBounds(x, y, width, height);
		panel.setOpaque(true);
		panel.setBackground(bg);
		JLabel label = new JLabel(title);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		panel.add(label);
		return panel;
	}



	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJLayeredPane tb = new TestJLayeredPane();
	}
}
