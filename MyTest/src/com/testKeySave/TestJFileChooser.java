package com.testKeySave;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestJFileChooser extends JFrame {
	public JFrame myJFrame = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJFileChooser() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		// TODO �Զ����ɵĹ��캯�����
		JPanel jp = new JPanel();
		final JTextArea jta = new JTextArea(10, 30);
		jta.setLineWrap(true);
		jp.add(jta);
		JButton btn1 = new JButton("��");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				showFileOpenDialog(myJFrame, jta);
			}
		});
		jp.add(btn1);

		JButton btn2 = new JButton("����");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				showFileSaveDialog(myJFrame, jta);
			}
		});
		jp.add(btn2);
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	private void showFileOpenDialog(JFrame myJFrame, JTextArea jta) {
		// TODO �Զ����ɵķ������
		JFileChooser jc = new JFileChooser();
		jc.setCurrentDirectory(new File("."));// ����Ĭ��ѡ���ļ���Ϊ��ǰ�ļ���
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// ����ѡ��Ľڵ㣬�ļ����ļ��ж�����
		jc.setMultiSelectionEnabled(false);// �������ѡ
		jc.addChoosableFileFilter(new FileNameExtensionFilter(
				"zip(*.zip, *.rar)", "zip", "rar"));// �����ļ�������������һΪ����������Ĳ���Ϊ������������Ϊ�ļ�����
		jc.setFileFilter(new FileNameExtensionFilter(
				"image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
		jc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				// TODO �Զ����ɵķ������
				return f.isDirectory()
						|| f.getName().toLowerCase().endsWith(".xls")
						|| f.getName().toLowerCase().endsWith(".xlsx");
			}

			@Override
			public String getDescription() {
				// TODO �Զ����ɵķ������
				return "*.xls,*.xlsx";
			}

		});
		int res = jc.showOpenDialog(myJFrame);// ����ѡ�����ĳ���λ�ã�����ʱ��������������������м�λ�ã��������ֵΪnull�������Ļ�м���ʾ����������Ӧ��ѡ��ֵ
		if (res == JFileChooser.APPROVE_OPTION) {// ���ݷ��ص�ѡ��ֵ����Ӧ�Ĳ���
			File file = jc.getSelectedFile();
			jta.append("ѡ����ļ�Ϊ��" + file.getAbsolutePath() + "\r\n");
		}
	}

	private void showFileSaveDialog(JFrame myJFrame, JTextArea jta) {
		// TODO �Զ����ɵķ������
		JFileChooser jc = new JFileChooser();
		// jc.setSelectedFile(new File("�������ļ���.�ļ���׺"));
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int res = jc.showSaveDialog(myJFrame);
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = jc.getSelectedFile();
			jta.append("�����ļ�����" + file.getAbsolutePath() + "\r\n");
		}
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJFileChooser tb = new TestJFileChooser();
	}
}
