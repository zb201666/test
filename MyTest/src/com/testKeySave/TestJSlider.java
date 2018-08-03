package com.testKeySave;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TestJSlider extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJSlider() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new FlowLayout());
		JLabel lb = new JLabel("滑块");
		jp.add(lb);
		// TODO 自动生成的构造函数存根
		final JSlider js = new JSlider(0, 30, 15);// 初始化，设置最小值、最大值、初始值
		Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
		table.put(0, new JLabel("start"));
		table.put(15, new JLabel("middle"));
		table.put(30, new JLabel("end"));
		js.setLabelTable(table);
		js.setOrientation(SwingConstants.VERTICAL);// 垂直方向
		js.setMajorTickSpacing(10);// 最大间隔
		js.setMinorTickSpacing(1);// 最小间隔
		js.setSnapToTicks(true);// 滑块只在有值的位置移动
		js.setPaintTicks(true);// 绘制刻度线
		js.setPaintLabels(true);// 绘制刻度值
		js.setPaintTrack(true);// 绘制滑道
		jp.add(js);
		JButton btn = new JButton("显示");
		btn.setFont(new Font("宋体", Font.BOLD, 16));
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JOptionPane.showMessageDialog(myJFrame,
						"滑块值为：" + js.getValue(), "信息",
						JOptionPane.INFORMATION_MESSAGE);
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
		TestJSlider tb = new TestJSlider();
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
