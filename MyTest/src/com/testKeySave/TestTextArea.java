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
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class TestTextArea extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestTextArea() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("��������Ϣ��");
		jp.add(lb);
		// TODO �Զ����ɵĹ��캯�����
		final JTextArea jta = new JTextArea(5,5);
		jta.setBackground(Color.WHITE);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(false);
		jp.add(jta);
		JButton btn = new JButton("�ύ");
		btn.setFont(new Font("����", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(jta.getText()==null){
					JOptionPane.showMessageDialog(myJFrame, "��������Ϣ��", "����", JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(myJFrame, "������Ϣ����ϢΪ��"+"\n"+jta.getText(), "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
		TestTextArea tb = new TestTextArea();
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
