package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

public class TestPasswordField extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestPasswordField() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("������6-10����ĸ�������֣�");
		jp.add(lb);
		// TODO �Զ����ɵĹ��캯�����
		final JPasswordField jpf = new JPasswordField(10);
		jpf.setForeground(Color.BLUE);
		jpf.setEchoChar('*');
		jp.add(jpf);
		JButton btn = new JButton("�ύ");
		btn.setFont(new Font("����", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				char[] pass = jpf.getPassword();
				if (pass == null || pass.length < 1) {
					JOptionPane.showMessageDialog(myJFrame, "δ�������룡", "����",
							JOptionPane.WARNING_MESSAGE);
				} else if (pass.length < 6 || pass.length > 10) {
					JOptionPane.showMessageDialog(myJFrame, "���볤��Ϊ6-10����ĸ�������֣�",
							"����", JOptionPane.WARNING_MESSAGE);
				} else {
					if (!isRight(pass)) {
						JOptionPane.showMessageDialog(myJFrame,
								"���볤��Ϊ6-10����ĸ�������֣�", "����",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(myJFrame,
								"����Ϊ��" + jpf.getText(), "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
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
		// TODO �Զ����ɵķ������
		TestPasswordField tb = new TestPasswordField();
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
