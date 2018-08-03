package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

public class TestJList extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJList() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("请选择：");
		jp.add(lb);
		// TODO 自动生成的构造函数存根
		String[] str = new String[]{"苹果","香蕉","橘子","梨子"};
		final JList<String> list = new JList<String>(str);
		list.setSelectionBackground(Color.BLUE);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//允许可间断多选
		jp.add(list);
		JButton btn = new JButton("输出");
		btn.setFont(new Font("宋体", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(list.getSelectedValues()==null||list.getSelectedValues().length<1){
					JOptionPane.showMessageDialog(myJFrame, "请选择！", "警告", JOptionPane.WARNING_MESSAGE);
				}else{
					Object[] s = list.getSelectedValues();
					StringBuilder sb = new StringBuilder();
					for(int i = 0;i<s.length;i++){
						sb.append(s[i]).append(" ");
					}
					JOptionPane.showMessageDialog(myJFrame, "选择的信息为："+"\n"+sb.toString(), "信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
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
		TestJList tb = new TestJList();
	}

	public boolean isRight(char[] chars) {
		boolean flag = true;
		for (char c : chars) {
			int i = c;
			if ((i > 64 && i < 91) || (i > 96 && i < 123) || (i > 47 && i < 58)) {
				flag = flag && true;
			} else {
				flag = flag && false;
			}
		}
		return flag;
	}

	public static void clearConsole() {
		try {
			String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				// Runtime.getRuntime().exec("cls");
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
						.waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
