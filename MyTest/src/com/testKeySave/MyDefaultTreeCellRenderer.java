package com.testKeySave;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3783046941634180074L;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);

		setText(value.toString());
		if (sel) {
			setForeground(getTextSelectionColor());
		} else {
			setForeground(getTextNonSelectionColor());
		}

		// �õ�ÿ���ڵ��TreeNode
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

		// �õ�ÿ���ڵ��text
		String str = node.toString();
		// �ж����ĸ��ı��Ľڵ����ö�Ӧ��ֵ����������ڵ㴫�����һ��ʵ��,����Ը���ʵ�������һ��������������ʾ��Ӧ��ͼ�꣩
		if (str == "�й�") {
			this.setIcon(new ImageIcon(this.getClass().getResource("�й�.png")));
		} else if (str == "�Ĵ�") {
			this.setIcon(new ImageIcon(this.getClass().getResource("�Ĵ�.png")));
		} else if (str == "����") {
			this.setIcon(new ImageIcon(this.getClass().getResource("����.png")));
		} else if (str == "����") {
			this.setIcon(new ImageIcon(this.getClass().getResource("������.png")));
		} else if (str == "����") {
			this.setIcon(new ImageIcon(this.getClass().getResource("����ʡ.png")));
		} else {
			this.setIcon(new ImageIcon(this.getClass().getResource("����.png")));
		}

		return this;
	}
}
