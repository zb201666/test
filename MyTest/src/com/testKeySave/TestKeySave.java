package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class TestKeySave extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3932453197785016253L;

	public void TestTestField() {
		this.setLayout(new BorderLayout());
		this.add(new CacheTextField(), BorderLayout.SOUTH);
		this.add(new JLabel(
				"pase enter ,data save in the cache, reinput,you can see point out"));
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new TestKeySave().TestTestField();
	}

	class CacheTextField extends JTextField implements KeyListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4007916357172495745L;
		HashSet<String> cache = new HashSet<String>();

		public CacheTextField() {
			this.addKeyListener(this);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根
			if (e.getKeyCode() >= KeyEvent.VK_LEFT
					&& e.getKeyCode() <= KeyEvent.VK_DOWN) {
				return;
			}

			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				return;
			}

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				cache.add(getText().trim());
				setText("");
			} else {
				String str = null;
				try {
					str = this.getText(0, this.getCaretPosition());
				} catch (BadLocationException e2) {
					e2.printStackTrace();
				}

				for (String txt : cache) {
					if (txt.length() <= str.length()) {
						continue;
					}

					if (txt.substring(0, str.length()).equals(str)) {
						int i = this.getCaretPosition();
						this.setText(this.getText()
								+ txt.substring(str.length()));
						this.setCaretPosition(i);
						this.select(i, this.getText().length());

						return;
					}
				}
			}
		}
	}
}
