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
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		JDesktopPane jdp = new JDesktopPane();// �����������
		JInternalFrame jif = createJInternalFrame();// �����ڲ�����
		try {
			jif.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		JInternalFrame jif = new JInternalFrame("�ڲ�����", true, true, true, true);
		jif.setSize(300, 250);//���óߴ�
		jif.setLocation(100, 100);//����ڸ��������Ͻǵ�����
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
		// TODO �Զ����ɵķ������
		TestJInternalFrame tb = new TestJInternalFrame();
	}

}
