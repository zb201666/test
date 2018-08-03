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
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		// TODO 自动生成的构造函数存根
		JPanel jp = new JPanel();
		final JTextArea jta = new JTextArea(10, 30);
		jta.setLineWrap(true);
		jp.add(jta);
		JButton btn1 = new JButton("打开");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				showFileOpenDialog(myJFrame, jta);
			}
		});
		jp.add(btn1);

		JButton btn2 = new JButton("保存");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
		// TODO 自动生成的方法存根
		JFileChooser jc = new JFileChooser();
		jc.setCurrentDirectory(new File("."));// 设置默认选择文件夹为当前文件夹
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// 设置选择的节点，文件和文件夹都可以
		jc.setMultiSelectionEnabled(false);// 不允许多选
		jc.addChoosableFileFilter(new FileNameExtensionFilter(
				"zip(*.zip, *.rar)", "zip", "rar"));// 设置文件过滤器，参数一为描述，后面的参数为不定参数，均为文件类型
		jc.setFileFilter(new FileNameExtensionFilter(
				"image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
		jc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				// TODO 自动生成的方法存根
				return f.isDirectory()
						|| f.getName().toLowerCase().endsWith(".xls")
						|| f.getName().toLowerCase().endsWith(".xlsx");
			}

			@Override
			public String getDescription() {
				// TODO 自动生成的方法存根
				return "*.xls,*.xlsx";
			}

		});
		int res = jc.showOpenDialog(myJFrame);// 设置选择器的出现位置（出现时尽量靠近传入的容器的中间位置，如果传入值为null则紧靠屏幕中间显示）并返回相应的选择值
		if (res == JFileChooser.APPROVE_OPTION) {// 根据返回的选择值作相应的操作
			File file = jc.getSelectedFile();
			jta.append("选择的文件为：" + file.getAbsolutePath() + "\r\n");
		}
	}

	private void showFileSaveDialog(JFrame myJFrame, JTextArea jta) {
		// TODO 自动生成的方法存根
		JFileChooser jc = new JFileChooser();
		// jc.setSelectedFile(new File("请输入文件名.文件后缀"));
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int res = jc.showSaveDialog(myJFrame);
		if (res == JFileChooser.APPROVE_OPTION) {
			File file = jc.getSelectedFile();
			jta.append("保存文件到：" + file.getAbsolutePath() + "\r\n");
		}
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJFileChooser tb = new TestJFileChooser();
	}
}
