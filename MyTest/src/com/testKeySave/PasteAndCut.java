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
		// TODO �Զ����ɵķ������
		new PasteAndCut();
	}

	private JFrame jf;
	private JPanel p1, p2, p3; // ������
	private JLabel title;
	private JTextArea edit, showMsg;
	private JButton copy, paste, cut;
	Clipboard clipboard;// ��ȡϵͳ�����塣

	public PasteAndCut() {
		this.init();
	}

	// �����ʼ��
	public void init() {
		jf = new JFrame("����ճ��");
		p1 = new JPanel(); // ��ű���
		p2 = new JPanel(); // ���JTextArea showMsg
		p3 = new JPanel(); // ��� button
		title = new JLabel("����ճ��������ʾ");
		edit = new JTextArea("����������", 15, 25);
		edit.setLineWrap(true);
		showMsg = new JTextArea(15, 25);
		showMsg.setLineWrap(true);
		showMsg.setEnabled(false);
		copy = new JButton("����");
		paste = new JButton("ճ��");
		cut = new JButton("����");
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

		// ����¼���������
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

	// �¼�����
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == copy) {
			String tempText = edit.getSelectedText(); // �϶����ѡȡ�ı�
			// �����ܴ���ָ�� String �� Transferable��
			StringSelection editText = new StringSelection(tempText);
			/**
			 * ��������ĵ�ǰ�������õ�ָ���� transferable ���� ����ָ���ļ�������������Ϊ�����ݵ�������ע�ᡣ
			 */
			clipboard.setContents(editText, null);
		} else if (e.getSource() == cut) {
			String tempText = edit.getSelectedText();
			StringSelection editText = new StringSelection(tempText);
			clipboard.setContents(editText, null);
			int start = edit.getSelectionStart();
			int end = edit.getSelectionEnd();
			edit.replaceRange("", start, end); // ��edit��ɾ����ѡȡ���ı���
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
