package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class TestJProgressBar extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public static final int MAX = 100;
	public static final int MIN = 0;
	public static int CUR = MIN;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJProgressBar() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("进度条");
		jp.add(lb);
		// TODO 自动生成的构造函数存根
		final JProgressBar jpb = new JProgressBar();
		jpb.setMaximum(MAX);
		jpb.setMinimum(MIN);
		jpb.setValue(CUR);
		jpb.setStringPainted(true);
		//jpb.setIndeterminate(true);
		jpb.setBackground(Color.WHITE);
		jpb.setForeground(Color.BLUE);
		jpb.repaint();
		jp.add(jpb);
		JButton btn = new JButton("开始");
		btn.setFont(new Font("宋体", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new Timer(500, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						CUR++;
						if (CUR > MAX) {
							CUR = MIN;
						}
						jpb.setValue(CUR);
					}

				}).start();
			}

		});
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJProgressBar tb = new TestJProgressBar();
	}

	public boolean isRight(char[] chars) {
		boolean flag = true;
		for (char c : chars) {
			int i = c;
			if ((i > 64 && i < 91) || (i > 96 && i < 123) || (i > 47 && i < 58)) {
				flag = flag && true;
			} else {
				flag = flag && false;
			}
		}
		return flag;
	}

	public static void clearConsole() {
		try {
			String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				// Runtime.getRuntime().exec("cls");
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
						.waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
