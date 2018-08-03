package com.testKeySave;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestButton extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public String start_image = "src/com/testKeySave/����.png";
	public String stop_image = "src/com/testKeySave/��ͣ.png";
	public String cancel_image = "src/com/testKeySave/�ر�.png";

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestButton() {
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		jp = new JPanel();
		// TODO �Զ����ɵĹ��캯�����
		final JButton btn = new JButton();
		btn.setIcon(new ImageIcon(start_image));
		btn.setBorderPainted(false);
		btn.setVisible(true);
		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				ImageIcon icon = (ImageIcon) btn.getIcon();
				if(icon.toString().equals(start_image)){
					btn.setIcon(new ImageIcon(stop_image));
				}else if(icon.toString().equals(stop_image)){
					btn.setIcon(new ImageIcon(cancel_image));
				}else if(icon.toString().equals(cancel_image)){
					btn.setIcon(new ImageIcon(start_image));
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
		});
		jp.add(btn);
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
		TestButton tb = new TestButton();
	}

}
