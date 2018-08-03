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
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		// 表头（列名）
		String[] columnNames = { "序号", "姓名", "语文", "数学", "英语", "总分" };

		// 表格所有行数据
		Object[][] rowData = { { 1, "张三", 80, 80, 80, 240 },
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
		table.setSelectionBackground(Color.WHITE);// 选中时前景色
		table.setSelectionForeground(Color.RED);
		table.setGridColor(Color.GRAY);// 网格颜色
		// 设置表头
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 14)); // 设置表头名称字体样式
		table.getTableHeader().setForeground(Color.RED); // 设置表头名称字体颜色
		table.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列
		table.setRowHeight(30);// 设置行高
		table.getColumnModel().getColumn(0).setPreferredWidth(40);// 第一列列宽设置为40
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));// 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
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
		 * 表头（列名）
		 */
		private Object[] columnNames = { "姓名", "语文", "数学", "英语", "总分" };

		/**
		 * 表格所有行数据
		 */
		private Object[][] rowData = { { "张三", 80, 80, 80, 240 },
				{ "John", 70, 80, 90, 240 }, { "Sue", 70, 70, 70, 210 },
				{ "Jane", 80, 70, 60, 210 }, { "Joe", 80, 70, 60, 210 } };

		/**
		 * 返回总行数
		 */
		@Override
		public int getRowCount() {
			// TODO 自动生成的方法存根
			return rowData.length;
		}

		/**
		 * 返回总列数
		 */
		@Override
		public int getColumnCount() {
			// TODO 自动生成的方法存根
			return columnNames.length;
		}

		/**
		 * 返回指定单元格的显示的值
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO 自动生成的方法存根
			return rowData[rowIndex][columnIndex];
		}

		/**
		 * 返回列名称（表头名称），AbstractTableModel 中对该方法的实现默认是以 大写字母 A
		 * 开始作为列名显示，所以这里需要重写该方法返回我们需要的列名。
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
		// TODO 自动生成的方法存根
		TestJTable tb = new TestJTable();
	}

}
