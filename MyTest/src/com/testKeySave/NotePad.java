package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

public class NotePad extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2332737745458877684L;
	private JTextArea text = null; // 定义文本区域
	private JScrollPane jScrollPane = null; // 定义滚动条面板
	private JMenuBar menuBar = null; // 定义JMenuBar
	private JMenu menuFile, menuSet = null; // 定义菜单对象
	private JMenuItem newItem, openItem, saveItem, exitItem = null; // 定义文件菜单各个菜单项组件
	private JMenuItem fontItem, colorItem = null; // 定义设置菜单的菜单项组件
	private JLabel timeLabel, numberLabel = null; // 状态栏显示系统时间
	private JButton openButton, saveButton;
	private JFileChooser jFileChooser;

	public NotePad() {
		initNotepade();
		init();
		setTitle("我的记事本");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setJMenuBar(menuBar); // 在窗体中加入JMenuBar组件
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		openButton = new JButton("打开");
		saveButton = new JButton("保存");
		add(openButton, BorderLayout.NORTH);
		add(saveButton, BorderLayout.SOUTH);
		saveButton.addActionListener(this);
		openButton.addActionListener(this);
	}

	public void init() {
		text = new JTextArea();
		text.setFont(new Font("宋体", Font.BOLD, 20));
		text.setEditable(true); // 设置文本域组件可编辑
		jScrollPane = new JScrollPane(text);
		add(jScrollPane, BorderLayout.CENTER);
		menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		menuFile = new JMenu("文件");
		menuFile.setIcon(new ImageIcon(this.getClass().getResource("文件夹.png")));
		menuSet = new JMenu("设置");
		menuSet.setIcon(new ImageIcon(this.getClass().getResource("设置.png")));
		menuBar.add(menuFile);
		menuBar.add(menuSet);
		newItem = new JMenuItem("新建", new ImageIcon(this.getClass()
				.getResource("新建.png")));
		openItem = new JMenuItem("打开", new ImageIcon(this.getClass()
				.getResource("文档.png")));
		saveItem = new JMenuItem("保存", new ImageIcon(this.getClass()
				.getResource("保存.png")));
		exitItem = new JMenuItem("退出", new ImageIcon(this.getClass()
				.getResource("退出.png")));
		newItem.setMnemonic('N');
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',
				java.awt.Event.CTRL_MASK));// 设置快捷键 Ctrl+N
		openItem.setMnemonic('O');
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',
				java.awt.Event.CTRL_MASK));// 设置快捷键 Ctrl+O
		saveItem.setMnemonic('S');
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S',
				java.awt.Event.CTRL_MASK));// 设置快捷键Ctrl+S
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		menuFile.add(newItem);
		menuFile.add(openItem);
		menuFile.add(saveItem);
		menuFile.addSeparator();
		menuFile.add(exitItem);
		fontItem = new JMenuItem("字体设置", new ImageIcon(this.getClass()
				.getResource("字体.png")));
		menuSet.add(fontItem);
		fontItem.addActionListener(this);
		colorItem = new JMenuItem("颜色设置", new ImageIcon(this.getClass()
				.getResource("颜色.png")));
		menuSet.add(colorItem);
		colorItem.addActionListener(this);
		timeLabel = new JLabel();
		add(timeLabel, BorderLayout.SOUTH);
		numberLabel = new JLabel();
		numberLabel.setBounds(100, 100, 100, 100);
		numberLabel.setFont(new Font("宋体", Font.BOLD, 60));
		text.add(numberLabel);
	}

	public static void main(String[] args) {
		new NotePad();
	}

	public void initNotepade() {
		jFileChooser = new JFileChooser();
		jFileChooser.addChoosableFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				if (f.getName().endsWith(".txt")) {
					return true;
				}
				return false;
			}

			@Override
			public String getDescription() {
				return "*.txt";
			}
		});
	}

	InputStream inputStream = null;

	public void openFile(File file) {
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[(int) file.length()];
			inputStream.read(b);
			text.setText(new String(b, "GB2312"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	OutputStream outputStream = null;

	public void saveFile(File file) {
		try {
			outputStream = new FileOutputStream(file);
			String string = text.getText();
			outputStream.write(string.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newItem) {
			JOptionPane.showMessageDialog(null, "新建文件");
		}
		if (e.getSource() == openItem) {
			JOptionPane.showMessageDialog(null, "打开文件");
			jFileChooser.setDialogTitle("打开文件");
			int result = jFileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				if (!file.exists()) {
					JOptionPane.showMessageDialog(this, file + "指定的文件不存在！",
							"文件不存在", JOptionPane.OK_OPTION);// 显示一个对话框来实现是否覆盖源文件
				} else {
					openFile(file);
				}
			}
		}
		if (e.getSource() == saveItem) {
			JOptionPane.showMessageDialog(null, "保存文件");
			jFileChooser.setDialogTitle("保存文件");
			int result = jFileChooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				if (file.exists()) {
					int opt = JOptionPane
							.showConfirmDialog(this, file + "文件已经存在,是否覆盖!",
									"文件存在", JOptionPane.YES_NO_OPTION);// 显示一个对话框来实现是否覆盖源文件
					if (JOptionPane.YES_OPTION != opt)
						return;
				}
				saveFile(file);
			}
		}
		if (e.getSource() == exitItem) {
			this.dispose();
		}
	}

	public void time() {
		Date date = new Date();// 创建日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = sdf.format(date);
		timeLabel.setText(timeString);
	}

	public void number() {
		int randomNumber = (int) (Math.random() * 47 + 1);
		String newRandom = String.valueOf(randomNumber);
		numberLabel.setText(newRandom);
	}
}
