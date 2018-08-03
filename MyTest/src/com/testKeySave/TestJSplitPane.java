package com.testKeySave;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class TestJSplitPane extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJSplitPane() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		// TODO 自动生成的构造函数存根
		JSplitPane jsp = new JSplitPane();
		jsp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jsp.setOneTouchExpandable(true);
		jsp.setContinuousLayout(true);
		jsp.setDividerLocation(300);
		jsp.setLeftComponent(new JButton("左边按钮"));
		jsp.setRightComponent(new JButton("右边按钮"));
		myJFrame.setContentPane(jsp);
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
		TestJSplitPane tb = new TestJSplitPane();
	}
}
