package com.testKeySave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestJColorChooser extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJColorChooser() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		// TODO �Զ����ɵĹ��캯�����
		JPanel jp = new JPanel();
		final JLabel lb = new JLabel();
		lb.setPreferredSize(new Dimension(150, 150));
		lb.setOpaque(true);
		jp.add(lb);
		JButton btn = new JButton("ѡ����ɫ");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Color color = JColorChooser.showDialog(myJFrame, "��ɫѡ����", null);
				if (color == null) {
					return;
				} else {
					lb.setBackground(color);
					int alpha = color.getAlpha();
					int red = color.getRed();
					int blue = color.getBlue();
					int green = color.getGreen();
					lb.setText("A=" + String.format("%02x", alpha) + ","
							+ String.format("#%02x%02x%02x", red, green, blue));
				}
			}

		});
		jp.add(btn);
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
		TestJColorChooser tb = new TestJColorChooser();
	}
}
