package com.filechooser;

import java.awt.EventQueue;

import com.filechooser.MyFileChooser.MyWindowListener;

public class TestMyFileChooser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		/**
		 * ���ظ�Ӧ��
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					MyFileChooser frame = new MyFileChooser();
					// ����Ӧ�ó�ʼλ����Ļ����
					// Dimension screenSize =s
					// Toolkit.getDefaultToolkit().getScreenSize();
					// Dimension size = frame.getSize();
					// int x = (screenSize.width - size.width)/2;
					// int y = (screenSize.height - size.height)/2;
					// frame.setLocation(x, y);
					frame.setLocationRelativeTo(null);
					// frame.setResizable(false);
					// frame.setUndecorated(true);
					//frame.addWindowListener(new MyWindowListener());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				try {
					MyFileChooser2 frame = new MyFileChooser2();
					// ����Ӧ�ó�ʼλ����Ļ����
					// Dimension screenSize =s
					// Toolkit.getDefaultToolkit().getScreenSize();
					// Dimension size = frame.getSize();
					// int x = (screenSize.width - size.width)/2;
					// int y = (screenSize.height - size.height)/2;
					// frame.setLocation(x, y);
					frame.setLocationRelativeTo(null);
					// frame.setResizable(false);
					// frame.setUndecorated(true);
					//frame.addWindowListener(new MyWindowListener());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
