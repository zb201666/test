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
	 * ����ϵͳ����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		});
	}

	private static void createGUI() {
		final JFrame jf = new JFrame("ϵͳ���̲���");
		jf.setSize(300, 300);
		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // ����رհ�ťʱ���ش���
		jf.setLocationRelativeTo(null);

		/*
		 * ���ϵͳ����
		 */
		if (SystemTray.isSupported()) {
			// ��ȡ��ǰƽ̨��ϵͳ����
			SystemTray tray = SystemTray.getSystemTray();

			// ����һ��ͼƬ��������ͼ�����ʾ
			Image image = Toolkit.getDefaultToolkit().getImage("src/com/testKeySave/���֤.png");

			// �������ͼ��ʱ�ĵ����˵�
			PopupMenu popupMenu = new PopupMenu();

			MenuItem openItem = new MenuItem("��");
			MenuItem exitItem = new MenuItem("�˳�");

			openItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ����򿪲˵�ʱ��ʾ����
					if (!jf.isShowing()) {
						jf.setVisible(true);
					}
				}
			});
			exitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ����˳��˵�ʱ�˳�����
					System.exit(0);
				}
			});

			popupMenu.add(openItem);
			popupMenu.add(exitItem);

			// ����һ������ͼ��
			TrayIcon trayIcon = new TrayIcon(image, "����һ������ͼ��", popupMenu);

			// ����ͼ������Ӧ�ߴ�
			trayIcon.setImageAutoSize(true);

			trayIcon.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("����ͼ�걻�Ҽ����");
				}
			});
			trayIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					switch (e.getButton()) {
					case MouseEvent.BUTTON1: {
						System.out.println("����ͼ�걻�����������");
						break;
					}
					case MouseEvent.BUTTON2: {
						System.out.println("����ͼ�걻����м������");
						break;
					}
					case MouseEvent.BUTTON3: {
						System.out.println("����ͼ�걻����Ҽ������");
						break;
					}
					default: {
						break;
					}
					}
				}
			});

			// �������ͼ�굽ϵͳ����
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("��ǰϵͳ��֧��ϵͳ����");
		}

		jf.setVisible(true);
	}
}
