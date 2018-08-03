package com.testKeySave;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Test_System_Tray {

	/**
	 * 测试系统托盘
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		});
	}

	private static void createGUI() {
		final JFrame jf = new JFrame("系统托盘测试");
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
		jf.setLocationRelativeTo(null);

		/*
		 * 添加系统托盘
		 */
		if (SystemTray.isSupported()) {
			// 获取当前平台的系统托盘
			SystemTray tray = SystemTray.getSystemTray();

			// 加载一个图片用于托盘图标的显示
			Image image = Toolkit.getDefaultToolkit().getImage("src/com/testKeySave/身份证.png");

			// 创建点击图标时的弹出菜单
			PopupMenu popupMenu = new PopupMenu();

			MenuItem openItem = new MenuItem("打开");
			MenuItem exitItem = new MenuItem("退出");

			openItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 点击打开菜单时显示窗口
					if (!jf.isShowing()) {
						jf.setVisible(true);
					}
				}
			});
			exitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 点击退出菜单时退出程序
					System.exit(0);
				}
			});

			popupMenu.add(openItem);
			popupMenu.add(exitItem);

			// 创建一个托盘图标
			TrayIcon trayIcon = new TrayIcon(image, "这是一个托盘图标", popupMenu);

			// 托盘图标自适应尺寸
			trayIcon.setImageAutoSize(true);

			trayIcon.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("托盘图标被右键点击");
				}
			});
			trayIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					switch (e.getButton()) {
					case MouseEvent.BUTTON1: {
						System.out.println("托盘图标被鼠标左键被点击");
						break;
					}
					case MouseEvent.BUTTON2: {
						System.out.println("托盘图标被鼠标中键被点击");
						break;
					}
					case MouseEvent.BUTTON3: {
						System.out.println("托盘图标被鼠标右键被点击");
						break;
					}
					default: {
						break;
					}
					}
				}
			});

			// 添加托盘图标到系统托盘
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("当前系统不支持系统托盘");
		}

		jf.setVisible(true);
	}
}
