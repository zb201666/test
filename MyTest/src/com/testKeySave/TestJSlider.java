package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TestJSlider extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJSlider() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("����");
		jp.add(lb);
		// TODO �Զ����ɵĹ��캯�����
		final JSlider js = new JSlider(0, 30, 15);// ��ʼ����������Сֵ�����ֵ����ʼֵ
		Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
		table.put(0, new JLabel("start"));
		table.put(15, new JLabel("middle"));
		table.put(30, new JLabel("end"));
		js.setLabelTable(table);
		js.setOrientation(SwingConstants.VERTICAL);// ��ֱ����
		js.setMajorTickSpacing(10);// �����
		js.setMinorTickSpacing(1);// ��С���
		js.setSnapToTicks(true);// ����ֻ����ֵ��λ���ƶ�
		js.setPaintTicks(true);// ���ƿ̶���
		js.setPaintLabels(true);// ���ƿ̶�ֵ
		js.setPaintTrack(true);// ���ƻ���
		jp.add(js);
		JButton btn = new JButton("��ʾ");
		btn.setFont(new Font("����", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(myJFrame,
						"����ֵΪ��" + js.getValue(), "��Ϣ",
						JOptionPane.INFORMATION_MESSAGE);
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
		TestJSlider tb = new TestJSlider();
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
