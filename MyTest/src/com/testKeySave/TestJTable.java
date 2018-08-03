package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TestJTable extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJTable() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		// ��ͷ��������
		String[] columnNames = { "���", "����", "����", "��ѧ", "Ӣ��", "�ܷ�" };

		// �������������
		Object[][] rowData = { { 1, "����", 80, 80, 80, 240 },
				{ 2, "John", 70, 80, 90, 240 }, { 3, "Sue", 70, 70, 70, 210 },
				{ 4, "Jane", 80, 70, 60, 210 },
				{ 5, "Joe_05", 80, 70, 60, 210 },
				{ 6, "Joe_06", 80, 70, 60, 210 },
				{ 7, "Joe_07", 80, 70, 60, 210 },
				{ 8, "Joe_08", 80, 70, 60, 210 },
				{ 9, "Joe_09", 80, 70, 60, 210 },
				{ 10, "Joe_10", 80, 70, 60, 210 },
				{ 11, "Joe_11", 80, 70, 60, 210 },
				{ 12, "Joe_12", 80, 70, 60, 210 },
				{ 13, "Joe_13", 80, 70, 60, 210 },
				{ 14, "Joe_14", 80, 70, 60, 210 },
				{ 15, "Joe_15", 80, 70, 60, 210 },
				{ 16, "Joe_16", 80, 70, 60, 210 },
				{ 17, "Joe_17", 80, 70, 60, 210 },
				{ 18, "Joe_18", 80, 70, 60, 210 },
				{ 19, "Joe_19", 80, 70, 60, 210 },
				{ 20, "Joe_20", 80, 70, 60, 210 } };
		// JTable table = new JTable(rowData, columnNames);
		// JTable table = new JTable(new MyTableModel());
		JTable table = new JTable(new DefaultTableModel(rowData, columnNames));
		table.setForeground(Color.BLUE);
		table.setFont(new Font(null, Font.BOLD, 14));
		table.setSelectionBackground(Color.WHITE);// ѡ��ʱǰ��ɫ
		table.setSelectionForeground(Color.RED);
		table.setGridColor(Color.GRAY);// ������ɫ
		// ���ñ�ͷ
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 14)); // ���ñ�ͷ����������ʽ
		table.getTableHeader().setForeground(Color.RED); // ���ñ�ͷ����������ɫ
		table.getTableHeader().setResizingAllowed(false); // ���ò������ֶ��ı��п�
		table.getTableHeader().setReorderingAllowed(false); // ���ò������϶������������
		table.setRowHeight(30);// �����и�
		table.getColumnModel().getColumn(0).setPreferredWidth(40);// ��һ���п�����Ϊ40
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));// ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		// �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		JScrollPane scrollPane = new JScrollPane(table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp.add(scrollPane);
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	class MyTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5949583519859110251L;

		/**
		 * ��ͷ��������
		 */
		private Object[] columnNames = { "����", "����", "��ѧ", "Ӣ��", "�ܷ�" };

		/**
		 * �������������
		 */
		private Object[][] rowData = { { "����", 80, 80, 80, 240 },
				{ "John", 70, 80, 90, 240 }, { "Sue", 70, 70, 70, 210 },
				{ "Jane", 80, 70, 60, 210 }, { "Joe", 80, 70, 60, 210 } };

		/**
		 * ����������
		 */
		@Override
		public int getRowCount() {
			// TODO �Զ����ɵķ������
			return rowData.length;
		}

		/**
		 * ����������
		 */
		@Override
		public int getColumnCount() {
			// TODO �Զ����ɵķ������
			return columnNames.length;
		}

		/**
		 * ����ָ����Ԫ�����ʾ��ֵ
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			return rowData[rowIndex][columnIndex];
		}

		/**
		 * ���������ƣ���ͷ���ƣ���AbstractTableModel �жԸ÷�����ʵ��Ĭ������ ��д��ĸ A
		 * ��ʼ��Ϊ������ʾ������������Ҫ��д�÷�������������Ҫ��������
		 */
		@Override
		public String getColumnName(int column) {
			return columnNames[column].toString();
		}
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJTable tb = new TestJTable();
	}

}
