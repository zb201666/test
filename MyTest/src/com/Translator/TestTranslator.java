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
		// TODO 自动生成的方法存根
		TranslatorWebServiceSoap trans = new TranslatorWebService().getTranslatorWebServiceSoap();
		System.out.println(trans.getEnCnTwoWayTranslator("汉字"));
	}

}
