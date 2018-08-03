package com.doSomethingForFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class MySearchAllFilesFrame extends JFrame {
	private JFrame myFrame = null;
	private JPanel jp1 = null;
	private JPanel jp2 = null;
	private JPanel jp3 = null;
	private JTextField jfa = null;
	private JTextArea jta = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104293877920330939L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new MySearchAllFilesFrame();
	}

	public MySearchAllFilesFrame() {
		myFrame = new JFrame("检索文件");
		myFrame.setSize(800, 600);
		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel();
		jp3 = new JPanel();
		JLabel lb1 = new JLabel("请输入文件路径：");
		JLabel lb2 = new JLabel("     ");
		jfa = new JTextField();
		jfa.setColumns(50);
		jp2.add(lb1);
		jp2.add(lb2);
		jp2.add(jfa);
		jp1.add(jp2, BorderLayout.NORTH);
		jta = new JTextArea();
		jta.setBackground(Color.WHITE);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setFont(new Font("宋体", Font.BOLD, 16));
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp1.add(jsp, BorderLayout.CENTER);
		JButton startBtn = new JButton("确定");
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jta.setText("");
				if (check() == false) {
					jta.setForeground(Color.RED);
					jta.append("请输入需要检索的文件路径！");
				} else {
					jta.setText("");
					searchAllFiles(jfa.getText());
				}
			}

		});
		JButton closeBtn = new JButton("关闭");
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				myFrame.dispose();
			}

		});
		jp3.add(startBtn);
		jp3.add(closeBtn);
		jp1.add(jp3, BorderLayout.SOUTH);
		myFrame.setContentPane(jp1);
		myFrame.setBackground(Color.WHITE);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.setLocationRelativeTo(null);

	}

	private boolean check() {
		if (jfa.getText() == null || jfa.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	private void searchAllFiles(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			jta.setForeground(Color.BLUE);
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File f : files) {
					if (f.isDirectory()) {
						searchAllFiles(f.getAbsolutePath());
					}
					if (f.isFile()) {
						jta.append(f.getAbsolutePath());
						jta.append("\r\n");
						jta.append(f.getName());
						jta.append("\r\n");
						jta.append("========================");
						jta.append("\r\n");
					}
				}
			} else {
				jta.append(file.getAbsolutePath());
				jta.append("\r\n");
				jta.append(file.getName());
				jta.append("\r\n");
				jta.append("========================");
				jta.append("\r\n");
			}

		} else {
			jta.setForeground(Color.RED);
			jta.append("文件不存在!");
		}
	}
}
