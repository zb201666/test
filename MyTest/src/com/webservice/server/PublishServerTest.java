/**
 * 
 */
package com.webservice.server;

import javax.xml.ws.Endpoint;

/**
 * @author Administrator
 *
 */
public class PublishServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//����1�����񱻷��ʵ�url   ip+�˿ں�+������
        //����2��ʵ����
        Endpoint.publish("http://localhost:8099/getAddress", new FisrtWebServiceImplement());
        System.out.println("���񷢲��ɹ�");
	}

}
