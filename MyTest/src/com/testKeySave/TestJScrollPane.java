package com.testKeySave;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class TestJScrollPane extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJScrollPane() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		// TODO 自动生成的构造函数存根
		JTextArea jta = new JTextArea();
		jta.setBackground(Color.WHITE);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(false);
		jta.setFont(new Font("宋体",Font.BOLD,16));
		JScrollPane js = new JScrollPane(jta,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myJFrame.setContentPane(js);
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
		TestJScrollPane tb = new TestJScrollPane();
	}
}
