package com.testKeySave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class testlabel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final JFrame jf = new JFrame("测试窗口"); 
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(520, 500);
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("文本");	
		jl.setFont(new Font("宋体",Font.BOLD,16));
		jl.setForeground(Color.BLUE);
		jl.setToolTipText("这是一个文本标签");
		jl.setOpaque(false);
		jl.setBackground(Color.WHITE);
		jl.setVisible(true);
		jl.setIcon(new ImageIcon("src/com/testKeySave/demo.jpg"));
		jl.setHorizontalTextPosition(SwingConstants.CENTER);
		jl.setVerticalTextPosition(SwingConstants.BOTTOM);
		jp.add(jl);
		jf.setContentPane(jp);
		jf.setLocationRelativeTo(null);//位于屏幕正中
		jf.setResizable(false);//不可放大
		jf.setVisible(true);
		jf.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				//位于屏幕正中
				setInitLoc(jf);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				//位于屏幕正中
				setInitLoc(jf);
			}
			
		});
	}
	public static void setInitLoc(JFrame jframe) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHight = (int) screenSize.getHeight();
		int screenWidth = (int) screenSize.getWidth();
		jframe.setLocation((screenWidth-jframe.getWidth())/2,(screenHight-jframe.getHeight())/2);
	}
}
