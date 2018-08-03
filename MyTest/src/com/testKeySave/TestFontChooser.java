package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFontChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -328658864211509926L;
	private JTextArea text = null;
	private JButton button = null;
	private JPanel jp = null;
	static {
		try {
			// 请配合Look And Feel使用本组件，可得到更好的效果
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//取得当前系统平台的组件显示风格
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public TestFontChooser() {
		text = new JTextArea(
				"五星红旗迎风飘扬，\n胜利歌声多么响亮；\n歌唱我们亲爱的祖国，\n从今走向繁荣富强。\n歌唱我们亲爱的祖国，\n从今走向繁荣富强。\n\n越过高山，\n越过平原，\n跨过奔腾的黄河长江；\n宽广美丽的土地，\n是我们亲爱的家乡，\n英雄的人民站起来了！\n我们团结友爱坚强如钢。");
		jp = new JPanel();
		button = new JButton("设置字体");
		jp.add(button);
		// 给按钮添加动作事件监听
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 构造字体选择器，参数字体为预设值
				FontChooser fontChooser = new FontChooser(text.getFont());
				// 打开一个字体选择器窗口，参数为父级所有者窗体。返回一个整型，代表设置字体时按下了确定或是取消，可参考FontChooser.APPROVE_OPTION和FontChooser.CANCEL_OPTION
				int returnValue = fontChooser
						.showFontDialog(TestFontChooser.this);
				// 如果按下的是确定按钮
				if (returnValue == FontChooser.APPROVE_OPTION) {
					// 获取选择的字体
					Font font = fontChooser.getSelectFont();
					// 将字体设置到JTextArea中
					text.setFont(font);
					System.out.println(text.getFont());
				}
			}
		});
		getContentPane().add(new JScrollPane(text));
		getContentPane().add(jp, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new TestFontChooser();
	}

}
