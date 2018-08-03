package com.testKeySave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class TestJPopupMenu extends JFrame {
	public JFrame myJFrame = null;
	public JPanel jp = null;
	public JTextArea jta = null;
	public Clipboard clipboard = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2528389151551310396L;

	public TestJPopupMenu() {
		myJFrame = new JFrame("测试窗口");
		myJFrame.setSize(600, 500);
		clipboard = myJFrame.getToolkit().getSystemClipboard();// 调用系统剪切板
		jp = new JPanel(new BorderLayout());
		jta = new JTextArea();
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBackground(Color.WHITE);
		// TODO 自动生成的构造函数存根
		jta.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(e.isMetaDown()){
					showPopupMenu(e.getComponent(),e.getX(),e.getY());
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

		});
		jp.add(jta, BorderLayout.CENTER);
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	public void showPopupMenu(Component invoker, int x, int y) {
		// =========================一级菜单====================================
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem copyItem = new JMenuItem("复制");
		JMenuItem pasteItem = new JMenuItem("粘贴");
		JMenuItem cutItem = new JMenuItem("剪切");
		JMenu editMenu = new JMenu("编辑");

		popupMenu.add(copyItem);
		popupMenu.add(pasteItem);
		popupMenu.add(cutItem);
		popupMenu.addSeparator();
		popupMenu.add(editMenu);
		// =========================二级菜单====================================
		JMenuItem findItem = new JMenuItem("查找");
		JMenuItem replaceItem = new JMenuItem("替换");
		editMenu.add(findItem);
		editMenu.add(replaceItem);
		// =========================监听====================================
		copyItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String text = jta.getSelectedText();// 鼠标选中内容
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);// 选中的内容设置到剪切板
			}

		});
		pasteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Transferable contents = clipboard.getContents(this);
				DataFlavor flavor = DataFlavor.stringFlavor;
				if (contents.isDataFlavorSupported(flavor)) {
					try {
						String str = (String) contents.getTransferData(flavor);
						jta.append(str);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}

		});
		cutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String text = jta.getSelectedText();
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);
				int start = jta.getSelectionStart();
				int end = jta.getSelectionEnd();
				jta.replaceRange("", start, end);// 将选中的内容删除
			}

		});
		
		
		
		popupMenu.show(invoker, x, y);// 在指定位置弹出菜单
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestJPopupMenu tb = new TestJPopupMenu();
	}

}
