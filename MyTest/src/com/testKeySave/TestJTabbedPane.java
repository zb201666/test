package com.testKeySave;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestJTabbedPane extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJTabbedPane() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		// TODO �Զ����ɵĹ��캯�����
		final JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("tab01", createComponent("tab01"));
		jtp.addTab("tab02",
				new ImageIcon("src/com/testKeySave/down-circle.png"),
				createComponent("tab02"));
		jtp.addTab("tab03",
				new ImageIcon("src/com/testKeySave/down-circle.png"),
				createComponent("tab03"), "����һ��ѡ���ǩ");
		jtp.setSelectedIndex(0);
		jtp.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(myJFrame,
						"ѡ�еı�ǩ����Ϊ��" + jtp.getSelectedIndex(), "��Ϣ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		myJFrame.setContentPane(jtp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	private Component createComponent(String string) {
		// TODO �Զ����ɵķ������
		JPanel jp = new JPanel(new GridLayout(1, 1));
		JLabel lb = new JLabel(string);
		lb.setFont(new Font("����", Font.BOLD, 20));
		lb.setHorizontalTextPosition(SwingConstants.CENTER);
		jp.add(lb);
		return jp;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJTabbedPane tb = new TestJTabbedPane();
	}
}
