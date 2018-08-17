package com.testLocale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// Locale表示的是本地，实际上使用的是ISO编码的封装类。
		// 对于各个国家来说都存在一个唯一的编码，那么这种编码就成为ISO编码，使用Locale以指定好一个具体的国家编码。
		Locale defaultLocale = Locale.getDefault();
		System.out.println("country:" + defaultLocale.getCountry());
		System.out.println("display_country:"
				+ defaultLocale.getDisplayCountry());
		System.out.println("language:" + defaultLocale.getLanguage());
		System.out.println("display_language:"
				+ defaultLocale.getDisplayLanguage());
		// ResourceBundle类是专门完成属性文件读取操作的，
		// 读取的时候直接指定文件名即可（此文件名称一般不需要指定后缀名，统一为*.properties），
		// 可以根据Locale所指定的区域码来自动选择所需要的资源文件。
		Locale currentLocale = new Locale("en","US");
		ResourceBundle rb = ResourceBundle.getBundle("com/testLocale/MessageBundle",
				currentLocale);
		// 如果想出现“你好，XXX”的效果，就必须在资源文件中进行一些动态文本的配置，设置占位符，
		// 这些符号中的内容暂时不固定，而是在程序执行的时候由程序进行设置的，而要想实现这样的功能，
		// 则必须使用MessageFormat类。此类在java.text包中定义的。
		// 占位符使用数字的形式表示，如果现在表示第一个内容”{0}”、第二个内容”{1}”……
		MessageFormat mf = new MessageFormat(rb.getString("k1"));
		System.out.println(mf.format(new Object[] { "张三" }));
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com/testLocale/MessageBundle",
				defaultLocale);
		// 如果想出现“你好，XXX”的效果，就必须在资源文件中进行一些动态文本的配置，设置占位符，
		// 这些符号中的内容暂时不固定，而是在程序执行的时候由程序进行设置的，而要想实现这样的功能，
		// 则必须使用MessageFormat类。此类在java.text包中定义的。
		// 占位符使用数字的形式表示，如果现在表示第一个内容”{0}”、第二个内容”{1}”……
		MessageFormat mf1 = new MessageFormat(rb1.getString("k1"));
		System.out.println(mf1.format(new Object[] { "张三" }));
	}

}
