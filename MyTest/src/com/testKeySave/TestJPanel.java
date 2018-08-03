package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TestJPanel extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp1 = null;
	public JPanel jp2 = null;
	public JPanel jp3 = null;
	public JButton btn1 = null;
	public JButton btn2 = null;
	public JTextField tf = null;
	public JPasswordField pf = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJPanel() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp1 = new JPanel();
		tf = new JTextField(10);
		jp1.add(new JLabel("用户名"));
		jp1.add(tf);
		jp2 = new JPanel();
		pf = new JPasswordField(10);
		jp2.add(new JLabel("密  码"));
		jp2.add(pf);
		jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btn1 = new JButton("登录");
		btn2 = new JButton("注册");
		jp3.add(btn1);
		jp3.add(btn2);
		btn1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (tf.getText() == null || tf.getText().equals("")) {
					JOptionPane.showMessageDialog(myJFrame, "请填写用户名！", "警告",
							JOptionPane.WARNING_MESSAGE);
				} else if (pf.getText() == null || pf.getText().equals("")) {
					JOptionPane.showMessageDialog(myJFrame, "请填写密码！", "警告",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(myJFrame, "登录成功！", "信息",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});
		btn2.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (tf.getText() == null || tf.getText().equals("")) {
					JOptionPane.showMessageDialog(myJFrame, "请填写用户名！", "警告",
							JOptionPane.WARNING_MESSAGE);
				} else if (pf.getText() == null || pf.getText().equals("")) {
					JOptionPane.showMessageDialog(myJFrame, "请填写密码！", "警告",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(myJFrame, "注册成功！", "信息",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		Box vBox = Box.createVerticalBox();
		vBox.add(jp1);
		vBox.add(jp2);
		vBox.add(jp3);
		myJFrame.setContentPane(vBox);
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
		TestJPanel tb = new TestJPanel();
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
