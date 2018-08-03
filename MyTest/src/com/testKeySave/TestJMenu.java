package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

public class TestJMenu extends JFrame {
	public JFrame myJFrame = null;
	public JTextArea jt = null;
	public JScrollPane js = null;
	public Clipboard clipboard = null;
	public Font font;
	public Color color;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJMenu() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jt = new JTextArea();
		jt.setBackground(Color.WHITE);
		jt.setLineWrap(true);
		jt.setWrapStyleWord(false);
		jt.setFont(new Font("����", Font.BOLD, 16));
		js = new JScrollPane(jt,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		clipboard = myJFrame.getToolkit().getSystemClipboard();// ����ϵͳ���а�
		// TODO �Զ����ɵĹ��캯�����
		JMenuBar menuBar = new JMenuBar();// �����˵���
		// ����һ���˵�
		JMenu fileMenu = newJMenu("�ļ�", "�ļ���.png");
		JMenu editMenu = newJMenu("�༭", "�༭.png");
		JMenu viewMenu = newJMenu("��ͼ", "��ͼ.png");
		JMenu aboutMenu = newJMenu("����", "����1.png");
		// ���һ���˵����˵���
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(aboutMenu);

		// ����һ���˵��ļ��˵����Ӳ˵�
		// =============================�½��˵�=====================================
		JMenu newMenu = new JMenu("�½�");
		newMenu.setIcon(new ImageIcon(this.getClass().getResource("�½�.png")));
		setSecondMenuForNew(newMenu);
		// �����Ӳ˵��Ϳ�ݼ�
		JMenuItem openMenuItem = newJMenuItem("��", "�ĵ�.png", 'O',
				Event.CTRL_MASK);
		JMenuItem saveMenuItem = newJMenuItem("����", "����.png", 'S',
				Event.CTRL_MASK);
		JMenuItem exitMenuItem = newJMenuItem("�˳�", "�˳�.png", 'E',
				Event.CTRL_MASK);
		// ����Ӳ˵���һ���˵�
		fileMenu.add(newMenu);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();// ��ӷָ���
		fileMenu.add(exitMenuItem);

		// =============================�༭�˵�=====================================
		JMenuItem copyMenuItem = newJMenuItem("����", "����.png", 'C',
				Event.CTRL_MASK);
		JMenuItem pasteMenuItem = newJMenuItem("ճ��", "ճ��.png", 'V',
				Event.CTRL_MASK);
		JMenuItem cutMenuItem = newJMenuItem("����", "�����ļ�.png", 'C',
				Event.SHIFT_MASK);
		JMenuItem fontMenuItem = newJMenuItem("����", "����.png", 'F',
				Event.ALT_MASK);
		JMenuItem colorMenuItem = newJMenuItem("��ɫ", "��ɫ.png", 'C',
				Event.ALT_MASK);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.addSeparator();
		editMenu.add(fontMenuItem);
		editMenu.add(colorMenuItem);

		// =============================��ͼ�˵�=====================================
		final JCheckBoxMenuItem cbMenu = new JCheckBoxMenuItem("��ѡ���Ӳ˵�");
		final JRadioButtonMenuItem rbMenu1 = new JRadioButtonMenuItem(
				"��ѡ��ť�Ӳ˵�1");
		final JRadioButtonMenuItem rbMenu2 = new JRadioButtonMenuItem(
				"��ѡ��ť�Ӳ˵�2");
		ButtonGroup group = new ButtonGroup();
		group.add(rbMenu1);
		group.add(rbMenu2);
		rbMenu1.setSelected(true);
		viewMenu.add(cbMenu);
		viewMenu.addSeparator();
		viewMenu.add(rbMenu1);
		viewMenu.add(rbMenu2);

		// =============================���ڲ˵�=====================================
		JMenuItem aboutMenuItem = newJMenuItem("����", "����.png", 'A',
				Event.ALT_MASK);
		aboutMenu.add(aboutMenuItem);

		// =============================�¼�����=====================================
		openMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String filePath = openFile();
				openFile(filePath);
			}

		});

		saveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				saveFile();
			}

		});

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				myJFrame.dispose();
			}

		});

		copyMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String text = jt.getSelectedText();// ���ѡ������
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);// ѡ�е��������õ����а�
			}

		});

		pasteMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Transferable contents = clipboard.getContents(this);
				DataFlavor flavor = DataFlavor.stringFlavor;
				if (contents.isDataFlavorSupported(flavor)) {
					try {
						String str = (String) contents.getTransferData(flavor);
						jt.append(str);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}

		});

		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String text = jt.getSelectedText();
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);
				int start = jt.getSelectionStart();
				int end = jt.getSelectionEnd();
				jt.replaceRange("", start, end);// ��ѡ�е�����ɾ��
			}

		});

		fontMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JFontChooser jf = new JFontChooser(myJFrame);
				font = jf.newFont;
				color = jf.newColor;
				jt.setFont(font);
				jt.setForeground(color);

			}

		});

		colorMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Color color = JColorChooser.showDialog(myJFrame, "��ɫѡ����", null);
				int alpha = color.getAlpha();
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				jt.append("\r\n" + "ѡ�����ɫΪ��" + "��͸����="
						+ String.format("%x", alpha) + "����ɫ="
						+ String.format("%x%x%x", red, green, blue) + "\r\n");
				jt.setForeground(color);
			}

		});

		cbMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(myJFrame,
						"��ѡ���Ƿ�ѡ�У�" + cbMenu.isSelected());
			}

		});

		rbMenu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(myJFrame,
						"��ѡ��ť1�Ƿ�ѡ�У�" + rbMenu1.isSelected());
			}

		});

		rbMenu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				JOptionPane.showMessageDialog(myJFrame,
						"��ѡ��ť2�Ƿ�ѡ�У�" + rbMenu2.isSelected());
			}

		});

		aboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				showCustomDialog(myJFrame, myJFrame);
			}

		});
		myJFrame.setJMenuBar(menuBar);
		myJFrame.setContentPane(js);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	public String openFile() {
		String filePath = null;
		JFileChooser jc = new JFileChooser();
		jc.setCurrentDirectory(new File("."));// ����Ĭ��ѡ���ļ���Ϊ��ǰ�ļ���
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// ����ѡ��Ľڵ㣬�ļ����ļ��ж�����
		jc.setMultiSelectionEnabled(false);// �������ѡ
		jc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				// TODO �Զ����ɵķ������
				return f.isDirectory()
						|| f.getName().toLowerCase().endsWith(".doc")
						|| f.getName().toLowerCase().endsWith(".docx");
			}

			@Override
			public String getDescription() {
				// TODO �Զ����ɵķ������
				return "*.doc,*.docx";
			}

		});
		int res = jc.showOpenDialog(myJFrame);// ����ѡ�����ĳ���λ�ã�����ʱ��������������������м�λ�ã��������ֵΪnull�������Ļ�м���ʾ����������Ӧ��ѡ��ֵ
		if (res == JFileChooser.APPROVE_OPTION) {// ���ݷ��ص�ѡ��ֵ����Ӧ�Ĳ���
			File file = jc.getSelectedFile();
			jt.append("ѡ����ļ�Ϊ��" + file.getAbsolutePath() + "\r\n");
			filePath = file.getAbsolutePath();
		}
		return filePath;
	}

	public void saveFile() {
		JFileChooser jc = new JFileChooser();
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int res = jc.showSaveDialog(myJFrame);
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = jc.getSelectedFile();
			jt.append("�����ļ�����" + file.getAbsolutePath() + "\r\n");
		}
	}

	public void openFile(String filePath) {
		if (filePath != null) {
			Desktop desktop = Desktop.getDesktop();
			Runtime runtime = Runtime.getRuntime();
			try {
				if (Desktop.isDesktopSupported()) {
					if (desktop.isSupported(Desktop.Action.OPEN)) {
						File file = new File(filePath);
						desktop.open(file);
					} else {
						runtime.exec("rundll32 url.dll FileProtocolHandler"
								+ " " + filePath);
					}
				} else {
					runtime.exec("cmd /c start" + " " + filePath);
				}
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}

		}
	}

	public void showCustomDialog(Frame owner, Component parentComponent) {
		final JDialog dialog = new JDialog(owner, "��Ϣ", false);// FALSE����ʾ�Ի���ĸ������ڿ���������������ģ̬��
		dialog.setSize(250, 200);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(parentComponent);
		JLabel messageLabel = new JLabel("����һ�����Դ���!");
		messageLabel.setBackground(Color.WHITE);
		JButton btn = new JButton("ȷ��");
		btn.setSize(30, 20);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				dialog.dispose();
			}

		});
		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(Color.WHITE);
		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.add(btn);
		jp.add(messageLabel, BorderLayout.CENTER);
		jp.add(jp1, BorderLayout.SOUTH);
		dialog.setContentPane(jp);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void setSecondMenuForNew(JMenu menu) {
		JMenuItem word = newJMenuItem("WORD.png", 'W', Event.CTRL_MASK);
		JMenuItem excel = newJMenuItem("ECEL.png", 'E', Event.CTRL_MASK);
		JMenuItem ppt = newJMenuItem("PPT.png", 'P', Event.CTRL_MASK);
		JMenuItem pdf = newJMenuItem("PDF.png", 'P', Event.ALT_MASK);
		JMenuItem email = newJMenuItem("�����ʼ�.png", 'E', Event.ALT_MASK);
		JMenuItem txt = newJMenuItem("txt.png", 'T', Event.CTRL_MASK);

		menu.add(word);
		menu.add(excel);
		menu.add(ppt);
		menu.add(email);
		menu.add(pdf);
		menu.add(txt);

		setActionListener(word, "cmd /c start winword");
		setActionListener(excel, "cmd /c start excel");
		setActionListener(ppt, "cmd /c start powerpnt");
		String pdfPath = "C:\\Program Files (x86)\\Adobe\\Reader 11.0\\Reader\\AcroRd32.exe";
		pdfPath = "\"" + pdfPath + "\"";// ·��ǰ������ţ����·���к��ո�����ŵ�����
		setActionListener(pdf, pdfPath);
		setActionListener(email, "cmd /c start outlook");
		setActionListener(txt, "cmd /c start notepad");

	}

	public void setActionListener(JMenuItem item, final String startApp) {
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					Runtime.getRuntime().exec(startApp);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}

		});
	}

	public JMenu newJMenu(String title, String pictureName) {
		JMenu menu = new JMenu(title);
		menu.setIcon(new ImageIcon(this.getClass().getResource(pictureName)));
		return menu;
	}

	public JMenuItem newJMenuItem(String pictureName, char key, int modifiers) {
		JMenuItem item = new JMenuItem();
		item.setIcon(new ImageIcon(this.getClass().getResource(pictureName)));
		item.setMnemonic(key);
		item.setAccelerator(KeyStroke.getKeyStroke(key, modifiers));
		return item;
	}

	public JMenuItem newJMenuItem(String title, String pictureName, char key,
			int modifiers) {
		JMenuItem item = new JMenuItem(title);
		item.setIcon(new ImageIcon(this.getClass().getResource(pictureName)));
		item.setMnemonic(key);
		item.setAccelerator(KeyStroke.getKeyStroke(key, modifiers));
		return item;
	}

	/*
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJMenu tb = new TestJMenu();
	}
}
