package com.testLocale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		// Locale��ʾ���Ǳ��أ�ʵ����ʹ�õ���ISO����ķ�װ�ࡣ
		// ���ڸ���������˵������һ��Ψһ�ı��룬��ô���ֱ���ͳ�ΪISO���룬ʹ��Locale��ָ����һ������Ĺ��ұ��롣
		Locale defaultLocale = Locale.getDefault();
		System.out.println("country:" + defaultLocale.getCountry());
		System.out.println("display_country:"
				+ defaultLocale.getDisplayCountry());
		System.out.println("language:" + defaultLocale.getLanguage());
		System.out.println("display_language:"
				+ defaultLocale.getDisplayLanguage());
		// ResourceBundle����ר����������ļ���ȡ�����ģ�
		// ��ȡ��ʱ��ֱ��ָ���ļ������ɣ����ļ�����һ�㲻��Ҫָ����׺����ͳһΪ*.properties����
		// ���Ը���Locale��ָ�������������Զ�ѡ������Ҫ����Դ�ļ���
		Locale currentLocale = new Locale("en","US");
		ResourceBundle rb = ResourceBundle.getBundle("com/testLocale/MessageBundle",
				currentLocale);
		// �������֡���ã�XXX����Ч�����ͱ�������Դ�ļ��н���һЩ��̬�ı������ã�����ռλ����
		// ��Щ�����е�������ʱ���̶��������ڳ���ִ�е�ʱ���ɳ���������õģ���Ҫ��ʵ�������Ĺ��ܣ�
		// �����ʹ��MessageFormat�ࡣ������java.text���ж���ġ�
		// ռλ��ʹ�����ֵ���ʽ��ʾ��������ڱ�ʾ��һ�����ݡ�{0}�����ڶ������ݡ�{1}������
		MessageFormat mf = new MessageFormat(rb.getString("k1"));
		System.out.println(mf.format(new Object[] { "����" }));
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com/testLocale/MessageBundle",
				defaultLocale);
		// �������֡���ã�XXX����Ч�����ͱ�������Դ�ļ��н���һЩ��̬�ı������ã�����ռλ����
		// ��Щ�����е�������ʱ���̶��������ڳ���ִ�е�ʱ���ɳ���������õģ���Ҫ��ʵ�������Ĺ��ܣ�
		// �����ʹ��MessageFormat�ࡣ������java.text���ж���ġ�
		// ռλ��ʹ�����ֵ���ʽ��ʾ��������ڱ�ʾ��һ�����ݡ�{0}�����ڶ������ݡ�{1}������
		MessageFormat mf1 = new MessageFormat(rb1.getString("k1"));
		System.out.println(mf1.format(new Object[] { "����" }));
	}

}
