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
		myJFrame = new JFrame("���Դ���");
		myJFrame.setSize(600, 500);
		clipboard = myJFrame.getToolkit().getSystemClipboard();// ����ϵͳ���а�
		jp = new JPanel(new BorderLayout());
		jta = new JTextArea();
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBackground(Color.WHITE);
		// TODO �Զ����ɵĹ��캯�����
		jta.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				if(e.isMetaDown()){
					showPopupMenu(e.getComponent(),e.getX(),e.getY());
				}
				
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
		jp.add(jta, BorderLayout.CENTER);
		myJFrame.setContentPane(jp);
		myJFrame.setBackground(Color.WHITE);
		myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myJFrame.setLocationRelativeTo(null);
		myJFrame.setResizable(false);
		myJFrame.setVisible(true);
	}

	public void showPopupMenu(Component invoker, int x, int y) {
		// =========================һ���˵�====================================
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem copyItem = new JMenuItem("����");
		JMenuItem pasteItem = new JMenuItem("ճ��");
		JMenuItem cutItem = new JMenuItem("����");
		JMenu editMenu = new JMenu("�༭");

		popupMenu.add(copyItem);
		popupMenu.add(pasteItem);
		popupMenu.add(cutItem);
		popupMenu.addSeparator();
		popupMenu.add(editMenu);
		// =========================�����˵�====================================
		JMenuItem findItem = new JMenuItem("����");
		JMenuItem replaceItem = new JMenuItem("�滻");
		editMenu.add(findItem);
		editMenu.add(replaceItem);
		// =========================����====================================
		copyItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String text = jta.getSelectedText();// ���ѡ������
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);// ѡ�е��������õ����а�
			}

		});
		pasteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Transferable contents = clipboard.getContents(this);
				DataFlavor flavor = DataFlavor.stringFlavor;
				if (contents.isDataFlavorSupported(flavor)) {
					try {
						String str = (String) contents.getTransferData(flavor);
						jta.append(str);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}

		});
		cutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String text = jta.getSelectedText();
				StringSelection tempText = new StringSelection(text);
				clipboard.setContents(tempText, null);
				int start = jta.getSelectionStart();
				int end = jta.getSelectionEnd();
				jta.replaceRange("", start, end);// ��ѡ�е�����ɾ��
			}

		});
		
		
		
		popupMenu.show(invoker, x, y);// ��ָ��λ�õ����˵�
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestJPopupMenu tb = new TestJPopupMenu();
	}

}
