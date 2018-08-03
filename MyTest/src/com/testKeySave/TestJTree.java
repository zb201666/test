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
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		jta = new JTextArea();
		DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode("�й�");// �������ڵ�

		// ���������ڵ�
		DefaultMutableTreeNode scnode = new DefaultMutableTreeNode("�Ĵ�");
		DefaultMutableTreeNode cqnode = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode gznode = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode ynnode = new DefaultMutableTreeNode("����");
		// �������ڵ������ڵ�
		rootnode.add(scnode);
		rootnode.add(cqnode);
		rootnode.add(gznode);
		rootnode.add(ynnode);
		// ����Ҷ�ڵ�
		DefaultMutableTreeNode cdnode = new DefaultMutableTreeNode("�ɶ�");
		DefaultMutableTreeNode mynode = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode ganode = new DefaultMutableTreeNode("�㰲");
		// ��Ҷ�ڵ��������ڵ���
		scnode.add(cdnode);
		scnode.add(mynode);
		scnode.add(ganode);
		DefaultMutableTreeNode gynode = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode zynode = new DefaultMutableTreeNode("����");
		gznode.add(gynode);
		gznode.add(zynode);
		DefaultMutableTreeNode kmnode = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode xglanode = new DefaultMutableTreeNode("�������");
		ynnode.add(kmnode);
		ynnode.add(xglanode);

		JTree tree = new JTree(rootnode);// ʹ�ø��ڵ㴴����
		tree.setShowsRootHandles(true);// ��ʾ���ڵ���
		tree.setEditable(true);// �������ڵ�ɱ༭
		String[] path = { "�ɶ�" };
		TreePath treepath = new TreePath(path);
		tree.setSelectionPath(treepath);// ���ó�ʼ��ѡ�еĽڵ�

		MyDefaultTreeCellRenderer renderer = new MyDefaultTreeCellRenderer();// ���ڵ���Ⱦ��
		renderer.setFont(new Font("����", Font.BOLD, 14));
		renderer.setTextSelectionColor(Color.RED);
		renderer.setTextNonSelectionColor(Color.BLUE);
		tree.setCellRenderer(renderer);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO �Զ����ɵķ������
				jta.setText("��ǰ��ѡ�еĽڵ㣺" + e.getPath() + "����ǰ��ѡ�еĽڵ�·���ϵĽڵ�����"
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
		// TODO �Զ����ɵķ������
		TestJTree tb = new TestJTree();
	}

}
