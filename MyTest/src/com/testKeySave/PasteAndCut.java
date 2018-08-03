package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PasteAndCut implements ActionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new PasteAndCut();
	}

	private JFrame jf;
	private JPanel p1, p2, p3; // 上中下
	private JLabel title;
	private JTextArea edit, showMsg;
	private JButton copy, paste, cut;
	Clipboard clipboard;// 获取系统剪贴板。

	public PasteAndCut() {
		this.init();
	}

	// 界面初始化
	public void init() {
		jf = new JFrame("复制粘贴");
		p1 = new JPanel(); // 存放标题
		p2 = new JPanel(); // 存放JTextArea showMsg
		p3 = new JPanel(); // 存放 button
		title = new JLabel("复制粘贴剪切演示");
		edit = new JTextArea("请输入内容", 15, 25);
		edit.setLineWrap(true);
		showMsg = new JTextArea(15, 25);
		showMsg.setLineWrap(true);
		showMsg.setEnabled(false);
		copy = new JButton("复制");
		paste = new JButton("粘贴");
		cut = new JButton("剪切");
		clipboard = jf.getToolkit().getSystemClipboard();

		p1.setLayout(new FlowLayout());
		p1.setSize(599, 30);
		p1.add(title);

		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.gray);
		p2.add(edit);
		p2.add(showMsg);

		p3.setLayout(new FlowLayout());
		p3.add(copy);
		p3.add(paste);
		p3.add(cut);

		// 添加事件监听机制
		copy.addActionListener(this);
		paste.addActionListener(this);
		cut.addActionListener(this);

		// this.copyStr(copy);
		jf.add(p1, BorderLayout.NORTH);
		jf.add(p2, BorderLayout.CENTER);
		jf.add(p3, BorderLayout.SOUTH);
		jf.setLocation(400, 200);
		jf.setSize(600, 450);
		jf.setResizable(false);
		jf.setVisible(true);
	}

	// 事件处理
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == copy) {
			String tempText = edit.getSelectedText(); // 拖动鼠标选取文本
			// 创建能传输指定 String 的 Transferable。
			StringSelection editText = new StringSelection(tempText);
			/**
			 * 将剪贴板的当前内容设置到指定的 transferable 对象， 并将指定的剪贴板所有者作为新内容的所有者注册。
			 */
			clipboard.setContents(editText, null);
		} else if (e.getSource() == cut) {
			String tempText = edit.getSelectedText();
			StringSelection editText = new StringSelection(tempText);
			clipboard.setContents(editText, null);
			int start = edit.getSelectionStart();
			int end = edit.getSelectionEnd();
			edit.replaceRange("", start, end); // 从edit中删除被选取的文本。
		} else if (e.getSource() == paste) {
			Transferable contents = clipboard.getContents(this);
			DataFlavor flavor = DataFlavor.stringFlavor;
			if (contents.isDataFlavorSupported(flavor)) {
				try {
					String str;
					str = (String) contents.getTransferData(flavor);
					showMsg.append(str);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
