package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class TestJToolBar extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public JTextArea jta = null;
	public JButton play = null;
	public JButton left = null;
	public JButton right = null;
	public String play_image = "src/com/testKeySave/play-circle-fill.png";
	public String left_image = "src/com/testKeySave/left-circle-fill.png";
	public String right_image = "src/com/testKeySave/right-circle-fill.png";

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJToolBar() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		// TODO �Զ����ɵĹ��캯�����
		JToolBar jtb = new JToolBar("���Թ�����");
		play = new JButton(new ImageIcon(play_image));
		left = new JButton(new ImageIcon(left_image));
		right = new JButton(new ImageIcon(right_image));
		jtb.add(left);
		jtb.add(play);
		jtb.add(right);
		jta = new JTextArea();
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		ButtonAction ba = new ButtonAction();
		play.addActionListener(ba);
		left.addActionListener(ba);
		right.addActionListener(ba);
		jp.add(jtb, BorderLayout.PAGE_START);// ��� ������ �� ������� �� ����
		jp.add(jta, BorderLayout.CENTER);// ��� �ı����� �� ������� �� �м�
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	class ButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(e.getSource().equals(left)){
				jta.setText("��һ��");
			}else if(e.getSource().equals(play)){
				jta.setText("����");
			}else{
				jta.setText("��һ��");
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJToolBar tb = new TestJToolBar();
	}

}
