/**
 * 
 */
package com.Translator;

/**
 * @author Administrator
 *
 */
public class TestTranslator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TranslatorWebServiceSoap trans = new TranslatorWebService().getTranslatorWebServiceSoap();
		System.out.println(trans.getEnCnTwoWayTranslator("����"));
	}

}
