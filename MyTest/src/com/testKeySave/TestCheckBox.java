package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestCheckBox extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public JCheckBox box1 = null;
	public JCheckBox box2 = null;
	public JCheckBox box3 = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestCheckBox() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		jp = new JPanel(new BorderLayout());
		// TODO 自动生成的构造函数存根
		box1 = new JCheckBox("苹果",true);
		box2 = new JCheckBox("橘子");
		box3 = new JCheckBox("香蕉");
		JPanel boxjp = new JPanel();
		boxjp.add(box1);
		boxjp.add(box2);
		boxjp.add(box3);
		jp.add(boxjp, BorderLayout.NORTH);
		JPanel btnjp = new JPanel();
		JButton btn = new JButton("输出选择的信息");
		btn.setSize(50, 20);
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				clearConsole();
				// TODO 自动生成的方法存根
				if(box1.isSelected()){
					System.out.println(box1.getText());
				}
				if(box2.isSelected()){
					System.out.println(box2.getText());
				}
				if(box3.isSelected()){
					System.out.println(box3.getText());
				}
			}
			
		});
		btnjp.add(btn);
		jp.add(btnjp, BorderLayout.SOUTH);
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
		TestCheckBox tb = new TestCheckBox();
	}

	public static void clearConsole()
	{
	    try
	    {
	        String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	           // Runtime.getRuntime().exec("cls");
	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (Exception exception)
	    {
	        exception.printStackTrace();
	    }
	}
}
