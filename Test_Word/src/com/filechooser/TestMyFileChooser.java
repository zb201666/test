package com.filechooser;

import java.awt.EventQueue;

import com.filechooser.MyFileChooser.MyWindowListener;

public class TestMyFileChooser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		/**
		 * 加载该应用
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					MyFileChooser frame = new MyFileChooser();
					// 设置应用初始位置屏幕正中
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
					// 设置应用初始位置屏幕正中
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
