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
		// TODO �Զ����ɵķ������
		final JFrame jf = new JFrame("���Դ���"); 
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(520, 500);
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("�ı�");	
		jl.setFont(new Font("����",Font.BOLD,16));
		jl.setForeground(Color.BLUE);
		jl.setToolTipText("����һ���ı���ǩ");
		jl.setOpaque(false);
		jl.setBackground(Color.WHITE);
		jl.setVisible(true);
		jl.setIcon(new ImageIcon("src/com/testKeySave/demo.jpg"));
		jl.setHorizontalTextPosition(SwingConstants.CENTER);
		jl.setVerticalTextPosition(SwingConstants.BOTTOM);
		jp.add(jl);
		jf.setContentPane(jp);
		jf.setLocationRelativeTo(null);//λ����Ļ����
		jf.setResizable(false);//���ɷŴ�
		jf.setVisible(true);
		jf.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO �Զ����ɵķ������
				//λ����Ļ����
				setInitLoc(jf);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
				//λ����Ļ����
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
