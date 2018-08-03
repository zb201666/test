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
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jt = new JTextArea();
		jt.setBackground(Color.WHITE);
		jt.setLineWrap(true);
		jt.setWrapStyleWord(false);
		jt.setFont(new Font("宋体", Font.BOLD, 16));
		js = new JScrollPane(jt,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		clipboard = myJFrame.getToolkit().getSystemClipboard();// 调用系统剪切板
		// TODO 自动生成的构造函数存根
		JMenuBar menuBar = new JMenuBar();// 创建菜单栏
		// 创建一级菜单
		JMenu fileMenu = newJMenu("文件", "文件夹.png");
		JMenu editMenu = newJMenu("编辑", "编辑.png");
		JMenu viewMenu = newJMenu("视图", "视图.png");
		JMenu aboutMenu = newJMenu("关于", "关于1.png");
		// 添加一级菜单到菜单栏
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(aboutMenu);

		// 创建一级菜单文件菜单的子菜单
		// =============================新建菜单=====================================
		JMenu newMenu = new JMenu("新建");
		newMenu.setIcon(new ImageIcon(this.getClass().getResource("新建.png")));
		setSecondMenuForNew(newMenu);
		// 设置子菜单和快捷键
		JMenuItem openMenuItem = newJMenuItem("打开", "文档.png", 'O',
				Event.CTRL_MASK);
		JMenuItem saveMenuItem = newJMenuItem("保存", "保存.png", 'S',
				Event.CTRL_MASK);
		JMenuItem exitMenuItem = newJMenuItem("退出", "退出.png", 'E',
				Event.CTRL_MASK);
		// 添加子菜单到一级菜单
		fileMenu.add(newMenu);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();// 添加分割线
		fileMenu.add(exitMenuItem);

		// =============================编辑菜单=====================================
		JMenuItem copyMenuItem = newJMenuItem("复制", "复制.png", 'C',
				Event.CTRL_MASK);
		JMenuItem pasteMenuItem = newJMenuItem("粘贴", "粘贴.png", 'V',
				Event.CTRL_MASK);
		JMenuItem cutMenuItem = newJMenuItem("剪切", "剪切文件.png", 'C',
				Event.SHIFT_MASK);
		JMenuItem fontMenuItem = newJMenuItem("字体", "字体.png", 'F',
				Event.ALT_MASK);
		JMenuItem colorMenuItem = newJMenuItem("颜色", "颜色.png", 'C',
				Event.ALT_MASK);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.addSeparator();
		editMenu.add(fontMenuItem);
		editMenu.add(colorMenuItem);

		// =============================视图菜单=====================================
		final JCheckBoxMenuItem cbMenu = new JCheckBoxMenuItem("复选框子菜单");
		final JRadioButtonMenuItem rbMenu1 = new JRadioButtonMenuItem(
				"单选按钮子菜单1");
		final JRadioButtonMenuItem rbMenu2 = new JRadioButtonMenuItem(
				"单选按钮子菜单2");
		ButtonGroup group = new ButtonGroup();
		group.add(rbMenu1);
		group.add(rbMenu2);
		rbMenu1.setSelected(true);
		viewMenu.add(cbMenu);
		viewMenu.addSeparator();
		viewMenu.add(rbMenu1);
		viewMenu.add(rbMenu2);

		// =============================关于菜单=====================================
		JMenuItem aboutMenuItem = newJMenuItem("关于", "关于.png", 'A',
				Event.ALT_MASK);
		aboutMenu.add(aboutMenuItem);

		// =============================事件监听=====================================
		openMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String filePath = openFile();
				openFile(filePath);
			}

		});

		saveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				saveFile();
			}

		});

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				myJFrame.dispose();
			}

		});

		copyMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String text = jt.getSelectedText();// 鼠标选中内容
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);// 选中的内容设置到剪切板
			}

		});

		pasteMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Transferable contents = clipboard.getContents(this);
				DataFlavor flavor = DataFlavor.stringFlavor;
				if (contents.isDataFlavorSupported(flavor)) {
					try {
						String str = (String) contents.getTransferData(flavor);
						jt.append(str);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}

		});

		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String text = jt.getSelectedText();
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);
				int start = jt.getSelectionStart();
				int end = jt.getSelectionEnd();
				jt.replaceRange("", start, end);// 将选中的内容删除
			}

		});

		fontMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				Color color = JColorChooser.showDialog(myJFrame, "颜色选择器", null);
				int alpha = color.getAlpha();
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				jt.append("\r\n" + "选择的颜色为：" + "不透明度="
						+ String.format("%x", alpha) + "，颜色="
						+ String.format("%x%x%x", red, green, blue) + "\r\n");
				jt.setForeground(color);
			}

		});

		cbMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane.showMessageDialog(myJFrame,
						"复选框是否被选中：" + cbMenu.isSelected());
			}

		});

		rbMenu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane.showMessageDialog(myJFrame,
						"单选按钮1是否被选中：" + rbMenu1.isSelected());
			}

		});

		rbMenu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane.showMessageDialog(myJFrame,
						"单选按钮2是否被选中：" + rbMenu2.isSelected());
			}

		});

		aboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
		jc.setCurrentDirectory(new File("."));// 设置默认选择文件夹为当前文件夹
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// 设置选择的节点，文件和文件夹都可以
		jc.setMultiSelectionEnabled(false);// 不允许多选
		jc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				// TODO 自动生成的方法存根
				return f.isDirectory()
						|| f.getName().toLowerCase().endsWith(".doc")
						|| f.getName().toLowerCase().endsWith(".docx");
			}

			@Override
			public String getDescription() {
				// TODO 自动生成的方法存根
				return "*.doc,*.docx";
			}

		});
		int res = jc.showOpenDialog(myJFrame);// 设置选择器的出现位置（出现时尽量靠近传入的容器的中间位置，如果传入值为null则紧靠屏幕中间显示）并返回相应的选择值
		if (res == JFileChooser.APPROVE_OPTION) {// 根据返回的选择值作相应的操作
			File file = jc.getSelectedFile();
			jt.append("选择的文件为：" + file.getAbsolutePath() + "\r\n");
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
			jt.append("保存文件到：" + file.getAbsolutePath() + "\r\n");
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
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

		}
	}

	public void showCustomDialog(Frame owner, Component parentComponent) {
		final JDialog dialog = new JDialog(owner, "信息", false);// FALSE：表示对话框的父级窗口可以正常操作（非模态）
		dialog.setSize(250, 200);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(parentComponent);
		JLabel messageLabel = new JLabel("这是一个测试窗口!");
		messageLabel.setBackground(Color.WHITE);
		JButton btn = new JButton("确定");
		btn.setSize(30, 20);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
		JMenuItem email = newJMenuItem("电子邮件.png", 'E', Event.ALT_MASK);
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
		pdfPath = "\"" + pdfPath + "\"";// 路径前后加引号，解决路径中含空格和括号的问题
		setActionListener(pdf, pdfPath);
		setActionListener(email, "cmd /c start outlook");
		setActionListener(txt, "cmd /c start notepad");

	}

	public void setActionListener(JMenuItem item, final String startApp) {
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					Runtime.getRuntime().exec(startApp);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
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
		// TODO 自动生成的方法存根
		TestJMenu tb = new TestJMenu();
	}
}
