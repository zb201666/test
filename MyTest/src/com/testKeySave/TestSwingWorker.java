package com.testKeySave;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class TestSwingWorker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		});
	}

	public static void createGUI() {
		JFrame jf = new JFrame("���Դ���");
		jf.setSize(300, 300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());

		final JLabel label = new JLabel("��������: 0%");
		panel.add(label, BorderLayout.NORTH);

		final JTextArea textArea = new JTextArea();
		panel.add(textArea, BorderLayout.CENTER);

		jf.setContentPane(panel);
		jf.setVisible(true);

		// ������̨����
		SwingWorker<String, Integer> task = new SwingWorker<String, Integer>() {
			@Override
			protected String doInBackground() throws Exception {
				for (int i = 0; i < 100; i += 10) {
					// ��ʱģ���ʱ����
					Thread.sleep(1000);

					// ���� progress ���Ե�ֵ��ͨ�����Ըı�������������ݵ��¼������̣߳�
					setProgress(i);

					// ͨ�� SwingWorker �ڲ����ƴ������ݵ��¼������߳�
					publish(i);
				}
				// ���ؼ�����
				return "�������";
			}

			@Override
			protected void process(List<Integer> chunks) {
				// �˷����� ���� doInBackground ���� public ���������¼������߳��б��ص�
				Integer progressValue = chunks.get(0);
				textArea.append("������: " + progressValue + "%\n");
			}

			@Override
			protected void done() {
				// �˷������ں�̨������ɺ����¼������߳��б��ص�
				String result = null;
				try {
					// ��ȡ������
					result = get();
				} catch (Exception e) {
					e.printStackTrace();
				}
				label.setText(result);
				textArea.append(result);
			}
		};

		// ������Ըı������
		task.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("progress".equals(evt.getPropertyName())) {
					Object progressValue = evt.getNewValue();
					label.setText("��������: " + progressValue + "%");
				}
			}
		});

		// ��������
		task.execute();
	}
}
