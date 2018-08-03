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
		// TODO 自动生成的方法存根
		FisrtWebServiceImplement impl = new FisrtWebServiceImplementService().getFisrtWebServiceImplementPort();
		System.out.println(impl.getAddressByPhoneNumber("13548796589"));
	}

}
