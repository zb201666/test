package com.testKeySave;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class TestRadioButton extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestRadioButton() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel();
		// TODO �Զ����ɵĹ��캯�����
		final JRadioButton btn1 = new JRadioButton("��",true);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(btn1.isSelected()){
					System.out.println(btn1.getText());
				}
			}
			
		});
		final JRadioButton btn2 = new JRadioButton("Ů",false);
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(btn2.isSelected()){
					System.out.println(btn2.getText());
				}
			}
			
		});
		ButtonGroup gr = new ButtonGroup();
		gr.add(btn1);
		gr.add(btn2);
		jp.add(btn1);
		jp.add(btn2);
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
		TestRadioButton tb = new TestRadioButton();
	}

}
