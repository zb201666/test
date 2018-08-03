package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class TestJTree extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public JTextArea jta = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJTree() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		jta = new JTextArea();
		DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode("中国");// 创建根节点

		// 创建二级节点
		DefaultMutableTreeNode scnode = new DefaultMutableTreeNode("四川");
		DefaultMutableTreeNode cqnode = new DefaultMutableTreeNode("重庆");
		DefaultMutableTreeNode gznode = new DefaultMutableTreeNode("贵州");
		DefaultMutableTreeNode ynnode = new DefaultMutableTreeNode("云南");
		// 将二级节点加入根节点
		rootnode.add(scnode);
		rootnode.add(cqnode);
		rootnode.add(gznode);
		rootnode.add(ynnode);
		// 创建叶节点
		DefaultMutableTreeNode cdnode = new DefaultMutableTreeNode("成都");
		DefaultMutableTreeNode mynode = new DefaultMutableTreeNode("绵阳");
		DefaultMutableTreeNode ganode = new DefaultMutableTreeNode("广安");
		// 将叶节点加入二级节点中
		scnode.add(cdnode);
		scnode.add(mynode);
		scnode.add(ganode);
		DefaultMutableTreeNode gynode = new DefaultMutableTreeNode("贵阳");
		DefaultMutableTreeNode zynode = new DefaultMutableTreeNode("遵义");
		gznode.add(gynode);
		gznode.add(zynode);
		DefaultMutableTreeNode kmnode = new DefaultMutableTreeNode("昆明");
		DefaultMutableTreeNode xglanode = new DefaultMutableTreeNode("香格里拉");
		ynnode.add(kmnode);
		ynnode.add(xglanode);

		JTree tree = new JTree(rootnode);// 使用根节点创建树
		tree.setShowsRootHandles(true);// 显示根节点句柄
		tree.setEditable(true);// 设置树节点可编辑
		String[] path = { "成都" };
		TreePath treepath = new TreePath(path);
		tree.setSelectionPath(treepath);// 设置初始被选中的节点

		MyDefaultTreeCellRenderer renderer = new MyDefaultTreeCellRenderer();// 树节点渲染器
		renderer.setFont(new Font("宋体", Font.BOLD, 14));
		renderer.setTextSelectionColor(Color.RED);
		renderer.setTextNonSelectionColor(Color.BLUE);
		tree.setCellRenderer(renderer);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO 自动生成的方法存根
				jta.setText("当前被选中的节点：" + e.getPath() + "；当前被选中的节点路径上的节点数："
						+ e.getPath().getPathCount());
			}

		});
		JScrollPane js = new JScrollPane(tree);
		JScrollPane js1 = new JScrollPane(jta);
		jp.add(js, BorderLayout.CENTER);
		jp.add(js1, BorderLayout.SOUTH);
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}


	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJTree tb = new TestJTree();
	}

}
