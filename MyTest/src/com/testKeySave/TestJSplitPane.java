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
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		// TODO �Զ����ɵĹ��캯�����
		JSplitPane jsp = new JSplitPane();
		jsp.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jsp.setOneTouchExpandable(true);
		jsp.setContinuousLayout(true);
		jsp.setDividerLocation(300);
		jsp.setLeftComponent(new JButton("��߰�ť"));
		jsp.setRightComponent(new JButton("�ұ߰�ť"));
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
		// TODO �Զ����ɵķ������
		TestJSplitPane tb = new TestJSplitPane();
	}
}
