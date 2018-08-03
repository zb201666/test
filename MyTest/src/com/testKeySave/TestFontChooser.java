package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFontChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -328658864211509926L;
	private JTextArea text = null;
	private JButton button = null;
	private JPanel jp = null;
	static {
		try {
			// �����Look And Feelʹ�ñ�������ɵõ����õ�Ч��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//ȡ�õ�ǰϵͳƽ̨�������ʾ���
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public TestFontChooser() {
		text = new JTextArea(
				"���Ǻ���ӭ��Ʈ�\nʤ��������ô������\n�質�����װ��������\n�ӽ������ٸ�ǿ��\n�質�����װ��������\n�ӽ������ٸ�ǿ��\n\nԽ����ɽ��\nԽ��ƽԭ��\n������ڵĻƺӳ�����\n������������أ�\n�������װ��ļ��磬\nӢ�۵�����վ�����ˣ�\n�����Ž��Ѱ���ǿ��֡�");
		jp = new JPanel();
		button = new JButton("��������");
		jp.add(button);
		// ����ť��Ӷ����¼�����
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��������ѡ��������������ΪԤ��ֵ
				FontChooser fontChooser = new FontChooser(text.getFont());
				// ��һ������ѡ�������ڣ�����Ϊ���������ߴ��塣����һ�����ͣ�������������ʱ������ȷ������ȡ�����ɲο�FontChooser.APPROVE_OPTION��FontChooser.CANCEL_OPTION
				int returnValue = fontChooser
						.showFontDialog(TestFontChooser.this);
				// ������µ���ȷ����ť
				if (returnValue == FontChooser.APPROVE_OPTION) {
					// ��ȡѡ�������
					Font font = fontChooser.getSelectFont();
					// ���������õ�JTextArea��
					text.setFont(font);
					System.out.println(text.getFont());
				}
			}
		});
		getContentPane().add(new JScrollPane(text));
		getContentPane().add(jp, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new TestFontChooser();
	}

}
