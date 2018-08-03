package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestJInternalFrame extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJInternalFrame() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		JDesktopPane jdp = new JDesktopPane();// 创建桌面面板
		JInternalFrame jif = createJInternalFrame();// 创建内部窗口
		try {
			jif.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		jdp.add(jif);
		myJFrame.setContentPane(jdp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);

	}

	private JInternalFrame createJInternalFrame() {
		// TODO 自动生成的方法存根
		JInternalFrame jif = new JInternalFrame("内部窗口", true, true, true, true);
		jif.setSize(300, 250);//设置尺寸
		jif.setLocation(100, 100);//相对于父容器左上角的坐标
		jif.setLayout(new BorderLayout());
		jp = new JPanel(new BorderLayout());
		jp.add(new JButton("button"),BorderLayout.CENTER);
		jif.add(new Label("label"),BorderLayout.CENTER);
		jif.add(jp,BorderLayout.SOUTH);
		jif.setVisible(true);
		return jif;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJInternalFrame tb = new TestJInternalFrame();
	}

}
