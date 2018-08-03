package com.testKeySave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class JFontChooser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2426473549353638490L;

	private JLabel nameLb;
	private JLabel styleLb;
	private JLabel sizeLb;
	private JLabel presLb;
	private JTextField nameTx;
	private JTextField styleTx;
	private JTextField sizeTx;
	private JTextField presTx;
	private JList<String> nameLt;
	private JList<String> styleLt;
	private JList<String> sizeLt;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JButton approve;
	private JButton cancel;
	private JButton chose;
	private JRadioButton[] language = new JRadioButton[2];
	private ButtonGroup languageg;
	private String Slanguage[] = { new String("����"), new String("ABC") };

	private static JFrame frame;
	public Font font, newFont;// ������
	private Color color;// ��ɫ��
	Color newColor;

	JFileChooser fileChoose = new JFileChooser();// �ļ�ѡ����ʵ��
	private JDialog colorDlg;// ��ɫ�Ի���
	private JColorChooser colorChoose = new JColorChooser();// ��ɫѡ����ʵ��

	private GraphicsEnvironment environment; // �������ֻ�ȡϵͳ����ķ�����
	private String[] fontNameSet;// ���塮�߼���'��
	// ���塮��ʽ'�����ַ�������
	private String[] fontStyleSet = { "����", "��б", "�Ӵ�", "��б �Ӵ�" };
	// ���塮��ʽ'���ĳ�������
	private Integer[] fontCon = { Font.PLAIN, Font.ITALIC, Font.BOLD,
			Font.BOLD | Font.ITALIC };
	// ���塮��С'��
	private String[] fontSizeSet = { "6", "7", "8", "9", "10", "11", "12",
			"14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" };

	public JFontChooser() {// �޲ι��캯��
		super(frame, "�������ô���", true);
		frame = new JFrame();
		initGUI();
	}

	public JFontChooser(JFrame frame) {// ���ι��캯��
		super(frame, "�������ô���", true);
		JFontChooser.frame = frame;// �������б�����һ��public��Font����
		// setAlwaysOnTop(true);
		initGUI();
	}

	private void initGUI() {// �����ʽѡ�����Ľ����ʼ��
		try {
			getContentPane().setLayout(null);
			environment = GraphicsEnvironment.getLocalGraphicsEnvironment();// GraphicsEnvironment��һ�������࣬����ʵ������ֻ�������еľ�̬������ȡһ��ʵ��
			fontNameSet = environment.getAvailableFontFamilyNames();// ��ȡϵͳ����
			addMenu();// ����˵�
			initFont();// ��ʼ������
			// pack();
			setSize(380, 337);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setWindowPos();// ʹ������Ļ����
			setResizable(false);// ��С���ɱ�
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initFont() {// ��ʼ������
		// ����Ĭ�������ʽΪ������font����������ʽ
		if (frame.getFont() == null) {
			nameTx.setText(fontNameSet[0]);
			styleTx.setText(fontStyleSet[0]);
			sizeTx.setText("12");
			nameLt.setSelectedValue(fontNameSet[0], true);
			styleLt.setSelectedIndex(0);
			sizeLt.setSelectedValue("12", true);
			font = new Font(fontNameSet[0], fontCon[0], 12);
			newFont = font;// ����ԭ���������ʽ
			presTx.setFont(font);
			// JOptionPane.showMessageDialog(null, "ccac");
		} else {
			int idxStyle = 0;
			for (int i = 0; i < fontCon.length; i++) {
				if (fontCon[i] == frame.getFont().getStyle())
					idxStyle = i;
			}
			nameTx.setText(frame.getFont().getName());// ��text
			styleTx.setText(fontStyleSet[idxStyle]);
			sizeTx.setText("" + frame.getFont().getSize());
			nameLt.setSelectedValue(frame.getFont().getName(), true);// ��list��ʾ
			styleLt.setSelectedIndex(idxStyle);
			sizeLt.setSelectedValue("" + frame.getFont().getSize(), true);
			font = new Font(fontNameSet[0], fontCon[0], 12);// ���浱ǰ��ʽ
			newFont = font;// ����ԭ���������ʽ
			presTx.setFont(font);// Ԥ������Ϊ��ǰģʽ
		}
	}

	private void addMenu() {// ����˵�
		// 4��lable---------------------------------------------------------------------------------
		nameLb = new JLabel();
		getContentPane().add(nameLb);
		nameLb.setText("���壺");
		nameLb.setBounds(10, 14, 120, 26);
		nameLb.setFont(new java.awt.Font("SimSun", 1, 14));

		styleLb = new JLabel();
		getContentPane().add(styleLb);
		styleLb.setText("���ͣ�");
		styleLb.setBounds(151, 14, 120, 26);
		styleLb.setFont(new java.awt.Font("SimSun", 1, 14));

		sizeLb = new JLabel();
		getContentPane().add(sizeLb);
		sizeLb.setText("��С��");
		sizeLb.setBounds(275, 14, 79, 26);
		sizeLb.setFont(new java.awt.Font("SimSun", 1, 14));

		presLb = new JLabel();
		getContentPane().add(presLb);
		presLb.setText("Ԥ����");
		presLb.setBounds(151, 150, 120, 80);
		presLb.setFont(new java.awt.Font("SimSun", 1, 14));

		// 4��textfield---------------------------------------------------------------------------------
		nameTx = new JTextField();
		nameTx.setEditable(false);
		getContentPane().add(nameTx);
		nameTx.setBounds(10, 42, 120, 22);

		styleTx = new JTextField();
		styleTx.setEditable(false);
		getContentPane().add(styleTx);
		styleTx.setBounds(151, 42, 100, 22);

		sizeTx = new JTextField();
		sizeTx.setEditable(false);
		getContentPane().add(sizeTx);
		sizeTx.setBounds(275, 42, 79, 22);

		presTx = new JTextField();
		presTx.setEditable(false);
		getContentPane().add(presTx);
		presTx.setBounds(151, 200, 203, 61);
		presTx.setText(Slanguage[1]);

		// 3��������--+����-----------------------------------------------------------------------------
		jScrollPane1 = new JScrollPane();
		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(10, 74, 120, 210);
		{
			ListModel<String> fontNameModel = new DefaultComboBoxModel<String>(
					fontNameSet);
			nameLt = new JList<String>();
			jScrollPane1.setViewportView(nameLt);
			nameLt.setModel(fontNameModel);
			nameLt.setBounds(274, 193, 90, 86);
			nameLt.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			nameLt.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					nameLtMouseClicked(evt);
				}
			});
		}

		jScrollPane2 = new JScrollPane();
		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(151, 74, 100, 103);
		{
			ListModel<String> fontStyleModel = new DefaultComboBoxModel<String>(
					fontStyleSet);
			styleLt = new JList<String>();
			jScrollPane2.setViewportView(styleLt);
			styleLt.setModel(fontStyleModel);
			styleLt.setBounds(310, 215, 70, 102);
			styleLt.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			styleLt.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					styleLtMouseClicked(evt);
				}
			});
		}

		jScrollPane3 = new JScrollPane();
		getContentPane().add(jScrollPane3);
		jScrollPane3.setBounds(275, 75, 79, 100);
		{
			ListModel<String> fontSizeModel = new DefaultComboBoxModel<String>(
					fontSizeSet);
			sizeLt = new JList<String>();
			jScrollPane3.setViewportView(sizeLt);
			sizeLt.setModel(fontSizeModel);
			sizeLt.setBounds(300, 218, 54, 102);
			sizeLt.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			sizeLt.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					sizeLtMouseClicked(evt);
				}
			});
		}// -------------------------------------------------------------------------------------

		// ��Ӣѡ��(---------------------------------------------------------------------------------
		languageg = new ButtonGroup();
		language[0] = new JRadioButton("��");
		getContentPane().add(language[0]);
		language[0].setSelected(true);// ��ʼ����ʾ
		language[0].setBounds(271, 179, 40, 20);
		language[0].setFont(new java.awt.Font("SimSun", 1, 12));
		languageg.add(language[0]);
		language[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				presTx.setText(Slanguage[0]);
			}
		});

		language[1] = new JRadioButton("Ӣ");
		getContentPane().add(language[1]);
		language[1].setSelected(false);
		language[1].setBounds(321, 179, 40, 20);
		language[1].setFont(new java.awt.Font("SimSun", 1, 12));
		languageg.add(language[1]);
		language[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				presTx.setText(Slanguage[1]);
			}
		});

		// 3����ť+����---------------------------------------------------------------------------------
		// ȷ����ť
		approve = new JButton();
		getContentPane().add(approve);
		approve.setText("ȷ��");
		approve.setBounds(151, 265, 67, 20);
		approve.setFont(new java.awt.Font("KaiTi_GB2312", 1, 12));
		approve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				approveActionPerformed(evt);
			}
		});

		// ȡ����ť
		cancel = new JButton();
		getContentPane().add(cancel);
		cancel.setText("ȡ��");
		cancel.setBounds(219, 265, 67, 20);
		cancel.setFont(new java.awt.Font("KaiTi_GB2312", 1, 12));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelActionPerformed(evt);
			}
		});

		// ��ɫѡ��ť
		chose = new JButton();
		getContentPane().add(chose);
		chose.setText("��ɫ");
		chose.setBounds(287, 265, 67, 20);
		chose.setFont(new java.awt.Font("KaiTi_GB2312", 1, 12));
		chose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				choseActionPerformed(evt);
			}
		});// -------------------------------------------------------------------------
	}

	private void setWindowPos() {// ���ھ���
		Toolkit kit = Toolkit.getDefaultToolkit();// �����࣬ͨ����̬������ȡʵ��
		Dimension frameSize = new Dimension(), screenSize = kit.getScreenSize(); // ��ȡ��Ļ�Ĵ�С
		getSize(frameSize); // ��ȡ���ڴ�С
		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	private void nameLtMouseClicked(MouseEvent evt) {// �����߼����б����굥���¼�
		nameTx.setText(nameLt.getSelectedValue().toString());
		font = new Font(nameTx.getText(), font.getStyle(), font.getSize());
		presTx.setFont(font);
	}

	private void styleLtMouseClicked(MouseEvent evt) {// ������ʽ�б����굥���¼�
		String temp = styleLt.getSelectedValue().toString();
		styleTx.setText(temp);
		int index = 0;
		while (index < 4 && !fontStyleSet[index].equals(temp)) {
			index++;
		}
		font = new Font(font.getName(), fontCon[index], font.getSize());
		presTx.setFont(font);
	}

	private void sizeLtMouseClicked(MouseEvent evt) {// �����С�б��������¼�
		sizeTx.setText(sizeLt.getSelectedValue().toString());
		font = new Font(font.getName(), font.getStyle(),
				Integer.parseInt(sizeTx.getText()));
		presTx.setFont(font);
	}

	private void approveActionPerformed(ActionEvent evt) {// ȷ����ť�Ĵ����¼�
		String name = nameTx.getText();
		int style = fontCon[styleLt.getSelectedIndex()];
		int size = Integer.parseInt(sizeTx.getText());
		font = new Font(name, style, size);
		frame.setFont(font); // �����ڵ�Font����
		newFont = font;// ����ԭ�������ʽ
		newColor = color;// ������ɫ
		if (newFont == null||newColor == null) {
			JOptionPane.showMessageDialog(frame, "��ѡ���������ɫ��", "����",
					JOptionPane.WARNING_MESSAGE);
		}else{
			this.dispose();
		}
		
	}

	private void cancelActionPerformed(ActionEvent evt) {// ȡ����ť�Ĵ����¼�
		this.dispose();
	}

	private void choseActionPerformed(ActionEvent evt) {// ��ɫѡ�񴥷��¼�
		if (colorDlg == null) {
			colorDlg = JColorChooser.createDialog(JFontChooser.this,
					"Select Text Color", true, colorChoose,
					new ColorOKListener(), null);
		}
		colorChoose.setColor(color = presTx.getForeground());
		colorDlg.setVisible(true);
	}

	class ColorOKListener implements ActionListener {// ��д��ɫ��ť��������า�ǽӿ�ActionListener
		public void actionPerformed(ActionEvent e) {
			Color c = colorChoose.getColor();
			color = c;
			presTx.setForeground(c);
			presTx.repaint();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new JFontChooser();
	}

}
