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

		// 得到每个节点的TreeNode
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

		// 得到每个节点的text
		String str = node.toString();
		// 判断是哪个文本的节点设置对应的值（这里如果节点传入的是一个实体,则可以根据实体里面的一个类型属性来显示对应的图标）
		if (str == "中国") {
			this.setIcon(new ImageIcon(this.getClass().getResource("中国.png")));
		} else if (str == "四川") {
			this.setIcon(new ImageIcon(this.getClass().getResource("四川.png")));
		} else if (str == "云南") {
			this.setIcon(new ImageIcon(this.getClass().getResource("云南.png")));
		} else if (str == "重庆") {
			this.setIcon(new ImageIcon(this.getClass().getResource("重庆市.png")));
		} else if (str == "贵州") {
			this.setIcon(new ImageIcon(this.getClass().getResource("贵州省.png")));
		} else {
			this.setIcon(new ImageIcon(this.getClass().getResource("城市.png")));
		}

		return this;
	}
}
