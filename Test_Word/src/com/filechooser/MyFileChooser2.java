package com.filechooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

public class MyFileChooser2 extends JFrame {

	private JPanel contentPane;
	private JTextField extNameField;
	private JTable table;
	private File dir;
	private JLabel label;

	private static final long serialVersionUID = -6263975104443132420L;

	/**
	 * 自定义扩展名过滤器
	 */
	private final class CustomFilter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			// 获取用户设置的指定扩展名
			String extName = extNameField.getText();
			if (extName == null || extName.isEmpty()) {
				return false;
			}

			if (!extName.startsWith(".")) {// 判断扩展名
				extName = "." + extName;// 获取扩展名
			}

			extName = extName.toLowerCase();
			// 判断扩展名与过滤文件名是否符合要求
			if (pathname.getName().toLowerCase().endsWith(extName)) {
				return true;
			} else {
				return false;
			}
		}
	}

	static class MyWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	/**
	 * 绘制应用的界面
	 */
	public MyFileChooser2() {
		setTitle("显示指定类型的文件");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel, BorderLayout.NORTH);

		JButton button = new JButton("选择文件夹");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});

		label = new JLabel("文件夹");

		JLabel label_1 = new JLabel("输入指定文件扩展名称（.*）：");

		extNameField = new JTextField();
		extNameField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				do_extNameField_caretUpdate(e);
			}
		});
		extNameField.setText("");
		extNameField.setBounds(0, 0, 20, 10);

		panel.add(button, BorderLayout.NORTH);
		panel.add(label, BorderLayout.NORTH);
		panel.add(label_1, BorderLayout.SOUTH);
		panel.add(extNameField, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"文件名称", "文件大小", "修改日期" }) {
			private static final long serialVersionUID = 5274214559103654856L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		scrollPane.setViewportView(table);
	}

	/**
	 * 选择文件夹按钮的事件处理方法
	 */
	protected void do_button_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();// 创建文件选择器
		// 设置选择器的过滤器
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showDialog(this, null);
		dir = chooser.getSelectedFile();
		getLabel().setText(dir.toString());
		// 获取过滤后的符合条件的文件数组
		listFiles();
	}

	/**
	 * 显示文件夹中的文件
	 */
	private void listFiles() {
		if (dir == null)
			return;
		// 获取符合条件的文件数组
		File[] files = dir.listFiles(new CustomFilter());
		// 获取表格的数据模型
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (File file : files) {// 遍历文件数组
			// 创建表格行数据
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Object[] row = { file.getName(), file.length() / 1024 + "KB",
					sdf.format(new Date(file.lastModified())) };
			model.addRow(row);// 添加行数据到表格模型
		}
	}

	protected void do_extNameField_caretUpdate(CaretEvent e) {
		listFiles();
	}

	protected JLabel getLabel() {
		return label;
	}
}
