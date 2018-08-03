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
		// TODO 自动生成的方法存根
		//参数1：服务被访问的url   ip+端口号+服务名
        //参数2：实现类
        Endpoint.publish("http://localhost:8099/getAddress", new FisrtWebServiceImplement());
        System.out.println("服务发布成功");
	}

}
