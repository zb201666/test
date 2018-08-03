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
	private JTextArea text = null; // �����ı�����
	private JScrollPane jScrollPane = null; // ������������
	private JMenuBar menuBar = null; // ����JMenuBar
	private JMenu menuFile, menuSet = null; // ����˵�����
	private JMenuItem newItem, openItem, saveItem, exitItem = null; // �����ļ��˵������˵������
	private JMenuItem fontItem, colorItem = null; // �������ò˵��Ĳ˵������
	private JLabel timeLabel, numberLabel = null; // ״̬����ʾϵͳʱ��
	private JButton openButton, saveButton;
	private JFileChooser jFileChooser;

	public NotePad() {
		initNotepade();
		init();
		setTitle("�ҵļ��±�");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setJMenuBar(menuBar); // �ڴ����м���JMenuBar���
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		openButton = new JButton("��");
		saveButton = new JButton("����");
		add(openButton, BorderLayout.NORTH);
		add(saveButton, BorderLayout.SOUTH);
		saveButton.addActionListener(this);
		openButton.addActionListener(this);
	}

	public void init() {
		text = new JTextArea();
		text.setFont(new Font("����", Font.BOLD, 20));
		text.setEditable(true); // �����ı�������ɱ༭
		jScrollPane = new JScrollPane(text);
		add(jScrollPane, BorderLayout.CENTER);
		menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		menuFile = new JMenu("�ļ�");
		menuFile.setIcon(new ImageIcon(this.getClass().getResource("�ļ���.png")));
		menuSet = new JMenu("����");
		menuSet.setIcon(new ImageIcon(this.getClass().getResource("����.png")));
		menuBar.add(menuFile);
		menuBar.add(menuSet);
		newItem = new JMenuItem("�½�", new ImageIcon(this.getClass()
				.getResource("�½�.png")));
		openItem = new JMenuItem("��", new ImageIcon(this.getClass()
				.getResource("�ĵ�.png")));
		saveItem = new JMenuItem("����", new ImageIcon(this.getClass()
				.getResource("����.png")));
		exitItem = new JMenuItem("�˳�", new ImageIcon(this.getClass()
				.getResource("�˳�.png")));
		newItem.setMnemonic('N');
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',
				java.awt.Event.CTRL_MASK));// ���ÿ�ݼ� Ctrl+N
		openItem.setMnemonic('O');
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',
				java.awt.Event.CTRL_MASK));// ���ÿ�ݼ� Ctrl+O
		saveItem.setMnemonic('S');
		saveItem.setAccelerator(KeyStroke.getKeyStroke('S',
				java.awt.Event.CTRL_MASK));// ���ÿ�ݼ�Ctrl+S
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		menuFile.add(newItem);
		menuFile.add(openItem);
		menuFile.add(saveItem);
		menuFile.addSeparator();
		menuFile.add(exitItem);
		fontItem = new JMenuItem("��������", new ImageIcon(this.getClass()
				.getResource("����.png")));
		menuSet.add(fontItem);
		fontItem.addActionListener(this);
		colorItem = new JMenuItem("��ɫ����", new ImageIcon(this.getClass()
				.getResource("��ɫ.png")));
		menuSet.add(colorItem);
		colorItem.addActionListener(this);
		timeLabel = new JLabel();
		add(timeLabel, BorderLayout.SOUTH);
		numberLabel = new JLabel();
		numberLabel.setBounds(100, 100, 100, 100);
		numberLabel.setFont(new Font("����", Font.BOLD, 60));
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
			JOptionPane.showMessageDialog(null, "�½��ļ�");
		}
		if (e.getSource() == openItem) {
			JOptionPane.showMessageDialog(null, "���ļ�");
			jFileChooser.setDialogTitle("���ļ�");
			int result = jFileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				if (!file.exists()) {
					JOptionPane.showMessageDialog(this, file + "ָ�����ļ������ڣ�",
							"�ļ�������", JOptionPane.OK_OPTION);// ��ʾһ���Ի�����ʵ���Ƿ񸲸�Դ�ļ�
				} else {
					openFile(file);
				}
			}
		}
		if (e.getSource() == saveItem) {
			JOptionPane.showMessageDialog(null, "�����ļ�");
			jFileChooser.setDialogTitle("�����ļ�");
			int result = jFileChooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				if (file.exists()) {
					int opt = JOptionPane
							.showConfirmDialog(this, file + "�ļ��Ѿ�����,�Ƿ񸲸�!",
									"�ļ�����", JOptionPane.YES_NO_OPTION);// ��ʾһ���Ի�����ʵ���Ƿ񸲸�Դ�ļ�
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
		Date date = new Date();// �������ڶ���
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
