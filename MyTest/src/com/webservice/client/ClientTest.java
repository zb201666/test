/**
 * 
 */
package com.webservice.client;

/**
 * @author Administrator
 *
 */
public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		FisrtWebServiceImplement impl = new FisrtWebServiceImplementService().getFisrtWebServiceImplementPort();
		System.out.println(impl.getAddressByPhoneNumber("13548796589"));
	}

}
