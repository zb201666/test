/**
 * 
 */
package com.testQQOnline;

/**
 * @author Administrator
 *
 */
public class TestQQOnline {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		QqOnlineWebServiceSoap qqOnline = new QqOnlineWebService().getQqOnlineWebServiceSoap();
		System.out.println(qqOnline.qqCheckOnline("987654321"));
	}

}
